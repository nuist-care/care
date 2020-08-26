package com.neuedu.care.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.DrugRepository;
import com.neuedu.care.dao.MedicineRepository;
import com.neuedu.care.entity.Drug;
import com.neuedu.care.entity.Medicine;
import com.neuedu.care.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
	MedicineRepository medicineRepository;
	
	@Autowired
	DrugRepository drugRepository;
	/**
	 * 根据药品名称和客户姓名进行多条件模糊查询
	 */
	@Override
	public List<Medicine> findByMnameAname(String mname, String aname) {
		if(StringUtils.isBlank(mname)) {
			mname=null;
		}
		if(StringUtils.isBlank(aname)) {
		    aname=null;
		}
		return medicineRepository.findByMnameAname(mname, aname);
	}
	
	/**
	 * 根据医嘱编号查询
	 */
	@Override
	public Medicine findByMid(Integer mid) {
		return medicineRepository.findByMid(mid);
	}
	/**
	 * 查询最新医嘱
	 */
	@Override
	public Drug findNewMedicine() {
		return drugRepository.findNewmdicine();
	}
	
	/**
	 * 新增药嘱
	 */
	@Override
	public boolean addMedicine(String mname, String msize, String prescribedtime) {
		int line=medicineRepository.addMedicine(mname, msize, prescribedtime);
		return line==1?true:false;
	}
	
	/**
	 * 新增用药记录
	 * 
	 */
	@Override
	public boolean addMedicinerecord(Integer aid, Integer mid) {
		int line=medicineRepository.addMedicinerecord(aid, mid);
		return line==1?true:false;
	}
	
	/**
	 * 修改药嘱
	 */
	@Override
	public boolean updateMedicine(Integer mid, String mname, String msize, String prescribedtime) {
	    int line=medicineRepository.updateMedicine(mid,  mname, msize, prescribedtime);
	    return line==1?true:false;
	}

}
