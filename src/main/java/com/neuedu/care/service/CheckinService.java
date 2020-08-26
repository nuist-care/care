package com.neuedu.care.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.neuedu.care.entity.Checkin;

/**
 * 业务逻辑接口CheckinService
 * @author 姚季
 *
 */
public interface CheckinService {
	/**
	 * 查询所有入住记录
	 * @return
	 */
	Page<Checkin> findAll(Pageable pageable);
	
	/**
	 * 入住记录编号，客户编号，客户姓名多条件查询入住记录
	 * @param iid
	 * @param aid
	 * @param aname
	 * @return
	 */
	List<Checkin> findByCondition(Integer iid,Integer aid,String aname);
	
	/**
	 * 根据入住记录编号查询入住记录
	 * @param id
	 * @return
	 */
	Checkin findById(Integer id);
	
	/**
	 * 插入入住记录
	 * @param intime
	 * @param outtime
	 * @param aname
	 * @param asex
	 * @param aage
	 * @param aIDnumber
	 * @param atelephone
	 * @return
	 */
	int insert(Date intime,Date outtime,String aname,String asex,Integer aage,String aIDnumber,String atelephone);
	
	/**
	 * 更新入住记录
	 * @param iid
	 * @param intime
	 * @param outtime
	 * @return
	 */
	int update(Integer iid,Date intime,Date outtime);
	
	/**
	 * 删除入住记录
	 * @param iid
	 * @return
	 */
	int delete(Integer iid);
}
