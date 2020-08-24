package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Level;

/**
 * JPA数据访问层接口LevelRepository
 * @author 马梦瑶
 *
 */
@Repository
public interface LevelRepository extends JpaRepository<Level, Integer>{
	/**
	 * 根据客户编号修改护理等级
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update client set clevel = ?2 where aid = ?1")
	int updateLevel(@Param("aid") Integer aid, @Param("clevel") Integer clevel);
	
	/** 
	 * 根据客户姓名进行模糊查询
	 */
	@Transactional
	List<Level> findByAnameContaining(@Param("aname")String aname);
	
	/**
	 * 查询所有护理级别信息
	 */
	@Transactional
	List<Level> findAll();

	/**
	 * 根据客户编号查询护理级别信息
	 */
	@Transactional
	Level findByAid(Integer aid);
}
