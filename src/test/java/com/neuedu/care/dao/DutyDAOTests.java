package com.neuedu.care.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Duty;

import lombok.extern.slf4j.Slf4j;

/**
 * 护士值班管理DAO层测试类
 * @author 马梦瑶
 *
 */
@SpringBootTest
@Slf4j
public class DutyDAOTests {
	@Autowired
	private DutyRepository dutyRepository;
	
//	/**
//	 * 新增值班信息
//	 */
//	@Test
//	public void test_save() {
//		System.out.println("测试开始，新增值班信息：");
//		Duty duty = Duty.builder()
//				.dtime("周日上午")
//				.dnurse("小红")
//				.build();
//		Duty d = dutyRepository.save(duty);
//		Assertions.assertNotEquals(0, d.getDid().intValue());
//		log.info(d.toString());
//		log.debug("测试通过！");
//	}
//	
//	/**
//	 * 根据值班编号删除值班信息
//	 */
//	@Test
//	public void test_deleteByPrimaryKey() {
//		System.out.println("测试开始，根据值班编号删除值班信息：");
//		Integer did = new Integer(1);
//		int d = dutyRepository.deleteByPrimaryKey(did);
//		Assertions.assertNotEquals(0, d);
//		log.debug("测试通过！");
//	}
//	
//	/**
//	 * 根据值班编号修改值班信息
//	 */
//	@Test
//	public void test_updateDuty() {
//		System.out.println("测试开始，根据值班编号修改值班信息：");
//		Integer did = new Integer(2);
//		String dtime = new String("周日下午");
//		String dnurse = new String("小红");
//		int d = dutyRepository.updateDuty(did, dtime, dnurse);
//		Assertions.assertNotEquals(0, d);
//		log.debug("测试通过！");
//	}
	
//	/**
//	 * 根据值班时间和值班人员进行多条件模糊查询
//	 */
//	@Test
//	public void test_findByDtimeContainingAndDnurseContaining() {
//		System.out.println("测试开始，根据值班时间和值班人员进行多条件模糊查询：");
//		List<Duty> duties = dutyRepository.findByDtimeContainingAndDnurseContaining("周日","");
//		Assertions.assertNotEquals(0, duties.size());
//		System.out.println(duties);
//		log.debug("测试通过！"); 
//	}
//	
//	/**
//	 * 查询所有值班信息
//	 */
//	@Test
//	public void test_findAll() {
//		System.out.println("测试开始，查询所有值班信息：");
//		List<Duty> duties = dutyRepository.findAll();
//		Assertions.assertNotEquals(0, duties.size());
//		System.out.println(duties);
//		log.debug("测试通过！");
//	}
	
	/**
	 * 根据值班编号查询值班信息
	 */
	@Test
	public void test_findByDid() {
		System.out.println("测试开始，根据值班编号查询值班信息：");
		Duty duty = dutyRepository.findByDid(7);
		Assertions.assertNotEquals(null, duty);
		System.out.println(duty);
		log.debug("测试通过！"); 
	}
}
