package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Employee;
import com.neuedu.care.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 员工相关操作控制器
 * @author 姚季
 *
 */
@Api(tags = "员工信息操作控制器")
@RestController
@RequestMapping(value = "employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 显示所有员工信息
	 * @return
	 */
	@ApiOperation(value = "显示所有员工信息")
	@GetMapping(value = "/list")
	public ResultBean list(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
			@RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum-1, pageSize);
		Page<Employee> employees = employeeService.findAll(pageable);
		ResultBean r = new ResultBean(200,true,"显示所有部门信息成功",employees);
		return r;
	}
	
	/**
	 * 多条件组合查询员工
	 * @param eid
	 * @param ename
	 * @param position
	 * @return
	 */
	@ApiOperation(value = "多条件组合查询员工")
	@GetMapping(value = "/find")
	public ResultBean find(Integer eid,String ename,String position) {
		if (ename == "") {
			ename = "不存在";
		}
		List<Employee> employees = employeeService.findCondition(eid, ename, position);
		ResultBean r = new ResultBean(200,true,"查询所有员工信息成功",employees);
		return r;
	}
	
	/**
	 * 删除一个员工信息
	 * @param eid
	 * @return
	 */
	@ApiOperation(value = "删除一个员工信息")
	@DeleteMapping(value = "/delete/{eid}")
	public ResultBean delete(@PathVariable("eid")Integer eid) {
		int line = employeeService.delete(eid);
		ResultBean r = null;
		if (line == 1) {
			r = new ResultBean(200,true,"删除员工成功",null);
		}else {
			r = new ResultBean(500,false,"删除员工失败",null);
		}
		return r;
	}
	
	/**
	 * 新增员工
	 * @param employee
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增员工")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Employee employee,BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5004,false,msg.toString(),null);
			return r;
		}
		Employee e = employeeService.save(employee);
		if (e != null) {
			r = new ResultBean(200,true,"新增员工成功,编号为:"+e.getEid(),null);
		}else {
			r = new ResultBean(500,false,"新增员工失败",null);
		}
		return r;
	}
	
	/**
	 * 显示一个员工信息界面
	 * @param eid
	 * @return
	 */
	@ApiOperation(value = "显示一个员工信息界面")
	@GetMapping(value = "/{eid}")
	public ResultBean detail(@PathVariable("eid")Integer eid) {
		Employee employee = employeeService.findByEid(eid);
		ResultBean r = new ResultBean(200,true,"查询成功。。。",employee);
		return r;
	}
	
	/**
	 * 更新一个员工信息
	 * @param id
	 * @param employee
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "更新一个员工信息")
	@PutMapping(value = "/update/{eid}")
	public ResultBean update(@PathVariable("eid")String id,@Validated Employee employee,BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getField()+": "+f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5004,false,msg.toString(),null);
			return r;
		}
		int line = employeeService.update(employee.getEid(), employee.getEname(), employee.getEsex(), employee.getEage(), 
				employee.getEIDnumber(), employee.getEtelephone(),employee.getEaddress(), 
				employee.getWorktime(), employee.getWorkage(), employee.getPosition());
		if (line == 1) {
			r = new ResultBean(200,true,"修改员工信息成功",null);
		}else {
			r = new ResultBean(500,false,"修改员工信息失败",null);
		}
		return r;
	}
	
	/**
	 * 显示所有医生和护工信息 by马梦瑶
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "显示所有医生和护工信息页面：数据存储在care中")
	@GetMapping(value = "/slist")
	public ResultBean slist() {
		List<Employee> employees = employeeService.findAllByPosition();
		ResultBean r = new ResultBean(200, true, "查询所有医生和护工信息成功！", employees);
		return r;
	}
}
