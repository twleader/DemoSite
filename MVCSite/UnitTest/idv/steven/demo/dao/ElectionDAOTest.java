package idv.steven.demo.dao;

import static org.junit.Assert.*;
import idv.steven.demo.dto.Election;

import java.io.IOException;
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
public class ElectionDAOTest {
	
	@Autowired
	private ElectionDAO electionDAO;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAll() throws IOException {
		List<Election> list = electionDAO.findAll();
		for(Election item:list) {
			System.out.println(item.toString());
		}
	}

}
