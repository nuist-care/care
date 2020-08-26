package com.neuedu.care.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Go;

/**
 * JPA数据访问层GoRepository
 * @author 姚季
 *
 */
@Repository
public interface GoRepository extends JpaRepository<Go, Integer> {

	/**
	 * 根据编号，客户编号和审批人查询外出表
	 * @param gid
	 * @param aid
	 * @param approver
	 * @return
	 */
	@Query(nativeQuery = true,value = "select go.gid,go.aid,go.gotime,go.goreason,go.applytime,go.escort,go.approver,go.approvalstatus,client.aname from go,client where go.aid = client.aid and (go.gid=?1 or go.aid=?2 or go.approver like concat ('%',?3,'%'))")
	List<Go> findByGidOrAidOrApproverlike(@Param("gid")Integer gid,@Param("aid")Integer aid,@Param("approver")String approver);
	
	/**
	 * 查询所有外出表信息
	 * @return
	 */
	@Query(nativeQuery = true,value = "select client.aname,go.gotime,go.gid,go.aid,go.goreason,go.applytime,go.escort,go.approver,go.approvalstatus from go,client where go.aid = client.aid")
	List<Go> findInfo();
	
	/**
	 * 根据编号查询外出表记录
	 * @param gid
	 * @return
	 */
	@Query(nativeQuery = true,value = "select go.gotime,go.gid,go.aid,go.goreason,go.applytime,go.escort,go.approver,go.approvalstatus,client.aname from go,client where go.gid = ?1 and client.aid = go.aid")
	Go findByGid(@Param("gid")Integer gid);
	
	/**
	 * 根据编号删除外出记录
	 * @param gid
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "delete from go where go.gid = ?1")
	int deleteByGid(@Param("gid")Integer gid);
	
	/**
	 * 新增外出记录
	 * @param gid
	 * @param aid
	 * @param goresson
	 * @param gotime
	 * @param applytime
	 * @param escort
	 * @param approver
	 * @param approvalstatus
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "insert into go (aid,goreason,gotime,applytime,escort,approver,approvalstatus) values (?1,?2,?3,?4,?5,?6,?7)")
	int insert(@Param("aid")Integer aid,@Param("goreason")String goreason,@Param("gotime")Date gotime,
			@Param("applytime")String applytime,@Param("escort")String escort,@Param("approver")String approver,@Param("approvalstatus")String approvalstatus);
	
	/**
	 * 更新外出记录
	 * @param gid
	 * @param aid
	 * @param goreason
	 * @param gotime
	 * @param applytime
	 * @param escort
	 * @param approver
	 * @param approvalstatus
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "update go set aid = ?2,goreason = ?3,gotime = ?4,applytime = ?5,escort = ?6,approver = ?7,approvalstatus = ?8 where gid = ?1")
	int update(@Param("gid")Integer gid,@Param("aid")Integer aid,@Param("goreason")String goreason,@Param("gotime")Date gotime,
			@Param("applytime")String applytime,@Param("escort")String escort,@Param("approver")String approver,@Param("approvalstatus")String approvalstatus);
}
 