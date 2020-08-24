package com.neuedu.care.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Level;

import lombok.extern.slf4j.Slf4j;

/**
 * 护理级别管理DAO层测试类
 * @author 马梦瑶
 *
 */
@SpringBootTest
@Slf4j
public class LevelDAOTests {
	@Autowired
	private LevelRepository levelRepository;
	
	/**
	 * 根据客户编号修改护理等级
	 */
	@Test
	void test_updateLevel() {
		System.out.println("测试开始，根据客户编号修改护理等级：");
		Integer aid = new Integer(1);
		Integer clevel = new Integer(5);
		int l = levelRepository.updateLevel(aid, clevel);
		Assertions.assertNotEquals(0, l);
		log.debug("测试通过！");
	}
	
	/**
	 * 根据客户姓名进行模糊查询
	 */
	@Test
	void test_findByAnameContaining() {
		System.out.println("测试开始，根据客户姓名进行模糊查询：");
		List<Level> levels = levelRepository.findByAnameContaining("李");
		Assertions.assertNotEquals(0, levels.size());
		System.out.println(levels);
		log.debug("测试通过！"); 
	}
	
	/**
	 * 查询所有护理级别信息
	 */
	@Test
	void test_findAll() {
		System.out.println("测试开始，查询所有护理级别信息：");
		List<Level> levels = levelRepository.findAll();
		Assertions.assertNotEquals(0, levels.size());
		System.out.println(levels);
		log.debug("测试通过！"); 
	}
	
	/**
	 * 根据客户编号查询护理级别信息
	 */
	@Test
	void test_findByAid() {
		System.out.println("测试开始，根据客户编号查询护理级别信息：");
		Level level = levelRepository.findByAid(1);
		Assertions.assertNotEquals(null, level);
		System.out.println(level);
		log.debug("测试通过！"); 
	}
}
