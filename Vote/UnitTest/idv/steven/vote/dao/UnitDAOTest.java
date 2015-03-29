package idv.steven.vote.dao;

import static org.junit.Assert.*;
import idv.steven.vote.dto.Unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:beans-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UnitDAOTest {
	@Autowired
	private UnitDAO dao;
	
	@Autowired
	private Unit unit;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStation() {
		unit.setElectionID("201201");
		unit.setCityName("������");
		unit.setAreaName("��01���");
		unit.setDistrictName("�緽��");
		unit.setName("�_�s��");
		unit.setStation(1);
		unit.setCitizen(36);
		unit.setParticipant(17);
		unit.setInvalidNum(17);
		unit.setValidNum(0);
		
		int count = dao.createStation(unit);
		assertEquals(1, count);
		
		Unit unit = dao.findStation("201201", "������", "��01���", 1);
		assertNotNull(unit);
		assertEquals(0, unit.getVotedNo());
		
		count = dao.removeStation("201201", "������", "��01���", 1);
		assertEquals(1, count);
	}
	
}
