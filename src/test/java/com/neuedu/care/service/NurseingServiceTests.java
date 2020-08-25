package com.neuedu.care.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Nurseing;

import lombok.extern.slf4j.Slf4j;

/**
 * 护理记录管理Service层测试类
 * 
 * @author 马梦瑶
 *
 */
@SpringBootTest
@Slf4j
public class NurseingServiceTests {

	@Autowired
	private NurseingService nurseingService;

//	/**
//	 * 新增护理记录
//	 * @throws ParseException 
//	 */
//	@Test
//	void test_insert() throws ParseException {
//		System.out.println("测试开始，新增护理记录：");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Nurseing nurseing = Nurseing.builder()
//				.aname("李四")
//				.ccontent("一切正常啦")
//				.ctime(sdf.parse("2020-08-08"))
//				.eid(10005).build();
//		System.out.println(nurseing);
//		boolean n = nurseingService.insert(nurseing);
//		Assertions.assertNotEquals(0, n);
//		log.debug("测试通过！");
//	}

//	/**
//	 * 修改护理记录信息
//	 */
//	@Test
//	void test_update() {
//		System.out.println("测试开始，修改护理记录信息：");
//		Nurseing nurseing = Nurseing.builder().cid(1).ccontent("一切正常啦!!")
//				.build();
//		boolean n = nurseingService.update(nurseing);
//		Assertions.assertNotEquals(0, n);
//		log.debug("测试通过！");
//	}

	/**
	 * 根据客户姓名进行模糊查询
	 */
	@Test
	void test_findByCondition() {
		System.out.println("测试开始，根据客户姓名进行模糊查询：");
		List<Nurseing> nurseings = nurseingService.findByCondition("李");
		Assertions.assertNotEquals(0, nurseings.size());
		System.out.println(nurseings);
		log.debug("测试通过！");
	}

	/**
	 * 查询所有护理记录信息
	 */
	@Test
	void test_selectAll() {
		System.out.println("测试开始，查询所有护理记录信息：");
		List<Nurseing> nurseings = nurseingService.selectAll();
		Assertions.assertNotEquals(0, nurseings.size());
		System.out.println(nurseings);
		log.debug("测试通过！");
	}

	/**
	 * 根据护理记录编号查询护理记录信息
	 */
	@Test
	void test_findByCid() {
		System.out.println("测试开始，根据护理记录编号查询护理记录信息：");
		Nurseing nurseing = nurseingService.findByCid(5);
		Assertions.assertNotEquals(null, nurseing);
		System.out.println(nurseing);
		log.debug("测试通过！");
	}

}
