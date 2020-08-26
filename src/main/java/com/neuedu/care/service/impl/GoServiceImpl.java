package com.neuedu.care.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.ClientRepository;
import com.neuedu.care.dao.GoRepository;
import com.neuedu.care.entity.Client;
import com.neuedu.care.entity.Go;
import com.neuedu.care.service.GoService;

/**
 * 业务逻辑接口GoService实现类GoServiceImpl
 * @author 姚季
 *
 *
 */
@Service
public class GoServiceImpl implements GoService {
	@Autowired
	private GoRepository goRepository;
	
	@Autowired
	private ClientRepository clientRepository;

	/**
	 * 查询所有外出记录
	 */
	@Override
	public List<Go> findAll() {
		List<Go> gos = goRepository.findInfo();
		return gos;
	}

	/**
	 * 根据编号查一条外出记录
	 */
	@Override
	public Go findByid(Integer gid) {
		Go go = goRepository.findByGid(gid);
		return go;
	}

	/**多条件查询外出记录
	 * 
	 */
	@Override
	public List<Go> findByCondition(Integer gid, Integer aid, String approver) {
		List<Go> gos= goRepository.findByGidOrAidOrApproverlike(gid, aid, approver);
		return gos;
	}

	/**
	 * 新增外出记录
	 */
	@Override
	public int save(Integer aid, String goreason, Date gotime, String applytime, String escort, String approver,
			String approvalstatus) {
		Client client = clientRepository.findByAid(aid);
		if (client == null) {
			return 2;
		}
		int line = goRepository.insert(aid, goreason, gotime, applytime, escort, approver, approvalstatus);
		return line;
	}

	/**
	 * 删除外出记录
	 */
	@Override
	public int delete(Integer gid) {
		//先查询是否有这条外出记录
		Go go = goRepository.findByGid(gid);
		if (go == null) {
			return 2;
		}
		int line = goRepository.deleteByGid(gid);
		return line;
	}

	/**
	 * 更新外出记录
	 */
	@Override
	public int update(Integer gid, Integer aid, String goreason, Date gotime, String applytime, String escort,
			String approver, String approvalstatus) {
		Client client = clientRepository.findByAid(aid);
		if (client == null) {
			return 2;
		}
		int line = goRepository.update(gid, aid, goreason, gotime, applytime, escort, approver, approvalstatus);
		return line;
	}

}
