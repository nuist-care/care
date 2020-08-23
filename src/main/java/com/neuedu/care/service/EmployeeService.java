package com.neuedu.care.service;

import java.text.ParseException;
import java.util.List;

import com.neuedu.care.entity.Employee;
/**
 * 业务逻辑接口EmployeeService
 * @author 姚季
 *
 */
public interface EmployeeService {
	/**
	 * 根据姓名，密码查询是否员工
	 * @param eid 员工编号
	 * @param password 密码
	 * @return 员工对象
	 */
	Employee login(Integer eid,String password);
	/**
	 * 查询所有员工
	 * @return
	 */
	List<Employee> findAll();
	
	List<Employee> fingCondition(Integer eid,String name,String position);
	
	Employee save(Employee employee);
}
