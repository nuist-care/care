package com.neuedu.care.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.HealthassessmentRepository;
import com.neuedu.care.entity.Healthassessment;
import com.neuedu.care.service.HealthassessmentService;

@Service
public class HealthassessmentServiceImpl implements HealthassessmentService{

	
	@Autowired 
	HealthassessmentRepository healthassessmentRepository;
	/**
	 * 添加健康评估
	 **/
	@Override
	public boolean addHealthassessment(Integer aid, String assesser, String assreason, String asstype, Date asstime,
			String assresult) {
		
		int line=healthassessmentRepository.addHealthassessment(aid, assesser, assreason, asstype, asstime, assresult);
		return line==1?true:false;
	}
	/**
	 * 修改健康评估
	 **/
	@Override
	public boolean updateHealthassessment(Integer assid, Integer aid, String assesser, String assreason, String asstype,
			Date asstime, String assresult) {
		int line=healthassessmentRepository.updateHealthassessment(assid, aid, assesser, assreason, asstype, asstime, assresult);
		return line==1?true:false;
	}
	/**
	 * 查询所有健康评估
	 **/
	@Override
	public List<Healthassessment> findAllHealthassessment() {
		
		return healthassessmentRepository.findAllHealthassessment();
	}
	
	/**
	 * 模糊查询健康评估
	 **/

	@Override
	public List<Healthassessment> findByAssidAidAname(Integer assid, Integer aid, String aname) {
		//去除空字符串
		if(assid!=null&&assid<1) {
			assid=null;
		}
		if(aid!=null&&aid<1) {
			aid=null;
		}
		if(StringUtils.isBlank(aname)) {
		    aname=null;
			
		}
		return healthassessmentRepository.findByAssidAidAname(assid, aid, aname);
	}
	
	/**
	 * 根据编号查询健康评估
	 **/
	
	@Override
	public Healthassessment findByAssid(Integer assid) {
		
		return healthassessmentRepository.findByAssid(assid);
	}

}
