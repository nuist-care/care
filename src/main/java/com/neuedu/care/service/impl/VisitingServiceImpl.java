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

	/**
	 * 模糊查询就诊记录
	 **/
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

	/**
	 * 修改就诊记录
	 **/
	@Override
	public boolean updateVisiting(Integer vid, Integer aid, String vhospital, Date vtime, String vroom,
			String vresult) {
		int line=vistingRepository.updateVisiting(vid, aid, vhospital, vtime, vroom, vresult);
		return line==1?true:false;
	}



	/**
	 * 添加就诊记录
	 **/
	@Override
	public boolean addVisiting(Integer aid, String vhospital, Date vtime, String vroom, String vresult) {
		int line=vistingRepository.addVisiting(aid, vhospital, vtime, vroom, vresult);
		return line==1?true:false;
		
		
	}


	/**
	 * 查询所有就诊记录
	 **/

	@Override
	public List<Visiting> findAllVisiting() {
		return vistingRepository.findAllVisiting();
	}
	
	/**
	 * 根据编号查询
	 **/

	@Override
	public Visiting findByVid(Integer vid) {
		if (null == vid || vid < 1) {
			return null;
		}
		return vistingRepository.findByVid(vid);
	}
	 

}
