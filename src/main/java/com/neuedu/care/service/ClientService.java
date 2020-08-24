package com.neuedu.care.service;

import java.util.List;
import java.util.Optional;

import com.neuedu.care.entity.Client;

public interface ClientService {
	/**
	 * 查询所有客户
	 * @return
	 */
	List<Client> findAll();
	
	/**
	 * 查询一个用户
	 * @return
	 */
	Client findByid(Integer aid);
}
