package idv.steven.vote;

import idv.steven.vote.dto.Area;
import idv.steven.vote.dto.Candidate;
import idv.steven.vote.dto.District;
import idv.steven.vote.dto.Election;
import idv.steven.vote.dto.Unit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.StringUtils;

public class CenterImport  extends ImportExcel {
	private Logger logger = LoggerFactory.getLogger(CenterImport.class);
	
	private String electionName = "";
	private String electionID = "";
	
	private String cityName;
	private String areaName;
	
	private int numOfCandidate = 0;
	
	public void run(String folderName) {
		if (!retrieveElectionData(folderName)) {
			logger.error("無法取得選舉編號!");
			return;
		}
		
		File folder = new File(folderName);
		File[] listOfFiles = folder.listFiles();
	    for (int i = 0; i < listOfFiles.length; i++) {
	    	if (listOfFiles[i].isFile()) {
	    		try {
	    			logger.info(listOfFiles[i].getName());
					InputStream inStream = new FileInputStream(listOfFiles[i].getCanonicalPath());
					workbook = new HSSFWorkbook(inStream);
					cityName = findCityName(listOfFiles[i].getName());
					importToDB();
					inStream.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
		    }
		}
	}

	/**
	 * 取得選舉名稱、選舉編號
	 * @param folderName 檔案所在的路徑全名
	 * @return true 成功取得, false 資料不存在
	 */
	private boolean retrieveElectionData(String folderName) {
		String[] s = folderName.split("/");
		electionName = s[s.length-1];
		Election election = electionDAO.findByName(electionName);
		if (election == null) {
			return false;
		}
		else {
			electionID = election.getId();
			return true;
		}
	}

	private void importToDB() {
		String tmp = null;
		
		for(int s=0; s<workbook.getNumberOfSheets(); s++) {
			HSSFSheet sheet = workbook.getSheetAt(s);
			
			boolean isCentral = checkCentral(sheet);
			
			areaName = sheet.getSheetName();
			logger.info("選區:" + areaName);
			
			//候選人票數統計
			int rowNum = 2, colNum = 3;
			
			do {
				String value = getCellText(sheet, rowNum, colNum);
				if (!StringUtils.isEmptyOrWhitespaceOnly(value)) {
					if (isCentral) {
						//中央的選舉才有候選人得票總計
						createCandidate(sheet, colNum, value);
					}

					colNum++;
				}
				else {
					break;
				}
			} while (true);
			
			//候選人人數
			int row = 5;
			numOfCandidate = colNum -3;
			
			String districtName = "";
			if (isCentral) {
				//中央選舉多了候選人得票總計，要多跳過一列。
				row = 6;
			}
			
			for(; row<=sheet.getLastRowNum(); row++) {
				tmp = getCellText(sheet, row, 0).replace("　", "");
				if (!StringUtils.isNullOrEmpty(tmp)) {
					districtName = tmp;
					districtName = districtName.replace("　", "");
				}
				if (!StringUtils.isNullOrEmpty(tmp)) {
					if (tmp.startsWith("備註︰")) {
						break;
					}
					//鄉鎮市區票數統計
					createDistrict(sheet, row, colNum, districtName);
					//候選人得票數
					createCandidateAtDistrict(sheet, row, districtName);
				}
				else {
					//投票所票數統計
					String unitName = getCellText(sheet, row, 1);
					int station = getCellNum(sheet, row, 2);
					createStation(sheet, row, colNum, districtName, unitName, station);
					//候選人得票數
					createCandidateAtStation(sheet, row, districtName, unitName,	station);
				}
			}
			
			//選區票數統計 - 總計
			if (isCentral) {
				//中央選舉由excel取得選區的統計資料
				createArea(sheet);
			}
			else {
				//地方選舉只能對各投票所選票進行統計
				areaDAO.createSumOfArea(electionID, cityName, areaName);
				areaDAO.createSumOfCandidate(electionID, cityName, areaName);
				candidateDAO.createSumOfCandidate(electionID, cityName, areaName);
				//填上候選人的姓名、黨籍
				updateCandidateDetail(sheet);
			}
		}
	}

	/**
	 * 由標題判斷是中央或地方選舉
	 * @param sheet
	 * @return true: 中央選舉, false: 地方選舉
	 */
	private boolean checkCentral(HSSFSheet sheet) {
		String title = getCellText(sheet, 0, 0);
		if (title.contains("總統") || title.contains("立法委員")) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 新候選人姓名、黨籍
	 * @param sheet
	 */
	private void updateCandidateDetail(HSSFSheet sheet) {
		String tmp;
		
		for(int c=1; c<=numOfCandidate; c++) {
			tmp = getCellText(sheet, 2, c + 2);
			String[] people = tmp.split("\n");
			if (people != null && people.length == 3) {
				people[0] = people[0].replace("(", "").replace(")", "");
				Candidate candidate = (Candidate) context.getBean("candidate");
				candidate.setElectionID(electionID);
				candidate.setCityName(cityName);
				candidate.setAreaName(areaName);
				candidate.setVotedNo(Integer.parseInt(people[0].trim()));
				candidate.setName(people[1].trim());
				candidate.setPartyName(people[2].trim());
				candidateDAO.updateCandidateDetail(candidate);
			}
			else {
				System.out.println("候選人姓名黨籍: " + tmp);
			}
		}
	}
	
	private String getCityName(HSSFSheet sheet) {
		String value = getCellText(sheet, 0, 0);
		value = value.replace(electionName, "");
		
		return value.substring(0, 3);
	}

	private void createCandidateAtStation(HSSFSheet sheet, int r,
			String districtName, String unitName, int station) {
		Unit unit = (Unit) context.getBean("unitFactory");
		unit.setElectionID(electionID);
		unit.setCityName(cityName);
		unit.setAreaName(areaName);
		unit.setDistrictName(districtName);
		unit.setName(unitName);
		unit.setStation(station);
		for(int n=1; n <= numOfCandidate; n++) {
			unit.setVotedNo(n);
			unit.setVotes(getCellNum(sheet, r, n+2));
			
			unitDAO.createCandidate(unit);
		}
	}

	private void createCandidateAtDistrict(HSSFSheet sheet, int r,
			String districtName) {
		District district = (District) context.getBean("districtFactory");
		district.setElectionID(electionID);
		district.setCityName(cityName);
		district.setAreaName(areaName);
		district.setName(districtName);
		for(int n=1; n <= numOfCandidate; n++) {
			district.setVotedNo(n);
			district.setVotes(getCellNum(sheet, r, n+2));
			
			districtDAO.createCandidate(district);
		}
	}

	/**
	 * 新增候選人得票統計
	 * @param sheet
	 * @param colNum
	 * @param value
	 */
	private void createCandidate(HSSFSheet sheet, int colNum, String value) {
		Candidate candidate = (Candidate) context.getBean("candidate");

		String[] people = value.split("\n");
		if (people != null && people.length == 3) {
			people[0] = people[0].replace("(", "").replace(")", "");
			candidate.setVotedNo(Integer.parseInt(people[0].trim()));
			candidate.setName(people[1].trim());
			candidate.setPartyName(people[2].trim());
		}
		
		candidate.setElectionID(electionID);
		candidate.setCityName(cityName);
		candidate.setAreaName(areaName);
		candidate.setVotes(getCellNum(sheet, 5, colNum));
		
		candidateDAO.create(candidate);
		
		Area area = (Area) context.getBean("area");
		area.setElectionID(electionID);
		area.setCityName(cityName);
		area.setName(areaName);
		area.setVotedNo(candidate.getVotedNo());
		area.setVotes(candidate.getVotes());
		
		areaDAO.createCandidate(area);
	}

	/**
	 * 新增選區選票統計
	 * @param sheet
	 */
	private void createArea(HSSFSheet sheet) {
		int colNum = 3 + numOfCandidate;
		
		Area area = (Area) context.getBean("area");
		area.setElectionID(electionID);
		area.setCityName(cityName);
		area.setName(areaName);
		
		area.setCitizen(getCellNum(sheet, 5, colNum+6));
		area.setParticipant(getCellNum(sheet, 5, colNum+2));
		area.setValidNum(getCellNum(sheet, 5, colNum));
		area.setInvalidNum(getCellNum(sheet, 5, colNum+1));
		
		areaDAO.createArea(area);
	}

	/**
	 * 新增投票所選票統計
	 * @param sheet
	 * @param rowNum
	 * @param colNum
	 * @param districtName
	 * @param unitName
	 * @param station
	 */
	private void createStation(HSSFSheet sheet, int rowNum, int colNum,
			String districtName, String unitName, int station) {
		
		Unit unit = (Unit) context.getBean("unitFactory");
		unit.setElectionID(electionID);
		unit.setCityName(cityName);
		unit.setAreaName(areaName);
		unit.setDistrictName(districtName);
		unit.setName(unitName);
		unit.setStation(station);
		
		unit.setValidNum(getCellNum(sheet, rowNum, colNum));
		unit.setInvalidNum(getCellNum(sheet, rowNum, colNum+1));
		unit.setParticipant(getCellNum(sheet, rowNum, colNum+2));
		unit.setCitizen(getCellNum(sheet, rowNum, colNum+6));
		
		unitDAO.createStation(unit);
	}

	/**
	 * 新增鄉鎮市區選票統計
	 * @param sheet
	 * @param rowNum
	 * @param colNum
	 * @param districtName
	 */
	private void createDistrict(HSSFSheet sheet, int rowNum, int colNum, String districtName) {
		District district = (District) context.getBean("districtFactory");
		
		district.setElectionID(electionID);
		district.setCityName(cityName);
		district.setAreaName(areaName);
		district.setName(districtName);
		
		district.setValidNum(getCellNum(sheet, rowNum, colNum));
		district.setInvalidNum(getCellNum(sheet, rowNum, colNum+1));
		district.setParticipant(getCellNum(sheet, rowNum, colNum+2));
		district.setCitizen(getCellNum(sheet, rowNum, colNum+6));
		
		districtDAO.createDistrict(district);
	}

	public static void main(String[] args) {
		//String folderName = "D:/DemoSite/doc/2014縣市議員";
		//String folderName = "D:/DemoSite/doc/Test";
		String folderName = "D:/DemoSite/doc/2012立法委員";
				
		context = new ClassPathXmlApplicationContext("beans-config.xml");
		CenterImport centerImport = (CenterImport) context.getBean("centerImport");
		centerImport.run(folderName);
	}

}
