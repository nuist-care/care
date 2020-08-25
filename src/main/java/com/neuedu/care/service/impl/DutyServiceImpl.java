package com.neuedu.care.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.DutyRepository;
import com.neuedu.care.dao.EmployeeRepository;
import com.neuedu.care.entity.Duty;
import com.neuedu.care.entity.Employee;
import com.neuedu.care.service.DutyService;

/**
 * 值班信息管理业务逻辑接口DutyService实现类DutyServiceImpl
 * 
 * @author 马梦瑶
 *
 */
@Service
public class DutyServiceImpl implements DutyService {

	@Autowired
	private DutyRepository dutyRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 根据值班编号删除值班信息
	 */
	@Override
	public boolean delete(Integer did) {
		// 业务判断：值班编号不能为null且不能小于1
		if (null == did || did < 1) {
			return false;
		}
		int line = dutyRepository.deleteByPrimaryKey(did);
		return line == 1 ? true : false;
	}

	/**
	 * 新增值班信息
	 */
	@Override
	public boolean insert(String dtime, String ename) {
		// 非空属性判断
		if (StringUtils.isBlank(dtime)
				|| StringUtils.isBlank(ename)) {
			return false;
		}
		// 员工姓名必须存在于员工表中
		Employee employee = employeeRepository.findByEname(ename);
		System.out.println(employee);
		if (null == employee) {
			return false;
		}
		// 值班时间必须是周一、周二、周三、周四、周五、周六、周日
		if (dtime.trim().toString().equals("周一") && dtime.trim().toString().equals("周二")
				&& dtime.trim().toString().equals("周三") && dtime.trim().toString().equals("周四")
				&& dtime.trim().toString().equals("周五") && dtime.trim().toString().equals("周六")
				&& dtime.trim().toString().equals("周日")) {
			return false;
		}
		// 不能重复添加
		Duty d = dutyRepository.findByDtimeAndEid(dtime, employee.getEid());
		if (null != d) {
			return false;
		}
		// 员工职位必须是护士
		System.out.println("employee.getPosition = " + employee.getPosition().toString());
		boolean flag = (employee.getPosition().toString().equals("护士"));
		System.out.println("flag= " + flag);
//		if (employee.getPosition().equals("护士")) {
//		System.out.println("employee.getPosition = " + employee.getPosition().toString());
//		boolean flag = (employee.getPosition().toString().equals("护士"));
//		System.out.println("flag= " + flag);
		if (!employee.getPosition().toString().equals("护士")) {
			return false;
		}
//		System.out.println("出if了" + employee.getPosition());
		int line = dutyRepository.insert(dtime, employee.getEid());
		return line == 1 ? true : false;
	}

	/**
	 * 更新值班信息
	 */
	@Override
	public boolean update(Integer did, String dtime, String ename) {
		// 非空属性判断
		if (org.apache.commons.lang3.StringUtils.isBlank(dtime)
				|| org.apache.commons.lang3.StringUtils.isBlank(ename)) {
			return false;
		}
		// 员工姓名必须存在于员工表中
		Employee employee = employeeRepository.findByEname(ename);
		System.out.println(employee);
		if (null == employee) {
			return false;
		}
		// 值班时间必须是周一、周二、周三、周四、周五、周六、周日
		if (dtime.trim().toString().equals("周一") && dtime.trim().toString().equals("周二")
				&& dtime.trim().toString().equals("周三") && dtime.trim().toString().equals("周四")
				&& dtime.trim().toString().equals("周五") && dtime.trim().toString().equals("周六")
				&& dtime.trim().toString().equals("周日")) {
			return false;
		}
		// 员工职位必须是护士
//				System.out.println("employee.getPosition = " + employee.getPosition().toString());
//				boolean flag = (employee.getPosition().toString().equals("护士"));
//				System.out.println("flag= " + flag);
		if (!employee.getPosition().toString().equals("护士")) {
			return false;
		}
//				System.out.println("出if了" + employee.getPosition());
		int line = dutyRepository.updateDuty(did, dtime, employee.getEid());
		return line == 1 ? true : false;
	}

	/**
	 * 根据值班时间和值班人员进行多条件模糊查询
	 */
	@Override
	public List<Duty> findByCondition(String dtime, String dnurse) {
		// 字符串主动去除空格
		if (null != dnurse) {
			dnurse = dnurse.trim();
			if (dnurse.length() == 0) {
				dnurse = "";
			}
		}
		if (null != dtime) {
			dtime = dtime.trim();
			if (dtime.length() == 0) {
				dtime = "";
			}
		}
		return dutyRepository.findByDtimeContainingAndDnurseContaining(dtime, dnurse);
	}

	/**
	 * 查询所有值班信息
	 */
	@Override
	public List<Duty> selectAll() {
		return dutyRepository.findAll();
	}

	/**
	 * 根据值班编号查询值班信息
	 */
	@Override
	public Duty findByDid(Integer did) {
		// 业务判断：值班编号不能为空且不能小于1
		if (null == did || did < 1) {
			did = null;
		}
		return dutyRepository.findByDid(did);
	}
}
