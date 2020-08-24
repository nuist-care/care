package com.neuedu.care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.dao.ServeObjRepository;
import com.neuedu.care.entity.ServeObj;
import com.neuedu.care.service.ServeObjService;

/**
 * 业务逻辑接口实现类ServeObjServiceImpl
 * @author ASUS
 *
 */
@Service
@Transactional
public class ServeObjServiceImpl implements ServeObjService{
	@Autowired
	private ServeObjRepository serveObjRepository;
	
	@Override
	public List<ServeObj> findByEid(Integer eid){
		List<ServeObj> serveObjs = serveObjRepository.findByEid(eid);
		return serveObjs;
	}
}
