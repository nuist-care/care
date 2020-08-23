package com.neuedu.care.dao;



import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class CareJPADAOTests {

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
	
	/**
	 * vistingRepository测试
	 *  添加
	 * 
	 *  */
//	@Test
//	public void test_save() throws ParseException {
//	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//	    Visiting visiting=Visiting.builder()
//	    		.aid(10002)
//	    		.aname("hjx")
//	    		.vhospital("人民医院")
//	    		.vtime(sdf.parse("2020-08-08"))
//	    		.vroom("207")
//	    		.vresult("发烧")
//	    		.build();
//	    Visiting d=vistingRepository.save(visiting);
//		log.info(d.toString());
//		log.debug("测试通过");
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

}
