package com.neuedu.care.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Checkin;

/**
 * JPA数据访问层CheckinRepository
 * @author 姚季
 *
 */
@Repository
public interface CheckinRepository extends JpaRepository<Checkin, Integer>{
	
	/**
	 * 查询所有入住记录
	 * @return
	 */
	@Query(nativeQuery = true,value = "select checkin.iid,checkin.aid,checkin.intime,checkin.outtime,client.aname,client.asex,client.aage,client.aIDnumber,client.atelephone from checkin,client where checkin.aid = client.aid")
	Page<Checkin> findAllInfo(Pageable pageable);
	
	/**
	 * 根据入住记录编号查询入住记录
	 * @param id
	 * @return
	 */
	@Query(nativeQuery = true,value = "select checkin.iid,checkin.aid,checkin.intime,checkin.outtime,client.aname,client.asex,client.aage,client.aIDnumber,client.atelephone from checkin,client where checkin.aid = client.aid and checkin.iid = ?1")
	Checkin findByIid(Integer id);
	
	/**
	 * 入住记录编号，客户编号，客户姓名多条件查询入住记录
	 * @param iid
	 * @param aid
	 * @param aname
	 * @return
	 */
	@Query(nativeQuery = true,value = "select checkin.iid,checkin.aid,checkin.intime,checkin.outtime,client.aname,client.asex,client.aage,client.aIDnumber,client.atelephone"
			+ " from checkin,client where checkin.aid = client.aid and (checkin.iid = ?1 or checkin.aid = ?2 or client.aname like concat ('%',?3,'%'))")
	List<Checkin> findByCondition(Integer iid,Integer aid,String aname);
	
	/**
	 * 删除入住记录
	 * @param iid
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "delete from checkin where checkin.iid = ?1")
	int deleteByIid(Integer iid);
	
	/**
	 * 插入入住记录
	 * @param aid
	 * @param intime
	 * @param outtime
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "insert into checkin (aid,intime,outtime) values (?1,?2,?3)")
	int insert(@Param("aid")Integer aid,@Param("intime")Date intime,@Param("outtime")Date outtime);
	
	/**
	 * 更新入住记录
	 * @param iid
	 * @param intime
	 * @param outtime
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "update checkin set intime = ?2,outtime = ?3 where iid = ?1")
	int update(@Param("iid")Integer iid,@Param("intime")Date intime,@Param("outtime")Date outtime);
}
