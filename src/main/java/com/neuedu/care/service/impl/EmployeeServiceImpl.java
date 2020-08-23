package com.neuedu.care.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.EmployeeRepository;
import com.neuedu.care.entity.Employee;
import com.neuedu.care.service.EmployeeService;
/**
 * 业务逻辑接口EmployeeService实现类EmployeeServiceImpl
 * @author 姚季
 *
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
/**
 * 实现login方法
 */
	@Override
	public Employee login(Integer eid, String password) {
		if (StringUtils.isBlank(eid.toString())||StringUtils.isBlank(password)) {
			return null;
		}
		if (eid.toString().length() != 5) {
			return null;
		}
		if (password.length() < 6) {
			return null;
		}
		Employee employee = employeeRepository.findByEidAndPassword(eid, password);
		return employee;
	}
	/**
	 * 实现查询所有用户
	 */
	@Override
	public List<Employee> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}
	/**
	 * 实现新增功能
	 */
	@Override
	public Employee save(Employee employee) {
		Employee e = employeeRepository.save(employee);
		return e;
	}
	/**
	 * 实现多条件查询
	 */
	@Override
	public List<Employee> fingCondition(Integer eid, String name, String position) {
		List<Employee> employees = employeeRepository.findByEidOrNameContainingAndPosition(eid, name, position);
		return employees;
	}

	
}
