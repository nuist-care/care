package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Employee;
import com.neuedu.care.service.EmployeeService;

/**
 * 员工相关操作控制器
 * @author 姚季
 *
 */

@Controller
@RequestMapping(value = "employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 显示所有员工信息
	 * @return
	 */
	@GetMapping(value = "/list")
	@ResponseBody
	public ResultBean list() {
		List<Employee> employees= employeeService.findAll();
		for (Employee employee : employees) {
			System.out.println(employee.getEIDnumber());
		}
		ResultBean r = new ResultBean(200,true,"显示所有部门信息成功",employees);
		return r;
	}
	
	/**
	 * d多条件组合查询员工
	 * @param eid
	 * @param ename
	 * @param position
	 * @return
	 */
	@GetMapping(value = "/find")
	@ResponseBody
	public ResultBean find(Integer eid,String ename,String position) {
		if (ename == "") {
			ename = "不存在";
		}
		List<Employee> employees = employeeService.findCondition(eid, ename, position);
		ResultBean r = new ResultBean(200,true,"查询所有部门信息成功",employees);
		return r;
	}
	
	/**
	 * 删除一个员工信息
	 * @param eid
	 * @return
	 */
	@DeleteMapping(value = "/delete/{eid}")
	@ResponseBody
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
	@PostMapping(value = "/insert")
	@ResponseBody
	public ResultBean insert(@Validated Employee employee,BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getField()+": "+f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5004,false,msg.toString(),null);
			return r;
		}
		Employee e = employeeService.save(employee);
		if (e != null) {
			r = new ResultBean(200,true,"新增部门成功,编号为:"+e.getEid(),null);
		}else {
			r = new ResultBean(500,false,"新增部门失败",null);
		}
		return r;
	}
	
	/**
	 * 显示一个员工信息界面
	 * @param eid
	 * @return
	 */
	@GetMapping(value = "/{eid}")
	@ResponseBody
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
	@PutMapping(value = "/update/{eid}")
	@ResponseBody
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
}
