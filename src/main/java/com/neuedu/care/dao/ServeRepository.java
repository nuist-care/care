package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Serve;

/**
 * JPA数据访问层接口ServeRepository
 * @author 马梦瑶
 *
 */
@Repository
public interface ServeRepository extends JpaRepository<Serve, Integer>{
	
	/**
	 * 新增服务信息
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "INSERT INTO serve (eid,aid) VALUES (?1,?2)")
	int insert(@Param("eid") Integer eid, @Param("aid") Integer aid);
	
	/**
	 * 根据服务编号删除服务信息
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "delete from serve where serveid = ?1")
	int deleteByPrimaryKey(@Param("serveid") Integer serveid);

	/**
	 * 根据员工姓名、客户姓名进行多条件模糊查询
	 */
	@Query(nativeQuery = true, value = "select serve.serveid,employee.eid,employee.ename,employee.etelephone,employee.position,client.aid,client.aname "
			+ "FROM employee,client,serve "
			+ "WHERE employee.eid = serve.eid AND client.aid = serve.aid AND employee.ename like concat ('%', ?1, '%') "
			+ "AND client.aname like concat ('%', ?2, '%') AND (employee.position = '医生' OR employee.position = '护工')")
	List<Serve> findByEnameContainingAndAnameContaining(@Param("ename") String ename, @Param("aname") String aname);
	
	/**
	 * 查询所有服务信息
	 */
	@Query(nativeQuery = true, value = "select serve.serveid,employee.eid,employee.ename,employee.etelephone,employee.position,client.aid,client.aname FROM employee,client,serve WHERE employee.eid = serve.eid AND client.aid = serve.aid AND (employee.position = '医生' OR employee.position = '护工')")
	List<Serve> findAll();
	
	/**
	 * 根据服务编号查询服务信息
	 */
	@Query(nativeQuery = true, value = "select serve.serveid,employee.eid,employee.ename,employee.etelephone,employee.position,client.aid,client.aname FROM employee,client,serve WHERE employee.eid = serve.eid AND client.aid = serve.aid AND serve.serveid = ?1 AND (employee.position = '医生' OR employee.position = '护工')")
	Serve findByServeid(Integer serveid);
	
	/**
	 * 根据员工编号和客户编号查询服务信息
	 */
	@Query(nativeQuery = true,value = "select serve.serveid,employee.eid,employee.ename,employee.etelephone,employee.position,client.aid,client.aname FROM employee,client,serve WHERE employee.eid = serve.eid AND client.aid = serve.aid AND serve.eid = ?1 AND serve.aid = ?2")
	Serve findByEidAndAid(@Param("eid")Integer eid, @Param("aid") Integer aid);
	
}
