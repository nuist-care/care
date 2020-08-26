package com.neuedu.care.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.HealthplanRepository;
import com.neuedu.care.entity.Healthplan;
import com.neuedu.care.service.HealthplanService;

@Service
public class HealthplanServiceImpl implements HealthplanService{
 
	@Autowired
	HealthplanRepository healthplanRepository;
	
	/**
	 * 添加康复计划
	 **/
	@Override
	public boolean addHealthplan(Integer aid, Integer eid, String phycondition, String plan, String recoverydays) {
		int line=healthplanRepository.addHealthplan(aid, eid, phycondition, plan, recoverydays);
		return line==1?true:false;
	}
	/**
	 * 修改康复计划
	 **/
	@Override
	public boolean updateHealthplan(Integer pid, Integer aid, Integer eid, String phycondition, String plan,
			String recoverydays) {
		int line=healthplanRepository.updateHealthplan(pid, aid, eid, phycondition, plan, recoverydays);
		return line==1?true:false;
	}
	
	/**
	 * 查询所有康复计划
	 **/

	@Override
	public List<Healthplan> findAllHealthplan() {
		return healthplanRepository.findAllHealthplan();
	}
	/**
	 * 模糊查询康复计划
	 **/
	@Override
	public List<Healthplan> findByPidAidAname(Integer pid, Integer aid, String aname) {
		if(pid!=null&&pid<1) {
			pid=null;
		}
		if(aid!=null&&aid<1) {
			aid=null;
		}
		if(StringUtils.isBlank(aname)) {
		    aname=null;
		}
		return healthplanRepository.findByPidAidAname(pid, aid, aname);
	}
	/**
	 * 根据编号查询康复计划
	 **/
	@Override
	public Healthplan findByPid(Integer pid) {
	    return healthplanRepository.findByPid(pid);
	}

}
