package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.config.Audience;
import com.neuedu.care.entity.Duty;
import com.neuedu.care.entity.Serve;
import com.neuedu.care.service.ServeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 设置服务对象控制器ServeController
 * @author 马梦瑶
 *
 */
@Api(tags = "设置服务对象控制器")
@RestController
@RequestMapping(value = "serve")
public class ServeController {
	@Autowired
	private ServeService serveService;
	
	@Autowired
	private Audience audience;

	/**
	 * 显示所有服务信息页面
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "显示所有服务信息页面：数据存储在care中")
	@GetMapping(value = "/list")
	public ResultBean servelist() {
		List<Serve> serves = serveService.selectAll();
		System.out.println("请求所有服务信息：" + serves);
		ResultBean r = new ResultBean(200, true, "查询所有服务信息成功！", serves);
		return r;
	}

	/**
	 * 根据员工姓名和客户姓名进行多条件模糊查询
	 * @param ename 员工姓名
	 * @param aname 客户姓名
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据员工姓名和客户姓名进行多条件模糊查询：数据存储在care中")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "ename", value = "员工姓名", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "aname", value = "客户姓名", dataType = "String"),
	})
	@GetMapping(value = "/find")
	public ResultBean find(String ename, String aname) {
		List<Serve> serves = serveService.findByEnameContainingAndAnameContaining(ename, aname);
		ResultBean r = new ResultBean(200, true, "根据员工姓名和客户姓名进行多条件模糊查询成功！", serves);
		System.out.println(r);
		return r;
	}
	
	/**
	 * 删除服务信息
	 * 
	 * @param serveid 服务编号
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "删除服务信息")
	@DeleteMapping(value = "/delete/{serveid}")
	public ResultBean delete(@PathVariable("serveid") Integer serveid) {
		boolean flag = serveService.delete(serveid);
		ResultBean r = null;
		if (flag) {
			r = new ResultBean(200, true, "删除服务信息成功！", null);
		} else {
			r = new ResultBean(5005, false, "删除服务信息失败！", null);
		}
		return r;
	}
}
