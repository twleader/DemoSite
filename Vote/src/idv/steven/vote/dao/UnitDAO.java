package idv.steven.vote.dao;

import idv.steven.vote.dto.Unit;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UnitDAO {
	public List<Unit> findAll();
	
	/**
	 * �d�߫��w�������ﲼ�έp
	 * @param electionID ���|�����s��
	 * @param cityName �����W��
	 * @param areaName ��ϧO
	 * @param name ����
	 * @return
	 */
	public Unit findUnit (
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("name") String name
			);
	
	/**
	 * �d�߫��w���Կ�H�A����w���벼�Ҫ��o���ơC
	 * @param electionID ���|�����s��
	 * @param cityName �����W��
	 * @param areaName ��ϧO
	 * @param station �벼�ҧO
	 * @param votedNo �Կ�H����
	 * @return
	 */
	public Unit findCandidateAtStation(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("station") int station,
			@Param("votedNo") int votedNo
			);
	
	/**
	 * �d�߫��w���Կ�H�A����w���벼�Ҫ��o���ơC
	 * @param electionID ���|�����s��
	 * @param cityName �����W��
	 * @param areaName ��ϧO
	 * @param station �벼�ҧO
	 * @param votedNo �Կ�H����
	 * @return
	 */
	public Unit findCandidateAtUnit(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("unit") String unit,
			@Param("votedNo") int votedNo
			);	
	
	/**
	 * �d�ߧ벼�ҧ벼�έp
	 * @param electionID
	 * @param cityName
	 * @param areaName
	 * @param station
	 * @return
	 */
	public Unit findStation(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("station") int station
			);
	
	/**
	 * 新增投票所投票統計
	 * @param unit
	 * @return
	 */
	public int createStation(@Param("unit") Unit unit);

	/**
	 * 新增投票所指定候選人的得票統計
	 * @param unit
	 * @return
	 */
	public int createCandidate(@Param("unit") Unit unit);
	
	public int removeAll();
	
	public int removeUnit(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("name") String name
			);

	public int removeStation(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areaName,
			@Param("station") int station
			);

	public int removeCandidateAtStation(
			@Param("electionID") String electionID,
			@Param("cityName") String cityName,
			@Param("areaName") String areatName,
			@Param("station") int station,
			@Param("votedNo") int votedNo
			);
}
