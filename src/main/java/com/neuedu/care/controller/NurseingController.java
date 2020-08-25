package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Client;
import com.neuedu.care.entity.Nurseing;
import com.neuedu.care.service.ClientService;
import com.neuedu.care.service.NurseingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 护理记录控制器NurseingController
 * 
 * @author 马梦瑶
 *
 */
@Api(tags = "护理记录控制器")
@RestController
@RequestMapping(value = "nurseing")
public class NurseingController {
	@Autowired
	private NurseingService nurseingService;

	@Autowired
	private ClientService clientService;

	/**
	 * 显示所有护理记录信息页面
	 * 
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "显示所有护理记录信息页面：数据存储在care中")
	@GetMapping(value = "/list")
	public ResultBean nursinglist() {
		List<Nurseing> nurseings = nurseingService.selectAll();
		System.out.println("请求所有护理记录信息：" + nurseings);
		ResultBean r = new ResultBean(200, true, "查询所有护理记录信息成功！", nurseings);
		return r;
	}

	/**
	 * 根据客户姓名进行模糊查询
	 * 
	 * @param aname 客户姓名
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据客户姓名进行模糊查询：数据存储在care中")
	@ApiImplicitParam(paramType = "query", name = "aname", value = "客户姓名", dataType = "String")
	@GetMapping(value = "/find")
	public ResultBean find(String aname) {
		List<Nurseing> nurseings = nurseingService.findByCondition(aname);
		ResultBean r = new ResultBean(200, true, "查询成功！", nurseings);
		System.out.println(r);
		return r;
	}

	/**
	 * 新增护理信息
	 * 
	 * @param nurseing      护理信息对象
	 * @param bindingResult 数据验证返回结果
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "新增护理信息")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Nurseing nurseing, BindingResult bindingResult) {
		ResultBean r = null;
//		System.out.println("对象信息：" + nurseing);
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getDefaultMessage() + "\n");
			}
			r = new ResultBean(5004, false, msg.toString(), null);
			return r;
		}
		// 验证客户是否存在于客户表中
		Client client = clientService.findByAname(nurseing.getAname());
		if (null == client) {
			return r = new ResultBean(5006, false, "该客户不存在！请重新输入！", null);
		}
		// 不能重复记录（客户姓名和护理时间同时相同则返回错误信息）
		Nurseing n = nurseingService.findByAnameAndCtime(nurseing.getAname(), nurseing.getCtime());
		if (null != n) {
			return r = new ResultBean(5006, false, "该记录已存在！如需修改，请使用修改功能！", null);
		}
		Nurseing flag = nurseingService.insert(nurseing);
		if (null != flag) {
			r = new ResultBean(200, true, "新增护理记录成功，记录编号为:" + flag.getCid(), null);
		} else {
			r = new ResultBean(500, false, "新增护理记录失败！", null);
		}
		return r;
	}
	
	/**
	 * 显示护理记录详细信息
	 * 
	 * @param cid 护理记录编号
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据护理记录编号查询护理记录信息")
	@ApiImplicitParam(paramType = "path", name = "cid", value = "护理记录编号", required = true, dataType = "int")
	@ApiResponse(code = 200, message = "弹出模态框，数据存储在care中")
	@GetMapping(value = "/{cid}")
	public ResultBean detail(@PathVariable("cid") Integer cid) {
		Nurseing nurseing = nurseingService.findByCid(cid);
		ResultBean r = new ResultBean(200, true, "查询成功！", nurseing);
		return r;
	}
	
	
	@ApiOperation(value = "修改护理信息")
	@PutMapping(value = "/update/{cid}/{ccontent}")
	public ResultBean update(@PathVariable("cid") Integer cid, @Validated String ccontent) {
		ResultBean r = null;
		boolean flag = nurseingService.update(cid,ccontent);
		if (flag) {
			r = new ResultBean(200, true, "修改成功！", null);
		} else {
			r = new ResultBean(500, false, "修改失败！", null);
		}
		return r;
	}

}
