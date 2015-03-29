package idv.steven.vote;

import static org.junit.Assert.*;
import idv.steven.vote.dto.District;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:beans-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class LegislatorTest {
	@Autowired
	private CenterImport legislator;
	
	@Autowired
	private HSSFWorkbook workbook;
	
	private HSSFSheet sheet = null;

	@Before
	public void setUp() throws Exception {
		CenterImport.context = new ClassPathXmlApplicationContext("beans-config.xml");
		
		sheet = workbook.getSheetAt(0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test宜蘭() {

	}

}
