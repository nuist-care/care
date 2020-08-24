package com.neuedu.care.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Food;

/**
 * JPA数据访问层接口 FoodRepository
 * @author ASUS
 *
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>{

	/**
	 *根据膳食编号查询膳食信息
	 * @param fid
	 * @return
	 */
	Food findByFid(Integer fid);
	
	/**
	 * 根据膳食编号修改膳食信息
	 * @param fid
	 * @param aid
	 * @param ftime
	 * @param fype
	 * @param fcontent
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "update food set aid=?2,ftime=?3,ftype=?4,fcontent=?5 where fid=?1")
	int updateByFid(@Param("fid")Integer fid,@Param("aid")Integer aid,@Param("ftime")Date ftime,@Param("ptype")String ftype,@Param("fcontent")String fcontent);
	
	/**
	 * 根据客户编号查询膳食信息
	 * @param aid
	 * @return
	 */
	@Transactional
	@Modifying
	List<Food> findByAid(@Param("aid")Integer aid);
	
	/**
	 * 查询所有膳食信息，并按时间排序
	 */
	@Transactional
	@Query(nativeQuery = true,value = "select * from food order by ftime")
	List<Food> findAll2();
}
