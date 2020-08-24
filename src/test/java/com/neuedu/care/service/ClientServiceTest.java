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
	@Test
	void test_findByAid() {
		Client client = clientService.findByid(100000);
		log.info(client.toString());
	}
}
