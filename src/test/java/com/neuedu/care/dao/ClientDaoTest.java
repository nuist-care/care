package com.neuedu.care.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Client;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class ClientDaoTest {
	@Autowired
	private ClientRepository clientRepository;

	/**
	 * 测试根据编号查询客户
	 */
//	@Test
//	void test_findByAid() {
//		Client client = clientRepository.findByAid(100000);
//		log.info(client.toString());
//	}

	/**
	 * 根据编号，姓名，护理等级查询客户
	 */
//	@Test
//	void test_findByidnameclevel() {
//		Integer aid = 100000;
//		String aname = "季";
//		Integer clevel = 0;
//		List<Client> clients = clientRepository.findByAidOrAnameContainingOrClevel(100000, "", null);
//		for (Client client : clients) {
//			log.info(client.toString());
//		}
//	}	
	
	/**
	 * 测试新增客户
	 */
	@Test
	void test_update() {
		Client client = Client.builder()
				.aid(100002)
				.aname("张强")
				.aage(88)
				.asex("男")
				.aIDnumber("123")
				.atelephone("123")
				.clevel(3)
				.build();
		int line = clientRepository.update(client.getAid(), client.getAname(), client.getAsex(), client.getAage(), client.getAIDnumber(),
				client.getAtelephone(), client.getAaddress(), client.getGenetichistory(), 
				client.getConditiondescription(), client.getClevel());
		log.info("更新成功"+line);	
	}
	
}
