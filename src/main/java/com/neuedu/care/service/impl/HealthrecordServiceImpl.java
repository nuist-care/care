package com.neuedu.care.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.HealthrecordRepository;
import com.neuedu.care.entity.Healthrecord;
import com.neuedu.care.service.HealthrecordService;

@Service
public class HealthrecordServiceImpl implements HealthrecordService{
	
	@Autowired
	HealthrecordRepository healthrecordRepository;

	/**
	 * 查询所有健康档案
	 **/
	@Override
	public List<Healthrecord> findAllHealthrecord() {
		return healthrecordRepository.findAllHealthrecord();
	}

	/**
	 * 根据编号查询健康档案
	 **/
	@Override
	public Healthrecord findByRid(Integer rid) {
		return healthrecordRepository.findByRid(rid);
	}

	/**
	 * 模糊查询健康档案
	 **/
	@Override
	public List<Healthrecord> findByRidAidAname(Integer rid, Integer aid, String aname) {
		if(rid!=null&&rid<1) {
			rid=null;
		}
		if(aid!=null&&aid<1) {
			aid=null;
		}
		if(StringUtils.isBlank(aname)) {
		    aname=null;
		}
		return healthrecordRepository.findByRidAidAname(rid, aid, aname);
	}
	
	/**
	 * 增加健康档案
	 **/

	@Override
	public boolean addHealthrecord(Integer aid, Integer bpressure, Integer bfat, Integer bsugar, Integer heartrate) {
		int line=healthrecordRepository.addHealthrecord(aid, bpressure, bfat, bsugar, heartrate);
		return line==1?true:false;
	}

	/**
	 * 修改健康档案
	 **/
	@Override
	public boolean updateHealthrecord(Integer rid, Integer aid, Integer bpressure, Integer bfat, Integer bsugar,
			Integer heartrate) {
		int line=healthrecordRepository.updateHealthrecord(rid, aid, bpressure, bfat, bsugar, heartrate);
		return line==1?true:false;
				
	}

}
