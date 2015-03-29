package idv.steven.vote.factory;

import idv.steven.vote.dto.District;

import org.springframework.beans.factory.FactoryBean;

public class DistrictFactory implements FactoryBean<District> {
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
	
	public String getElectionID() {
		return electionID;
	}

	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCitizen() {
		return citizen;
	}

	public void setCitizen(int citizen) {
		this.citizen = citizen;
	}

	public int getParticipant() {
		return participant;
	}

	public void setParticipant(int participant) {
		this.participant = participant;
	}

	public int getValidNum() {
		return validNum;
	}

	public void setValidNum(int validNum) {
		this.validNum = validNum;
	}

	public int getInvalidNum() {
		return invalidNum;
	}

	public void setInvalidNum(int invalidNum) {
		this.invalidNum = invalidNum;
	}

	public int getVotedNo() {
		return votedNo;
	}

	public void setVotedNo(int votedNo) {
		this.votedNo = votedNo;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public District getObject() throws Exception {
		District district = new District();
		
		district.setElectionID(getElectionID());
		district.setCitizen(getCitizen());
		district.setAreaName(getAreaName());
		district.setName(getName());
		district.setCitizen(getCitizen());
		district.setParticipant(getParticipant());
		district.setValidNum(getValidNum());
		district.setInvalidNum(getInvalidNum());
		district.setVotedNo(getVotedNo());
		district.setVotes(getVotes());
		
		return district;
	}

	@Override
	public Class<District> getObjectType() {
		return District.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
