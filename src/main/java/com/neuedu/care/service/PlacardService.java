package com.neuedu.care.service;

import java.util.List;

import com.neuedu.care.entity.Placard;

/**
 * 业务逻辑层接口PlacardService
 * @author ASUS
 *
 */
public interface PlacardService {

	/**
	 * 新增公告
	 * @param placard 公告信息对象
	 * @return 是否成功标志
	 */
	boolean insert(Placard placard);
	
	/**
	 * 修改公告
	 * @param placard 公告信息对象
	 * @return 是否成功标志
	 */
	boolean update(Placard placard);
	
	/**
	 * 根据公告编号删除公告信息
	 * @param pid 公告编号
	 * @return 是否成功标志
	 */
	boolean delete(Integer pid);
	
	/**
	 * 根据公告编号查询公告信息
	 * @param pid 公告编号
	 * @return 是否成功标志
	 */
	Placard selectByPid(Integer pid);
	
	/**
	 * 查询所有公告信息
	 * @return 公告信息对象集合
	 */
	List<Placard> selectAll();
	
}
