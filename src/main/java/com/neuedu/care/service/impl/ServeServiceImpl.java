package com.neuedu.care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.ServeRepository;
import com.neuedu.care.entity.Serve;
import com.neuedu.care.service.ServeService;

/**
 * 设置服务对象管理业务逻辑层接口ServeService实现类ServeServiceImpl
 * 
 * @author 马梦瑶
 *
 */
@Service
public class ServeServiceImpl implements ServeService {

	@Autowired
	private ServeRepository serveRepository;

	/**
	 * 根据服务编号删除服务信息
	 */
	@Override
	public boolean delete(Integer serveid) {
		// 业务判断：服务编号不能为null且不能小于1
		if (null == serveid || serveid < 1) {
			return false;
		}
		int line = serveRepository.deleteByPrimaryKey(serveid);
		return line == 1 ? true : false;
	}

	/**
	 * 新增服务信息
	 */
	@Override
	public Serve insert(Serve serve) {
		// 非空属性判断
		if (null == serve.getEid() || null == serve.getAid()) {
			return null;
		}
		// 不能重复添加
		Serve s = serveRepository.findByEidAndAid(serve.getEid(), serve.getAid());
		if (null != s) {
			return null;
		}
		int line = serveRepository.insert(serve.getEid(), serve.getAid());
		if (line != 1) {
			return null;
		}
		return serveRepository.findByEidAndAid(serve.getEid(), serve.getAid());
	}

	/**
	 * 查询所有服务信息
	 */
	@Override
	public List<Serve> selectAll() {
		return serveRepository.findAll();
	}

	/**
	 * 根据服务编号查询服务信息
	 */
	@Override
	public Serve selectByPrimaryKey(Integer serveid) {
		// 业务判断：服务编号不能为null且不能小于1
		if (null == serveid || serveid < 1) {
			return null;
		}
		return serveRepository.findByServeid(serveid);
	}

	/**
	 * 根据员工姓名和客户姓名进行多条件模糊查询
	 */
	@Override
	public List<Serve> findByEnameContainingAndAnameContaining(String ename, String aname) {
		// 字符串去除空格
		if (null != aname) {
			aname = aname.trim();
			if (aname.length() == 0) {
				aname = "";
			}
		}
		if (null != ename) {
			ename = ename.trim();
			if (ename.length() == 0) {
				ename = "";
			}
		}
		return serveRepository.findByEnameContainingAndAnameContaining(ename, aname);
	}

	@Override
	public Serve findByEidAndAid(Integer eid, Integer aid) {
//		System.out.println("在serveServiceImpl中：eid:" + eid + ",aid:" + aid);
		// 非空属性判断
		if (null == eid || null == aid) {
			return null;
		}
		Serve serve = serveRepository.findByEidAndAid(eid, aid);
		System.out.println("在serveServiceImpl中：返回serve对象：" + serve);
		return serve;
	}

}
