package com.neuedu.care.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Employee;

import lombok.extern.slf4j.Slf4j;
/**
 * EmployeeRepository函数测试类：EmployeeTest
 * @author 姚季
 *
 */
@SpringBootTest
@Slf4j
class EmployeeTest {
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 测试findByEidAndPassword（）函数
	 * 查询是否有这个员工
	 */
	@Test
	void test_findByEidAndPassword() {
		Integer eid = new Integer(10000);
		String password = "123456";
		Employee employee = employeeRepository.findByEidAndPassword(eid, password);
		log.info(employee.toString());
	}

}
