package com.neuedu.care.service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Go;

import lombok.extern.slf4j.Slf4j;

/**
 * 业务逻辑接口GoServiceTest测试类
 * @author 姚季
 *
 */
@SpringBootTest
@Slf4j
class GoServiceTest {
	@Autowired
	private GoService goService;

	/**
	 * 
	 */
	@Test
	void test_1() {
		Integer gid = null;
		Integer aid = null;
		String approver = "";
		List<Go> gos = goService.findByCondition(100000, aid, "内部极大的");
		for (Go go : gos) {
			log.info(go.toString());	
		}
	}

	/**
	 * 
	 */
//	@Test
//	void test_2() {
//		List<Go> gos = goService.findAll();
//		for (Go go : gos) {
//			log.info(go.toString());	
//		}
//	}
	
	/**
	 * 
	 */
//	@Test
//	void test_3() {
//		Go go = goService.findByid(100002);
//		log.info(go.toString());
//	}
	
	/**
	 * 
	 */
//	@Test
//	void test_delete() {
//		int line = goService.delete(100002);
//		log.info("删除成功"+line);		
//	}
	
	/**
	 * @throws ParseException 
	 * 
	 */
//	@Test
//	void test_5() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		int line = goService.save(2, "七夕", sdf.parse("2020-02-12"), "2天", null, "姚季", "审批中");
//		log.info(line+"ok");
//	}
	
	/**
	 * @throws ParseException 
	 * 
	 */
//	@Test
//	void test_6() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		int line = goService.update(100011,223, "七夕3", sdf.parse("2020-03-12"), "2天", null, "姚季", "审批");
//		log.info(line+"ok");
//	}
	
}
