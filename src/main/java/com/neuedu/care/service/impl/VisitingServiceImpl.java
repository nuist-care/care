package com.neuedu.care.service.impl;

import java.util.Date;
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

	@Override
	public int updateVisiting(Integer vid, Integer aid, String aname, String vhospital, Date vtime, String vroom,
			String vresult) {
		// TODO Auto-generated method stub
		int line=vistingRepository.updateVisiting(vid, aid, aname, vhospital, vtime, vroom, vresult);
		return line;
	}



	@Override
	public int addVisiting(Integer aid, String aname, String vhospital, Date vtime, String vroom, String vresult) {
		int line=addVisiting(aid, aname, vhospital, vtime, vroom, vresult);
		return line;
	}



	@Override
	public List<Visiting> findAllVisiting() {
		return vistingRepository.findAllVisiting();
	}
	 

}
