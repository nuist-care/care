package com.neuedu.care.service;

import java.util.Date;
import java.util.List;

import com.neuedu.care.entity.Nurseing;

/**
 * 护理记录业务逻辑层接口NurseingService
 * @author 马梦瑶
 *
 */
public interface NurseingService {
	
	/**
	 * 新增护理记录
	 * @param nurseing 护理记录对象
	 * @return 是否成功新增
	 */
	Nurseing insert(Nurseing nurseing);
	
	/**
	 * 修改护理记录信息
	 * @param nurseing 护理记录对象
	 * @return 是否成功修改
	 */
	boolean update(Integer cid,String ccontent);
	
	/**
	 * 根据客户姓名进行模糊查询
	 * @param aname 客户姓名
	 * @return 护理记录对象合集
	 */
	List<Nurseing> findByCondition(String aname);
	
	/**
	 * 查询所有护理记录信息
	 * @return 护理记录对象合集
	 */
	List<Nurseing> selectAll();
	
	/**
	 *  根据护理记录编号查询护理记录信息
	 * @param cid 护理记录编号
	 * @return 护理记录对象
	 */
	Nurseing findByCid(Integer cid);
	
	/**
	 * 根据客户姓名和护理时间精确查询护理记录信息
	 * @param aname 客户姓名
	 * @param ctime 护理时间
	 * @return 护理记录对象集合
	 */
	Nurseing findByAnameAndCtime(String aname,Date ctime);

}
