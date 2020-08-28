package com.neuedu.care.service;

import java.util.Date;
import java.util.List;

import com.neuedu.care.entity.Healthassessment;


public interface HealthassessmentService {
	
	/**
	 * 添加健康评估
	 * 
	 */
	
	boolean addHealthassessment(Integer aid,String assesser,String assreason,String asstype,Date asstime,String assresult);
	
	/**
	 * 修改健康评估
	 * 
	 */
	boolean updateHealthassessment(Integer assid,Integer aid,String assesser,String assreason,String asstype,Date asstime,String assresult);
	
	
	/**
	 * 查询所有健康评估
	 * 
	 */
	List<Healthassessment> findAllHealthassessment();
	
	/**
	 * 通过评估编号，客户编号，客户名模糊查询健康评估
	 * 
	 */
	
	List<Healthassessment> findByAssidAidAname(Integer assid,Integer aid,String aname);
	
	/**
	 * 根据评估编号查询健康评估
	 * 
	 */
	
	Healthassessment findByAssid(Integer assid);

}
