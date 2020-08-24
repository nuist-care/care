package com.neuedu.care.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.ClientRepository;
import com.neuedu.care.entity.Client;
import com.neuedu.care.service.ClientService;
/**
 * 业务逻辑接口ClientService实现类ClientServiceImpl
 * @author 姚季
 *
 *
 */
@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
		List<Client> clients = clientRepository.findAll();
		return clients;
	}

	@Override
	public Client findByid(Integer aid) {
		Client client = clientRepository.findByAid(aid);
		return client;
	}


}
