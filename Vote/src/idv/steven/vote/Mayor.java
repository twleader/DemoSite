package idv.steven.vote;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import idv.steven.vote.dto.District;
import idv.steven.vote.dto.Unit;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mayor extends ImportExcel {
	private Logger logger = LoggerFactory.getLogger(Mayor.class);
	
	public void run() {
		File folder = new File("D:/DemoSite/doc/2014縣市長選舉");
		File[] listOfFiles = folder.listFiles();
	    for (int i = 0; i < listOfFiles.length; i++) {
	    	if (listOfFiles[i].isFile()) {
	    		try {
	    			String filename = listOfFiles[i].getName();
					InputStream inStream = new FileInputStream(listOfFiles[i].getCanonicalPath());
					workbook = new HSSFWorkbook(inStream);
					
					String[] items = filename.split("/");
					String districtName = filename = items[items.length-1].replace(".xls", "");
					if (districtName.length() == 3) {
						importDistrict(workbook, "201400", districtName);
					}
					else {
						String cityName = districtName.substring(0, 3);
						districtName = districtName.replace(cityName, "");
						importUnit(workbook, "201400", cityName, districtName);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}
	}
	
	public void importDistrict(HSSFWorkbook workbook, String electionID, String cityName) {
		String districtName = "";
		
		HSSFSheet sheet = workbook.getSheetAt(0);
		int total = 0;
		
		for(int r=1; r<=sheet.getLastRowNum(); r++) {
			String tmp = getCellText(sheet, r, 0);
			if (!StringUtils.isEmpty(tmp)) {
				if (total != 0) {
					createDistrict(electionID, cityName, districtName, total);
					total = 0;
				}
				
				districtName = tmp.replace(cityName, "");
			}
			
			int votedNo = getCellNum(sheet, r, 2);
			int votes = getCellNum(sheet, r, 3);
			
			createCandidateAtDistrict(electionID, cityName, districtName, votedNo, votes);
			total = total + votes;
		}
		
		if (total != 0) {
			createDistrict(electionID, cityName, districtName, total);
		}	
	}
	
	public void importUnit(HSSFWorkbook workbook, String electionID, String cityName, String districtName) {
		String unitName = "";
		
		HSSFSheet sheet = workbook.getSheetAt(0);
		int total = 0;
		int stationNo = 1;
		
		for(int r=1; r<=sheet.getLastRowNum(); r++) {
			String tmp = getCellText(sheet, r, 0);
			if (!StringUtils.isEmpty(tmp)) {
				if (total != 0) {
					createUnit(electionID, cityName, districtName, unitName, stationNo, total);
					total = 0;
					stationNo++;
				}
				
				unitName = tmp.replace(cityName, "").replace(districtName, "");
			}
			
			int votedNo = getCellNum(sheet, r, 2);
			int votes = getCellNum(sheet, r, 3);
			
			createCandidateAtUnit(electionID, cityName, districtName, unitName, stationNo, votedNo, votes);
			
			total = total + votes;
		}
		
		if (total != 0) {
			createUnit(electionID, cityName, districtName, unitName, stationNo, total);
		}
	}

	private void createUnit(String electionID, String cityName,
			String districtName, String unitName, int stationNo, int total) {
		Unit unit = (Unit) context.getBean("unitFactory");
		unit.setElectionID(electionID);
		unit.setCityName(cityName);
		unit.setAreaName(districtName);
		unit.setDistrictName(districtName);
		unit.setName(unitName);
		unit.setStation(stationNo);
		unit.setValidNum(total);
		unitDAO.createStation(unit);
	}

	private void createCandidateAtUnit(String electionID, String cityName,
			String districtName, String unitName, int stationNo, int votedNo, int votes) {
		Unit unit = (Unit) context.getBean("unitFactory");
		unit.setElectionID(electionID);
		unit.setCityName(cityName);
		unit.setAreaName(districtName);
		unit.setDistrictName(districtName);
		unit.setName(unitName);
		unit.setStation(stationNo);
		unit.setVotedNo(votedNo);
		unit.setVotes(votes);
		unitDAO.createCandidate(unit);
	}

	private void createDistrict(String electionID, String cityName,
			String districtName, int total) {
		
		District district = (District) context.getBean("districtFactory");
		district.setElectionID(electionID);
		district.setCityName(cityName);
		district.setAreaName(districtName);
		district.setName(districtName);
		district.setVotedNo(0);
		district.setValidNum(total);
			
		districtDAO.createDistrict(district);
	}

	private void createCandidateAtDistrict(String electionID, String cityName,
			String districtName, int votedNo, int votes) {
		
		District district = (District) context.getBean("districtFactory");
		district.setElectionID(electionID);
		district.setCityName(cityName);
		district.setAreaName(districtName);
		district.setName(districtName);
		district.setVotedNo(votedNo);
		district.setVotes(votes);
			
		districtDAO.createCandidate(district);
	}


	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans-config.xml");
		Mayor mayor = (Mayor) context.getBean("mayor");
		mayor.run();
	}
}
