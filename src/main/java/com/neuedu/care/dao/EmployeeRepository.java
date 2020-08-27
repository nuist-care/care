package com.neuedu.care.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	Page<Employee> findAll(Pageable pageable);
	
	/**
	 * 根据编号查询一个员工信息
	 * @param eid
	 * @return
	 */
	Employee findByEid(Integer eid);
	
	/**
	 * 根据员工姓名查询一个员工信息
	 * @param ename
	 * @return
	 */
	Employee findByEname(String ename);
	
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
	List<Employee> findByEidOrEnameContainingOrPosition(@Param("eid")Integer eid,@Param("ename")String ename,@Param("position")String position);
	
	/**
	 * 查询所有医生和护工的信息 by马梦瑶
	 * @return
	 */
	@Query(nativeQuery = true, value = "select * from employee where position = '护工' or position = '医生'")
	Page<Employee> findAllByPosition(Pageable pageable);
	
	/**
	 * 更新员工信息
	 * @param eid
	 * @param ename
	 * @param esex
	 * @param eage
	 * @param eIDnumber
	 * @param etelephone
	 * @param eaddress
	 * @param worktime
	 * @param workage
	 * @param position
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = "update employee set ename = ?2,esex = ?3,eage = ?4,eIDnumber = ?5,etelephone = ?6,eaddress = ?7,worktime = ?8,workage = ?9,position =  ?10 where eid = ?1")
	int update(@Param("eid")Integer eid,@Param("ename")String ename,@Param("esex")String esex,@Param("eage")Integer eage,
			@Param("eIDnumber")String eIDnumber,@Param("etelephone")String etelephone,@Param("eaddress")String eaddress,@Param("worktime")Date worktime,
			@Param(" workage")Integer workage,@Param("position")String position);
}
