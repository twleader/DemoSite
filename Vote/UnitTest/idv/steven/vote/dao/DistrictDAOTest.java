package idv.steven.vote.dao;

import static org.junit.Assert.*;
import idv.steven.vote.dto.District;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:beans-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DistrictDAOTest {
	@Autowired
	private DistrictDAO districtDAO;
	
	@Autowired
	private District district;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	

}
