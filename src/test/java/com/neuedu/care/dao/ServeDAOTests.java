package com.neuedu.care.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Serve;

import lombok.extern.slf4j.Slf4j;

/**
 * 设置服务对象DAO层测试类
 * @author 马梦瑶
 *
 */
@SpringBootTest
@Slf4j
public class ServeDAOTests {
	@Autowired
	private ServeRepository serveRepository;
	
	/**
	 * 根据服务编号删除服务信息
	 */
	@Test
	public void test_deleteByPrimaryKey() {
		System.out.println("测试开始，根据服务编号删除服务信息：");
		Integer serveid = new Integer(5);
		int s = serveRepository.deleteByPrimaryKey(serveid);
		Assertions.assertNotEquals(0, s);
		log.debug("测试通过！");
	}
	
	/**
	 * 新增服务信息
	 */
	@Test
	public void test_insert() {
		System.out.println("测试开始，新增服务信息：");
		Integer eid = new Integer(10001);
		Integer aid = new Integer(1);
		int s = serveRepository.insert(eid, aid);
		Assertions.assertNotEquals(0, s);
		log.debug("测试通过！");
	}

	/**
	 * 查询所有服务信息
	 */
	@Test
	public void test_findAll() {
		System.out.println("测试开始，查询所有服务信息：");
		List<Serve> serves = serveRepository.findAll();
		Assertions.assertNotEquals(0, serves.size());
		System.out.println(serves);
		log.debug("测试通过！");
	}
	
	/**
	 * 根据服务编号查询服务信息
	 */
	@Test
	public void test_findByServeid() {
		System.out.println("测试开始，根据服务编号查询服务信息：");
		Integer serveid = new Integer(6);
		Serve serve = serveRepository.findByServeid(serveid);
		Assertions.assertNotEquals(null, serve);
		System.out.println(serve);
		log.debug("测试通过！");
	}
	
	/**
	 * 根据员工姓名和客户姓名进行多条件模糊查询
	 */
	@Test
	public void test_findByEnameContainingAndAnameContaining() {
		System.out.println("测试开始，根据员工姓名和客户姓名进行多条件模糊查询：");
		String ename = new String("散");
		String aname = new String("李");
		List<Serve> serves = serveRepository.findByEnameContainingAndAnameContaining(ename, aname);
		Assertions.assertNotEquals(0, serves.size());
		System.out.println(serves);
		log.debug("测试通过！");
	}
}
