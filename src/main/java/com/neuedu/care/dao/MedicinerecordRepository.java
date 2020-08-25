package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Medicinerecord;

/**
 * JPA数据访问层接口MedicinerecordRepository
 * @author 马梦瑶
 *
 */
@Repository
public interface MedicinerecordRepository extends JpaRepository<Medicinerecord, Integer>{
	
	/**
	 * 根据用药记录编号修改实际用药时间
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update medicinerecord set actualtime = ?2 where mrid = ?1")
	int updateMedicinerecord(@Param("mrid") Integer mrid, @Param("actualtime") String actualtime);
	
	/**
	 * 根据药品名称和客户姓名进行多条件模糊查询
	 */
	@Query(nativeQuery = true, value = "select medicinerecord.mrid,medicine.mname,client.aname,medicine.prescribedtime,medicine.msize,medicinerecord.actualtime FROM medicinerecord,medicine,client WHERE medicinerecord.aid = client.aid AND medicinerecord.mid = medicine.mid AND medicine.mname like concat ('%', ?1, '%') AND client.aname like concat ('%', ?2, '%')")
	List<Medicinerecord> findByMnameContainingAndAnameContaining(@Param("mname")String mname, @Param("aname")String aname);
	
	/**
	 * 查询所有用药记录信息
	 */
	@Query(nativeQuery = true, value = "select medicinerecord.mrid,medicine.mname,client.aname,medicine.prescribedtime,medicine.msize,medicinerecord.actualtime FROM medicinerecord,medicine,client WHERE medicinerecord.aid = client.aid AND medicinerecord.mid = medicine.mid")
	List<Medicinerecord> findAll();

	/**
	 * 根据用药记录编号查询用药记录信息
	 */
	@Query(nativeQuery = true, value = "select medicinerecord.mrid,medicine.mname,client.aname,medicine.prescribedtime,medicine.msize,medicinerecord.actualtime FROM medicinerecord,medicine,client WHERE medicinerecord.aid = client.aid AND medicinerecord.mid = medicine.mid AND medicinerecord.mrid = ?1")
	Medicinerecord findByMrid(Integer mrid);

}
