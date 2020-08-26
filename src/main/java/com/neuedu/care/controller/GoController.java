package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.neuedu.care.entity.Go;
import com.neuedu.care.service.GoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = ("外出记息操作控制器"))
@RestController
@RequestMapping(value = "go")
public class GoController {
	@Autowired
	private GoService goService;
	
	/**
	 * 显示所有外出记录
	 * @return
	 */
	@ApiOperation(value = " 显示所有外出记录")
	@GetMapping(value = "/list")
	public ResultBean list() {
		List<Go> gos = goService.findAll();
		return new ResultBean(200,true,"显示所有客户信息成功",gos);
	}

	/**
	 * 根据外出记录编号客户编号和审批人查询外出记录
	 * @param gid
	 * @param aid
	 * @param approver
	 * @return
	 */
	@ApiOperation(value = "根据外出记录编号客户编号和审批人查询外出记录")
	@GetMapping(value = "/find")
	public ResultBean find(Integer gid,Integer aid,@RequestParam(defaultValue = "不存在")String approver) {
		System.out.println(approver);
		List<Go> gos= goService.findByCondition(gid, aid, approver);
		if (gos != null) {
			return  new ResultBean(200,true,"查询所有客户信息成功",gos);
		}else {
			return  new ResultBean(200,true,"查询结果为空",null);
		}
	}
	
	/**
	 * 删除外出记录
	 * @param gid
	 * @return
	 */
	@ApiOperation(value = "删除外出记录")
	@DeleteMapping(value = "/delete/{gid}")
	public ResultBean delete(@PathVariable("gid")Integer gid) {
		int line = goService.delete(gid);
		ResultBean r = null;
		if (line == 1) {
			r = new ResultBean(200,true,"删除外出记录成功",null);
		}else if (line == 2) {
			r = new ResultBean(200,true,"没有这条外出记录",null);
		}else {
			r = new ResultBean(500,false,"删除外出记录失败",null);
		}
		return r;
	}
	
	/**
	 * 根据编号查询外出记录
	 * @param gid
	 * @return
	 */
	@ApiOperation(value = "根据编号查询外出记录")
	@GetMapping(value = "/{gid}")
	public ResultBean detail(@PathVariable("gid")Integer gid) {
		Go go = goService.findByid(gid);
		ResultBean r = new ResultBean(200,true,"查询成功。。。",go);
		return r;
	}
	
	/**
	 * 更新外出记录
	 * @param gid
	 * @param go
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "更新外出记录")
	@PutMapping(value = "/update/{gid}")
	public ResultBean update(@PathVariable("gid")String gid,@Validated Go go,BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5004,false,msg.toString(),null);
			return r;
		}
		int line = goService.update(go.getGid(), go.getAid(), go.getGoreason(), go.getGotime(), go.getApplytime(), go.getEscort(), go.getApprover(), go.getApprovalstatus());
		if (line == 1) {
			r = new ResultBean(200,true,"修改外出表信息成功",null);
		}else if (line == 2) {
			r = new ResultBean(500,false,"此用户编号不存在，无法更新记录",null);
		}else {
			r = new ResultBean(500,false,"修改外出表信息失败",null);
		}
		return r;
	}
	
	/**
	 * 新增外出记录
	 * @param go
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增外出记录")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Go go,BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5004,false,msg.toString(),null);
			return r;
		}
		int line = goService.save(go.getAid(), go.getGoreason(), go.getGotime(), go.getApplytime(), go.getEscort(),go.getApprover(), go.getApprovalstatus());
		if (line == 1) {
			r = new ResultBean(200,true,"新增外出表成功",null);
		}else if (line == 2) {
			r = new ResultBean(500,false,"此用户编号不存在，无法新增记录",null);
		}else {
			r = new ResultBean(500,false,"新增外出表失败",null);
		}
		return r;
	}
}
