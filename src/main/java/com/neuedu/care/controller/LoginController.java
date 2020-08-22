package com.neuedu.care.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.config.Audience;
import com.neuedu.care.entity.Employee;
import com.neuedu.care.service.EmployeeService;
import com.neuedu.care.util.JWTTokenUtil;
/**
 * 登录控制类LoginController
 * @author 姚季
 *
 */
@Controller
public class LoginController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private Audience audience;
	/**
	 * 登录
	 * @param id
	 * @param password
	 * @return
	 */
	@PostMapping(value = "checklogin")
	@ResponseBody
	public ResultBean checklogin(Integer eid,String password) {
		ResultBean r = null;
		if (eid == null || password == null) {
			r = new ResultBean(5001,false,"账号或密码不能为空！",null);
			return r;
		}
		if (eid.toString().length() != 5) {
			r = new ResultBean(5001,false,"账号长度错误！",null);
			return r;
		}
		if (password.length() < 6) {
			r = new ResultBean(5001,false,"密码长度不能少于六位！",null);
			return r;
		}
		Employee employee = employeeService.login(eid, password);
		if (employee != null) {
			employee.setPassword("******");
			//String token = JWTTokenUtil.createJWT(""+employee.getEid(), employee.getName(), audience);
			r = new ResultBean(200,true,"登陆成功",employee);
		}else {
			r = new ResultBean(5001,false,"登陆失败",null);
		}
		return r;
	}
}
