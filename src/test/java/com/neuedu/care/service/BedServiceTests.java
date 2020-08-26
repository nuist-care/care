package com.neuedu.care.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.dao.BedRepository;
import com.neuedu.care.entity.Bed;

import lombok.extern.slf4j.Slf4j;

/**
 * 公告逻辑层接口测试类BedServiceTests
 * @author ASUS
 *
 */
@SpringBootTest
@Slf4j
public class BedServiceTests {
	@Autowired
	private BedService bedService;
	
	/**
	 * 对selectByPid()方法进行测试
	 */
//	@Test
//	void test_selectByBid() {
//		Integer bid = new Integer(1);
//		Bed bed = bedService.selectByBid(bid);
//		assertEquals(bid.intValue(),bed.getBid().intValue());
//	}

	/**
	 * 对selectAll()方法进行测试
	 */
//	@Test
//	void test_selectAll() {
//		List<Bed> beds = bedService.selectAll();
//		for(Bed bed : beds) {
//			log.info(bed.toString());
//		}
//	}
//	
	/**
	 * 对findByFloorAndRoomAndBnum()方法进行测试
	 */
//	@Test
//	void test_findByFloorAndRoomAndBnum() {
//		List<Bed> beds = bedService.findByFloorAndRoomAndBnum( 1, 1, 1);
//		for(Bed bed : beds) {
//			log.info(bed.toString());
//		}
//	}
//	
	/**
	 * 对insert()方法进行测试
	 * @throws ParseException
	 */
//	@Test
//	void test_insert() throws ParseException{
//		Bed bed = Bed.builder()
//				.floor(1)
//				.room(3)
//				.bnum(1)
//				.aid(5)
//				.build();
//		Bed b = bedService.insert(bed);
//		log.info(b.toString());
//	}
	
	/**
	 * 对update()方法进行测试
	 * @throws ParseException
	 */
//	@Test
//	void test_update() throws ParseException {
//		Integer bid = 1;
//		Integer aid = 1;
//		int line = bedService.update(bid,aid);
//		log.info(line + "更新成功");
//	}
	
	/**
	 * 对delete()函数进行测试
	 */
//	@Test
//	void test_delete() {
//		int line = bedService.delete(4);
//		log.info(line+"删除成功");
//	}
	
	/**
	 * 对findByAid()方法进行测试
	 */
//	@Test
//	void test_findByAid() {
//		Integer aid = new Integer(1);
//		Bed bed = bedService.findByAid(aid);
//		assertEquals(aid.intValue(),bed.getAid().intValue());
//	}
}
