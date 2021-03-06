package com.neuedu.care.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Healthplan;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class HealthplanDAOTests {

	@Autowired
	HealthplanRepository healthplanRepository;
	
	/**
	 * 查询所有健康计划
	 */
//	@Test
//	public void test_findAllHealthplan() {
//		System.out.println("测试查询所有信息：");
//		List<Healthplan> healthplans=healthplanRepository.findAllHealthplan();
//		Assertions.assertNotEquals(0, healthplans.size());
//		System.out.println(healthplans);
//		log.debug("测试通过！");
//	}
	
	/**
	 * healthplanRepository测试
	 *  根据评估编号查询
	 *  */
//	@Test
//	public void test_selectByPid() {
//		Integer pid=new Integer(30001);
//		Healthplan d=healthplanRepository.findByPid(pid);
//		Assertions.assertNotEquals(null, d);
//		System.out.println(d);
//		log.debug("测试通过！");
//		
//	}
	
	/**
	 * 多条件模糊查询
	 */
//	@Test
//	public void test_findByPidAidAname() {
//		System.out.println("模糊查询：");
//		List<Healthplan> healthplans=healthplanRepository.findByPidAidAname(1, 1, "");
//		Assertions.assertNotEquals(0, healthplans.size());
//		System.out.println(healthplans);
//		log.debug("测试通过！");
//	}
	
	/**
	 * 添加健康计划
	 */
//	@Test
//	public void test_addHealthplan() {
//		System.out.println("测试添加：");
//		int s = healthplanRepository.addHealthplan(10002, 40002, "呕吐", "多吃点", "1tian");
//		Assertions.assertNotEquals(0, s);
//		log.debug("测试通过！");
//	}
	
	/**
	 * 修改
	 */
//	@Test
//	public void test_updateHealthplan() {
//		System.out.println("测试添加：");
//		int s = healthplanRepository.updateHealthplan(30002,10002, 40002, "呕吐", "多吃点", "1天");
//		Assertions.assertNotEquals(0, s);
//		log.debug("测试通过！");
//	}

}
