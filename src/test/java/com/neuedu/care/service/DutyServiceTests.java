package com.neuedu.care.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Duty;

import lombok.extern.slf4j.Slf4j;

/**
 * 值班管理Service层测试类
 * @author 马梦瑶
 *
 */
@SpringBootTest
@Slf4j
public class DutyServiceTests {
	
	@Autowired
	private DutyService dutyService;
	
//	/**
//	 * 根据值班编号删除值班信息
//	 */
//	@Test
//	void test_delete() {
//		System.out.println("测试开始，根据值班编号删除值班信息：");
//		Integer did = new Integer(5);
//		boolean d = dutyService.delete(did);
//		Assertions.assertNotEquals(0, d);
//		log.debug("测试通过！");
//	}
	
//	/**
//	 * 新增值班信息
//	 */
//	@Test
//	void test_insert() {
//		System.out.println("测试开始，新增值班信息：");
//		boolean d = dutyService.insert("周一", "胡适");
//		Assertions.assertNotEquals(0, d);
//		log.debug("测试通过！");
//	}
//	
//	/**
//	 * 更新值班信息
//	 */
//	@Test
//	void test_update() {
//		System.out.println("测试开始，更新值班信息：");
//		boolean d = dutyService.update(8, "周三", "胡适")
//		Assertions.assertNotEquals(0, d);
//		log.debug("测试通过！");
//	}

//	/**
//	 * 根据值班时间和值班人员进行多条件模糊查询
//	 */
//	@Test
//	void test_findByCondition() {
//		System.out.println("测试开始，根据值班时间和值班人员进行多条件模糊查询：");
//		List<Duty> duties = dutyService.findByCondition("周日","");
//		Assertions.assertNotEquals(0, duties.size());
//		System.out.println(duties);
//		log.debug("测试通过！"); 
//	}
//
//	/**
//	 * 查询所有值班信息
//	 */
//	@Test
//	void test_selectAll() {
//		System.out.println("测试开始，查询所有值班信息：");
//		List<Duty> duties = dutyService.selectAll();
//		Assertions.assertNotEquals(0, duties.size());
//		System.out.println(duties);
//		log.debug("测试通过！");
//	}
//
//
//	/**
//	 * 根据值班编号查询值班信息
//	 */
//	@Test
//	void test_findByDid() {
//		System.out.println("测试开始，根据值班编号查询值班信息：");
//		Duty duty = dutyService.findByDid(6);
//		Assertions.assertNotEquals(null, duty);
//		System.out.println(duty);
//		log.debug("测试通过！"); 
//	}
}
