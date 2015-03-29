package idv.steven.vote.dao;

import static org.junit.Assert.*;
import idv.steven.vote.dto.Area;

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
public class AreaDAOTest {
	@Autowired
	private AreaDAO areaDAO;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//@Test
//	public void testRemoveAll() {
//		areaDAO.createArea("201201", "�O�_��", "��01���", 265606, 204766, 202270, 2496);
//		
//		List<Area> areas = areaDAO.findAll();
//		assertEquals(1, areas.size());
//		
//		Area area = areaDAO.findArea("201201", "�O�_��", "��01���");
//		assertEquals(265606, area.getCitizen());
//		assertEquals(0, area.getVotedNo());
//		
//		areaDAO.removeAll();
//		
//		areas = areaDAO.findAll();
//		assertEquals(0, areas.size());
//	}
	
//	@Test
//	public void testCandidate() {
//		areaDAO.createCandidate("201201", "�O�_��", "��01���", 1, 4733);
//		
//		List<Area> areas = areaDAO.findAll();
//		assertTrue(areas.size() > 0);
//		
//		Area a = areaDAO.findArea("201201", "�O�_��", "��01���");
//		assertNotNull(a);
//		assertEquals(0, a.getCitizen());
//		assertEquals(1, a.getVotedNo());
//		assertEquals("201201", a.getElectionID());
//		
//		Area area = new Area();
//		area.setElectionID("201201");
//		area.setCityName("�O�_��");
//		area.setName("��01���");
//		area.setVotedNo(1);
//		
//		int count = areaDAO.removeCandidate(area);
//		
//		assertEquals(1, count);
//		
//		area = areaDAO.findArea("201201", "�O�_��", "��01���");
//		assertNull(area);
//	}

}
