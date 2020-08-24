package com.neuedu.care.service;

import java.util.List;

import com.neuedu.care.entity.ServeObj;

/**
 * 业务逻辑层接口 ServeObjService
 * @author ASUS
 *
 */
public interface ServeObjService {
	/**
	 * 根据护工编号搜索客户信息
	 * @return
	 */
	List<ServeObj> findByEid(Integer eid);
}
