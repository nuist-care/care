package com.neuedu.care.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.ClientRepository;
import com.neuedu.care.dao.NurseingRepository;
import com.neuedu.care.entity.Client;
import com.neuedu.care.entity.Nurseing;
import com.neuedu.care.service.NurseingService;

/**
 * 护理记录管理业务逻辑层接口NurseingService实现类NurseingServiceImpl
 * 
 * @author 马梦瑶
 *
 */
@Service
public class NurseingServiceImpl implements NurseingService {

	@Autowired
	private NurseingRepository nurseingRepository;

	@Autowired
	private ClientRepository clientRepository;

	/**
	 * 新增护理记录
	 */
	@Override
	public Nurseing insert(Nurseing nurseing) {
		// 非空属性判断
//		System.out.println("新增护理记录业务逻辑层非空属性判断开始。");
		if (org.apache.commons.lang3.StringUtils.isBlank(nurseing.getAname())
				|| org.apache.commons.lang3.StringUtils.isBlank(nurseing.getCcontent()) || null == nurseing.getCtime()
				|| null == nurseing.getEid()) {
			return null;
		}
//		System.out.println("新增护理记录业务逻辑层客户是否存在判断开始。");
		// 该客户姓名必须存在于客户表
		Client client = clientRepository.findByAname(nurseing.getAname());
		if (null == client) {
			return null;
		}
		// 不能重复记录（客户姓名和护理时间同时相同的记录不写入数据库）
		Nurseing n = nurseingRepository.findByAnameAndCtime(nurseing.getAname(), nurseing.getCtime());
		if (null != n) {
			return null;
		}
		int line = nurseingRepository.insert(client.getAid(), nurseing.getEid(), nurseing.getCcontent(),
				nurseing.getCtime());
		if (line != 1) {
			return null;
		}
		return nurseingRepository.findByAnameAndCtime(nurseing.getAname(), nurseing.getCtime());
	}

	/**
	 * 根据护理记录编号修改护理记录信息
	 */
	@Override
	public boolean update(Integer cid,String ccontent) {
		// 非空属性判断
		if (org.apache.commons.lang3.StringUtils.isBlank(ccontent)) {
			return false;
		}
		int line = nurseingRepository.update(cid, ccontent);
		return line == 1 ? true : false;
	}

	/**
	 * 根据客户姓名进行模糊查询
	 */
	@Override
	public List<Nurseing> findByCondition(String aname) {
//		System.out.println("前端传来的数据aname = " + aname);
		// 字符串主动去除空格
		if (null != aname) {
			aname = aname.trim();
			if (aname.length() == 0) {
				aname = "";
			}
		}
//		System.out.println(nurseingRepository.findByAnameContaining(aname));
		return nurseingRepository.findByAnameContaining(aname);
	}

	/**
	 * 查询所有护理记录信息
	 */
	@Override
	public List<Nurseing> selectAll() {
		return nurseingRepository.findAll();
	}

	/**
	 * 根据护理记录编号查询护理记录信息
	 */
	@Override
	public Nurseing findByCid(Integer cid) {
		// 业务判断：值班编号不能为空且不能小于1
		if (null == cid || cid < 1) {
			cid = null;
		}
		return nurseingRepository.findByCid(cid);
	}

	/**
	 * 根据客户姓名和护理时间精确查询护理记录信息
	 */
	@Override
	public Nurseing findByAnameAndCtime(String aname, Date ctime) {
		// 非空属性判断
		if (org.apache.commons.lang3.StringUtils.isBlank(aname) || null == ctime) {
			return null;
		}
		// 客户姓名不得少于两个字
		if (aname.length() < 2) {
			return null;
		}
		return nurseingRepository.findByAnameAndCtime(aname, ctime);
	}

}
