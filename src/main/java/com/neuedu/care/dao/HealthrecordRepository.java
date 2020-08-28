package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.neuedu.care.entity.Healthrecord;

/**
JPA数据访问层接口HealthrecordRepository
*/
@Repository
public interface HealthrecordRepository extends JpaRepository<Healthrecord, Integer>{
	/**
	 * 查询所有健康档案
	 */
	@Transactional
	@Query(nativeQuery = true,value = "select r.rid,r.aid,c.aname,r.bpressure,r.bfat,r.bsugar,r.heartrate "
			+ " from healthrecord r,client c"
			+ " where r.aid=c.aid "
			+ " order by  r.rid asc")
	List<Healthrecord> findAllHealthrecord();
	
	/**
	 * 根据编号查询健康档案
	 */
	@Transactional
	@Query(nativeQuery = true,value = "select r.rid,r.aid,c.aname,r.bpressure,r.bfat,r.bsugar,r.heartrate "
			+ " from healthrecord r,client c"
			+ " where r.aid=c.aid and r.rid=?1"
			+ "  order by  r.rid asc")
	Healthrecord findByRid(Integer rid);

	/**
	 * 档案编号，客户编号，客户姓名模糊查询
	 */
	@Transactional
	@Query(nativeQuery = true,value = "select r.rid,r.aid,c.aname,r.bpressure,r.bfat,r.bsugar,r.heartrate "
			+ " from healthrecord r,client c"
			+ " where r.aid=c.aid  and (r.rid like concat('%',?1,'%') or r.aid like concat('%',?2,'%')"
			+ " or c.aname like concat('%',?3,'%'))")
	List<Healthrecord> findByRidAidAname(@Param("rid")Integer rid,@Param("aid")Integer aid,@Param("aname")String aname);
	
	/**
	 * 添加健康档案
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "insert into healthrecord(aid,bpressure,bfat,bsugar,heartrate)"
			+ " values(?1,?2,?3,?4,?5)")
	int addHealthrecord(@Param("aid")Integer aid,
			@Param("bpressure")Integer bpressure,
			@Param("bfat")Integer bfat,
			@Param("bsugar")Integer bsugar,
			@Param("heartrate")Integer heartrate);
	
	/**
	 * 修改健康档案
	 */

	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "update healthrecord set aid=?2,bpressure=?3,bfat=?4,bsugar=?5,heartrate=?6"
			+ " where rid=?1")
	int updateHealthrecord(@Param("rid")Integer rid,
			@Param("aid")Integer aid,
			@Param("bpressure")Integer bpressure,
			@Param("bfat")Integer bfat,
			@Param("bsugar")Integer bsugar,
			@Param("heartrate")Integer heartrate);
}
