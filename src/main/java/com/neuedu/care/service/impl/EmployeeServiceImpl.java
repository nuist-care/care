package com.neuedu.care.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		List<Employee> employees = employeeRepository.findByEidOrNameContainingOrPosition(eid, name, position);
		return employees;
	}
	@Override
	public int update(Integer eid, String name, String sex, Integer age, String IDnumber, String telephone,
			String address, Date worktime, Integer workage, String position) {
		int line = employeeRepository.update(eid, name, sex, age, IDnumber, telephone, address, worktime, workage, position);
		return line;
	}
	@Override
	public int delete(Integer eid) {
		int line = 0;
		try {
			employeeRepository.deleteById(eid);
			line = 1;
		} catch (Exception e) {
			line = 0;
		}
		return line;
	}

	
}
