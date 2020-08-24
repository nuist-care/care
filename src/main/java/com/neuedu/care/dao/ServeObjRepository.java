package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.ServeObj;

/**
 * JPA数据访问层接口 ServeObjRepository
 * @author ASUS
 *
 */
@Repository
public interface ServeObjRepository extends JpaRepository<ServeObj, Integer>{
	
	/**
	 * 根据护工编号查询客户信息
	 * @return 
	 */
	@Transactional
//	@Modifying
	@Transient
	@Query(nativeQuery = true,value = "select s.serveid,s.eid,s.aid,c.aname,b.floor,b.room,b.bnum from serve s,client c,bed b where s.eid=?1 and c.aid=s.aid and b.aid=s.aid")
	List<ServeObj> findByEid(@Param("eid")Integer eid);
}
