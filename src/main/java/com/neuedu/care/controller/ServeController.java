package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Serve;
import com.neuedu.care.service.ServeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 设置服务对象控制器ServeController
 * 
 * @author 马梦瑶
 *
 */
@Api(tags = "设置服务对象控制器")
@RestController
@RequestMapping(value = "serve")
public class ServeController {
	@Autowired
	private ServeService serveService;
	
	/**
	 * 显示所有服务信息页面
	 * 
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
	 * 
	 * @param ename 员工姓名
	 * @param aname 客户姓名
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据员工姓名和客户姓名进行多条件模糊查询：数据存储在care中")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "ename", value = "员工姓名", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "aname", value = "客户姓名", dataType = "String"), })
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

	/**
	 * 新增服务对象信息
	 * @param serve         服务对象信息对象
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "新增服务对象信息")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Serve serve) {
		ResultBean r = null;
		// 数据验证
		if (null == serve.getEid()) {
			return r = new ResultBean(5006, false, "员工编号不能为空！", null);
		}
		if (serve.getEid() < 10000) {
			return r = new ResultBean(5006, false, "员工编号不合法！", null);
		}
		if (null == serve.getAid()) {
			return r = new ResultBean(5006, false, "客户编号不能为空！", null);
		}
		// 不能重复记录（用户编号和客户编号同时相同则返回错误信息）
		Serve s = serveService.findByEidAndAid(serve.getEid(), serve.getAid());
		System.out.println(s);
		if (null != s) {
			return r = new ResultBean(5006, false, "此员工与此客户已存在服务关系！", null);
		}
		Serve flag = serveService.insert(serve);
		if (null != flag) {
			r = new ResultBean(200, true, "新增服务关系成功，记录编号为:" + flag.getServeid(), null);
		} else {
			r = new ResultBean(500, false, "新增服务关系失败！", null);
		}
		return r;
	}
}
