package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.dao.DutyRepository;
import com.neuedu.care.dao.EmployeeRepository;
import com.neuedu.care.entity.Duty;
import com.neuedu.care.entity.Employee;
import com.neuedu.care.service.DutyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 值班信息控制器DutyController
 * 
 * @author 马梦瑶
 *
 */
@Api(tags = "值班信息控制器")
@RestController
@RequestMapping(value = "duty")
public class DutyController {
	@Autowired
	private DutyService dutyService;

	@Autowired
	private DutyRepository dutyRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 显示所有值班信息页面
	 * 
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "显示所有值班信息页面：数据存储在care中")
	@GetMapping(value = "/list")
	public ResultBean dutylist() {
		List<Duty> duties = dutyService.selectAll();
		System.out.println("请求所有值班信息：" + duties);
		ResultBean r = new ResultBean(200, true, "查询所有值班信息成功！", duties);
		return r;
	}

	/**
	 * 根据值班时间和值班人员进行多条件模糊查询
	 * 
	 * @param dtime  值班时间
	 * @param dnurse 值班人员
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据值班时间和值班人员进行多条件模糊查询：数据存储在care中")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "dtime", value = "值班时间", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "dnurse", value = "值班人员", dataType = "String")})
	@GetMapping(value = "/find")
	public ResultBean find(String dtime, String dnurse) {
		List<Duty> duties = dutyService.findByCondition(dtime, dnurse);
		ResultBean r = new ResultBean(200, true, "查询成功！", duties);
		System.out.println(r);
		return r;
	}

	/**
	 * 新增值班信息
	 * 
	 * @param dtime 值班时间
	 * @param ename 员工姓名
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "新增值班信息")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated String dtime, @Validated String ename) {
		ResultBean r = null;
		// 数据验证
		// 非空属性判断
		if (org.apache.commons.lang3.StringUtils.isBlank(dtime)) {
			return r = new ResultBean(5005, false, "值班日期不能为空！", null);
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(ename)) {
			return r = new ResultBean(5005, false, "值班人员不能为空！", null);
		}
		// 员工姓名必须存在于员工表中，员工职位必须是护士
		Employee employee = employeeRepository.findByEname(ename);
//		System.out.println(employee);
		if (null == employee || !employee.getPosition().toString().equals("护士")) {
			return r = new ResultBean(5005, false, "该护士不存在！", null);
		}
		// 值班时间必须是周一、周二、周三、周四、周五、周六、周日
		if (dtime.trim().toString().equals("周一") && dtime.trim().toString().equals("周二")
				&& dtime.trim().toString().equals("周三") && dtime.trim().toString().equals("周四")
				&& dtime.trim().toString().equals("周五") && dtime.trim().toString().equals("周六")
				&& dtime.trim().toString().equals("周日")) {
			return r = new ResultBean(5005, false, "值班日期不合法！", null);
		}
		// 不能重复添加
		Duty d = dutyRepository.findByDtimeAndEid(dtime, employee.getEid());
		if (null != d) {
			return r = new ResultBean(5005, false, "该值班记录已存在！", null);
		}
//		System.out.println("dtime = " + dtime + "    ename = " + ename);
		boolean flag = dutyService.insert(dtime, ename);
		Duty d_now = dutyRepository.findByDtimeAndEname(dtime, ename);
		if (flag) {
			r = new ResultBean(200, true, "新增值班信息成功！\n新增值班编号为：" + d_now.getDid(), null);
		} else {
			r = new ResultBean(5005, false, "新增值班信息失败！", null);
		}
		System.out.println(r);
		return r;
	}

	/**
	 * 显示值班详细信息
	 * 
	 * @param did 值班编号
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据值班编号查询值班信息")
	@ApiImplicitParam(paramType = "path", name = "did", value = "值班编号", required = true, dataType = "int")
	@ApiResponse(code = 200, message = "返回duty_update.html页面，数据存储在care中")
	@GetMapping(value = "/{did}")
	public ResultBean detail(@PathVariable("did") Integer did) {
		Duty duty = dutyService.findByDid(did);
		ResultBean r = new ResultBean(200, true, "查询成功！", duty);
		return r;
	}

	/**
	 * 修改值班信息
	 * 
	 * @param did   值班编号
	 * @param dtime 值班时间
	 * @param ename 员工姓名
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "修改值班信息")
	@PutMapping(value = "/update/{did}")
	public ResultBean update(@PathVariable("did") Integer did, @Validated String dtime, @Validated String ename) {
		ResultBean r = null;
		// 数据验证
		// 非空属性判断
		if (null == did) {
			return r = new ResultBean(5005, false, "值班编号不能为空！", null);
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(dtime)) {
			return r = new ResultBean(5005, false, "值班日期不能为空！", null);
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(ename)) {
			return r = new ResultBean(5005, false, "值班人员不能为空！", null);
		}
		// 员工姓名必须存在于员工表中，员工职位必须是护士
		Employee employee = employeeRepository.findByEname(ename);
//				System.out.println(employee);
		if (null == employee || !employee.getPosition().toString().equals("护士")) {
			return r = new ResultBean(5005, false, "该护士不存在！", null);
		}
		// 值班时间必须是周一、周二、周三、周四、周五、周六、周日
		if (dtime.trim().toString().equals("周一") && dtime.trim().toString().equals("周二")
				&& dtime.trim().toString().equals("周三") && dtime.trim().toString().equals("周四")
				&& dtime.trim().toString().equals("周五") && dtime.trim().toString().equals("周六")
				&& dtime.trim().toString().equals("周日")) {
			return r = new ResultBean(5005, false, "值班日期不合法！", null);
		}
//				System.out.println("dtime = " + dtime + "    ename = " + ename);
		boolean flag = dutyService.update(did, dtime, ename);
		if (flag) {
			r = new ResultBean(200, true, "修改值班信息成功！", null);
		} else {
			r = new ResultBean(5005, false, "修改值班信息失败！", null);
		}
		return r;
	}

	/**
	 * 删除值班信息
	 * 
	 * @param did 值班编号
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "删除值班信息")
	@DeleteMapping(value = "/delete/{did}")
	public ResultBean delete(@PathVariable("did") Integer did) {
		boolean flag = dutyService.delete(did);
		ResultBean r = null;
		if (flag) {
			r = new ResultBean(200, true, "删除值班信息成功！", null);
		} else {
			r = new ResultBean(5005, false, "删除值班信息失败！", null);
		}
		return r;
	}
}
