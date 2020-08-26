package com.neuedu.care.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Healthassessment;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class HealthassessmentDAOTests {
	
	@Autowired
	HealthassessmentRepository healthassessmentRepository;

	/**
	 * healthassessmentRepository测试
	 *  根据评估编号查询
	 *  */
//	@Test
//	public void test_selectByAssid() {
//		Integer assid=new Integer(20001);
//		Healthassessment d=healthassessmentRepository.findByAssid(assid);
//		Assertions.assertNotEquals(null, d);
//		System.out.println(d);
//		log.debug("测试通过！");
//		
//	}
	
	/**
	 * healthassessmentRepository测试
	 *  查询所有
	 *  */
//	@Test
//	public void test_findAllHealthassessment() {
//		Iterable<Healthassessment> d=healthassessmentRepository.findAllHealthassessment();
//		log.info(d.toString());
//		log.debug("测试通过");
//		
//	}
	
	/**
	 * healthassessmentRepository测试
	 *  添加
	 * @throws ParseException 
	 * 
	 *  */
//	@Test
//	public void test_addHealthassessment() throws ParseException {
//	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println("测试开始，新增信息：");
//		Integer aid = new Integer(10001);
//		String assesser="王五";
//		String assreason="喉咙疼";
//		String asstype="口部";
//		Date asstime=sdf.parse("2020-08-23");
//		String assresult="感冒";
//		int h=healthassessmentRepository.addHealthassessment(aid, assesser, assreason, asstype, asstime, assresult);
//		Assertions.assertNotEquals(0, h);
//		log.debug("测试通过！");
//	}
	/**
	 * healthassessmentRepository测试
	 *  条件组合查询
	 * 
	 *  */
//	@Test
//	public void test_findByAssidAidAname() {
//        List<Healthassessment> hs=healthassessmentRepository.findByAssidAidAname(2, 2, "z");
//        Assertions.assertNotEquals(0, hs.size());
//		System.out.println(hs);
//		log.debug("测试通过");
//	}
	
	/**
	 * healthassessmentRepository测试
	 *  修改
	 * 
	 *  */
//	@Test
//	public void test_updateVisiting() throws ParseException {
//	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println("测试开始，修改信息：");
//		Integer assid = new Integer(20001);
//		Integer aid = new Integer(10001);
//		String assesser="王五";
//		String assreason="喉咙疼";
//		String asstype="口部";
//		Date asstime=sdf.parse("2020-08-23");
//		String assresult="感冒";
//		int h=healthassessmentRepository.updateHealthassessment(assid, aid, assesser, assreason, asstype, asstime, assresult);
//		Assertions.assertNotEquals(0, h);
//		log.debug("测试通过！");
//	}
}
