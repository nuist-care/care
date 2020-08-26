package com.neuedu.care.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Healthassessment;
import com.neuedu.care.entity.Visiting;

/**
 * Jpa访问数据层接口HealthassessmentRepository*/

@Repository
public interface HealthassessmentRepository extends JpaRepository<Healthassessment, Integer>{
	/**
	 *  查询所有 */
	@Query(nativeQuery = true,value = "select h.assid,h.aid,c.aname,h.assesser,h.assreason,h.asstype,h.asstime,h.assresult from healthassessment h ,client c where h.aid=c.aid order by h.assid asc")
	List<Healthassessment> findAllHealthassessment();
	/**
	 *  条件查询 */
	@Query(nativeQuery = true,value = "select h.assid,h.aid,c.aname,h.assesser,h.assreason,h.asstype,h.asstime,h.assresult from healthassessment h ,client c where h.aid=c.aid and (h.assid like concat('%',?1,'%') or h.aid like concat('%',?2,'%') or c.aname like concat('%',?3,'%')) order by h.assid asc")
	List<Healthassessment> findByAssidAidAname(@Param("assid")Integer assid,@Param("aid")Integer aid,@Param("aname")String aname);
    
	/**
	 *  添加健康评估 */
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = "insert into healthassessment(aid,assesser,assreason,asstype,asstime,assresult) values(?1,?2,?3,?4,?5,?6) ")
	int addHealthassessment(@Param("aid")Integer aid,@Param("assesser")String assesser,@Param("assreason")String assreason,
			@Param("asstype")String asstype,@Param("asstime")Date asstime,@Param("assresult")String assresult);
	/**
	 *  修改 */
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = "update healthassessment h set h.aid = ?2,h.assesser = ?3,h.assreason=?4,h.asstype=?5,h.asstime = ?6,h.assresult = ?7  where  assid = ?1")
	int updateHealthassessment(@Param("assid")Integer assid,@Param("aid")Integer aid,@Param("assesser")String assesser,@Param("assreason")String assreason,
			@Param("asstype")String asstype,@Param("asstime")Date asstime,@Param("assresult")String assresult);
	/**
	 * 根据评估编号查询
	 */
	@Transactional
	@Query(nativeQuery = true, value = "select h.assid,h.aid,c.aname,h.assesser,h.assreason,h.asstype,h.asstime,h.assresult from healthassessment h ,client c WHERE h.aid = c.aid  AND h.assid = ?1")
	Healthassessment findByAssid(Integer assid);

}
