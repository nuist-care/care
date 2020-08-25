package com.neuedu.care.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Serve;

import lombok.extern.slf4j.Slf4j;

/**
 * 设置服务对象Service层测试类
 * @author 马梦瑶
 *
 */
@SpringBootTest
@Slf4j
public class ServeServiceTests {
	
	@Autowired
	private ServeService serveService;
	
	/**
	 * 根据服务编号删除服务信息
	 */
	@Test
	void test_delete() {
		System.out.println("测试开始，根据服务编号删除服务信息：");
		Integer serveid = new Integer(6);
		boolean s = serveService.delete(serveid);
		Assertions.assertNotEquals(0, s);
		log.debug("测试通过！");
	}
	
	/**
	 * 新增服务信息
	 */
	@Test
	void test_insert() {
		System.out.println("测试开始，新增服务信息：");
		Serve serve = Serve.builder()
				.eid(10002)
				.aid(2)
				.build();
		Serve s = serveService.insert(serve);
		Assertions.assertNotEquals(null, s);
		log.debug("测试通过！");
	}
	
	/**
	 * 根据服务编号查询服务信息
	 */
	@Test
	void test_selectByPrimaryKey() {
		System.out.println("测试开始，根据服务编号查询服务信息：");
		Integer serveid = new Integer(12);
		Serve serve = serveService.selectByPrimaryKey(serveid);
		Assertions.assertNotEquals(null, serve);
		System.out.println(serve);
		log.debug("测试通过！");
	}
	
	/**
	 * 查询所有服务信息
	 */
	@Test
	void test_selectAll() {
		System.out.println("测试开始，查询所有服务信息：");
		List<Serve> serves = serveService.selectAll();
		Assertions.assertNotEquals(0, serves.size());
		System.out.println(serves);
		log.debug("测试通过！");
	}
	
	/**
	 * 根据员工姓名和客户姓名进行多条件模糊查询
	 */
	@Test
	void test_findByEnameContainingAndAnameContaining() {
		System.out.println("测试开始，根据员工姓名和客户姓名进行多条件模糊查询：");
		String ename = new String("散");
		String aname = new String("李");
		List<Serve> serves = serveService.findByEnameContainingAndAnameContaining(ename, aname);
		Assertions.assertNotEquals(0, serves.size());
		System.out.println(serves);
		log.debug("测试通过！");
	}
}
