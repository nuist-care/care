package com.neuedu.care.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Employee;

import lombok.val;
import lombok.extern.slf4j.Slf4j;
/**
 * EmployeeRepository函数测试类：EmployeeTest
 * @author 姚季
 *
 */
@SpringBootTest
@Slf4j
class EmployeeDaoTest {
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 测试findByEidAndPassword（）函数
	 * 查询是否有这个员工
	 */
//	@Test
//	void test_findByEidAndPassword() {
//		Integer eid = new Integer(10000);
//		String password = "123456";
//		Employee employee = employeeRepository.findByEidAndPassword(eid, password);
//		log.info(employee.toString());
//	}
	
	/**
	 * 测试findByEname（）函数
	 * 查询是否有这个员工
	 */
//	@Test
//	void test_findByEname() {
//		String ename = new String("张三");
//		Employee employee = employeeRepository.findByEname(ename);
//		System.out.println(employee);
//	}
	
	/**
	 * 测试finaAll()函数
	 */
//	@Test
//	void test_finaAll() {
//		List<Employee> employees = employeeRepository.findAll();
//		for (Employee employee : employees) {
//			log.info(employee.toString());
//		}
//	}

	/**
	 * 测试多条件查询
	 */
//	@Test
//	void test_findByEidOrNameLikeOrPositionn() {
//		Integer eid = new Integer("10001");
//		String ename = "mm";
//		String position = "医生";
//		List<Employee> employees = employeeRepository.findByEidOrEnameContainingOrPosition(null,"y","");
//		for (Employee employee : employees) {
//			log.info(employee.toString());
//		}
//	}
	/**
	 * 测试新增功能
	 * @throws ParseException 
	 * 
	 */
//	@Test
//	void test_save() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Employee employee = Employee.builder()
//				.name("qsy")
//				.sex("男")
//				.age(18)
//				.IDnumber("123")
//				.telephone("135")
//				.worktime(sdf.parse("2012-02-12"))
//				.workage(2)
//				.position("杂工")
//				.password("123456")
//				.build();
//		Employee e = employeeRepository.save(employee);
//		log.info(e.toString());
//	}
	
	/**
	 * 测试删除
	 */
//	@Test
//	void test_delete() {
//		int line = 0;
//		try {
//			employeeRepository.deleteById(10004);
//			line =1;
//		} catch (Exception e) {
//			line = 0;
//		}
//
//		log.info(line+"删除成功");
//	}
	
	/**
	 * 测试更新操作
	 * @throws ParseException 
	 */
//	@Test
//	void test_update() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Integer eid = 10006;
//		String name ="qsy";
//		String sex = "男";
//		Integer age = 18;
//		String IDnumber = "123";
//		String telephone = "135";
//		Date worktime = sdf.parse("2012-02-12");
//		Integer workage = 2;
//		String position = "杂工";
//		String address = "南通";
//		int line = employeeRepository.update(eid, name, sex, age, IDnumber, telephone, address, worktime, workage, position);
//		log.info(line+"更新成功");
//	}
	
}
