package com.neuedu.care.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Employee;

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
	@Test
	void test_login() {
		Integer eid = new Integer(10000);
		String password = "123456";
		Employee employee = employeeService.login(eid, password);
		log.info(employee.toString());
	}

}
