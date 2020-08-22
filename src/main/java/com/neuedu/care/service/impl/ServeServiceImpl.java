package com.neuedu.care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.dao.ServeRepository;
import com.neuedu.care.entity.Serve;
import com.neuedu.care.service.ServeService;

/**
 * 业务逻辑层接口ServeService实现类ServeServiceImpl
 * @author 马梦瑶
 *
 */
@Service
public class ServeServiceImpl implements ServeService{
	
	@Autowired
	private ServeRepository serveRepository;

	/**
	 * 测试根据服务编号删除服务信息
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	@Override
	public boolean delete(Integer serveid) {
		// 业务逻辑验证：服务编号不能为null且不能小于1
		if(null == serveid || serveid < 1) {
			return false;
		}
		int line = serveRepository.deleteByPrimaryKey(serveid);
		return line == 1 ? true : false;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	@Override
	public boolean insert(Serve serve) {
		// 业务逻辑验证：服务对象不能为null
		if (null == serve) {
			return false;
		}
		// 非空属性判断
		if (null == serve.getAid() || null == serve.getEid()) {
			return false;
		}
		Serve line = serveRepository.save(serve);
		return line != null ? true : false;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	@Override
	public List<Serve> selectByPrimaryKey(Integer eid) {
		// 业务逻辑判断：员工编号不能为null且不能小于10001
		if (null == eid || eid < 10001) {
			return null;
		}
		return serveRepository.selectByPrimaryKey(eid);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	@Override
	public List<Serve> selectAll() {
		return serveRepository.selectAll();
	}

}
