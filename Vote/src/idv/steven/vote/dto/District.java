package idv.steven.vote.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * �m���ϲ��Ʋέp 
 * @author Steven
 */
@Component
public class District implements Serializable {
	private static final long serialVersionUID = 3459115412614605719L;
	
	private String electionID;
	private String cityName;
	private String areaName;
	private String name;
	private int citizen;
	private int participant;
	private int validNum;
	private int invalidNum;
	private int votedNo;
	private int votes;
	
	/**
	 * @return ���|�����s��
	 */
	public String getElectionID() {
		return electionID;
	}
	
	/**
	 * @param electionID ���|�����s��
	 */
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}

	/**
	 * @return �����W��
	 */
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * @param cityName �����W��
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return ��ϧO
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName ��ϧO
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return �m����
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name �m����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return ���|�H��
	 */
	public int getCitizen() {
		return citizen;
	}
	
	/**
	 * @param citizen ���|�H��
	 */
	public void setCitizen(int citizen) {
		this.citizen = citizen;
	}
	
	/**
	 * @return �벼�H��
	 */
	public int getParticipant() {
		return participant;
	}
	
	/**
	 * @param participant �벼�H��
	 */
	public void setParticipant(int participant) {
		this.participant = participant;
	}
	
	/**
	 * @return ���Ĳ���
	 */
	public int getValidNum() {
		return validNum;
	}
	
	/**
	 * @param validNum ���Ĳ���
	 */
	public void setValidNum(int validNum) {
		this.validNum = validNum;
	}
	
	/**
	 * @return �L�Ĳ���
	 */
	public int getInvalidNum() {
		return invalidNum;
	}
	
	/**
	 * @param invalidNum �L�Ĳ���
	 */
	public void setInvalidNum(int invalidNum) {
		this.invalidNum = invalidNum;
	}

	/**
	 * @return �Կ�H����
	 */
	public int getVotedNo() {
		return votedNo;
	}

	/**
	 * @param votedNo �Կ�H����
	 */
	public void setVotedNo(int votedNo) {
		this.votedNo = votedNo;
	}

	/**
	 * @return �Կ�H�o����
	 */
	public int getVotes() {
		return votes;
	}

	/**
	 * @param votes �Կ�H�o����
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}
}
