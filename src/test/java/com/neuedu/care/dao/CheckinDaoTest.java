package com.neuedu.care.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Checkin;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class CheckinDaoTest {
	@Autowired
	private CheckinRepository checkinRepository;
	
//	@Test
//	void test_findAll() {
//		List<Checkin> checkins = checkinRepository.findAll();
//		for (Checkin checkin : checkins) {
//			log.info(checkin.toString());
//		}
//	}
	
//	@Test
//	void test_findByid() {
//		Checkin checkin = checkinRepository.findByIid(100001);
//			log.info(checkin.toString());
//	}
	
//	@Test
//	void test_findByCondition() {
//		List<Checkin> checkins = checkinRepository.findByCondition(100001, null, "姚");
//		for (Checkin checkin : checkins) {
//		log.info(checkin.toString());
//		}
//	}

}
