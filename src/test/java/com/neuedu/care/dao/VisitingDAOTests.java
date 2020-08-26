package com.neuedu.care.dao;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Visiting;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
public class VisitingDAOTests {

	@Autowired
	private VistingRepository vistingRepository;
	
	 
	/**
	 * vistingRepository测试
	 *  根据就诊编号查询
	 *  */
//	@Test
//	public void test_selectByVid() {
//		Integer vid=new Integer(10001);
//		Optional<Visiting> d=vistingRepository.findById(vid);
//		Assertions.assertEquals(vid.intValue(), d.get().getVid().intValue());
//		log.info(d.get().toString());
//		log.debug("测试通过");
//		
//	}
//	
	/**
	 * vistingRepository测试
	 *  查询所有
	 *  */
//	@Test
//	public void test_findAllVisiting() {
//		Iterable<Visiting> d=vistingRepository.findAllVisiting();
////		Assertions.assertEquals(vid.intValue(), d.get().getVid().intValue());
//		log.info(d.toString());
//		log.debug("测试通过");
//		
//	}
//	
	/**
	 * vistingRepository测试
	 *  添加
	 * 
	 *  */
//	@Test
//	public void test_addVisiting() throws ParseException {
//	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println("测试开始，新增信息：");
//		Integer aid = new Integer(10001);
//		String vhospital="人民医院";
//		Date vtime=sdf.parse("2020-08-23");
//		String vroom="207";
//		String vresult="发烧";
//		int v=vistingRepository.addVisiting(aid, vhospital, vtime, vroom, vresult);
//		Assertions.assertNotEquals(0, v);
//		log.debug("测试通过！");
//	}
//	
	/**
	 * vistingRepository测试
	 *  条件组合查询
	 * 
	 *  */
//	@Test
//	public void test_findByViaAidAname() {
//        List<Visiting> visitings=vistingRepository.findByVidAidAname(1, 1, "zq");
//        Assertions.assertNotEquals(0, visitings.size());
//		System.out.println(visitings);
//		log.debug("测试通过");
//	}
	/**
	 * 修改
	 */
//	@Test
//	public void test_updateVisiting() throws ParseException {
//	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println("测试开始，修改信息：");
//		Integer vid = new Integer(10001);
//		Integer aid = new Integer(10002);
//		String vhospital="人民医院";
//		Date vtime=sdf.parse("2020-08-23");
//		String vroom="333";
//		String vresult="发烧";
//		int v=vistingRepository.updateVisiting(vid, aid, vhospital, vtime, vroom, vresult);
//		Assertions.assertNotEquals(0, v);
//		log.debug("测试通过！");
//	}
	//根据就诊编号查询
//		@Test
//	public void test_findByVid() {
//		System.out.println("根据就诊编号查询就诊信息：");
//		Integer vid = new Integer(10001);
//		Visiting visiting = vistingRepository.findByVid(vid);
//		Assertions.assertNotEquals(null, visiting);
//		System.out.println(visiting);
//		log.debug("测试通过！");
//	}

}
