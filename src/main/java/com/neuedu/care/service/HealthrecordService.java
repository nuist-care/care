package com.neuedu.care.service;

import java.util.List;


import com.neuedu.care.entity.Healthrecord;

public interface HealthrecordService {
	
	List<Healthrecord> findAllHealthrecord();
	
	Healthrecord findByRid(Integer rid);
	
	List<Healthrecord> findByRidAidAname(Integer rid,Integer aid,String aname);
	
	boolean addHealthrecord(Integer aid,Integer bpressure, Integer bfat,Integer bsugar,Integer heartrate);
	
	boolean updateHealthrecord(Integer rid,Integer aid,Integer bpressure, Integer bfat,Integer bsugar,Integer heartrate);
	
	

}
