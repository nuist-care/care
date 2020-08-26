package com.neuedu.care.service;

import java.util.Date;
import java.util.List;

import com.neuedu.care.entity.Healthassessment;


public interface HealthassessmentService {
	boolean addHealthassessment(Integer aid,String assesser,String assreason,String asstype,Date asstime,String assresult);
	
	boolean updateHealthassessment(Integer assid,Integer aid,String assesser,String assreason,String asstype,Date asstime,String assresult);
	
	List<Healthassessment> findAllHealthassessment();
	
	
	List<Healthassessment> findByAssidAidAname(Integer assid,Integer aid,String aname);
	
	Healthassessment findByAssid(Integer assid);

}
