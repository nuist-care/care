package com.neuedu.care.service;

import java.util.List;

import com.neuedu.care.entity.Serve;

/**
 *设置服务对象管理业务逻辑层接口ServeService
 * @author 马梦瑶
 *
 */
public interface ServeService {
	/**
	 * 删除服务信息
	 * @param serveid 服务编号
	 * @return 是否成功删除
	 */
	boolean delete(Integer serveid);
	
	/**
	 * 新增服务信息
	 * @param serve 服务信息对象
	 * @return 是否成功新增
	 */
	Serve insert(Serve serve);
	
	/**
	 * 根据服务编号查询服务信息
	 * @param serveid 服务编号
	 * @return 服务信息对象
	 */
	Serve selectByPrimaryKey(Integer serveid); 
	
	/**
	 * 查询所有服务信息
	 * @return 服务信息对象集合
	 */
	List<Serve> selectAll();
	
	/**
	 * 根据员工姓名、客户姓名进行多条件模糊查询
	 * @param ename 员工姓名
	 * @param aname 客户姓名
	 * @return 服务信息对象集合
	 */
	List<Serve> findByEnameContainingAndAnameContaining(String ename, String aname);
	
	/**
	 * 根据员工编号和客户编号精确查询服务对象信息
	 * @param eid 员工编号
	 * @param aid 客户编号
	 * @return 服务信息对象
	 */
	Serve findByEidAndAid(Integer eid, Integer aid);
}
