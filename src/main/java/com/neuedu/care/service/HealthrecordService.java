package com.neuedu.care.service;

import java.util.List;


import com.neuedu.care.entity.Healthrecord;

public interface HealthrecordService {
	
	/**
	 * 查询所有健康档案
	 * 
	 */
	
	List<Healthrecord> findAllHealthrecord();
	
	/**
	 * 根据编号查询健康档案
	 * 
	 */
	
	Healthrecord findByRid(Integer rid);
	
	/**
	 * 根据档案编号，客户编号，客户姓名模糊查询
	 * 
	 */
	
	List<Healthrecord> findByRidAidAname(Integer rid,Integer aid,String aname);
	
	/**
	 * 添加健康档案
	 * 
	 */
	boolean addHealthrecord(Integer aid,Integer bpressure, Integer bfat,Integer bsugar,Integer heartrate);
	
	/**
	 * 修改健康档案
	 * 
	 */
	boolean updateHealthrecord(Integer rid,Integer aid,Integer bpressure, Integer bfat,Integer bsugar,Integer heartrate);
	
	

}
