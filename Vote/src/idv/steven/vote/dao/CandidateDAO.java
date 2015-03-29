package idv.steven.vote.dao;

import idv.steven.vote.dto.Candidate;

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
	
	public int create(@Param("candidate") Candidate candidate);
	
	public int createSumOfCandidate(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("name") String name
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
