package com.neuedu.care.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Go;

import lombok.extern.slf4j.Slf4j;

/**
 * GoRepository函数测试类：GoDaoTest
 * @author 姚季
 *
 */
@SpringBootTest
@Slf4j
class GoDaoTest {
	@Autowired
	private GoRepository goRepository;

//	/**
//	 * 
//	 */
//	@Test
//	void test_findBygidaid() {
//		Integer gid = null;
//		Integer aid = null;
//		String approver = "姚";
//		List<Go> gos = goRepository.findByGidOrAidOrApproverlike(gid, aid, approver);
//		for (Go go : gos) {
//			log.info(go.toString());	
//		}
//	}
	
//	/**
//	 * 
//	 */
//	@Test
//	void test_findInfo() {
//		List<Go> gos = goRepository.findInfo();
//		for (Go go : gos) {
//			log.info(go.toString());	
//		}
//	}

	/**
	 * 
	 */
//	@Test
//	void test_findByAid() {
//		Go go = goRepository.findByGid(100000);
//			log.info(go.toString());	
//	}
	
	/**
	 * 
	 */
	@Test
	void test_delete() {
		int line = goRepository.deleteByGid(100001);
		log.info("删除成功"+line);	
	}
}
