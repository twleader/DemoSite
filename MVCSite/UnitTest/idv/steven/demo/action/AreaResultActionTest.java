package idv.steven.demo.action;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.opensymphony.xwork2.ActionSupport;

@ContextConfiguration(locations={"classpath:beans-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AreaResultActionTest {
	@Autowired
	private AreaResultAction action;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAreaName() throws Exception {
		action.setElectionID("201201");
		action.setCityName("高雄市");
		String result = action.findAreaName();
		assertEquals(ActionSupport.INPUT, result);
		
		Map<String, String> map = action.getAreaNameList();
		assertEquals(9, map.size());
	}
}
