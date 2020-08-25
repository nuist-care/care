package com.neuedu.care.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Nurseing;

/**
 * JPA数据访问层接口NurseingRepository
 * @author 马梦瑶
 *
 */
@Repository
public interface NurseingRepository extends JpaRepository<Nurseing, Integer>{

	/**
	 * 新增护理记录
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "insert into nurseing(aid,eid,ccontent,ctime) values (?1,?2,?3,?4) ")
	int insert(@Param("aid") Integer aid, @Param("eid") Integer eid, @Param("ccontent") String ccontent, @Param("ctime") Date ctime);
	
	/**
	 * 根据护理记录编号修改护理记录信息
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update nurseing set ccontent = ?2 where cid = ?1")
	int update(@Param("cid") Integer cid, @Param("ccontent") String ccontent);
	
	/** 
	 * 根据客户姓名进行模糊查询
	 */
	@Query(nativeQuery = true, value = "SELECT nurseing.cid, client.aname, nurseing.ccontent, nurseing.ctime, nurseing.eid, employee.ename FROM nurseing,client,employee WHERE nurseing.aid = client.aid AND nurseing.eid = employee.eid AND client.aname like concat ('%', ?1, '%')")
	List<Nurseing> findByAnameContaining(@Param("aname")String aname);
	
	/**
	 * 查询所有护理记录信息
	 */
	@Query(nativeQuery = true, value = "SELECT nurseing.cid, client.aname, nurseing.ccontent, nurseing.ctime, nurseing.eid, employee.ename FROM nurseing,client,employee WHERE nurseing.aid = client.aid AND nurseing.eid = employee.eid")
	List<Nurseing> findAll();
	
	/**
	 * 根据护理记录编号查询护理记录信息
	 */
	@Query(nativeQuery = true, value = "SELECT nurseing.cid, client.aname, nurseing.ccontent, nurseing.ctime, nurseing.eid, employee.ename FROM nurseing,client,employee WHERE nurseing.aid = client.aid AND nurseing.eid = employee.eid AND nurseing.cid = ?1")
	Nurseing findByCid(Integer cid);
	
	/**
	 * 根据客户姓名和护理时间精确查询护理记录信息
	 */
	@Query(nativeQuery = true, value = "SELECT nurseing.cid, client.aname, nurseing.ccontent, nurseing.ctime, nurseing.eid, employee.ename FROM nurseing,client,employee WHERE nurseing.aid = client.aid AND nurseing.eid = employee.eid AND client.aname = ?1 AND nurseing.ctime = ?2")
	List<Nurseing> findByAnameAndCtime(@Param("aname") String aname, @Param("ctime") Date ctime);
}
