package com.neuedu.care.service;

import java.util.List;

import com.neuedu.care.entity.Visiting;


public interface VisitingService {
	boolean insert(Visiting visiting);
	
	boolean update(Visiting visiting);
	
	List<Visiting> findAll();
	
	List<Visiting> findByVidAidAname(Integer vid,Integer aid,String aname);

}
