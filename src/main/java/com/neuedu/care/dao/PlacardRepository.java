package com.neuedu.care.dao;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Placard;

/**
 * JPA数据访问层接口 PlacardRepository
 * @author ASUS
 *
 */
@Repository
public interface PlacardRepository extends JpaRepository<Placard, Integer>{

	/**
	 * 根据编号查询公告信息
	 * @param pid
	 * @return
	 */
	Placard findByPid(Integer pid);
	
	
	
	/**
	 * 根据编号修改公告信息
	 * @param record
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "update placard set pauthor=?2,ptype=?3,ptime=?4,ptitle=?5,pcontent=?6 where pid=?1")
	int updateByPid(@Param("pid")Integer pid,@Param("pauthor")String pauthor,@Param("ptype")String ptype,@Param("ptime")Date ptime,@Param("ptitle")String ptitle,@Param("pcontent")String pcontent);
	
	/**
	 * 根据编号，作者，类型进行多条件组合查询
	 * @param pid
	 * @param pauthor
	 * @param ptype
	 * @return
	 */
	@Transactional
	@Modifying
	List<Placard> findByPidAndPauthorContainingAndPtype(@Param("pid")Integer pid,@Param("pauthor")String pauthor,@Param("ptype")String ptype);
}