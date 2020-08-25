package com.neuedu.care.service;

import java.util.List;

import com.neuedu.care.entity.Bed;

/**
 * 业务逻辑层接口BedService
 * @author ASUS
 *
 */
public interface BedService {

	/**
	 * 新增床位信息
	 * @param bed
	 * @return
	 */
	Bed insert(Bed bed);
	
	/**
	 * 修改床位信息
	 * @param bid
	 * @param floor
	 * @param room
	 * @param bnum
	 * @param aid
	 * @return
	 */
	int update(Integer bid,Integer floor,Integer room,Integer bnum,Integer aid);
	
	/**
	 * 根据床位编号删除床位信息
	 * @param bid
	 * @return
	 */
	int delete(Integer bid);
	
	/**
	 * 根据床位编号查询床位信息
	 * @param bid
	 * @return
	 */
	Bed selectByBid(Integer bid);
	
	/**
	 * 查询所有床位信息
	 * @return
	 */
	List<Bed> selectAll();
	
	/**
	 * 根据客户编号查询床位信息 by马梦瑶
	 */
	Bed findByAid(Integer aid);
}
