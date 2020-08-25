package com.neuedu.care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.MedicinerecordRepository;
import com.neuedu.care.entity.Medicinerecord;
import com.neuedu.care.service.MedicinerecordService;

/**
 * 用药管理业务逻辑层接口MedicinerecordService实现类MedicinerecordServiceImpl
 * 
 * @author 马梦瑶
 *
 */
@Service
public class MedicinerecordServiceImpl implements MedicinerecordService {

	@Autowired
	private MedicinerecordRepository medicinerecordRepository;

	/**
	 * 根据用药记录编号修改实际用药时间
	 */
	@Override
	public boolean update(Integer mrid, String actualtime) {
		// 业务判断：非空属性判断
		if (null == mrid || org.apache.commons.lang3.StringUtils.isBlank(actualtime)) {
			return false;
		}
		int line = medicinerecordRepository.updateMedicinerecord(mrid, actualtime);
		return line == 1 ? true : false;
	}

	/**
	 * 根据药品名称和客户姓名进行多条件模糊查询
	 */
	@Override
	public List<Medicinerecord> findByCondition(String mname, String aname) {
		// 字符串主动去除空格
		if (null != mname) {
			mname = mname.trim();
			if (mname.length() == 0) {
				mname = "";
			}
		}
		if (null != aname) {
			aname = aname.trim();
			if (aname.length() == 0) {
				aname = "";
			}
		}
		return medicinerecordRepository.findByMnameContainingAndAnameContaining(mname, aname);
	}

	/**
	 * 查询所有用药记录信息
	 */
	@Override
	public List<Medicinerecord> selectAll() {
		return medicinerecordRepository.findAll();
	}

	/**
	 * 根据用药记录编号查询用药记录信息
	 */
	@Override
	public Medicinerecord findByMrid(Integer mrid) {
		// 业务判断：服务编号不能为null且不能小于1
		if (null == mrid || mrid < 1) {
			return null;
		}
		return medicinerecordRepository.findByMrid(mrid);
	}

}
