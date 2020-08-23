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
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Duty;
import com.neuedu.care.service.DutyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 值班信息控制器DutyController
 * @author 马梦瑶
 *
 */
@Api(tags = "值班信息控制器")
@RestController
@RequestMapping(value = "duty")
public class DutyController {
	@Autowired
	private DutyService dutyService;
	
	/**
	 * 显示所有值班信息页面
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "显示所有值班信息页面：数据存储在care中")
	@GetMapping(value = "/list")
	public ResultBean dutylist() {
		List<Duty> duties = dutyService.selectAll();
		System.out.println("请求所有值班信息：" + duties);
		ResultBean r = new ResultBean(200, true, "查询所有值班信息成功！", duties);
		return r;
	}
	
	/**
	 *  根据值班时间和值班人员进行多条件模糊查询
	 * @param dtime 值班时间
	 * @param dnurse 值班人员
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据值班时间和值班人员进行多条件模糊查询：数据存储在care中")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "dtime", value = "值班时间", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "dnurse", value = "值班人员", dataType = "String"),
	})
	@GetMapping(value = "/find")
	public ResultBean find(String dtime, String dnurse) {
		List<Duty> duties = dutyService.findByCondition(dtime, dnurse);
		ResultBean r = new ResultBean(200, true, "根据值班时间和值班人员进行多条件模糊查询成功！", duties);
		System.out.println(r);
		return r;
	}
	
	/**
	 * 新增值班信息
	 * @param duty 值班信息对象
	 * @param bindingResult 参数校验结果
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "新增值班信息")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Duty duty, BindingResult bindingResult) {
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
		boolean flag = dutyService.insert(duty);
		if (flag) {
			r = new ResultBean(200, true, "新增值班信息成功！\n新增值班编号为：" + duty.getDid(), null);
		} else {
			r = new ResultBean(5005, false, "新增值班信息失败！", null);
		}
		System.out.println(r);
		return r;
	}
	
	/**
	 * 显示值班详细信息
	 * @param did 值班编号
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据值班编号查询值班信息")
	@ApiImplicitParam(paramType = "path", name = "did", value = "值班编号", required = true, dataType = "int")
	@ApiResponse(code = 200, message = "返回duty_update.html页面，数据存储在care中")
	@GetMapping(value = "/{did}")
	public ResultBean detail(@PathVariable("did") Integer did) {
		Duty duty = dutyService.findByDid(did);
		ResultBean r = new ResultBean(200, true, "查询成功！", duty);
		return r;
	}
	
	/**
	 * 修改值班信息
	 * @param did 值班编号
	 * @param duty 值班信息对象
	 * @param bindingResult 参数校验结果
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "修改值班信息")
	@PutMapping(value = "/update/{did}")
	public ResultBean update(@PathVariable("did") Integer did, @Validated Duty duty, BindingResult bindingResult) {
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
		boolean flag = dutyService.update(did, duty.getDtime(), duty.getDnurse());
		if (flag) {
			r = new ResultBean(200, true, "修改值班信息成功！", null);
		} else {
			r = new ResultBean(5005, false, "修改值班信息失败！", null);
		}
		return r;
	}
	
	/**
	 * 删除值班信息
	 * 
	 * @param did 值班编号
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "删除值班信息")
	@DeleteMapping(value = "/delete/{did}")
	public ResultBean delete(@PathVariable("did") Integer did) {
		boolean flag = dutyService.delete(did);
		ResultBean r = null;
		if (flag) {
			r = new ResultBean(200, true, "删除值班信息成功！", null);
		} else {
			r = new ResultBean(5005, false, "删除值班信息失败！", null);
		}
		return r;
	}
}
