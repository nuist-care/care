package com.neuedu.care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.DutyRepository;
import com.neuedu.care.entity.Duty;
import com.neuedu.care.service.DutyService;

/**
 * 业务逻辑接口DutyService实现类DutyServiceImpl
 * 
 * @author 马梦瑶
 *
 */
@Service
public class DutyServiceImpl implements DutyService {

	@Autowired
	private DutyRepository dutyRepository;

	/**
	 * 根据值班编号删除值班信息
	 */
	@Override
	public boolean delete(Integer did) {
		// 业务判断：值班编号不能为null且不能小于1
		if (null == did || did < 1) {
			return false;
		}
		int line = dutyRepository.deleteByPrimaryKey(did);
		return line == 1 ? true : false;
	}

	/**
	 * 新增值班信息
	 */
	@Override
	public boolean insert(Duty duty) {
		// 业务判断：值班对象不能为null
		if (null == duty) {
			return false;
		}
		// 非空属性判断
		if (org.apache.commons.lang3.StringUtils.isBlank(duty.getDtime())
				|| org.apache.commons.lang3.StringUtils.isBlank(duty.getDnurse())) {
			return false;
		}
		// 不能重复添加
				Duty d = dutyRepository.findByDid(duty.getDid());
				if (null != d) {
					return false;
				}
		Duty line = dutyRepository.save(duty);
		return line.getDid().intValue() != 0 ? true : false;
	}

	/**
	 * 更新值班信息
	 */
	@Override
	public boolean update(Integer did, String dtime, String dnurse) {
		// 业务判断：非空属性判断
		if (null == did
				|| org.apache.commons.lang3.StringUtils.isBlank(dtime)
				|| org.apache.commons.lang3.StringUtils.isBlank(dnurse)) {
			return false;
		}
		int line = dutyRepository.updateDuty(did, dtime, dnurse);
		return line == 1 ? true : false;
	}

	/**
	 * 根据值班时间和值班人员进行多条件模糊查询
	 */
	@Override
	public List<Duty> findByCondition(String dtime, String dnurse) {
		// 字符串主动去除空格
		if(null != dnurse) {
			dnurse = dnurse.trim();
			if (dnurse.length() == 0) {
				dnurse = "";
			}
		}
		if(null != dtime) {
			dtime = dtime.trim();
			if (dtime.length() == 0) {
				dtime = "";
			}
		}
		return dutyRepository.findByDtimeContainingAndDnurseContaining(dtime, dnurse);
	}

	/**
	 * 查询所有值班信息
	 */
	@Override
	public List<Duty> selectAll() {
		return dutyRepository.findAll();
	}

	/**
	 * 根据值班编号查询值班信息
	 */
	@Override
	public Duty findByDid(Integer did) {
		// 业务判断：值班编号不能为空且不能小于1
		if (null == did || did < 1) {
			did = null;
		}
		return dutyRepository.findByDid(did);
	}
}
