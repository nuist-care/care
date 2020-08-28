package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.neuedu.care.entity.Checkin;
import com.neuedu.care.service.CheckinService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 入住记录相关操作控制器
 * @author 姚季
 *
 */
@Api(tags = ("入住记录操作控制器"))
@RestController
@RequestMapping(value = "checkin")
public class CheckinController {
	@Autowired
	private CheckinService checkinService;
	
	/**
	 * 显示所有入住记录
	 * @return
	 */
	@ApiOperation(value = " 显示所有入住记录")
	@GetMapping(value = "/list")
	public ResultBean list(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
			@RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum-1, 5);
		Page<Checkin> checkins = checkinService.findAll(pageable);
		return new ResultBean(200,true,"显示所有入住信息成功",checkins);
	}
	
	/**
	 * 根据入住记录编号客户编号和客户姓名查询入住记录
	 * @param iid
	 * @param aid
	 * @param aname
	 * @return
	 */
	@ApiOperation(value = "根据入住记录编号客户编号和客户姓名查询入住记录")
	@GetMapping(value = "/find")
	public ResultBean find(Integer iid,Integer aid,String aname) {
		boolean falg = false;
		if (aname == "") {
			aname = "不存在";
			falg = true;
		}
		if (iid == null && aid == null && falg) {
			aname = "";
		}
		List<Checkin> checkins = checkinService.findByCondition(iid, aid, aname);
		if (checkins != null) {
			return  new ResultBean(200,true,"查询所有入住信息成功",checkins);
		}else {
			return  new ResultBean(200,true,"查询结果为空",null);
		}
	}
	
	/**
	 * 删除一条入住记录
	 * @param iid
	 * @return
	 */
	@ApiOperation(value = " 删除一条入住记录")
	@DeleteMapping(value = "/delete/{iid}")
	public ResultBean delete(@PathVariable("iid")Integer iid) {
		int line = checkinService.delete(iid);
		ResultBean r = null;
		if (line == 1) {
			r = new ResultBean(200,true,"删除入住记录成功",null);
		}else if (line == 2) {
			r = new ResultBean(200,true,"没有这条入住记录",null);
		}else {
			r = new ResultBean(500,false,"删除入住记录失败",null);
		}
		return r;
	}
	
	/**
	 * 根据编号查询入住记录
	 * @param iid
	 * @return
	 */
	@ApiOperation(value = "根据编号查询入住记录")
	@GetMapping(value = "/{iid}")
	public ResultBean detail(@PathVariable("iid")Integer iid) {
		Checkin checkin = checkinService.findById(iid);
		ResultBean r = new ResultBean(200,true,"查询成功。。。",checkin);
		return r;
	}
	
	/**
	 * 更新入住记录
	 * @param iid
	 * @param checkin
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "更新入住记录")
	@PutMapping(value = "/update/{iid}")
	public ResultBean update(@PathVariable("iid")String iid,@Validated Checkin checkin,BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5004,false,msg.toString(),null);
			return r;
		}
		int line = checkinService.update(checkin.getIid(),checkin.getIntime(),checkin.getOuttime());
		if (line == 1) {
			r = new ResultBean(200,true,"修改入住表信息成功",null);
		}else if (line == 2) {
			r = new ResultBean(500,false,"此用户编号不存在，无法更新记录",null);
		}else {
			r = new ResultBean(500,false,"修改入住表信息失败",null);
		}
		return r;
	}
	
	/**
	 * 新增入住记录
	 * @param checkin
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增入住记录")
	@PostMapping(value = "/insert")
	public ResultBean insert(Checkin checkin) {
		ResultBean r = new ResultBean();
		String msg= "";
		if (checkin.getAname() == "") 
			msg+="姓名不能为空"+"\n";		
		if (checkin.getAsex() == "") 
			msg+="性别不能为空"+"\n";		
		if (checkin.getAage() == null) 
			msg+="年龄不能为空"+"\n";
		if (checkin.getAIDnumber() == "") 
			msg+="身份证号码不能为空"+"\n";
		if (checkin.getAIDnumber().length() != 18) 
			msg+="身份证号码长度错误"+"\n";
		if (checkin.getAtelephone() == "") 
			msg+="电话号码不能为空"+"\n";
		if (checkin.getAtelephone().length() != 11) 
			msg+="电话号码长度错误"+"\n";
		if (msg != "") {
			r = new ResultBean(5004,false,msg,null);
			return r;
		}
		int line = checkinService.insert(checkin.getIntime(), checkin.getOuttime(), checkin.getAname(), checkin.getAsex(),checkin.getAage(), 
				checkin.getAIDnumber(), checkin.getAtelephone());
		if (line == 1) {
			r = new ResultBean(200,true,"新增入住表成功",null);
		}else if (line == 2) {
			r = new ResultBean(500,false,"此用户编号不存在，无法新增记录",null);
		}else {
			r = new ResultBean(500,false,"新增入住表失败",null);
		}
		return r;
	}
}
