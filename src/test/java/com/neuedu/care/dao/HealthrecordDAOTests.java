package com.neuedu.care.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Healthrecord;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class HealthrecordDAOTests {
	@Autowired
	HealthrecordRepository healthrecordRepository;
	
	/**
	 * 查询所有健康档案
	 */
//	@Test
//	public void test_findAllHealthrecord() {
//		System.out.println("测试查询所有信息：");
//		List<Healthrecord> healthrecords=healthrecordRepository.findAllHealthrecord();
//		Assertions.assertNotEquals(0, healthrecords.size());
//		System.out.println(healthrecords);
//		log.debug("测试通过！");
//	}
	
	/**
	 * healthrecordRepository测试
	 *  根据档案编号查询
	 *  */
//	@Test
//	public void test_selectByRid() {
//		Integer rid=new Integer(50001);
//		Healthrecord d=healthrecordRepository.findByRid(rid);
//		Assertions.assertNotEquals(null, d);
//		System.out.println(d);
//		log.debug("测试通过！");
//		
//	}
	
	/**
	 * 多条件模糊查询
	 */
//	@Test
//	public void test_findByRidAidAname() {
//		System.out.println("模糊查询：");
//		List<Healthrecord> healthrecords=healthrecordRepository.findByRidAidAname(1, 2, "");
//		Assertions.assertNotEquals(0, healthrecords.size());
//		System.out.println(healthrecords);
//		log.debug("测试通过！");
//	}
//	
	/**
	 * 添加健康档案
	 */
//	@Test
//	public void test_addHealthplan() {
//		System.out.println("测试添加：");
//		int s = healthrecordRepository.addHealthrecord(10002, 77, 66, 66, 66);
//		Assertions.assertNotEquals(0, s);
//		log.debug("测试通过！");
//	}
	
	/**
	 * 修改
	 */
//	@Test
//	public void test_updateHealthplan() {
//		System.out.println("测试修改：");
//		int s = healthrecordRepository.updateHealthrecord(50001, 10001, 88, 99, 99, 99);
//		Assertions.assertNotEquals(0, s);
//		log.debug("测试通过！");
//	}

}
