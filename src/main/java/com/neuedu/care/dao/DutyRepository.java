package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Duty;

/**
 * JPA数据访问层接口DutyRepository
 * @author 马梦瑶
 *
 */
@Repository
public interface DutyRepository extends JpaRepository<Duty, Integer>{
	
	/**
	 * 根据值班编号删除值班信息
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "delete from duty where did = ?1")
	int deleteByPrimaryKey(@Param("did") Integer did);
	
	/**
	 * 根据值班编号修改值班信息
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update duty set dtime = ?2, dnurse = ?3 where did = ?1")
	int updateDuty(@Param("did") Integer did, @Param("dtime") String dtime, @Param("dnurse") String dnurse);
	
	/**
	 * 根据值班时间和值班人员进行多条件模糊查询
	 */
	@Transactional
	List<Duty> findByDtimeContainingAndDnurseContaining(@Param("dtime")String dtime, @Param("dnurse")String dnurse);
	
	/**
	 * 查询所有值班信息
	 */
	@Transactional
	List<Duty> findAll();

	/**
	 * 根据值班编号查询值班信息
	 */
	@Transactional
	Duty findByDid(Integer did);
}
