package com.neuedu.care.service;

import java.util.Date;
import java.util.List;

import com.neuedu.care.entity.Go;



/**
 * 业务逻辑接口GoService
 * @author 姚季
 *
 */
public interface GoService {
	/**
	 * 查询所有客户
	 * @return
	 */
	List<Go> findAll();
	
	/**
	 * 查询一个用户
	 * @return
	 */
	Go findByid(Integer gid);
	/**
	 * 根据客户编号，姓名，护理等级进行多条件组合查询
	 * @param aid
	 * @param aname
	 * @param clevel
	 * @return
	 */
	List<Go> findByCondition(Integer gid,Integer aid,String approver);
	
	/**
	 * 新增客户
	 * @param client
	 * @return
	 */
	int save(Integer aid,String goreason,Date gotime,String applytime,String escort,String approver,String approvalstatus);
	
	/**
	 * 删除客户信息
	 * @param aid
	 * @return
	 */
	int delete(Integer gid);
	
	/**
	 * 更新客户信息
	 * @param aid
	 * @param aname
	 * @param asex
	 * @param aage
	 * @param aIDnumber
	 * @param atelephone
	 * @param aaddress
	 * @param genetichistory
	 * @param conditiondescription
	 * @param clevel
	 * @return
	 */
	int update(Integer gid,Integer aid,String goreason,Date gotime,String applytime,String escort,String approver,String approvalstatus);
}
