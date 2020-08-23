package com.neuedu.care.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

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
	/**
	 * 根据编号，姓名，职位多条件模糊查询
	 * @param eid
	 * @param name
	 * @param position
	 * @return
	 */
	List<Employee> fingCondition(Integer eid,String name,String position);
	/**
	 * 新增用户
	 * @param employee
	 * @return
	 */
	Employee save(Employee employee);
	/**
	 * 更新员工信息
	 * @param eid
	 * @param name
	 * @param sex
	 * @param age
	 * @param IDnumber
	 * @param telephone
	 * @param address
	 * @param worktime
	 * @param workage
	 * @param position
	 * @return
	 */
	int update(Integer eid,String name,String sex,Integer age,String IDnumber,
			String telephone,String address,Date worktime,Integer workage,String position);
	/**
	 * 根据编号删除用户
	 * @param eid
	 * @return
	 */
	int delete(Integer eid);
}
