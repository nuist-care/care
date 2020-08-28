package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Client;
import com.neuedu.care.entity.Healthassessment;
import com.neuedu.care.entity.Visiting;
import com.neuedu.care.service.ClientService;
import com.neuedu.care.service.HealthassessmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(tags = "健康评估控制器")
@RequestMapping(value = "healthassessment")
@RestController
public class HealthassessmentController {
	
	@Autowired
	HealthassessmentService healthassessmentService;
	
	@Autowired
	ClientService clientService;
	
	/**
	 * 显示所有评估信息*/
	@ApiOperation(value = "显示所有评估信息")
	@GetMapping(value = "/healthassessmentlist")
	public ResultBean list() {
		List<Healthassessment> healthassessments=healthassessmentService.findAllHealthassessment();
		System.out.println("请求所有信息为："+healthassessments);
		ResultBean r=new ResultBean(200, true, "查询所有信息成功", healthassessments);
		return r;
	}
	
	/**
	 * 模糊查询
	 */
	@ApiOperation(value = "模糊查询评估信息")
	@GetMapping(value = "/find")
	public ResultBean find(Integer assid,Integer aid,String aname) {
		List<Healthassessment> healthassessments = healthassessmentService.findByAssidAidAname(assid, aid, aname);
		System.out.println("请求所有部门信息为："+healthassessments);
		ResultBean r=new ResultBean(200,true,"组合模糊查询成功",healthassessments);
		return r;
	}
	
	/**
	 * 增加评估信息*/
	@ApiOperation(value = "增加评估信息")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Healthassessment healthassessment,BindingResult bindingResult)  { 
		ResultBean r=null;
		if(bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for(FieldError f:bindingResult.getFieldErrors()) {
				msg.append(f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5006, false, msg.toString(), null);
			return r;
		};
		Client client=clientService.findByid(healthassessment.getAid());
		if(client==null) {
			r = new ResultBean(5000, false, "客户编号不存在!", null);
			return r;
		}
		boolean flag=healthassessmentService.addHealthassessment(healthassessment.getAid(),
				healthassessment.getAssesser(),healthassessment.getAssreason(),healthassessment.getAsstype(),
				healthassessment.getAsstime(),healthassessment.getAssresult());
		if(flag) {
			r=new ResultBean(200,true,"新增评估信息成功",null);
		}else {
			r=new ResultBean(5005, false, "新增评估信息失败", null);
		}
		return r;
	}
	
	/**
	 * 修改评估信息
	 */
	@ApiOperation(value = "修改健康评估信息")
	@PutMapping(value = "/update/{assid}")
	public ResultBean update(@PathVariable("assid") Integer assid, @Validated Healthassessment healthassessment, BindingResult bindingResult) {
		ResultBean r = null;
		if (bindingResult.hasErrors()) {
			// 将无法通过数据校验的信息，合并成一个字符串，返回给前端
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getDefaultMessage() + "\n");
			}
			r = new ResultBean(5006, false, msg.toString(), null);
			return r;
		}
		Client client=clientService.findByid(healthassessment.getAid());
		if(client==null) {
			r = new ResultBean(5000, false, "客户编号不存在!", null);
			return r;
		}
		boolean flag = healthassessmentService.updateHealthassessment(assid, healthassessment.getAid(),
				healthassessment.getAssesser(),healthassessment.getAssreason(),healthassessment.getAsstype(),
				healthassessment.getAsstime(),healthassessment.getAssresult());
		if (flag) {
			r = new ResultBean(200, true, "修改就诊信息成功！", null);
		} else {
			r = new ResultBean(5005, false, "修改就诊信息失败！", null);
		}
		return r;
	}
	
	/**
	 * 根据编号查询
	 */
	@ApiOperation(value = "根据评估编号查询信息")
	@GetMapping(value = "/{assid}")
	public ResultBean findByAssid(@PathVariable("assid") Integer assid) {
		Healthassessment healthassessment=healthassessmentService.findByAssid(assid);
		ResultBean r = new ResultBean(200, true, "查询成功！", healthassessment);
		System.out.println(healthassessment);
		return r;
	}
	

}
