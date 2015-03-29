package idv.steven.vote.dao;

import static org.junit.Assert.*;
import idv.steven.vote.dto.Candidate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:beans-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CandidateDAOTest {
	@Autowired
	private CandidateDAO candidateDAO;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testAll() {
//		int count = candidateDAO.create("201201", "������", "��01���", 1, "��ĳ��", "���D�i�B��", 89913);
//		assertEquals(1, count);
//		count = candidateDAO.create("201201", "������", "��01���", 2, "��ЩM", "��������", 75627);
//		assertEquals(1, count);
//		
//		Candidate candidate = candidateDAO.find("201201", "������", "��01���", 1);
//		assertNotNull(candidate);
//		assertEquals(89913, candidate.getVotes());
//		assertEquals("���D�i�B��", candidate.getPartyName());
//		
//		count = candidateDAO.remove("201201", "������", "��01���", 1);
//		assertEquals(1, count);
//		
//		count = candidateDAO.removeAll();
//		assertEquals(1, count);
//	}

}
