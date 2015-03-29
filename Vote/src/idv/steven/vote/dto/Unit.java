package idv.steven.vote.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * ń布计参璸
 * @author Steven
 */
@Component
public class Unit implements Serializable {
	private static final long serialVersionUID = -8234278772113368227L;
	
	private String electionID;
	private String cityName;
	private String areaName;
	private String districtName;
	private String name;
	private int station;
	private int citizen;
	private int participant;
	private int validNum;
	private int invalidNum;
	private int votedNo;
	private int votes;
	
	/**
	 * @return 匡羭初Ω絪腹
	 */
	public String getElectionID() {
		return electionID;
	}
	
	/**
	 * @param electionID 匡羭初Ω絪腹
	 */
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}
	
	/**
	 * @return 郡カ嘿
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName 郡カ嘿
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return 匡跋
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName 匡跋
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return 秏马カ跋
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName 秏马カ跋
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * @return ń
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name ń
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return щ布┮
	 */
	public int getStation() {
		return station;
	}

	/**
	 * @param station щ布┮
	 */
	public void setStation(int station) {
		this.station = station;
	}

	/**
	 * @return 匡羭计
	 */
	public int getCitizen() {
		return citizen;
	}
	
	/**
	 * @param citizen 匡羭计
	 */
	public void setCitizen(int citizen) {
		this.citizen = citizen;
	}
	
	/**
	 * @return щ布计
	 */
	public int getParticipant() {
		return participant;
	}
	
	/**
	 * @param participant щ布计
	 */
	public void setParticipant(int participant) {
		this.participant = participant;
	}
	
	/**
	 * @return Τ布计
	 */
	public int getValidNum() {
		return validNum;
	}
	
	/**
	 * @param valid Τ布计
	 */
	public void setValidNum(int validNum) {
		this.validNum = validNum;
	}
	
	/**
	 * @return 礚布计
	 */
	public int getInvalidNum() {
		return invalidNum;
	}
	
	/**
	 * @param invalid 礚布计
	 */
	public void setInvalidNum(int invalidNum) {
		this.invalidNum = invalidNum;
	}
	
	/**
	 * @return 匡腹Ω
	 */
	public int getVotedNo() {
		return votedNo;
	}
	
	/**
	 * @param votedNo 匡腹Ω
	 */
	public void setVotedNo(int votedNo) {
		this.votedNo = votedNo;
	}
	
	/**
	 * @return 匡眔布计
	 */
	public int getVotes() {
		return votes;
	}
	
	/**
	 * @param votes 匡眔布计
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}
}
