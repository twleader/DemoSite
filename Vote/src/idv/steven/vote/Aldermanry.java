package idv.steven.vote;

import idv.steven.vote.dto.Area;
import idv.steven.vote.dto.Candidate;
import idv.steven.vote.dto.District;
import idv.steven.vote.dto.Unit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.media.jfxmedia.logging.Logger;

/**
 * 縣市議員選舉
 * @author Steven
 */
public class Aldermanry extends ImportExcel {
	
	public void run() {
		try {
			File folder = new File("D:/DemoSite/doc/2014縣市議員");
			File[] listOfFiles = folder.listFiles();
			
			if (listOfFiles == null) {
				System.out.println("目錄裡沒有任何檔案!");
				return;
			}
			
		    for (int i = 0; i < listOfFiles.length; i++) {
		    	if (listOfFiles[i].isFile()) {
		    		String filename = listOfFiles[i].getName();
					InputStream inStream = new FileInputStream(listOfFiles[i].getCanonicalPath());
					workbook = new HSSFWorkbook(inStream);

					if (filename.contains("直轄市選舉結果")) {
						//候選人、選區得票統計
						//importCandidate(sheet, "201401");
					}
					else {
						int numOfSheets = workbook.getNumberOfSheets();
						for(int j=0; j<numOfSheets; j++) {
							HSSFSheet sheet = workbook.getSheetAt(j);
							
							String cityName = findCityName(filename);
							if (filename.length() > 8) {
								//村里得票統計
								String areaName = filename.substring(3, 8);
								String districtName = filename.substring(8);
								importUnit(sheet, "201401", cityName, areaName, districtName);
								
							}
							else {
								//鄉鎮市區得票統計
								String areaName = filename.substring(3);
								importDistrict(sheet, "201401", cityName, areaName); 
							}
						}
					}
		    	}
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void importCandidate(HSSFSheet sheet, String electionID) {
		String cityName = "", areaName = "";
		int total = 0;
		
		for(int row = 1; row <= sheet.getLastRowNum(); row++) {
			String tmp = getCellText(sheet, row, 0);
			if (!StringUtils.isEmpty(tmp)) {
				System.out.println(tmp);
				
				if (total != 0) {
					Area area = new Area();
					area.setElectionID(electionID);
					area.setCityName(cityName);
					area.setName(areaName);
					area.setValidNum(total);
					areaDAO.createArea(area);
					
					total = 0;
				}
				
				cityName = tmp.substring(0, 3);
				areaName = tmp.replace(cityName, "");
			}
			
			String name = getCellText(sheet, row, 1);
			int votedNo = getCellNum(sheet, row, 2);
			String partyName = getCellText(sheet, row, 5);
			int votes = getCellNum(sheet, row, 6);
			char elected = 'N';
			if ("*".equals(getCellText(sheet, row, 8))) {
				elected = 'Y';
			}
			
			Candidate candidate = new Candidate();
			candidate.setElectionID(electionID);
			candidate.setCityName(cityName);
			candidate.setAreaName(areaName);
			candidate.setVotedNo(votedNo);
			candidate.setName(name);
			candidate.setPartyName(partyName);
			candidate.setVotes(votes);
			candidate.setElected(elected);
			candidateDAO.create(candidate);
			
			Area area = new Area();
			area.setElectionID(electionID);
			area.setCityName(cityName);
			area.setName(areaName);
			area.setVotedNo(votedNo);
			area.setVotes(votes);
			areaDAO.createCandidate(area);
			
			total = total + votes;
		}
		
		if (total != 0) {
			Area area = new Area();
			area.setElectionID(electionID);
			area.setCityName(cityName);
			area.setName(areaName);
			area.setValidNum(total);
			areaDAO.createArea(area);
		}
		
		System.out.println("完成!");
	}
	
	private void importDistrict(HSSFSheet sheet, String electionID, String cityName, String areaName) {
		String districtName = "";
		int total = 0;
		
		for(int row = 1; row <= sheet.getLastRowNum(); row++) {
			String tmp = getCellText(sheet, row, 0);
			if (!StringUtils.isEmpty(tmp)) {
				System.out.println(tmp);
				
				if (total != 0) {
					District district = new District();
					district.setElectionID(electionID);
					district.setCityName(cityName);
					district.setAreaName(areaName);
					district.setName(districtName);
					district.setValidNum(total);
					districtDAO.createDistrict(district);
					
					total = 0;
				}
			
				districtName = tmp.replace(cityName, "").replace(areaName, "");
			}
			
			String name = getCellText(sheet, row, 1);
			int votedNo = getCellNum(sheet, row, 2);
			int votes = getCellNum(sheet, row, 3);
			
			District district = new District();
			district.setElectionID(electionID);
			district.setCityName(cityName);
			district.setAreaName(areaName);
			district.setName(districtName);
			district.setVotedNo(votedNo);
			district.setVotes(votes);
			districtDAO.createCandidate(district);
			
			total = total + votes;
		}
		
		if (total != 0) {
			District district = new District();
			district.setElectionID(electionID);
			district.setCityName(cityName);
			district.setAreaName(areaName);
			district.setName(districtName);
			district.setValidNum(total);
			districtDAO.createDistrict(district);
		}
		
		System.out.println("完成!");
	}

	private void importUnit(HSSFSheet sheet, String electionID, String cityName, String areaName, String districtName) {
		String unitName = "";
		int total = 0;
		int station = 1;
		
		for(int row = 1; row <= sheet.getLastRowNum(); row++) {
			String tmp = getCellText(sheet, row, 0);
			if (!StringUtils.isEmpty(tmp)) {
				System.out.println(tmp);
				
				if (total != 0) {
					Unit unit = new Unit();
					unit.setElectionID(electionID);
					unit.setCityName(cityName);
					unit.setAreaName(areaName);
					unit.setDistrictName(districtName);
					unit.setName(unitName);
					unit.setValidNum(total);
					unit.setStation(station);
					unitDAO.createStation(unit);
					
					total = 0;
					station++;
				}
			
				unitName = tmp.replace(cityName, "").replace(areaName, "").replace(districtName, "");
			}
			
			String name = getCellText(sheet, row, 1);
			int votedNo = getCellNum(sheet, row, 2);
			int votes = getCellNum(sheet, row, 3);
			
			Unit unit = new Unit();
			unit.setElectionID(electionID);
			unit.setCityName(cityName);
			unit.setAreaName(areaName);
			unit.setDistrictName(districtName);
			unit.setName(unitName);
			unit.setStation(station);
			unit.setVotedNo(votedNo);
			unit.setVotes(votes);
			unitDAO.createCandidate(unit);
			
			total = total + votes;
		}
		
		if (total != 0) {
			Unit unit = new Unit();
			unit.setElectionID(electionID);
			unit.setCityName(cityName);
			unit.setAreaName(areaName);
			unit.setDistrictName(districtName);
			unit.setName(unitName);
			unit.setValidNum(total);
			unit.setStation(station);
			unitDAO.createStation(unit);
		}
		
		System.out.println("完成!");		
	}
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans-config.xml");
		Aldermanry aldermanry = (Aldermanry) context.getBean("aldermanry");
		aldermanry.run();
	}

}
