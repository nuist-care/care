package com.neuedu.care.service.impl;

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

}
