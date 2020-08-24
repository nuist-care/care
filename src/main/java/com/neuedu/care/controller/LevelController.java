package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Level;
import com.neuedu.care.service.LevelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 护理级别信息控制器LevelController
 * @author 马梦瑶
 *
 */
@Api(tags = "护理级别信息控制器")
@RestController
@RequestMapping(value = "level")
public class LevelController {
	@Autowired
	private LevelService levelService;
	
	/**
	 * 显示所有护理级别信息页面
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "显示所有护理级别信息页面：数据存储在care中")
	@GetMapping(value = "/list")
	public ResultBean levellist() {
		List<Level> levels = levelService.selectAll();
		System.out.println("请求所有护理级别信息：" + levels);
		ResultBean r = new ResultBean(200, true, "查询所有护理级别信息成功！", levels);
		return r;
	}
	
	/**
	 * 根据客户姓名进行模糊查询
	 * @param aname 客户姓名
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据客户姓名进行模糊查询：数据存储在care中")
	@ApiImplicitParam(paramType = "query", name = "aname", value = "客户姓名", dataType = "String")
	@GetMapping(value = "/find")
	public ResultBean find(String aname) {
		List<Level> levels = levelService.findByCondition(aname);
		ResultBean r = new ResultBean(200, true, "查询成功！", levels);
		System.out.println(r);
		return r;
	}
	
	/**
	 * 显示护理级别详细信息
	 * @param aid 客户编号
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据客户编号查询护理级别信息")
	@ApiImplicitParam(paramType = "path", name = "aid", value = "客户编号", required = true, dataType = "int")
	@ApiResponse(code = 200, message = "弹出模态框，数据存储在care中")
	@GetMapping(value = "/{aid}")
	public ResultBean detail(@PathVariable("aid") Integer aid) {
		Level level = levelService.findByAid(aid);
		ResultBean r = new ResultBean(200, true, "查询成功！", level);
		return r;
	}
	
	/**
	 * 修改护理级别
	 * @param aid 客户编号
	 * @param clevel 护理级别
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "修改护理级别")
	@PutMapping(value = "/update/{aid}/{clevel}")
	public ResultBean update(@PathVariable("aid") Integer aid, @PathVariable("clevel") Integer clevel) {
		ResultBean r = null;
		if (null == aid) {
			r = new ResultBean(5006, false, "客户编号不能为空！", null);
			return r;
		}else if (null == clevel) {
			r = new ResultBean(5006, false, "护理等级不能为空！", null);
			return r;
		} 
		boolean flag = levelService.update(aid, clevel);
		if (flag) {
			r = new ResultBean(200, true, "修改成功！", null);
		} else {
			r = new ResultBean(5005, false, "修改失败！", null);
		}
		return r;
	}
}
