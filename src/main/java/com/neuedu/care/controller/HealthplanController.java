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
import com.neuedu.care.entity.Healthplan;
import com.neuedu.care.service.HealthplanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "健康计划控制器")
@RestController(value = "healthplan")
@RequestMapping(value = "healthplan")
public class HealthplanController {
	
	@Autowired
	HealthplanService healthplanService;
	
	/**
	 * 显示所有健康信息*/
	@ApiOperation(value = "显示所有健康信息")
	@GetMapping(value = "/healthplanlist")
	public ResultBean list() {
		List<Healthplan> healthplans=healthplanService.findAllHealthplan();
		System.out.println("请求所有部门信息为："+healthplans);
		ResultBean r=new ResultBean(200, true, "查询所有信息成功", healthplans);
		return r;
	}
	
	/**
	 * 根据编号查询
	 */
	@ApiOperation(value = "根据就诊编号查询健康计划信息")
	@GetMapping(value = "/{pid}")
	public ResultBean findByVid(@PathVariable("pid") Integer pid) {
		Healthplan healthplan=healthplanService.findByPid(pid);
		ResultBean r = new ResultBean(200, true, "查询成功！", healthplan);
		System.out.println(healthplan);
		return r;
	}
	
	/**
	 * 模糊查询
	 */
	@ApiOperation(value = "根据信息模糊查询健康计划信息")
	@GetMapping(value = "/find")
	public ResultBean find(Integer pid,Integer aid,String aname) {
		List<Healthplan> healthplans = healthplanService.findByPidAidAname(pid, aid, aname);
		System.out.println("请求所有部门信息为："+healthplans);
		ResultBean r=new ResultBean(200,true,"组合模糊查询成功",healthplans);
		return r;
	}
	
	/**
	 * 增加健康计划信息
	 * */
	@ApiOperation(value = "增加健康计划信息")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Healthplan healthplan,BindingResult bindingResult)  { 
		ResultBean r=null;
		if(bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for(FieldError f:bindingResult.getFieldErrors()) {
				msg.append(f.getField()+":"+f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5006, false, msg.toString(), null);
			return r;
		}
		boolean flag=healthplanService.addHealthplan(healthplan.getAid(), healthplan.getEid(), healthplan.getPhycondition(), healthplan.getPlan(), healthplan.getRecoverydays());
		if(flag) {
			r=new ResultBean(200,true,"新增健康计划成功",null);
		}else {
			r=new ResultBean(5005, false, "新增健康计划失败", null);
		}
		return r;
	}
	
	/**
	 * 修改健康计划信息
	 */
	@ApiOperation(value = "修改健康计划信息")
	@PutMapping(value = "/update/{pid}")
	public ResultBean update(@PathVariable("pid") Integer pid, @Validated Healthplan healthplan, BindingResult bindingResult) {
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
		boolean flag = healthplanService.updateHealthplan(pid, healthplan.getAid(), healthplan.getEid(), healthplan.getPhycondition(), healthplan.getPlan(), healthplan.getRecoverydays());
		if (flag) {
			r = new ResultBean(200, true, "修改健康计划成功！", null);
		} else {
			r = new ResultBean(5005, false, "修改健康计划失败！", null);
		}
		return r;
	}

}
