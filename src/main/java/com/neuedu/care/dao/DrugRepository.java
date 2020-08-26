package com.neuedu.care.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Drug;
import com.neuedu.care.entity.Medicine;
/**
 * JPA数据访问层接口DrugRepository
 * 
 *
 */
@Repository
public interface DrugRepository extends JpaRepository<Drug, Integer>{
	
	/**
	 * 查询新增的医嘱
	 */
	@Transactional
	@Query(nativeQuery = true,value = "select mid, mname,msize,prescribedtime from medicine  where "
			+ " mid=(select max(mid) from medicine )")
	Drug findNewmdicine();

}
