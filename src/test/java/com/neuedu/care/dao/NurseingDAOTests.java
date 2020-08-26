package com.neuedu.care.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Nurseing;

import lombok.extern.slf4j.Slf4j;

/**
 * 护理记录管理DAO层测试类
 * @author 马梦瑶
 *
 */
@SpringBootTest
@Slf4j
public class NurseingDAOTests {
	@Autowired
	private NurseingRepository nurseingRepository;
	
//	/**
//	 * 新增护理记录
//	 * @throws ParseException 
//	 */
//	@Test
//	void test_save() throws ParseException {
//		System.out.println("测试开始，新增护理记录：");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		int n = nurseingRepository.insert(1, 10005, "食欲不振", sdf.parse("2020-08-05"));
//		Assertions.assertNotEquals(0, n);
//		log.debug("测试通过！");
//	}
//
//	/**
//	 * 根据护理记录编号修改护理记录信息
//	 */
//	@Test
//	void test_update() {
//		System.out.println("测试开始，根据护理记录编号修改护理记录信息：");
//		int n = nurseingRepository.update(1, "修改测试");
//		Assertions.assertNotEquals(0, n);
//		log.debug("测试通过！");
//	}
	
	/**
	 * 根据客户姓名进行模糊查询
	 */
//	@Test
//	void test_findByAnameContaining() {
//		System.out.println("测试开始，根据客户姓名进行模糊查询：");
//		List<Nurseing> nurseings = nurseingRepository.findByAnameContaining("王");
//		Assertions.assertNotEquals(0, nurseings.size());
//		System.out.println(nurseings);
//		log.debug("测试通过！");
//	}
	
//	/**
//	 * 查询所有护理记录信息
//	 */
	@Test
	void test_findAll() {
		System.out.println("测试开始，查询所有护理记录信息：");
		List<Nurseing> nurseings = nurseingRepository.findAll();
		Assertions.assertNotEquals(0, nurseings.size());
		System.out.println(nurseings);
		log.debug("测试通过！");
	}
//	
//	/**
//	 * 根据护理记录编号查询护理记录信息
//	 */
//	@Test
//	void test_findByCid() {
//		System.out.println("测试开始，根据护理记录编号查询护理记录信息：");
//		Nurseing nurseings = nurseingRepository.findByCid(1);
//		Assertions.assertNotEquals(null, nurseings);
//		System.out.println(nurseings);
//		log.debug("测试通过！");
//	}
//
//	/**
//	 * 根据客户姓名和护理时间精确查询护理记录信息
//	 * @throws ParseException 
//	 */
//	@Test
//	void test_findByAnameAndCtime() throws ParseException {
//		System.out.println("测试开始，根据客户姓名和护理时间精确查询护理记录信息：");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date ctime = sdf.parse("2020-08-24");
//		Nurseing nurseing = nurseingRepository.findByAnameAndCtime("李四", ctime);
//		Assertions.assertNotEquals(null, nurseings);
//		System.out.println(nurseings);
//		log.debug("测试通过！");
//	}
}
