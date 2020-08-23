package com.neuedu.care.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	/**
	 * 根据员工编号，姓名，职位进行多条件组合查询
	 * @param eid
	 * @param name
	 * @param position
	 * @return
	 */
	@Transactional
	@Modifying
	List<Employee> findByEidOrNameContainingOrPosition(@Param("eid")Integer eid,@Param("name")String name,@Param("position")String position);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = "update employee set name = ?2,sex = ?3,age = ?4,IDnumber = ?5,telephone = ?6,address = ?7,worktime = ?8,workage = ?9,position =  ?10 where eid = ?1")
	int update(@Param("eid")Integer eid,@Param("name")String name,@Param("sex")String sex,@Param("age")Integer age,
			@Param("IDnumber")String IDnumber,@Param("telephone")String telephone,@Param("address")String address,@Param("worktime")Date worktime,
			@Param(" workage")Integer workage,@Param("position")String position);
}
