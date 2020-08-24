package com.neuedu.care.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.neuedu.care.entity.Client;

public interface ClientService {
	/**
	 * 查询所有客户
	 * @return
	 */
	List<Client> findAll();
	
	/**
	 * 查询一个用户
	 * @return
	 */
	Client findByid(Integer aid);
	/**
	 * 根据客户编号，姓名，护理等级进行多条件组合查询
	 * @param aid
	 * @param aname
	 * @param clevel
	 * @return
	 */
	List<Client> findByCondition(Integer aid,String aname,Integer clevel);
	
	/**
	 * 新增客户
	 * @param client
	 * @return
	 */
	Client save(Client client);
	
	/**
	 * 删除客户信息
	 * @param aid
	 * @return
	 */
	int delete(Integer aid);
	
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
	int update(Integer aid,String aname,String asex,Integer aage,String aIDnumber,
			String atelephone,String aaddress,String genetichistory,
			String conditiondescription,Integer clevel);
}
