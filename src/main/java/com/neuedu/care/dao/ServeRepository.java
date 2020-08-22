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
	 * 根据服务编号删除服务信息
	 * @param serveid 服务编号
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "delete from serve where serveid = ?1")
	int deleteByPrimaryKey(@Param("serveid") Integer serveid);

	/**
	 * 根据员工编号查询服务信息
	 * @param eid 员工编号
	 * @return
	 */
	@Query(nativeQuery = true, value = "select serve.serveid,employee.eid,employee.name,employee.telephone,client.aid,client.`name`,bed.floor,bed.room,bed.bnum FROM employee,client,bed,serve WHERE employee.eid = serve.eid AND client.aid = serve.aid AND bed.aid = client.aid AND serve.eid = ?1")
	List<Serve> selectByPrimaryKey(@Param("eid") Integer eid);
	
	/**
	 * 查询所有服务信息
	 * @return
	 */
	@Query(nativeQuery = true, value = "select serve.serveid,employee.eid,employee.name,employee.telephone,client.aid,client.`name`,bed.floor,bed.room,bed.bnum FROM employee,client,bed,serve WHERE employee.eid = serve.eid AND client.aid = serve.aid AND bed.aid = client.aid")
	List<Serve> selectAll();
	
}
