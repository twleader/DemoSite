package idv.steven.vote.dao;

import idv.steven.vote.dto.District;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
//@Transactional
public interface DistrictDAO {
	public List<District> findAll();
	
	/**
	 * �d�߫��w���m���Ͽﲼ�έp
	 * @param electionID ���|�����s��
	 * @param cityName �����W��
	 * @param areaName ��ϧO
	 * @param name �m���ϦW
	 * @return
	 */
	public District findDistrict(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("name") String name
			);
	
	/**
	 * �d�߫��w���Կ�H�A����w���m���Ϫ��o���ơC
	 * @param electionID ���|�����s��
	 * @param cityName �����W��
	 * @param areaName ��ϧO
	 * @param name �m���ϦW
	 * @param votedNo �Կ�H����
	 * @return
	 */
	public District findCandidate(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("name") String name,
			@Param("votedNo") int votedNo
			);
	
	/**
	 * 新增鄉鎮市區投票統計
	 */
	public int createDistrict(@Param("district") District district);

	/**
	 * 新增鄉鎮市區的某個號次候選人得票數
	 */
	public int createCandidate(@Param("district") District district);
	
	public int removeAll();
	
	public int removeDistrict(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("name") String name
			);
	
	public int removeCandidate(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("name") String name,
			@Param("votedNo") int votedNo
			);
}
