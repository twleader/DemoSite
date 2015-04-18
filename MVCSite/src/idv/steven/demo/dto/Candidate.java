package idv.steven.demo.dto;

import org.springframework.stereotype.Component;

/**
 * 候選人得票統計
 * @author Steven
 */
@Component
public class Candidate {
	private String electionID;
	private String cityName;
	private String areaName;
	private int votedNo;
	private String name;
	private String partyName;
	private int votes;
	private char elected;

	/**
	 * @return 選舉場次編號
	 */
	public String getElectionID() {
		return electionID;
	}
	
	/**
	 * @param electionID 選舉場次編號
	 */
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}
	
	/**
	 * @return 縣市
	 */
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * @param cityName 縣市
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	/**
	 * @return 選區
	 */
	public String getAreaName() {
		return areaName;
	}
	
	/**
	 * @param area 選區
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	/**
	 * @return 候選人號次
	 */
	public int getVotedNo() {
		return votedNo;
	}
	
	/**
	 * @param votedNo 候選人號次
	 */
	public void setVotedNo(int votedNo) {
		this.votedNo = votedNo;
	}
	
	/**
	 * @return 姓名
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return 政黨
	 */
	public String getPartyName() {
		return partyName;
	}
	
	/**
	 * @param partyName 政黨
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	
	/**
	 * @return 得票數
	 */
	public int getVotes() {
		return votes;
	}
	
	/**
	 * @param votes 得票數
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}

	/**
	 * @return 是否當選 (Y:當選,N:落選)
	 */
	public char getElected() {
		return elected;
	}

	/**
	 * @param elected 是否當選 (Y:當選,N:落選)
	 */
	public void setElected(char elected) {
		this.elected = elected;
	}

	@Override
	public String toString() {
		return "Candidate [electionID=" + electionID + ", cityName=" + cityName
				+ ", areaName=" + areaName + ", votedNo=" + votedNo + ", name="
				+ name + ", partyName=" + partyName + ", votes=" + votes
				+ ", elected=" + elected + "]";
	}
}
