package com.neuedu.care.service;

import java.util.List;

import com.neuedu.care.entity.Duty;

/**
 * 值班信息管理业务逻辑层接口DutyService
 * @author 马梦瑶
 *
 */
public interface DutyService {
	
	/**
	 * 根据值班编号删除值班信息
	 * @param did 值班编号
	 * @return 是否成功删除
	 */
	boolean delete(Integer did);
	
	/**
	 * 新增值班信息
	 * @param dtime 值班时间
	 * @param ename 员工姓名
	 * @return 是否成功新增
	 */
	boolean insert(String dtime,String ename);
	
	/**
	 * 更新值班信息
	 * @param did 值班编号
	 * @param dtime 值班时间
	 * @param ename 员工姓名
	 * @return 是否成功更新
	 */
	boolean update(Integer did, String dtime, String ename);
	
	/**
	 * 查询所有值班信息
	 * @return 值班信息对象集合
	 */
	List<Duty> selectAll();

	/**
	 * 根据值班时间和员工姓名进行多条件模糊查询
	 * @param dtime 值班时间
	 * @param ename 员工姓名
	 * @return 值班信息对象集合
	 */
	List<Duty> findByCondition(String dtime, String ename);
	
	/**
	 * 根据值班编号查询值班信息
	 * @param did 值班编号
	 * @return 值班信息对象
	 */
	Duty findByDid(Integer did);
}
