package idv.steven.vote.dao;

import idv.steven.vote.dto.ZipArea;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipAreaDAO {
	public List<ZipArea> findAll();
	public ZipArea find(@Param("zipCode") String zipCode);
	public int create(@Param("zipCode") String zipCode, @Param("name") String name);
	public int removeAll();
}
