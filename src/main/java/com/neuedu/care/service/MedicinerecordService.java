package com.neuedu.care.service;

import java.util.List;

import com.neuedu.care.entity.Medicinerecord;

/**
 * 业务逻辑层接口MedicinerecordService
 * @author 马梦瑶
 *
 */
public interface MedicinerecordService {
	
	/**
	 * 根据用药记录编号修改实际用药时间
	 * @param mrid 用药记录编号
	 * @param actualtime 实际用药时间
	 * @return 是否成功更新
	 */
	boolean update(Integer mrid, String actualtime);
	
	/**
	 * 根据药品名称和客户姓名进行多条件模糊查询
	 * @param mname 药品名称
	 * @param aname 客户姓名
	 * @return 用药记录对象集合
	 */
	List<Medicinerecord> findByCondition(String mname, String aname);
	
	/**
	 * 查询所有用药记录信息
	 * @return 用药记录对象集合
	 */
	List<Medicinerecord> selectAll();
	
	/**
	 * 根据用药记录编号查询用药记录信息
	 * @param mrid 用药记录编号
	 * @return 用药记录对象
	 */
	Medicinerecord findByMrid(Integer mrid);
}
