package com.neuedu.care.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Bed;

import lombok.extern.slf4j.Slf4j;

/**
 * 床位接口测试类
 * @author ASUS
 *
 */
@SpringBootTest
@Slf4j
public class BedDaoTests {
	@Autowired
	private BedRepository bedRepository;
	
	/**
	 * 对findByBid()函数进行测试
	 */
//	@Test
//	public void test_findByBid() {
//		Integer bid = new Integer(1);
//		Bed bed = bedRepository.findByBid(bid);
//		Assertions.assertEquals(bid.intValue(),bed.getBid().intValue());
//		log.debug("测试通过");
//	}
	
	/**
	 * 对findAll()函数进行测试
	 */
//	@Test
//	void test_findAll() {
//		List<Bed> beds = bedRepository.findAll();
//		for(Bed bed : beds) {
//			log.info(beds.toString());
//		}
//	}
	
	/**
	 * 对save()函数进行测试
	 * @throws ParseException
	 */
//	@Test
//	void test_save() throws ParseException{
//		Bed bed = Bed.builder()
//				.floor(1)
//				.room(2)
//				.bnum(1)
//				.aid(3)
//				.build();
//		Bed b = bedRepository.save(bed);
//		log.info(b.toString());
//	}
	
	/**
	 * 对delete()函数进行测试
	 */
//	@Test
//	void test_delete() {
//		int line = 0;
//		try {
//			bedRepository.deleteById(2);
//			line = 1;
//		} catch (Exception e) {
//			line = 0;
//		}
//		log.info(line+"删除成功");
//	}
	
	/**
	 * 对updateByBid()函数进行测试
	 * @throws ParseException
	 */
//	@Test
//	void test_updateBid() throws ParseException{
//		Integer bid = 1;
//		Integer floor = 1;
//		Integer room = 1;
//		Integer bnum = 1;
//		Integer aid = 2;
//		int line = bedRepository.updateByBid(bid, floor, room, bnum, aid);
//		log.info(line + "更新成功");
//	}
	
	/**
	 * 对findByFloorAndRoomAndBnum()方法进行测试
	 */
//	@Test
//	void test_findByFloorAndRoomAndBnum() {
//		Integer floor = 1;
//		Integer room = 1;
//		Integer bnum = 1;
//		List<Bed> beds = bedRepository.findByFloorAndRoomAndBnum(floor, room, bnum);
//		for(Bed bed : beds) {
//			log.info(bed.toString());
//		}
//	}

	/**
	 * 对findByAid()方法进行测试
	 */
	public void test_findByAid() {
		Integer aid = new Integer(1);
		Bed bed = bedRepository.findByAid(aid);
		Assertions.assertEquals(aid.intValue(),bed.getAid().intValue());
		log.debug("测试通过");
	}
}
