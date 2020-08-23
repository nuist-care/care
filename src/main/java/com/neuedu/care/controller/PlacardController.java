package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Placard;
import com.neuedu.care.service.PlacardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 公告控制器
 * @author ASUS
 *
 */
@RestController
@Api(tags = "公告控制器")
@RequestMapping(value = "placard")
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
	@ResponseBody
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
	@ResponseBody
    public ResultBean insert(@Validated Placard placard,BindingResult bindingResult){
  	ResultBean r = new ResultBean();
  	if (bindingResult.hasErrors()) {
  		StringBuffer msg = new StringBuffer();
  		for (FieldError f:bindingResult.getFieldErrors()) {
				msg.append(f.getField() + ":" + f.getDefaultMessage() + "\n");
			}
  		    r = new ResultBean(500,false,msg.toString(),null);
  		    return r;
		}
     	Placard p= placardService.insert(placard);
		if (p != null) {
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
//    @ApiImplicitParam(paramType="path",name="pid",value = "编号",required = true,dataType = "int")
//    @ApiResponse(code = 200,message = "返回placard_update.html页面")
    @GetMapping(value = "/{pid}")
	@ResponseBody
    public ResultBean detail(@PathVariable("pid")Integer pid) {
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
	@PutMapping(value = "/update/{pid}")
	@ResponseBody
    public ResultBean update(@PathVariable("pid")Integer pid,@Validated Placard placard,BindingResult bindingResult){
  	ResultBean r = new ResultBean();
  	if (bindingResult.hasErrors()) {
  		StringBuffer msg = new StringBuffer();
  		for (FieldError f:bindingResult.getFieldErrors()) {
				msg.append(f.getField() + ":" + f.getDefaultMessage() + "\n");
			}
  		    r = new ResultBean(500,false,msg.toString(),null);
  		    return r;
		}
  	   int line = placardService.update(placard.getPid(),placard.getPauthor(),
  			   placard.getPtype(),placard.getPtime(),placard.getPtitle(),placard.getPcontent());
		if (line == 1) {
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
	@DeleteMapping(value = "/delete/{pid}")
	@ResponseBody
    public ResultBean delete(@PathVariable("pid")Integer pid) {
   	int line = placardService.delete(pid);
   	ResultBean r = null;
   	if (line == 1) {
			r = new ResultBean(200,true,"删除公告成功",null);
		}else {
			r = new ResultBean(500,false,"删除公告失败",null);
		}
   	return r;
	}
	 
	 /**
	  * 编号，作者，类型多条件组合查询公告信息
	  * @param pid
	  * @param pauthor
	  * @param ptype
	  * @return
	  */
	 @ApiOperation(value="根据部门编号，作者，类型组合模糊查询")
//	 @ApiImplicitParams(value= {
//	    @ApiImplicitParam(paramType = "query",name = "pid",value = "编号",dataType = "String"),
//	    @ApiImplicitParam(paramType = "query",name = "pauthor",value = "作者",dataType = "String"),
//	    @ApiImplicitParam(paramType = "query",name = "ptype",value = "类型",dataType = "String")
//	 })
	 @ResponseBody
	 @GetMapping(value = "/find")
	 public ResultBean find(Integer pid,String pauthor,String ptype) {
	 	List<Placard> placards = placardService.findByCondition(pid, pauthor, ptype);
	  	ResultBean r = new ResultBean(200, true, "组合模糊查询成功", placards);
	   	return r;
     }
}
