package com.neuedu.care.service;

import java.util.List;

import com.neuedu.care.entity.Healthplan;

public interface HealthplanService {
	
	boolean addHealthplan(Integer aid,Integer eid,String phycondition,String plan,String recoverydays);
	
	boolean updateHealthplan(Integer pid,Integer aid,Integer eid,String phycondition,String plan,String recoverydays);
	
	List<Healthplan> findAllHealthplan();
	
	List<Healthplan> findByPidAidAname(Integer pid,Integer aid,String aname);
	
	Healthplan findByPid(Integer pid);
	
	

}
