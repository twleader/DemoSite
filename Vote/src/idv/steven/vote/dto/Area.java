package idv.steven.vote.dto;

import org.springframework.stereotype.Component;

/**
 * 選區票數統計
 * @author Steven
 */
@Component
public class Area {
	private String electionID;
	private String cityName;
	private String name;	
	private int citizen;
	private int participant;
	private int validNum;
	private int invalidNum;
	private int votedNo;
	private int votes;
	
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
	 * @return 縣市名稱
	 */
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * @param cityName 縣市名稱
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	/**
	 * @return 選區名稱
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param areaName 選區名稱
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 選舉人數
	 */
	public int getCitizen() {
		return citizen;
	}
	
	/**
	 * @param citizen 選舉人數
	 */
	public void setCitizen(int citizen) {
		this.citizen = citizen;
	}
	
	/**
	 * @return 投票人數
	 */
	public int getParticipant() {
		return participant;
	}
	
	/**
	 * @param participant 投票人數
	 */
	public void setParticipant(int participant) {
		this.participant = participant;
	}
	
	/**
	 * @return 有效票數
	 */
	public int getValidNum() {
		return validNum;
	}
	
	/**
	 * @param validNum 有效票數
	 */
	public void setValidNum(int validNum) {
		this.validNum = validNum;
	}
	
	/**
	 * @return 無效票數
	 */
	public int getInvalidNum() {
		return invalidNum;
	}
	
	/**
	 * @param invalidNum 無效票數
	 */
	public void setInvalidNum(int invalidNum) {
		this.invalidNum = invalidNum;
	}
	
	/**
	 * 當 votedNo = 0 時，是該選區的選票統計<br>
	 * 當 votedNo <> 0 時，是指定號次的候選人得票。
	 * @return 候選人號次
	 */
	public int getVotedNo() {
		return votedNo;
	}
	
	/**
	 * 當 votedNo = 0 時，是該選區的選票統計<br>
	 * 當 votedNo <> 0 時，是指定號次的候選人得票。
	 * @param votedNo 候選人號次
	 */
	public void setVotedNo(int votedNo) {
		this.votedNo = votedNo;
	}
	
	/**
	 * @return 候選人得票數
	 */
	public int getVotes() {
		return votes;
	}
	
	/**
	 * @param votes 候選人得票數
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}
}
