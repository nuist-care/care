package com.neuedu.care.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Serve;
import com.neuedu.care.entity.Visiting;



/**
 * Jpa访问数据层接口VistingRepository*/

@Repository
public interface VistingRepository extends JpaRepository<Visiting, Integer>{
	/**
	 *  查询所有 */
	@Query(nativeQuery = true,value = "select v.vid,v.aid,c.aname,v.vhospital,v.vtime,v.vroom,v.vresult from visiting v ,client c where v.aid=c.aid")
	List<Visiting> findAllVisiting();
	/**
	 *  条件查询 */
	@Query(nativeQuery = true,value = "select v.vid,v.aid,c.aname,v.vhospital,v.vtime,v.vroom,v.vresult from visiting v ,client c where v.aid=c.aid and (v.vid like concat('%',?1,'%') or v.aid like concat('%',?2,'%') or c.aname like concat('%',?3,'%'))")
	List<Visiting> findByVidAidAname(@Param("vid")Integer vid,@Param("aid")Integer aid,@Param("aname")String aname);
    
	/**
	 *  添加就诊信息 */
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = "insert into visiting(aid,vhospital,vtime,vroom,vresult) values(?1,?2,?3,?4,?5) ")
	int addVisiting(@Param("aid")Integer aid,@Param("vhospital")String vhospital,
			@Param("vtime")Date vtime,@Param("vroom")String vroom,@Param("vresult")String vresult);
	/**
	 *  修改 */
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = "update visiting v ,client c set v.aid = ?2,c.aname = ?3,v.vhospital = ?4,v.vtime = ?5,v.vroom = ?6,v.vresult = ?7  where v.aid=c.aid and vid = ?1")
	int updateVisiting(@Param("vid")Integer vid,@Param("aid")Integer aid,@Param("aname")String aname,@Param("vhospital")String vhospital,
			@Param("vtime")Date vtime,@Param("vroom")String vroom,@Param("vresult")String vresult);
	/**
	 * 根据编号查询
	 */
	@Transactional
	@Query(nativeQuery = true, value = "select v.vid,v.aid,c.aname,v.vhospital,v.vtime,v.vroom,v.vresult FROM visiting v,client c WHERE v.aid = c.aid  AND v.vid = ?1")
	Visiting findByVid(Integer vid);
}
