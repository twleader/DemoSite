package idv.steven.vote.dao;

import idv.steven.vote.dto.Area;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaDAO {
	public List<Area> findAll();
	
	public Area findArea(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("name") String name
			);
	
	public int createArea(@Param("area") Area area);
	
	public int createCandidate(@Param("area") Area area);
	
	public int createSumOfArea(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("name") String name
			);
	
	public int createSumOfCandidate(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("name") String name
			);
	
	public int removeAll();
	
	public int removeArea(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("name") String name
			);
	
	public int removeCandidate(@Param("area") Area area);
}
