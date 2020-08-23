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
import com.neuedu.care.entity.Duty;
import com.neuedu.care.entity.Medicinerecord;
import com.neuedu.care.service.MedicinerecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * 用药记录控制器MedicinerecordController
 * @author 马梦瑶
 *
 */
@Api(tags = "用药记录控制器")
@RestController
@RequestMapping(value = "medicinerecord")
public class MedicinerecordController {
	@Autowired
	private MedicinerecordService medicinerecordService;

	/**
	 * 显示所有用药记录信息页面
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "显示所有用药记录信息页面：数据存储在care中")
	@GetMapping(value = "/list")
	public ResultBean medicinerecordlist() {
		List<Medicinerecord> medicinerecords = medicinerecordService.selectAll();
		System.out.println("请求所有用药记录信息：" + medicinerecords);
		ResultBean r = new ResultBean(200, true, "查询所有用药记录信息成功！", medicinerecords);
		return r;
	}
	
	/**
	 *  根据药品名称和客户姓名进行多条件模糊查询
	 * @param mname 药品名称
	 * @param aname 客户姓名
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据药品名称和客户姓名进行多条件模糊查询：数据存储在care中")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(paramType = "query", name = "mname", value = "药品名称", dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "aname", value = "客户姓名", dataType = "String"),
	})
	@GetMapping(value = "/find")
	public ResultBean find(String mname, String aname) {
		List<Medicinerecord> medicinerecords = medicinerecordService.findByCondition(mname, aname);
		ResultBean r = new ResultBean(200, true, "根据药品名称和客户姓名进行多条件模糊查询成功！", medicinerecords);
		System.out.println(r);
		return r;
	}
	
	/**
	 * 显示用药记录详细信息
	 * @param mrid 用药记录编号
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "根据用药记录编号查询用药记录信息")
	@ApiImplicitParam(paramType = "path", name = "mrid", value = "用药记录编号", required = true, dataType = "int")
	@ApiResponse(code = 200, message = "弹出模态框，数据存储在care中")
	@GetMapping(value = "/{mrid}")
	public ResultBean 修改实际用药时间(@PathVariable("mrid") Integer mrid) {
		Medicinerecord medicinerecord = medicinerecordService.findByMrid(mrid);
		ResultBean r = new ResultBean(200, true, "查询成功！", medicinerecord);
		return r;
	}
	
	/**
	 * 修改实际用药时间
	 * @param did 值班编号
	 * @param duty 值班信息对象
	 * @param bindingResult 参数校验结果
	 * @return 返回JSON数据
	 */
	@ApiOperation(value = "修改实际用药时间")
	@PutMapping(value = "/update/{mrid}")
	public ResultBean update(@PathVariable("mrid") Integer mrid, @PathVariable("actualtime") String actualtime, BindingResult bindingResult) {
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
		boolean flag = medicinerecordService.update(mrid, actualtime);
		if (flag) {
			r = new ResultBean(200, true, "修改值班信息成功！", null);
		} else {
			r = new ResultBean(5005, false, "修改值班信息失败！", null);
		}
		return r;
	}
}
