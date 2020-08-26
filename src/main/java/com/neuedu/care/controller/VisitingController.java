package com.neuedu.care.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.id.insert.IdentifierGeneratingInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.neuedu.care.dao.VistingRepository;
import com.neuedu.care.entity.Client;
import com.neuedu.care.entity.Visiting;
import com.neuedu.care.service.ClientService;
import com.neuedu.care.service.VisitingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;





@Api(tags = "就诊管理控制器")
@RequestMapping(value = "visiting")
@RestController(value = "visiting")
public class VisitingController {
	
	@Autowired
	VisitingService visitingService;
	
	@Autowired
	ClientService clientService;
	
	/**
	 * 显示所有就诊信息*/
	@ApiOperation(value = "显示所有就诊信息")
	@GetMapping(value = "/visitinglist")
	public ResultBean list() {
		List<Visiting> visitings=visitingService.findAllVisiting();
		System.out.println("请求所有部门信息为："+visitings);
		ResultBean r=new ResultBean(200, true, "查询所有信息成功", visitings);
		return r;
	}
	
	/**
	 * 增加就诊信息
	 * */
	@ApiOperation(value = "增加就诊信息")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Visiting visiting,BindingResult bindingResult)  { 
		ResultBean r=null;
		if(bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for(FieldError f:bindingResult.getFieldErrors()) {
				msg.append(f.getField()+":"+f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5006, false, msg.toString(), null);
			return r;
		}
		Client client=clientService.findByid(visiting.getAid());
		if(client==null) {
			r = new ResultBean(5000, false, "老人编号不存在!", null);
			return r;
		}
		
		boolean flag=visitingService.addVisiting(visiting.getAid(),visiting.getVhospital(),visiting.getVtime(),visiting.getVroom(),visiting.getVresult());
		if(flag) {
			r=new ResultBean(200,true,"新增就诊信息成功",null);
		}else {
			r=new ResultBean(5005, false, "新增就诊信息失败", null);
		}
		return r;
	}

	/**
	 * 修改就诊信息
	 */
	@ApiOperation(value = "修改就诊信息")
	@PutMapping(value = "/update/{vid}")
	public ResultBean update(@PathVariable("vid") Integer vid, @Validated Visiting visiting, BindingResult bindingResult) {
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
		Client client=clientService.findByid(visiting.getAid());
		if(client==null) {
			r = new ResultBean(5000, false, "老人编号不存在!", null);
			return r;
		}
		boolean flag = visitingService.updateVisiting(vid, visiting.getAid(), visiting.getVhospital(), visiting.getVtime(), visiting.getVroom(), visiting.getVresult());
		if (flag) {
			r = new ResultBean(200, true, "修改就诊信息成功！", null);
		} else {
			r = new ResultBean(5005, false, "修改就诊信息失败！", null);
		}
		return r;
	}

	/**
	 * 模糊查询
	 */
	@ApiOperation(value = "根据信息模糊查询就诊信息")
	@GetMapping(value = "/find")
	public ResultBean find(Integer vid,Integer aid,String aname) {
		List<Visiting> visitings = visitingService.findByVidAidAname(vid,aid,aname);
		System.out.println("请求所有部门信息为："+visitings);
		ResultBean r=new ResultBean(200,true,"组合模糊查询成功",visitings);
		return r;
	}

	/**
	 * 根据编号查询
	 */
	@ApiOperation(value = "根据就诊编号查询就诊信息")
	@GetMapping(value = "/{vid}")
	public ResultBean findByVid(@PathVariable("vid") Integer vid) {
		Visiting visiting=visitingService.findByVid(vid);
		ResultBean r = new ResultBean(200, true, "查询成功！", visiting);
		System.out.println(visiting);
		return r;
	}
	

}
