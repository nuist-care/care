package com.neuedu.care.dao;

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
class MedicineDAOTests {
	@Autowired
	MedicineRepository medicineRepository;
	
	@Autowired
	DrugRepository drugRepository;

	/**
	 * 添加医嘱表,同时添加用药记录
	 */
//	@Test
//	public void test_addHealthMedicine() {
//		System.out.println("测试添加：");
//		int s=medicineRepository.addMedicine("头孢", "一天一次", "5天");
//		Assertions.assertNotEquals(0, s);
//		Drug medicine= drugRepository.findNewmdicine();
//		System.out.println(medicine.getMid());
//		int d=medicineRepository.addMedicinerecord(10001, medicine.getMid());
//		Assertions.assertNotEquals(0, d);
//		log.debug("测试通过！"); 
//	}
	
	/**
	 * 修改医嘱表
	 */
//	@Test
//	public void test_updateHealthMedicine() {
//		System.out.println("测试修改：");
//		int s=medicineRepository.updateMedicine(70007, 10002,"头孢", "一天一次", "6天");
//		Assertions.assertNotEquals(0, s);
//		log.debug("测试通过！");
//	}
	
	/**
	 * 根据药名和老人姓名模糊查询
	 */
//	@Test
//	public void test_findByMnameAname() {
//		System.out.println("测试模糊查询：");
//		List<Medicine> medicines=medicineRepository.findByMnameAname("感", "y");
//		Assertions.assertNotEquals(0, medicines.size());
//		System.out.println(medicines);
//		log.debug("测试通过！");
//				
//	}
	
	/**
	 * 根据医嘱编号查询
	 */
//	@Test
//	public void test_findByMid() {
//		System.out.println("测试查询：");
//		Medicine medicine=medicineRepository.findByMid(70001);
//		Assertions.assertNotEquals(null, medicine);
//		System.out.println(medicine);
//		log.debug("测试通过！");
//		
//	}
	
	

}
