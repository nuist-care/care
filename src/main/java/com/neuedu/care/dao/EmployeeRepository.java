package com.neuedu.care.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neuedu.care.entity.Employee;


/**
 * JPA数据访问层EmployeeRepository
 * @author 姚季
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	/**
	 * 根据eid，password查询员工
	 * @param eid
	 * @param password
	 * @return
	 */
	Employee findByEidAndPassword(Integer eid,String password);
}
