package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Healthplan;

/**
JPA数据访问层接口ServeRepository
*/
@Repository
public interface HealthplanRepository extends JpaRepository<Healthplan, Integer>{
	
	/**
	 * 查询所有健康计划信息
	 */
	@Transactional
	@Query(nativeQuery = true,value = "select p.pid,p.aid,p.eid,c.aname,e.ename,p.phycondition,p.plan,p.recoverydays "
			+ "from healthplan p,client c,employee e"
			+ " where p.aid=c.aid and p.eid=e.eid"
			+ " order by p.pid asc")
	List<Healthplan> findAllHealthplan();
	
	/**
	 * 根据编号查询健康计划信息
	 */
	@Transactional
	@Query(nativeQuery = true,value = "select p.pid,p.aid,p.eid,c.aname,e.eid,e.ename,p.phycondition,p.plan,p.recoverydays "
			+ "from healthplan p,client c,employee e"
			+ " where p.aid=c.aid and p.eid=e.eid and p.pid=?1")
	Healthplan findByPid(Integer pid);
	
	/**
	 * 评估编号，老人编号，老人姓名模糊查询
	 */
	@Transactional
	@Query(nativeQuery = true,value = "select p.pid,p.aid,p.eid,c.aname,e.ename,p.phycondition,p.plan,p.recoverydays "
			+ "from healthplan p,client c,employee e"
			+ " where p.aid=c.aid and p.eid=e.eid and (p.pid like concat('%',?1,'%') or p.aid like concat('%',?2,'%')"
			+ " or c.aname like concat('%',?3,'%'))"
			+ " order by p.pid asc")
	List<Healthplan> findByPidAidAname(@Param("pid")Integer pid,@Param("aid")Integer aid,@Param("aname")String aname);
	
	/**
	 * 添加健康计划信息
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "insert into healthplan(aid,eid,phycondition,plan,recoverydays)"
			+ " values(?1,?2,?3,?4,?5)")
	int addHealthplan(@Param("aid")Integer aid,@Param("eid")Integer eid,@Param("phycondition")String phycondition,@Param("plan")String plan,@Param("recoverydays")String recoverydays);
	
	/**
	 * 修改健康计划信息
	 */

	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "update healthplan set aid=?2,eid=?3,phycondition=?4,plan=?5,recoverydays=?6"
			+ " where pid=?1")
	int updateHealthplan(@Param("pid")Integer pid,@Param("aid")Integer aid,@Param("eid")Integer eid,@Param("phycondition")String phycondition,@Param("plan")String plan,@Param("recoverydays")String recoverydays);
	
}
