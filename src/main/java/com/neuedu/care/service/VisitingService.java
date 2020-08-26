package com.neuedu.care.service;

import java.util.Date;
import java.util.List;

import com.neuedu.care.entity.Visiting;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;


public interface VisitingService {
	boolean addVisiting(Integer aid,String vhospital,Date vtime,String vroom,String vresult);
	
	boolean updateVisiting(Integer vid,Integer aid,String vhospital,Date vtime,String vroom,String vresult);
	
	List<Visiting> findAllVisiting();
	
	
	List<Visiting> findByVidAidAname(Integer vid,Integer aid,String aname);
	
	Visiting findByVid(Integer vid);

}
