package com.neuedu.care.service;

import java.util.Date;
import java.util.List;

import com.neuedu.care.entity.Visiting;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;


public interface VisitingService {
	
	/**
	 * 添加就诊信息
	 * 
	 */
	boolean addVisiting(Integer aid,String vhospital,Date vtime,String vroom,String vresult);
	/**
	 * 修改就诊信息
	 * 
	 */
	boolean updateVisiting(Integer vid,Integer aid,String vhospital,Date vtime,String vroom,String vresult);
	/**
	 * 显示所有就诊信息
	 * 
	 */
	List<Visiting> findAllVisiting();
	/**
	 * 根据就诊编号，客户编号，客户姓名模糊查询
	 * 
	 */
	List<Visiting> findByVidAidAname(Integer vid,Integer aid,String aname);
	
	/**
	 * 根据就诊编号查询
	 * 
	 */
	Visiting findByVid(Integer vid);

}
