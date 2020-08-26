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
import com.neuedu.care.entity.Drug;
import com.neuedu.care.entity.Healthplan;
import com.neuedu.care.entity.Medicine;
import com.neuedu.care.entity.Medicinerecord;
import com.neuedu.care.service.ClientService;
import com.neuedu.care.service.MedicineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "医嘱控制器")
@RestController(value = "medicine")
@RequestMapping(value = "medicine")
public class MedicineController {
	@Autowired
	MedicineService medicineService;
	
	@Autowired
	ClientService clientService;
	
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
	@GetMapping(value = "/{mid}")
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
	public ResultBean insert(@Validated Medicine medicine,BindingResult bindingResult)  { 
		ResultBean r=null;
		if(bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for(FieldError f:bindingResult.getFieldErrors()) {
				msg.append(f.getField()+":"+f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5006, false, msg.toString(), null);
			return r;
		}
		boolean flag=medicineService.addMedicine(medicine.getMname(), medicine.getMsize(), medicine.getPrescribedtime());
		System.out.println("flag:"+flag);
		Drug drug=medicineService.findNewMedicine();
		System.out.println(drug.getMid());
		Client client=clientService.findByid(medicine.getAid());
		if(client==null) {
			r = new ResultBean(5000, false, "老人编号不存在!", null);
			return r;
		}
		boolean flag2=medicineService.addMedicinerecord(medicine.getAid(), drug.getMid());
		if(flag2) {
			r=new ResultBean(200,true,"新增医嘱成功",null);
		}else {
			r=new ResultBean(5005, false, "新增医嘱失败", null);
		}
		return r;
	}
	
	
	/**
	 * 修改医嘱
	 */
	@ApiOperation(value = "修改医嘱")
	@PutMapping(value = "/update/{mid}")
	public ResultBean update(@PathVariable("mid") Integer mid, @Validated Medicine medicine, BindingResult bindingResult) {
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
		Client client=clientService.findByid(medicine.getAid());
		if(client==null) {
			r = new ResultBean(5000, false, "老人编号不存在!", null);
			return r;
		}
		boolean flag = medicineService.updateMedicine(mid, medicine.getAid(), medicine.getMname(), medicine.getMsize(), medicine.getPrescribedtime());
		if (flag) {
			r = new ResultBean(200, true, "修改医嘱成功！", null);
		} else {
			r = new ResultBean(5005, false, "修改医嘱失败！", null);
		}
		return r;
	}

}
