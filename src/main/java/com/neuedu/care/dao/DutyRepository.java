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
	 * 新增值班信息
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "insert into duty(dtime,eid) value (?1,?2)")
	int insert(@Param("dtime") String dtime, @Param("eid") Integer eid);
	
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
	@Query(nativeQuery = true, value = "update duty set dtime = ?2, eid = ?3 where did = ?1")
	int updateDuty(@Param("did") Integer did, @Param("dtime") String dtime, @Param("eid") Integer eid);
	
	/**
	 * 根据值班时间和员工姓名进行多条件模糊查询
	 */
	@Query(nativeQuery = true,value = "SELECT duty.did,duty.dtime,duty.eid,employee.ename,employee.position FROM duty,employee WHERE duty.eid = employee.eid AND (duty.dtime like concat ('%', ?1, '%') OR employee.ename like concat ('%', ?2, '%'))")
	List<Duty> findByDtimeContainingAndDnurseContaining(@Param("dtime")String dtime, @Param("ename")String ename);
	
	/**
	 * 查询所有值班信息
	 */
	@Query(nativeQuery = true,value = "SELECT duty.did,duty.dtime,duty.eid,employee.ename,employee.position FROM duty,employee WHERE duty.eid = employee.eid")
	List<Duty> findAll();

	/**
	 * 根据值班编号查询值班信息
	 */
	@Query(nativeQuery = true,value = "SELECT duty.did,duty.dtime,duty.eid,employee.ename,employee.position FROM duty,employee WHERE duty.eid = employee.eid AND duty.did = ?1")
	Duty findByDid(Integer did);
	
	/**
	 * 根据值班时间和员工编号查询值班信息
	 */
	@Query(nativeQuery = true,value = "SELECT duty.did,duty.dtime,duty.eid,employee.ename,employee.position FROM duty,employee WHERE duty.eid = employee.eid AND duty.dtime = ?1 AND duty.eid = ?2")
	Duty findByDtimeAndEid(@Param("dtime") String dtime,@Param("eid") Integer eid);
	
	/**
	 * 根据值班时间和员工姓名查询值班信息
	 */
	@Query(nativeQuery = true,value = "SELECT duty.did,duty.dtime,duty.eid,employee.ename,employee.position FROM duty,employee WHERE duty.eid = employee.eid AND duty.dtime = ?1 AND employee.ename = ?2")
	Duty findByDtimeAndEname(@Param("dtime")String dtime,@Param("ename") String ename);
}
