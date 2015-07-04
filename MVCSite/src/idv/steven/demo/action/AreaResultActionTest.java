package idv.steven.demo.action;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.opensymphony.xwork2.ActionContext;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({})
public class AreaResultActionTest extends StrutsSpringTestCase {
	@Override
	protected String[] getContextLocations() {
		return new String[] {"classpath:beans-config.xml"};
	}
	
	@Before
	public void setUp() throws Exception {
		//這幾行一定要寫
			//等價於在 web.xml 中設定 <init-param> 參數
		Map<String, String> dispatcherInitParams = new HashMap<String, String>();
		ReflectionTestUtils.setField(this, "dispatcherInitParams", dispatcherInitParams);
			//載入 struts 設定檔
		dispatcherInitParams.put("config", "struts-default.xml,struts-plugin.xml,struts.xml");
		
	    super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testFindCityName() throws UnsupportedEncodingException, ServletException {
		//初始化 http 相關環境變數 request、response ...
		initServletMockObjects();
		
		//jsp要submit那些欄位的資料到action? 透過 request.setParameter傳入。
		request.setParameter("electionID", "201201");
		executeAction("/findCityName");
		
		//執行完action，取得action物件。
		AreaResultAction action = (AreaResultAction) ActionContext.getContext().getActionInvocation().getAction();
		//jsp網頁中，縣市的下拉選單呼叫 cityNameList 取得縣市資料。
		Map<String, String> cities = action.getCityNameList();
		for(String city:cities.keySet()) {
			System.out.println(city);
		}
	}
}
