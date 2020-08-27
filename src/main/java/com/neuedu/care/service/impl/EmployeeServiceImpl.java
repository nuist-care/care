package com.neuedu.care.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Employee login(Integer eid, String epassword) {
		if (StringUtils.isBlank(eid.toString())||StringUtils.isBlank(epassword)) {
			return null;
		}
		if (eid.toString().length() != 5) {
			return null;
		}
		if (epassword.length() < 6) {
			return null;
		}
		Employee employee = employeeRepository.findByEidAndPassword(eid, epassword);
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
	public List<Employee> findCondition(Integer eid, String ename, String position) {

		List<Employee> employees = employeeRepository.findByEidOrEnameContainingOrPosition(eid, ename, position);
		return employees;
	}
	
	@Override
	public int update(Integer eid, String ename, String esex, Integer eage, String eIDnumber, String etelephone,
			String eaddress, Date worktime, Integer workage, String position) {
		int line = employeeRepository.update(eid, ename, esex, eage, eIDnumber, etelephone, eaddress, worktime, workage, position);
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
	
	@Override
	public Employee findByEid(Integer eid) {
		Employee employee = employeeRepository.findByEid(eid);
		return employee;
	}
	
	@Override
	public Page<Employee> findAll(Pageable pageable) {
		Page<Employee> ePage = employeeRepository.findAll(pageable);
		return ePage;
	}
	
	/**
	 * 查询所有医生和护工的信息  by马梦瑶
	 */
	@Override
	public Page<Employee> findAllByPosition(Pageable pageable) {
		Page<Employee> ePage = employeeRepository.findAllByPosition(pageable);
		return ePage;
	}	
}
