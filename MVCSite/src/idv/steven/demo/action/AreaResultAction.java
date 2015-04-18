package idv.steven.demo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import idv.steven.demo.dao.CandidateDAO;
import idv.steven.demo.dao.ElectionDAO;
import idv.steven.demo.dto.Candidate;
import idv.steven.demo.dto.Election;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class AreaResultAction extends ActionSupport {
	private static final long serialVersionUID = -213699129575326012L;
	final static Logger logger = LoggerFactory.getLogger(AreaResultAction.class);
	
	@Autowired
	private ElectionDAO electionDAO;
	
	@Autowired
	private CandidateDAO candidateDAO;
	
	private Map<String, String> electionList = new TreeMap<String, String>();
	private Map<String, String> cityNameList = new TreeMap<String, String>();
	private Map<String, String> areaNameList = new TreeMap<String, String>();
	private List<Candidate> candidateList = new ArrayList<Candidate>();
	
	private String electionID;
	private String cityName;
	private String areaName;

	/**
	 * 將網頁導向「AreaResult.jsp」(「選區投票結果查詢」網頁)
	 */
	@Action(value = "/areaResult", results = { @Result(location = "/jsp/AreaResult.jsp", name = "success") })
	public String execute() throws Exception {
        return SUCCESS;
    }
	
	/**
	 * 將查詢結果顯示在 Grid
	 * @return
	 */
    @Action(value = "/showAreaResult", results = { @Result(location = "/jsp/AreaResultGrid.jsp", name = "success") })
    public String showAreaResult() {
        return SUCCESS;
    }

	/**
	 * 傳回選舉場次
	 * @return
	 */
    @Action(value = "/findElection", results = { @Result(name = "input", type = "json") })
    public String findElection() {
    	List<Election> list = electionDAO.findAll();
    	for(Election item:list) {
    		electionList.put(item.getId(), item.getName());
    	}
        
        return INPUT;
    }
    
	/**
	 * 傳回縣市
	 * @return
	 */
    @Action(value = "/findCityName", results = { @Result(name = "input", type = "json") })
    public String findCityName() {
    	List<String> list = candidateDAO.findCityName(electionID);
    	for(String item:list) {
    		cityNameList.put(item, item);
    	}
        
        return INPUT;
    }

	/**
	 * 傳回選區
	 * @return
	 */
    @Action(value = "/findAreaName", results = { @Result(name = "input", type = "json") })
    public String findAreaName() {
    	List<String> list = candidateDAO.findAreaName(electionID, cityName);
    	for(String item:list) {
    		areaNameList.put(item, item);
    	}
        
        return INPUT;
    }
    
    @Action(value = "/findCandidate", results = { @Result(name = "input", type = "json") })
    public String findCandidate() {
    	candidateList = candidateDAO.findCandidate(electionID, cityName, areaName);
        
        return INPUT;
    }
    
    //由網頁中取值
	public Map<String, String> getElectionList() {
		return electionList;
	}
	
	public Map<String, String> getCityNameList() {
		return cityNameList;
	}

	public Map<String, String> getAreaNameList() {
		return areaNameList;
	}
	
	public List<Candidate> getCandidateList() {
		return candidateList;
	}

	//網頁 submit 時傳值過來
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}
