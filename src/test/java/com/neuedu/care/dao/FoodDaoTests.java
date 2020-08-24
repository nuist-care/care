package com.neuedu.care.dao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Food;

import lombok.extern.slf4j.Slf4j;

/**
 * 膳食接口测试类 FoodDaoTests
 * @author ASUS
 *
 */
@SpringBootTest
@Slf4j
public class FoodDaoTests {
	@Autowired
	private FoodRepository foodRepository;
	
	/**
	 * 对selectById()函数进行测试
	 */
//	@Test
//	public void test_selectById() {
//		Integer fid = new Integer(1);
//		Food food = foodRepository.findById(fid).get();
//		Assertions.assertEquals(fid.intValue(),food.getFid().intValue());
//		log.debug("测试通过");
//	}
	
	/**
	 * 对findAll()函数进行测试
	 */
//	@Test
//	void test_findAll() {
//		List<Food> foods = foodRepository.findAll();
//		for(Food food : foods) {
//			log.info(foods.toString());
//		}
//	}
	
	/**
	 * 对findByAid()函数进行测试
	 */
//	@Test
//	void test_findByAid() {
//		Integer aid = new Integer(1);
//		List<Food> foods = foodRepository.findByAid(aid);
//		for(Food food : foods) {
//			log.info(foods.toString());
//		}
//	}
//	
	/**
	 * 对save()函数进行测试
	 * @throws ParseException
	 */
//	@Test
//	void test_save() throws ParseException{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Food food = Food.builder()
//				.aid(2)
//				.ftime(sdf.parse("2020-8-20"))
//				.ftype("早饭")
//				.fcontent("凉水")
//				.build();
//		Food f = foodRepository.save(food);
//		log.info(f.toString());
//	}
	
	/**
	 * 对delete()函数进行测试
	 */
//	@Test
//	void test_delete() {
//		int line = 0;
//		try {
//			foodRepository.deleteById(6);
//			line = 1;
//		} catch (Exception e) {
//			line = 0;
//		}
//		log.info(line+"删除成功");
//	}
//	
	/**
	 * 对updateByFid()函数进行测试
	 * @throws ParseException
	 */
//	@Test
//	void test_updateByFid() throws ParseException{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Integer fid = 1;
//		Integer aid = 2;
//		Date ftime = sdf.parse("2020-08-22");
//		String ftype = "早饭";
//		String fcontent = "蔬菜粥";
//		int line = foodRepository.updateByFid(fid, aid, ftime, ftype, fcontent);
//		log.info(line + "更新成功");
//	}
	
	/**
	 * 对findAll2()方法进行测试
	 */
	@Test
	void test_findAll2() {
		List<Food> foods = foodRepository.findAll2();
		for(Food food : foods) {
			log.info(foods.toString());
	}
	}
}
