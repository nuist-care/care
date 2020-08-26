package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Drug;
import com.neuedu.care.entity.Healthplan;
import com.neuedu.care.entity.Medicine;
import com.neuedu.care.entity.Medicinerecord;
import com.neuedu.care.service.MedicineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "医嘱控制器")
@RestController(value = "medicine")
@RequestMapping(value = "medicine")
public class MedicineController {
	@Autowired
	MedicineService medicineService;
	
	/**
	 * 根据药名，老人名模糊查询
	 */
	@ApiOperation(value = "根据药名，老人名模糊查询医嘱")
	@GetMapping(value = "/find")
	public ResultBean find(String mname,String aname) {
		List<Medicine> medicines = medicineService.findByMnameAname(mname, aname);
		System.out.println("请求所有部门信息为："+medicines);
		ResultBean r=new ResultBean(200,true,"组合模糊查询成功",medicines);
		return r;
	}
	
	/**
	 * 根据医嘱编号查询
	 */
	@ApiOperation(value = "根据医嘱编号查询医嘱")
	@GetMapping(value = "/{pid}")
	public ResultBean findByMid(@PathVariable("mid") Integer mid) {
		Medicine medicine=medicineService.findByMid(mid);
		ResultBean r = new ResultBean(200, true, "查询成功！", medicine);
		System.out.println(medicine);
		return r;
	}
	
	/**
	 * 增加医嘱
	 * */
	@ApiOperation(value = "增加医嘱")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Medicine medicine,@Validated Medicinerecord medicinerecord,BindingResult bindingResult)  { 
		ResultBean r=null;
		if(bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for(FieldError f:bindingResult.getFieldErrors()) {
				msg.append(f.getField()+":"+f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5006, false, msg.toString(), null);
			return r;
		}
		boolean flag=medicineService.addMedicine(medicine.getAname(), medicine.getMsize(), medicine.getPrescribedtime());
		Drug drug=medicineService.findNewMedicine();
//		boolean flag2=medicineService.addMedicinerecord(medicinerecord.getAid(), drug.getMid());
		if(flag) {
			r=new ResultBean(200,true,"新增健康计划成功",null);
		}else {
			r=new ResultBean(5005, false, "新增健康计划失败", null);
		}
		return r;
	}

}
