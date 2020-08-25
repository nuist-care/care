package com.neuedu.care.service.impl;

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
	public boolean insert(Nurseing nurseing) {
		// 非空属性判断
		if (org.apache.commons.lang3.StringUtils.isBlank(nurseing.getAname())
				|| org.apache.commons.lang3.StringUtils.isBlank(nurseing.getCcontent()) || null == nurseing.getCtime()
				|| null == nurseing.getEid()) {
			return false;
		}
		// 该客户姓名必须存在于客户表
		Client client = clientRepository.findByAname(nurseing.getAname());
		if (null == client) {
			return false;
		}
		// 不能重复记录（客户姓名和护理时间同时相同的记录不写入数据库）
		List<Nurseing> n = nurseingRepository.findByAnameAndCtime(nurseing.getAname(), nurseing.getCtime());
		if (0 != n.size()) {
			return false;
		}
		int line = nurseingRepository.insert(client.getAid(), nurseing.getEid(), nurseing.getCcontent(),
				nurseing.getCtime());
		return line == 1 ? true : false;
	}

	/**
	 * 根据护理记录编号修改护理记录信息
	 */
	@Override
	public boolean update(Nurseing nurseing) {
		// 非空属性判断
		if (org.apache.commons.lang3.StringUtils.isBlank(nurseing.getCcontent())) {
			return false;
		}
		int line = nurseingRepository.update(nurseing.getCid(), nurseing.getCcontent());
		return line == 1 ? true : false;
	}

	/**
	 * 根据客户姓名进行模糊查询
	 */
	@Override
	public List<Nurseing> findByCondition(String aname) {
		// 字符串主动去除空格
		if (null != aname) {
			aname = aname.trim();
			if (aname.length() == 0) {
				aname = "";
			}
		}
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

}
