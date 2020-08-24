package com.neuedu.care.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.ServeObj;

import lombok.extern.slf4j.Slf4j;

/**
 * 公告逻辑层接口测试类 ServeObjServiceTests
 * @author ASUS
 *
 */
@SpringBootTest
@Slf4j
public class ServeObjServiceTests {
	@Autowired
	private ServeObjService serveObjService;
	
	/**
	 * 对findByEid()方法进行测试
	 */
	@Test
	void test_findByEid() {
		List<ServeObj> serveObjs = serveObjService.findByEid(1);
		for(ServeObj serveObj : serveObjs) {
			log.info(serveObj.toString());
		}
	}
}
