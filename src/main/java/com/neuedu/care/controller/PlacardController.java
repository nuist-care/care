package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Placard;
import com.neuedu.care.service.PlacardService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 公告控制器
 * @author ASUS
 *
 */
@Controller
public class PlacardController {
	@Autowired
	private PlacardService placardService;
	
	/**
	 * 显示所有公告信息页面
	 * @param model
	 * @return
	 */
	@ApiOperation(value = "显示所有公告信息页面")
	@GetMapping(value = "/list")
	public ResultBean list() {
		List<Placard> placards = placardService.selectAll();
		System.out.println("请求所有公告信息：" + placards);
		ResultBean r = new ResultBean(200,true,"查询所有公告成功",placards);
		return r;
	}
	
	/**
	 * 新增公告
	 * @param placard
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(value = "/insert")
  public ResultBean insert(@Validated Placard placard,BindingResult bindingResult){
  	ResultBean r = null;
  	if (bindingResult.hasErrors()) {
  		//将无法通过数据校验的信息，合并为一个字符串，返回给前端
  		StringBuffer msg = new StringBuffer();
  		for (FieldError f:bindingResult.getFieldErrors()) {
				msg.append(f.getField() + ":" + f.getDefaultMessage() + "\n");
			}
  		r = new ResultBean(500,false,msg.toString(),null);
  		return r;
		}
  	Integer pid = null;
  	boolean flag = placardService.insert(placard);
		if (flag) {
			r = new ResultBean(200,true,"新增公告成功~~\n新增公告编号为" + placard.getPid() ,null);
		}else {
			r = new ResultBean(500,false,"新增公告失败",null);
		}
  	return r;
	}
	
	/**
	 * 根据编号查询公告信息
	 * @param pid
	 * @return
	 */
	@ApiOperation(value="根据编号查询公告信息")
    @ApiImplicitParam(paramType="path",name="pid",value = "编号",required = true,dataType = "int")
    @ApiResponse(code = 200,message = "返回placard_update.html页面")
    @GetMapping(value = "/{pid}")
    public ResultBean detail1(@PathVariable("pid")Integer pid) {
		Placard placard = placardService.selectByPid(pid);
		ResultBean r = new ResultBean(200,true,"查询成功",placard);
		return r;
	}
	
	/**
	 * 修改公告信息
	 * @param pid
	 * @param placard
	 * @param bindingResult
	 * @return
	 */
	@PutMapping(value = "/update/{id}")
  public ResultBean update(@PathVariable("pid")Integer pid,@Validated Placard placard,BindingResult bindingResult){
  	ResultBean r = null;
  	if (bindingResult.hasErrors()) {
  		StringBuffer msg = new StringBuffer();
  		for (FieldError f:bindingResult.getFieldErrors()) {
				msg.append(f.getField() + ":" + f.getDefaultMessage() + "\n");
			}
  		r = new ResultBean(500,false,msg.toString(),null);
  		return r;
		}
  	boolean flag = placardService.update(placard);
		if (flag) {
			r = new ResultBean(200,true,"修改公告成功",null);
		}else {
			r = new ResultBean(500,false,"修改公告失败",null);
		}
  	return r;
	}
	
	/**
	 * 删除公告信息
	 * @param pid
	 * @return
	 */
	 @DeleteMapping(value = "/delete/{id}")
   public ResultBean delete(@PathVariable("pid")Integer pid) {
   	boolean flag = placardService.delete(pid);
   	ResultBean r = null;
   	if (flag) {
			r = new ResultBean(200,true,"删除公告成功",null);
		}else {
			r = new ResultBean(500,false,"删除公告失败",null);
		}
   	return r;
	}
}
