package com.neuedu.care.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Food;

import lombok.extern.slf4j.Slf4j;

/**
 * 公告逻辑层接口测试类PlacardServiceTests
 * @author ASUS
 *
 */
@SpringBootTest
@Slf4j
public class FoodServiceTests {
	@Autowired
	private FoodService foodService;
	
	/**
	 * 对selectByFid()方法进行测试
	 */
//	@Test
//	void test_selectByFid() {
//		Integer fid = new Integer(1);
//		Food food = foodService.selectByFid(fid);
//		assertEquals(fid.intValue(),food.getFid().intValue());
//	}

	/**
	 * 对selectAll()方法进行测试
	 */
	@Test
	void test_selectAll() {
		List<Food> foods = foodService.selectAll();
		for(Food food : foods) {
			log.info(foods.toString());
		}
	}
	
	/**
	 * 对findByAid()方法进行测试
	 */
	@Test
	void test_findByAid() {
		List<Food> foods = foodService.findByAid(1);
		for(Food food : foods) {
			log.info(foods.toString());
		}
	}
	
	/**
	 * 对insert()方法进行测试
	 * @throws ParseException
	 */
	@Test
	void test_insert() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Food food = Food.builder()
				.aid(3)
				.ftime(sdf.parse("2020-8-22"))
				.ftype("早饭")
				.fcontent("凉白开")
				.build();
		Food f = foodService.insert(food);
		log.info(f.toString());
	}
	
	/**
	 * 对update()方法进行测试
	 * @throws ParseException
	 */
	@Test
	void test_update() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Integer fid = 1;
		Integer aid = 1;
		Date ftime = sdf.parse("2020-08-22");
		String ftype = "早饭";
		String fcontent = "鸡蛋粥";
		int line = foodService.update(fid, aid, ftime, ftype, fcontent);
		log.info(line + "更新成功");
	}
	
	/**
	 * 对delete()函数进行测试
	 */
	@Test
	void test_delete() {
		int line = foodService.delete(5);
		log.info(line+"删除成功");
	}
	
	/**
	 * 对selectAll2()方法进行测试
	 */
	@Test
	void test_selectAll2() {
		List<Food> foods = foodService.selectAll2();
		for(Food food : foods) {
			log.info(foods.toString());
		}
	}
}
