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
import com.neuedu.care.entity.Healthrecord;
import com.neuedu.care.service.HealthrecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "健康档案控制器")
@RestController(value = "healthrecord")
@RequestMapping(value = "healthrecord")
public class HealthrecordController {
	
	@Autowired
	HealthrecordService healthrecordService;
	
	/**
	 * 显示所有健康档案*/
	@ApiOperation(value = "显示所有健康档案")
	@GetMapping(value = "/healthrecordlist")
	public ResultBean list() {
		List<Healthrecord> healthrecords=healthrecordService.findAllHealthrecord();
		System.out.println("请求所有信息为："+healthrecords);
		ResultBean r=new ResultBean(200, true, "查询所有信息成功", healthrecords);
		return r;
	}
	
	/**
	 * 根据编号查询
	 */
	@ApiOperation(value = "根据档案编号查询健康计划信息")
	@GetMapping(value = "/{rid}")
	public ResultBean findByRid(@PathVariable("rid") Integer rid) {
		Healthrecord healthrecord=healthrecordService.findByRid(rid);
		ResultBean r = new ResultBean(200, true, "查询成功！", healthrecord);
		System.out.println(healthrecord);
		return r;
	}
	
	/**
	 * 模糊查询
	 */
	@ApiOperation(value = "根据档案编号，老人编号，老人姓名信息模糊查询健康计划信息")
	@GetMapping(value = "/find")
	public ResultBean find(Integer rid,Integer aid,String aname) {
		List<Healthrecord> healthrecords = healthrecordService.findByRidAidAname(rid, aid, aname);
		System.out.println("请求所有信息为："+healthrecords);
		ResultBean r=new ResultBean(200,true,"组合模糊查询成功",healthrecords);
		return r;
	}
	
	/**
	 * 增加健康档案
	 * */
	@ApiOperation(value = "增加健康档案")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Healthrecord healthrecord,BindingResult bindingResult)  { 
		ResultBean r=null;
		if(bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for(FieldError f:bindingResult.getFieldErrors()) {
				msg.append(f.getField()+":"+f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5006, false, msg.toString(), null);
			return r;
		}
		boolean flag=healthrecordService.addHealthrecord(healthrecord.getAid(), 
				healthrecord.getBpressure(), healthrecord.getBfat(), 
				healthrecord.getBsugar(), healthrecord.getHeartrate());
		if(flag) {
			r=new ResultBean(200,true,"新增健康档案成功",null);
		}else {
			r=new ResultBean(5005, false, "新增健康档案失败", null);
		}
		return r;
	}
	
	/**
	 * 修改健康档案
	 */
	@ApiOperation(value = "修改健康档案")
	@PutMapping(value = "/update/{rid}")
	public ResultBean update(@PathVariable("rid") Integer rid, @Validated Healthrecord healthrecord, BindingResult bindingResult) {
		ResultBean r = null;
		if (bindingResult.hasErrors()) {
			// 将无法通过数据校验的信息，合并成一个字符串，返回给前端
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getField() + ":" + f.getDefaultMessage() + "\n");
			}
			r = new ResultBean(5006, false, msg.toString(), null);
			return r;
		}
		boolean flag = healthrecordService.updateHealthrecord(rid, healthrecord.getAid(), 
				healthrecord.getBpressure(), healthrecord.getBfat(), 
				healthrecord.getBsugar(), healthrecord.getHeartrate());
		if (flag) {
			r = new ResultBean(200, true, "修改健康档案成功！", null);
		} else {
			r = new ResultBean(5005, false, "修改健康档案失败！", null);
		}
		return r;
	}

}
