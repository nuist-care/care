package com.neuedu.care.service;

import java.util.List;


import com.neuedu.care.entity.Drug;
import com.neuedu.care.entity.Medicine;

public interface MedicineService {

	List<Medicine> findByMnameAname(String mname,String aname);
	
	Medicine findByMid(Integer mid);
	
	Drug findNewMedicine();
	
	boolean addMedicine(String mname,String msize,String prescribedtime);
	
	boolean addMedicinerecord(Integer aid,Integer mid);
	
	boolean updateMedicine(Integer mid,Integer aid,String mname,String msize,String prescribedtime);

}
