package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Medicine;
import com.neuedu.care.entity.Medicinerecord;
/**
 * JPA数据访问层接口MedicineRepository
 * 
 *
 */
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer>{
	/**
	 * 新增药嘱
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "insert into medicine(mname,msize,prescribedtime)"
			+ " values(?1,?2,?3)")
	int addMedicine(@Param("mname")String mname,
			@Param("msize")String msize,
			@Param("prescribedtime")String prescribedtime);
	

	
	/**
	 * 新增用药记录
	 * 
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "insert into medicinerecord(aid,mid)"
			+ " values(?1,?2)")
	int addMedicinerecord(@Param("aid")Integer aid,
			@Param("mid")Integer mid);
	
//	/**
//	 * 修改药嘱
//	 */
//	@Modifying
//	@Transactional
//	@Query(nativeQuery = true,value = "update medicine m,medicinerecord r "
//			+ " set r.aid=?2,m.mname=?3,m.msize=?4,m.prescribedtime=?5"
//			+ " where r.mid=m.mid and m.mid=?1")
//	int updateMedicine(@Param("mid")Integer mid,
//			@Param("aid")Integer aid,
//			@Param("mname")String mname,
//			@Param("msize")String msize,
//			@Param("prescribedtime")String prescribedtime);
	
	/**
	 * 修改药嘱
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "update medicine  "
			+ " set mname=?2,msize=?3,prescribedtime=?4"
			+ " where mid=?1")
	int updateMedicine(@Param("mid")Integer mid,
			@Param("mname")String mname,
			@Param("msize")String msize,
			@Param("prescribedtime")String prescribedtime);
	
	/**
	 * 根据药品名称和客户姓名进行多条件模糊查询
	 */
	@Transactional
	@Query(nativeQuery = true,value = "select m.mid,m.mname,m.msize,m.prescribedtime,r.mrid,r.aid,c.aname "
			+ " from medicine m,client c,medicinerecord r"
			+ " where r.mid=m.mid and r.aid=c.aid and (m.mname like concat('%',?1,'%') or c.aname like concat('%',?2,'%'))"
			+ " order by m.mid asc")
	List<Medicine> findByMnameAname(@Param("mname")String mname, @Param("aname")String aname);
	
	/**
	 * 根据医嘱编号查询
	 */
	@Transactional
	@Query(nativeQuery = true,value = "select m.mid,m.mname,m.msize,m.prescribedtime,r.mrid,r.aid,c.aname "
			+ " from medicine m,client c,medicinerecord r"
			+ " where r.mid=m.mid and r.aid=c.aid and m.mid=?1"
			+ " order by m.mid asc")
	Medicine findByMid(@Param("mid")Integer mid);

}
