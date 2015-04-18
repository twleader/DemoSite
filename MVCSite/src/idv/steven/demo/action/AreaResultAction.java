package idv.steven.demo.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idv.steven.demo.dao.CandidateDAO;
import idv.steven.demo.dao.ElectionDAO;
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

	private Map<String, String> election = new HashMap<String, String>();
	
	@Action(value = "/areaResult", results = { @Result(location = "/jsp/AreaResult.jsp", name = "success") })
	public String execute() throws Exception {
    	List<Election> list = electionDAO.findAll();
    	for(Election item:list) {
    		election.put(item.getId(), item.getName());
    	}
		
        return SUCCESS;
    }

    @Action(value = "/findElection", results = { @Result(name = "success", type = "json") })
    public String findElection() {
    	List<Election> list = electionDAO.findAll();
    	for(Election item:list) {
    		election.put(item.getId(), item.getName());
    	}
        
        return SUCCESS;
    }

	public Map<String, String> getElection() {
		return election;
	}

	public void setElection(Map<String, String> election) {
		this.election = election;
	}
}
