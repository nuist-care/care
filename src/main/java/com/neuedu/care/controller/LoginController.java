package com.neuedu.care.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.config.Audience;
import com.neuedu.care.entity.Employee;
import com.neuedu.care.service.EmployeeService;
import com.neuedu.care.util.JWTTokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 登录控制类LoginController
 * @author 姚季
 *
 */
@Api(tags = "登录控制器")
@RestController
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
	@ApiOperation(value = "登录")
	@PostMapping(value = "checklogin")
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
			String token = JWTTokenUtil.createJWT(""+employee.getEid(), employee.getEname(), audience);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("e", employee);
			map.put("token", token);
			r = new ResultBean(200,true,"登陆成功",map);
		}else {
			r = new ResultBean(5001,false,"登陆失败",null);
		}
		return r;
	}
	
	/**
	 * 登出
	 * @return
	 */
	@ApiOperation(value = "登出")
	@GetMapping(value = "exit")
	public ResultBean exit() {
		return new ResultBean(5007,true,"注销成功",null);
	}
}
