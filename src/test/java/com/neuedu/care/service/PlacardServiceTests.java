package com.neuedu.care.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Placard;
import lombok.extern.slf4j.Slf4j;

/**
 * 公告逻辑层接口测试类PlacardServiceTests
 * @author ASUS
 *
 */
@SpringBootTest
@Slf4j
public class PlacardServiceTests {
	@Autowired
	private PlacardService placardService;
	
	/**
	 * 对selectByPid()方法进行测试
	 */
//	@Test
//	void test_selectByPid() {
//		Integer pid = new Integer(1);
//		Placard placard = placardService.selectByPid(pid);
//		assertEquals(pid.intValue(),placard.getPid().intValue());
//	}

	/**
	 * 对selectAll()方法进行测试
	 */
//	@Test
//	void test_selectAll() {
//		List<Placard> placards = placardService.selectAll();
//		for(Placard placard : placards) {
//			log.info(placard.toString());
//		}
//	}
	
	/**
	 * 对findByCondition()方法进行测试
	 */
//	@Test
//	void test_findByCondition() {
//		List<Placard> placards = placardService.findByCondition(1, "姚季", "常驻");
//		for(Placard placard : placards) {
//			log.info(placard.toString());
//		}
//	}
	
	/**
	 * 对insert()方法进行测试
	 * @throws ParseException
	 */
//	@Test
//	void test_insert() throws ParseException{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Placard placard = Placard.builder()
//				.pauthor("姚季")
//				.ptype("常驻")
//				.ptime(sdf.parse("2020-8-22"))
//				.ptitle("入院须知2")
//				.pcontent("减少噪音")
//				.build();
//		Placard p = placardService.insert(placard);
//		log.info(p.toString());
//	}
	
	/**
	 * 对update()方法进行测试
	 * @throws ParseException
	 */
//	@Test
//	void test_update() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Integer pid = 1;
//		String pauthor = "姚季";
//		String ptype = "常驻";
//		Date ptime = sdf.parse("2020-08-22");
//		String ptitle = "入院须知";
//		String pcontent = "保持环境卫生";
//		int line = placardService.update(pid, pauthor, ptype, ptime, ptitle, pcontent);
//		log.info(line + "更新成功");
//	}
	
	/**
	 * 对delete()函数进行测试
	 */
	@Test
	void test_delete() {
		int line = placardService.delete(4);
		log.info(line+"删除成功");
	}
}
