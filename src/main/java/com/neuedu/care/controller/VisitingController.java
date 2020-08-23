package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.dao.VistingRepository;
import com.neuedu.care.entity.Visiting;
import com.neuedu.care.service.VisitingService;






@RequestMapping(value = "visiting")
@RestController(value = "visiting")
public class VisitingController {
	@Autowired
	VistingRepository vistingRepository;
	
	@Autowired
	VisitingService visitingService;
	
	/**
	 * 显示所有就诊信息*/
	@GetMapping(value = "/visitinglist")
	@ResponseBody
	public ResultBean list() {
		List<Visiting> visitings=vistingRepository.findAllVisiting();
		System.out.println("请求所有部门信息为："+visitings);
		ResultBean r=new ResultBean(200, true, "查询所有信息成功", visitings);
		return r;
	}
	/**
	 * 增加就诊信息*/
//	
//	@PostMapping(value = "/insert")
//	public ResultBean insert(@Validated Visiting visiting,BindingResult bindingResult)  { 
//		ResultBean r=null;
//		if(bindingResult.hasErrors()) {
//			StringBuffer msg = new StringBuffer();
//			for(FieldError f:bindingResult.getFieldErrors()) {
//				msg.append(f.getField()+":"+f.getDefaultMessage()+"\n");
//			}
//			r = new ResultBean(5006, false, msg.toString(), null);
//			return r;
//		}
//		Integer vid=null;
//		int flag=visitingService.addVisiting(aid, aname, vhospital, vtime, vroom, vresult);
//		if(flag) {
//			r=new ResultBean(200,true,"新增就诊信息成功\n新增就诊信息编号为："+visiting.getVid(),null);
//		}else {
//			r=new ResultBean(5005, false, "新增就诊信息失败", null);
//		}
//		return r;
//	}

	/**
	 * 模糊查询
	 */
	
	@GetMapping(value = "/find")
    @ResponseBody
	public ResultBean find(Integer vid,Integer aid,String aname) {
		List<Visiting> visitings = vistingRepository.findByVidAidAname(vid,aid,aname);
		System.out.println("请求所有部门信息为："+visitings);
		ResultBean r=new ResultBean(200,true,"组合模糊查询成功",visitings);
		return r;
	}
	/**
	 * 修改
	 */
//	@PostMapping(value = "/update")
	
	

}
