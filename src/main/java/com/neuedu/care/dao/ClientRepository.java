package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Client;

/**
 * JPA数据访问层ClientRepository
 * @author 姚季
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	/**
	 * 根据编号查询一个客户
	 * @param aid
	 * @return
	 */
	Client findByAid(Integer aid);
	
	/**
	 * 根据编号，姓名，护理等级查询客户
	 * @param aid
	 * @param aname
	 * @param clevel
	 * @return
	 */
	List<Client> findByAidOrAnameContainingOrClevel(@Param("aid")Integer aid,@Param("aname")String aname,@Param("clevel")Integer clevel);
	
	/**
	 * 根据客户姓名精确查询客户信息
	 * @param aname
	 * @return
	 */
	Client findByAname(String aname);
	
	/**
	 * 更新客户信息
	 * @param aid
	 * @param aname
	 * @param asex
	 * @param aage
	 * @param aIDnumber
	 * @param atelephone
	 * @param aaddress
	 * @param genetichistory
	 * @param conditiondescription
	 * @param clevel
	 * @return
	 */
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = "update client set aname = ?2,asex = ?3,aage = ?4,aIDnumber = ?5,atelephone = ?6,aaddress = ?7,genetichistory = ?8,conditiondescription = ?9,clevel = ?10 where aid = ?1")
	int update(@Param("aid")Integer aid,@Param("aname")String aname,@Param("asex")String asex,
			@Param("aage")Integer aage,@Param("aIDnumber")String aIDnumber,
			@Param("atelephone")String atelephone,@Param("aaddress")String aaddress,@Param("genetichistory")String genetichistory,
			@Param("conditiondescription")String conditiondescription,@Param("clevel")Integer clevel);
}
