package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
	List<Go> findByGidOrAidOrApproverContaining(Integer gid,Integer aid,String approver);
	
	List<Go> findInfo();
}
