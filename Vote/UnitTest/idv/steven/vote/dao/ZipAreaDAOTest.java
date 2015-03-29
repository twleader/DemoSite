package idv.steven.vote.dao;

import static org.junit.Assert.*;
import idv.steven.vote.dto.ZipArea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:beans-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ZipAreaDAOTest {
	@Autowired
	private BufferedReader brdZipArea;
	
	@Autowired
	private ZipAreaDAO zipAreaDAO;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAll() throws IOException {
		String line = "";
		
		List<ZipArea> zipArea = zipAreaDAO.findAll();
		
		if (zipArea.size() != 371) {
			zipAreaDAO.removeAll();
			
			while ((line = brdZipArea.readLine()) != null) {
				String[] items = line.split(" ");
				if (items != null && items.length == 2) {
					zipAreaDAO.create(items[1], items[0]);
				}
			}
		}
		
		assertEquals(371, zipArea.size());
		
		ZipArea hometown = zipAreaDAO.find("723");
		assertEquals("¦è´ä°Ï", hometown.getName());
	}

}
