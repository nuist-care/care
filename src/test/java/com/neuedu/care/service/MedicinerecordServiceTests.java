package com.neuedu.care.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Medicinerecord;

import lombok.extern.slf4j.Slf4j;

/**
 * 用药记录管理Service层测试类
 * @author 马梦瑶
 *
 */
@SpringBootTest
@Slf4j
public class MedicinerecordServiceTests {
	@Autowired
	private MedicinerecordService medicinerecordService;
	
	/**
	 * 根据用药记录编号修改实际用药时间
	 */
	@Test
	void test_update() {
		System.out.println("测试开始，根据用药记录编号修改实际用药时间：");
		Integer mrid = new Integer(2);
		String actualtime = new String("饭中");
		boolean m = medicinerecordService.update(mrid, actualtime);
		Assertions.assertNotEquals(0, m);
		log.debug("测试通过！");
	}
	
	/**
	 * 根据药品名称和客户姓名进行多条件模糊查询
	 */
	@Test
	void test_findByCondition() {
		System.out.println("测试开始，根据药品名称和客户姓名进行多条件模糊查询：");
		List<Medicinerecord> medicinerecords = medicinerecordService.findByCondition("A","");
		Assertions.assertNotEquals(0, medicinerecords.size());
		System.out.println(medicinerecords);
		log.debug("测试通过！"); 
	}
	
	/**
	 * 查询所有用药记录信息
	 */
	@Test
	void test_selectAll() {
		System.out.println("测试开始，查询所有用药记录信息：");
		List<Medicinerecord> medicinerecords = medicinerecordService.selectAll();
		Assertions.assertNotEquals(0, medicinerecords.size());
		System.out.println(medicinerecords);
		log.debug("测试通过！");
	}
	
	/**
	 * 根据用药记录编号查询用药记录信息
	 */
	@Test
	void test_findByMrid() {
		System.out.println("测试开始，根据用药记录编号查询用药记录信息：");
		Medicinerecord medicinerecord = medicinerecordService.findByMrid(2);
		Assertions.assertNotEquals(null, medicinerecord);
		System.out.println(medicinerecord);
		log.debug("测试通过！"); 
	}
}
