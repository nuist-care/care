package com.neuedu.care.service;

import java.util.List;

import com.neuedu.care.entity.Serve;

/**
 * 业务逻辑层接口ServeService
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
	boolean insert(Serve serve);
	
	/**
	 * 根据服务编号查询服务信息
	 * @param serveid 服务编号
	 * @return 服务信息对象集合
	 */
	Serve selectByPrimaryKey(Integer serveid); 
	
	/**
	 * 查询所有服务信息
	 * @return 服务信息对象集合
	 */
	List<Serve> selectAll();
	
	/**
	 * 根据员工姓名和客户姓名进行多条件模糊查询
	 * @param ename 员工姓名
	 * @param aname 客户姓名
	 * @return 服务信息对象集合
	 */
	List<Serve> findByEnameContainingAndAnameContaining(String ename, String aname);
}
