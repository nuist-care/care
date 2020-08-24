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
	@Query(nativeQuery = true,value = "select client.aname,go.gid,go.aid,go.gotime,go.goreason,go.applytime,go.escort,go.approver,go.approvalstatus from go,client where go.gid=?1 or go.aid=?2 or go.approver like concat ('%',?3,'%')")
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
	@Query(nativeQuery = true,value = "select client.aname,go.gotime,go.gid,go.aid,go.goreason,go.applytime,go.escort,go.approver,go.approvalstatus from go,client where go.gid = ?1 and client.aid = go.aid")
	Go findByGid(@Param("gid")Integer gid);
	
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "delete from go where go.gid = ?1")
	int deleteByGid(@Param("gid")Integer gid);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "delete from go where go.gid = ?1")
	Go insert(Integer gid,Integer aid,String goresson,Date gotime,String applytime,String escort,String approver,String approvalstatus);
}
 