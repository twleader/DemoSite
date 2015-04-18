package idv.steven.demo.dao;

import idv.steven.demo.dto.Election;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionDAO {
	public List<Election> findAll();
	
	public Election findById(@Param("id") String id);
	
	public Election findByName(@Param("name") String name);
	
	public int create(
			@Param("year") int year,
			@Param("name") String name,
			@Param("id") String id
			);
	
	public int removeAll();
}
