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
	 * @param eid 员工编号
	 * @return 是否成功删除
	 */
	boolean delete(Integer eid);
	
	/**
	 * 新增服务信息
	 * @param serve 服务信息对象
	 * @return 是否成功新增
	 */
	boolean insert(Serve serve);
	
	/**
	 * 根据员工编号查询服务信息
	 * @param eid 员工编号
	 * @return 部门信息对象集合
	 */
	List<Serve> selectByPrimaryKey(Integer eid); 
	
	/**
	 * 查询所有服务信息
	 * @return 服务信息对象集合
	 */
	List<Serve> selectAll();
}
