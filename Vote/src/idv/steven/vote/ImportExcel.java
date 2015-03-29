package idv.steven.vote;

import java.util.List;

import idv.steven.vote.dao.AreaDAO;
import idv.steven.vote.dao.CandidateDAO;
import idv.steven.vote.dao.DistrictDAO;
import idv.steven.vote.dao.ElectionDAO;
import idv.steven.vote.dao.UnitDAO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.mysql.jdbc.StringUtils;

public class ImportExcel {
	static ApplicationContext context;
	
	protected HSSFWorkbook workbook;
	
	@Autowired
	protected ElectionDAO electionDAO;
	
	@Autowired
	protected AreaDAO areaDAO;
	
	@Autowired
	protected DistrictDAO districtDAO;
	
	@Autowired
	protected UnitDAO unitDAO;
	
	@Autowired
	protected CandidateDAO candidateDAO;
	
	private List<String> allCity;
	
	protected String getCellText(HSSFSheet sheet, int row, int col) {
		HSSFRow rowHSSF = sheet.getRow(row);
		HSSFCell cellHSSF = rowHSSF.getCell(col);
		
		return cellHSSF.getStringCellValue();
	}
	
	protected int getCellNum(HSSFSheet sheet, int row, int col) {
		HSSFRow rowHSSF = sheet.getRow(row);
		rowHSSF.getCell(col).setCellType(Cell.CELL_TYPE_STRING);
		
		String value = rowHSSF.getCell(col).getStringCellValue();
		if (StringUtils.isEmptyOrWhitespaceOnly(value)) {
			return 0;
		}
		else {
			return Integer.parseInt(value);
		}
	}
	
	/**
	 * 搜尋字串中所包含的縣市名稱
	 * @param s 要搜尋的字串
	 * @return 縣市名稱
	 */
	protected String findCityName(String s) {
		for(String city:allCity) {
			if (s.contains(city)) {
				return city;
			}
		}
		
		return "";
	}

	public List<String> getAllCity() {
		return allCity;
	}

	public void setAllCity(List<String> allCity) {
		this.allCity = allCity;
	}
}
