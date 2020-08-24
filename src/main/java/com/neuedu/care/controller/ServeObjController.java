package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.ServeObj;
import com.neuedu.care.service.ServeObjService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 查看服务对象控制器
 * @author ASUS
 *
 */
@RestController
@Api(tags = "查看服务对象控制器")
@RequestMapping(value = "serveObj")
public class ServeObjController {
	@Autowired
	private ServeObjService serveObjService;
	
	/**
	 * 根据护工编号查询服务对象信息
	 */
	@ApiOperation(value="根据护工编号查询服务对象信息")
	@ResponseBody
	@GetMapping(value = "/{eid}")
	public ResultBean find(@PathVariable("eid")Integer eid) {
		List<ServeObj> serveObjs = serveObjService.findByEid(eid);
		ResultBean r = new ResultBean(200,true,"查询成功",serveObjs);
		return r;
	}
}
