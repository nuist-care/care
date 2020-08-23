package com.neuedu.care.service;

import java.util.Date;
import java.util.List;
//import java.util.Optional;

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
	Placard insert(Placard placard);
	
	/**
	 * 修改公告信息
	 * @param pid
	 * @param pauthor
	 * @param ptype
	 * @param ptime
	 * @param ptitle
	 * @param Pcontent
	 * @return
	 */
	int update(Integer pid,String pauthor,String ptype,Date ptime,String ptitle,String pcontent);
	
	/**
	 * 根据公告编号删除公告信息
	 * @param pid 公告编号
	 * @return 是否成功标志
	 */
	int delete(Integer pid);
	
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
	
	/**
	 * 根据编号，作者，类型进行查询
	 * @param pid
	 * @param pauthor
	 * @param ptype
	 * @return
	 */
	List<Placard> findByCondition(Integer pid,String pauthor,String ptype);
	
}
