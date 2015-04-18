package idv.steven.demo.dao;

import static org.junit.Assert.*;
import idv.steven.demo.dto.Candidate;

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
public class CandidateDAOTest {
	
	@Autowired
	private CandidateDAO dao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindCityName() {
		List<String> cities = dao.findCityName("201201");
		for(String city:cities) {
			System.out.println(city);
		}
	}

	@Test
	public void testFindAreaName() {
		List<String> areas = dao.findAreaName("201201", "高雄市");
		for(String area:areas) {
			System.out.println(area);
		}
	}
	
	@Test
	public void findCandidate() {
		List<Candidate> candidate = dao.findCandidate("201201", "高雄市", "第01選區");
		for(Candidate c:candidate) {
			System.out.println(c.toString());
		}
	}

}
