package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.dao.VistingRepository;
import com.neuedu.care.entity.Visiting;

@Controller
@RequestMapping(value = "visiting")
public class VisitingController {
	@Autowired
	VistingRepository vistingRepository;
	
	/**
	 * 显示所有就诊信息*/
	@GetMapping(value = "/visitinglist")
	@ResponseBody
	public ResultBean list() {
		List<Visiting> visitings=vistingRepository.findAll();
		System.out.println("请求所有部门信息为："+visitings);
		ResultBean r=new ResultBean(200, true, "查询所有信息成功", visitings);
		return r;
	}

}
