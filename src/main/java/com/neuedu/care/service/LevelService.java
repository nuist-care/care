package com.neuedu.care.service;

import java.util.List;

import com.neuedu.care.entity.Level;

/**
 * 护理级别管理业务逻辑层接口LevelService
 * @author 马梦瑶
 *
 */
public interface LevelService {
	
	/**
	 * 根据客户编号修改护理等级
	 * @param aid 客户编号
	 * @param clevel 护理等级
	 * @return 是否修改成功
	 */
	boolean update(Integer aid,Integer clevel);
	
	/**
	 * 根据客户姓名进行模糊查询
	 * @param aname 客户姓名
	 * @return 护理级别信息对象集合
	 */
	List<Level> findByCondition(String aname);
	
	/**
	 * 查询所有护理级别信息
	 * @return 护理级别信息对象集合
	 */
	List<Level> selectAll();
	
	/**
	 * 根据客户编号查询护理级别信息
	 * @param aid 客户编号
	 * @return 护理级别信息对象
	 */
	Level findByAid(Integer aid);
}
