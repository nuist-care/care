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
	
	/**
	 * 实现查询所有客户
	 */
	@Override
	public List<Client> findAll() {
		List<Client> clients = clientRepository.findAll();
		return clients;
	}

	/**
	 * 实现根据编号查询客户
	 */
	@Override
	public Client findByid(Integer aid) {
		Client client = clientRepository.findByAid(aid);
		return client;
	}

	/**
	 * 实现根据多条件组合查询客户
	 */
	@Override
	public List<Client> findByCondition(Integer aid, String aname, Integer clevel) {
		List<Client> clients = clientRepository.findByAidOrAnameContainingOrClevel(aid, aname, clevel);
		return clients;
	}

	/**
	 * 实现新增客户
	 */
	@Override
	public Client save(Client client) {
		Client c = clientRepository.save(client);
		return c;
	}

	/**
	 * 实现删除客户
	 */
	@Override
	public int delete(Integer aid) {
		int line = 0;
		try {
			line = 1;
			clientRepository.deleteById(aid);
		} catch (Exception e) {
			line = 0;
		}
		return line;
	}

	/**
	 * 实现更新客户
	 */
	@Override
	public int update(Integer aid, String aname, String asex, Integer aage, String aIDnumber, String atelephone,
			String aaddress, String genetichistory, String conditiondescription, Integer clevel) {
		int line = clientRepository.update(aid, aname, asex, aage, aIDnumber, atelephone, aaddress, genetichistory, conditiondescription, clevel);
		return line;
	}


}
