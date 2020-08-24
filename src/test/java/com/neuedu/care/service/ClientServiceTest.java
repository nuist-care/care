package com.neuedu.care.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Client;

import lombok.extern.slf4j.Slf4j;
/**
 * 业务逻辑接口ClientService测试类
 * @author 姚季
 *
 */

@SpringBootTest
@Slf4j
class ClientServiceTest {
	@Autowired
	private ClientService clientService;
	/**
	 * 测试查询所有客户
	 */
//	@Test
//	void test_findAll() {
//		List<Client> clients = clientService.findAll();
//		for (Client client : clients) {
//			log.info(client.toString());
//		}
//	}

	/**
	 * 测试查询一个客户
	 */
//	@Test
//	void test_findByAid() {
//		Client client = clientService.findByid(100000);
//		log.info(client.toString());
//	}
	
	/**
	 * 测试多条件查询客户
	 */
//	@Test
//	void test_findByCondition() {
//		Integer aid = 100002;
//		String aname = "季";
//		Integer clevel = 1;
//		List<Client> clients = clientService.findByCondition(aid, aname, clevel);
//		for (Client client : clients) {
//			log.info(client.toString());
//		}
//	}
	
	/**
	 * 测试新增
	 */
//	@Test
//	void test_save() {
//		Client client = Client.builder()
//				.aname("张强")
//				.aage(88)
//				.asex("男")
//				.aIDnumber("123")
//				.atelephone("123")
//				.clevel(3)
//				.build();
//		Client client2 = clientService.save(client);
//		log.info(client2.toString());
//	}
	
	/**
	 * 测试更新
	 */
//	@Test
//	void test_update() {
//		Client client = Client.builder()
//				.aid(100003)
//				.aname("张强")
//				.aage(88)
//				.asex("男")
//				.aIDnumber("123")
//				.atelephone("123")
//				.clevel(3)
//				.build();
//		int line = clientService.update(client.getAid(), client.getAname(), client.getAsex(), client.getAage(), client.getAIDnumber(),
//				client.getAtelephone(), client.getAaddress(), client.getGenetichistory(), 
//				client.getConditiondescription(), client.getClevel());
//		log.info("更新成功"+line);
//	}
	
	/**
	 * 测试删除
	 */
	@Test
	void test_update() {
		int line = clientService.delete(100003);
		log.info("删除成功"+line);
	}
}
