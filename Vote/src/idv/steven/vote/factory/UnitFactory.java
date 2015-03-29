package idv.steven.vote.factory;

import idv.steven.vote.dto.Unit;

import org.springframework.beans.factory.FactoryBean;

public class UnitFactory implements FactoryBean<Unit>{
	
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
	
	@Override
	public Unit getObject() throws Exception {
		Unit unit = new Unit();
		unit.setElectionID(getElectionID());
		unit.setCityName(getCityName());
		unit.setAreaName(getAreaName());
		unit.setDistrictName(getDistrictName());
		unit.setName(getName());
		unit.setStation(getStation());
		unit.setCitizen(getCitizen());
		unit.setParticipant(getParticipant());
		unit.setValidNum(getValidNum());
		unit.setInvalidNum(getInvalidNum());
		unit.setVotedNo(getVotedNo());
		unit.setVotes(getVotes());
		
		return unit;
	}

	@Override
	public Class<Unit> getObjectType() {
		return Unit.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
	
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

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
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
}
