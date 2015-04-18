package idv.steven.demo.dao;

import idv.steven.demo.dto.Candidate;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDAO {
	public List<Candidate> findAll();
	
	public Candidate find(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("votedNo") int votedNo
			);
	
	/**
	 * 查詢某次選舉的所有縣市名稱
	 * @param electionID 選舉編號
	 * @return
	 */
	public List<String> findCityName(@Param("electionID") String electionID);
	
	/**
	 * 查詢某次選舉某縣市的所有選區名稱
	 * @param electionID 選舉編號
	 * @param cityName 縣市
	 * @return
	 */
	public List<String> findAreaName(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName
		);
	
	/**
	 * 查詢某次選舉某縣市的某選區的所有候選人得票狀況
	 * @param electionID 選舉編號
	 * @param cityName 縣市
	 * @param name 選區
	 * @return
	 */
	public List<Candidate> findCandidate(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName
		);
	
	public int create(@Param("candidate") Candidate candidate);
	
	public int createSumOfCandidate(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName
		);
	
	/**
	 * 更新候選人姓名、黨籍
	 * @param candidate
	 * @return
	 */
	public int updateCandidateDetail(@Param("candidate") Candidate candidate);
	
	public int removeAll();
	
	public int remove(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("votedNo") int votedNo
		);
}
