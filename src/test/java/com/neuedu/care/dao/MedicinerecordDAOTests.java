package com.neuedu.care.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Medicinerecord;

import lombok.extern.slf4j.Slf4j;

/**
 * 用药记录管理DAO层测试类
 * @author 马梦瑶
 *
 */
@SpringBootTest
@Slf4j
public class MedicinerecordDAOTests {
	@Autowired
	private MedicinerecordRepository medicinerecordRepository;
	
	/**
	 * 根据用药记录编号修改实际用药时间
	 */
	@Test
	public void test_updateMedicinerecord() {
		System.out.println("测试开始，根据用药记录编号修改实际用药时间：");
		Integer mrid = new Integer(2);
		String actualtime = new String("饭后半小时");
		int m = medicinerecordRepository.updateMedicinerecord(mrid, actualtime);
		Assertions.assertNotEquals(0, m);
		log.debug("测试通过！");
	}
	
	/**
	 * 根据药品名称和客户姓名进行多条件模糊查询
	 */
	@Test
	public void test_findByMnameContainingAndAnameContaining() {
		System.out.println("测试开始，根据药品名称和客户姓名进行多条件模糊查询：");
		List<Medicinerecord> medicinerecords = medicinerecordRepository.findByMnameContainingAndAnameContaining("A", "");
		Assertions.assertNotEquals(0, medicinerecords.size());
		System.out.println(medicinerecords);
		log.debug("测试通过！"); 
	}
	
	/**
	 * 查询所有用药记录信息
	 */
	@Test
	public void test_findAll() {
		System.out.println("测试开始，查询所有用药记录信息：");
		List<Medicinerecord> medicinerecords = medicinerecordRepository.findAll();
		Assertions.assertNotEquals(0, medicinerecords.size());
		System.out.println(medicinerecords);
		log.debug("测试通过！");
	}
	
	/**
	 * 根据用药记录编号查询用药记录信息
	 */
	@Test
	public void test_findByMrid() {
		System.out.println("测试开始，根据用药记录编号查询用药记录信息：");
		Medicinerecord medicinerecord = medicinerecordRepository.findByMrid(2);
		Assertions.assertNotEquals(null, medicinerecord);
		System.out.println(medicinerecord);
		log.debug("测试通过！"); 
	}

}
