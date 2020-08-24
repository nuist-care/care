package com.neuedu.care.service;

import java.util.Date;
import java.util.List;

import com.neuedu.care.entity.Food;

/**
 * 业务逻辑层接口FoodService
 * @author ASUS
 *
 */
public interface FoodService {

	/**
	 * 新增膳食信息
	 * @param food
	 * @return
	 */
	Food insert(Food food);
	
	/**
	 * 修改膳食信息
	 * @param fid
	 * @param aid
	 * @param ftime
	 * @param ftype
	 * @param fcontent
	 * @return
	 */
	int update(Integer fid,Integer aid,Date ftime,String ftype,String fcontent);
	
	/**
	 * 根据膳食编号删除膳食信息
	 * @param fid
	 * @return
	 */
	int delete(Integer fid);
	
	/**
	 * 根据膳食编号查询膳食信息
	 * @param fid
	 * @return
	 */
	Food selectByFid(Integer fid);
	
	/**
	 * 查询所有膳食信息
	 * @return
	 */
	List<Food> selectAll();
	
	/**
	 * 根据客户信息查询膳食信息
	 * @return
	 */
	List<Food> findByAid(Integer aid);

	/**
	 * 查询所有膳食信息，并按照时间排序
	 * @return
	 */
	List<Food> selectAll2();
}
