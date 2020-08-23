package com.neuedu.care.service;

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
 * 业务逻辑接口EmployeeService测试类
 * @author 姚季
 *
 */
@SpringBootTest
@Slf4j
class EmployeeServiceTest {
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 测试接口EmployeeService函数login
	 */
//	@Test
//	void test_login() {
//		Integer eid = new Integer(10000);
//		String password = "123456";
//		Employee employee = employeeService.login(eid, password);
//		log.info(employee.toString());
//	}

	/**
	 * 测试查询所有员工
	 */
//	@Test
//	void test_findAll() {
//		List<Employee> employees = employeeService.findAll();
//		for (Employee employee : employees) {
//			log.info(employee.toString());
//		}
//	}
	
	/**
	 * 多条件模糊查询
	 */
	@Test
	void test_findCondition() {
		String ename = "y";
		List<Employee> employees = employeeService.findCondition(10001, "", "");
		for (Employee employee : employees) {
			log.info(employee.toString());
		}
	}
	
	/**
	 * 新增员工
	 * @throws ParseException 
	 * 
	 */
//	@Test
//	void test_save() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Employee employee = Employee.builder()
//		.name("qsy")
//		.sex("男")
//		.age(18)
//		.IDnumber("123")
//		.telephone("135")
//		.worktime(sdf.parse("2012-02-12"))
//		.workage(2)
//		.position("杂工")
//		.password("123456")
//		.build();
//		Employee e = employeeService.save(employee);
//		log.info(e.toString());
//	}
	
	/**
	 * 测试更新员工信息
	 * @throws ParseException 
	 * 
	 */
//	@Test
//	void test_update() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Integer eid = 10008;
//		String name ="qsy";
//		String sex = "男";
//		Integer age = 18;
//		String IDnumber = "123";
//		String telephone = "135";
//		Date worktime = sdf.parse("2012-02-12");
//		Integer workage = 2;
//		String position = "杂工";
//		String address = "南通";
//		int line = employeeService.update(eid, name, sex, age, IDnumber, telephone, address, worktime, workage, position);
//		log.info(line+"更新成功");
//	}
	
	/**
	 * 测试删除
	 */
//	@Test
//	void test_delete() {
//		int line = employeeService.delete(10009);
//		log.info(line+"删除成功");
//	}

}
