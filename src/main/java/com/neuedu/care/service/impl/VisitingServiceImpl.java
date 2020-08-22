package com.neuedu.care.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.VistingRepository;
import com.neuedu.care.entity.Visiting;
import com.neuedu.care.service.VisitingService;

@Service
public class VisitingServiceImpl implements VisitingService{
	@Autowired
	public VistingRepository vistingRepository;

	@Override
	public boolean insert(Visiting visiting) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Visiting visiting) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Visiting> findAll() {
		// TODO Auto-generated method stub
		return vistingRepository.findAll();
	}

	@Override
	public List<Visiting> findByVidAidAname(Integer vid, Integer aid, String aname) {
		//业务逻辑判断
		if(vid!=null&&vid<1) {
			vid=null;
		}
		if(aid!=null&&aid<1) {
			aid=null;
		}
		if(StringUtils.isBlank(aname)) {
		    aname=null;
			
		}
		return vistingRepository.findByVidAidAname(vid, aid, aname); 
	}
	 

}
