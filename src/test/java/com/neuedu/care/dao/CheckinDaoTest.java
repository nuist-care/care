package com.neuedu.care.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Checkin;

import lombok.extern.slf4j.Slf4j;

/**
 * CheckinRepository 函数测试类：CheckinDaoTest
 * @author 姚季
 *
 */
@SpringBootTest
@Slf4j
class CheckinDaoTest {
	@Autowired
	private CheckinRepository checkinRepository;
	
	/**
	 * 测试查询所有入住记录
	 */
//	@Test
//	void test_findAll() {
//		List<Checkin> checkins = checkinRepository.findAll();
//		for (Checkin checkin : checkins) {
//			log.info(checkin.toString());
//		}
//	}
	
	/**
	 * 测试根据入住记录编号查询入住记录
	 */
//	@Test
//	void test_findByid() {
//		Checkin checkin = checkinRepository.findByIid(100001);
//			log.info(checkin.toString());
//	}
	
	/**
	 * 测试入住记录编号，客户编号，客户姓名多条件查询入住记录
	 */
//	@Test
//	void test_findByCondition() {
//		List<Checkin> checkins = checkinRepository.findByCondition(100001, null, "姚");
//		for (Checkin checkin : checkins) {
//		log.info(checkin.toString());
//		}
//	}
	
	/**
	 * 测试插入入住记录
	 */
//	@Test
//	void test_insert() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		int line = checkinRepository.insert(100000,sdf.parse("2020-02-20") , null);
//		log.info("插入成功"+line);
//	}

	/**
	 * 测试更新入住记录
	 */
//	@Test
//	void test_update() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		int line = checkinRepository.update(100002,100000,sdf.parse("2020-06-20") , null);
//		log.info("跟新成功"+line);
//	}
	
	/**
	 * 测试删除入住记录
	 */
	@Test
	void test_delete() {
		int line = checkinRepository.deleteByIid(100002);
		log.info("删除成功"+line);
	}
}
