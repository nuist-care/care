package com.neuedu.care.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.neuedu.care.entity.Client;

/**
 * 业务逻辑接口ClientService
 * @author 姚季
 *
 */
public interface ClientService {
	
	Page<Client> findAll(Pageable pageable);
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
	 * 根据客户姓名精确查询客户信息
	 * @param aname
	 * @return
	 */
	Client findByAname(String aname);
	
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
