package com.neuedu.care.service;

import java.util.List;


import com.neuedu.care.entity.Drug;
import com.neuedu.care.entity.Medicine;

public interface MedicineService {
	/**
	 * 根据药名，老人姓名模糊查询
	 * 
	 */
	List<Medicine> findByMnameAname(String mname,String aname);
	/**
	 * 根据医嘱编号查询
	 * 
	 */
	Medicine findByMid(Integer mid);
	/**
	 * 查询最新添加的医嘱
	 * 
	 */
	Drug findNewMedicine();
	/**
	 * 添加医嘱
	 * 
	 */
	boolean addMedicine(String mname,String msize,String prescribedtime);
	
	/**
	 *添加用药记录 
	 * 
	 */
	
	boolean addMedicinerecord(Integer aid,Integer mid);
	/**
	 * 修改医嘱
	 * 
	 */
	boolean updateMedicine(Integer mid,String mname,String msize,String prescribedtime);

}
