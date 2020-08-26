package com.neuedu.care.service;

import java.util.List;

import com.neuedu.care.entity.Healthplan;

public interface HealthplanService {
	
	/**
	 * 添加健康计划
	 * 
	 */
	
	boolean addHealthplan(Integer aid,Integer eid,String phycondition,String plan,String recoverydays);
	
	/**
	 * 修改健康计划
	 * 
	 */
	boolean updateHealthplan(Integer pid,Integer aid,Integer eid,String phycondition,String plan,String recoverydays);
	
	/**
	 * 查询所有健康计划
	 * 
	 */
	List<Healthplan> findAllHealthplan();
	
	/**
	 * 根据健康计划编号，老人编号，老人姓名模糊查询
	 * 
	 */
	List<Healthplan> findByPidAidAname(Integer pid,Integer aid,String aname);
	
	/**
	 * 根据健康计划编号查询健康计划
	 * 
	 */
	
	Healthplan findByPid(Integer pid);
	
	

}
