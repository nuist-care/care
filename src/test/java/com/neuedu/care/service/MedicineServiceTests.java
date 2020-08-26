package com.neuedu.care.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Drug;
import com.neuedu.care.entity.Medicine;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class MedicineServiceTests {
	@Autowired
	MedicineService medicineService;
	/**
	 * 添加医嘱表,同时添加用药记录
	 */
//	@Test
//	public void test_addHealthMedicine() {
//		System.out.println("测试添加：");
//		boolean s=medicineService.addMedicine("头孢", "一天十次", "5天");
//		Assertions.assertNotEquals(0, s);
//		Drug medicine= medicineService.findNewMedicine();
//		System.out.println(medicine.getMid());
//		boolean d=medicineService.addMedicinerecord(10002, medicine.getMid());
//		Assertions.assertNotEquals(0, d);
//		log.debug("测试通过！"); 
//	}
	/**
	 * 修改医嘱表
	 */
//	@Test
//	public void test_updateHealthMedicine() {
//		System.out.println("测试修改：");
//		boolean s=medicineService.updateMedicine(70007, 10002,"头", "一天一次", "5天");
//		Assertions.assertNotEquals(0, s);
//		log.debug("测试通过！");
//	}
	
//	/**
//	 * 根据药名和老人姓名模糊查询
//	 */
//	@Test
//	public void test_findByMnameAname() {
//		System.out.println("测试模糊查询：");
//		List<Medicine> medicines=medicineService.findByMnameAname("感", "y");
//		Assertions.assertNotEquals(0, medicines.size());
//		System.out.println(medicines);
//		log.debug("测试通过！");
//				
//	}
//	
//	/**
//	 * 根据医嘱编号查询
//	 */
//	@Test
//	public void test_findByMid() {
//		System.out.println("测试查询：");
//		Medicine medicine=medicineService.findByMid(70001);
//		Assertions.assertNotEquals(null, medicine);
//		System.out.println(medicine);
//		log.debug("测试通过！");
//		
//	}


}
