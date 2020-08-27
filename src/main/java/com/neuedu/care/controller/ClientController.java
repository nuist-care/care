package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Client;
import com.neuedu.care.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 客户相关操作控制器
 * @author 姚季
 *
 */
@Api(tags = "客户信息操作控制器")
@RestController
@RequestMapping(value = "client")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	/**
	 * 显示所有客户信息
	 * @return
	 */
	@ApiOperation(value = "显示所有客户信息")
	@GetMapping(value = "/list")
	public ResultBean list(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
			@RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum-1, 5);
		Page<Client> clients= clientService.findAll(pageable);
		ResultBean r = new ResultBean(200,true,"显示所有客户信息成功",clients);
		return r;
	}
	
	/**
	 * 多条件组合查询客户信息
	 * @param aid
	 * @param aname
	 * @param clevel
	 * @return
	 */
	@ApiOperation(value = "多条件组合查询客户信息")
	@GetMapping(value = "/find")
	public ResultBean find(Integer aid,String aname,Integer clevel) {
		boolean falg = false;
		if (aname == "") {
			aname = "不存在";
			falg = true;
		}
		if (aid == null && clevel == null && falg) {
			aname = "";
		}
		List<Client> clients= clientService.findByCondition(aid, aname, clevel);
		ResultBean r = new ResultBean(200,true,"查询所有客户信息成功",clients);
		return r;
	}
	
	/**
	 * 删除一个员工信息
	 * @param eid
	 * @return
	 */
	@ApiOperation(value = "删除一个员工信息")
	@DeleteMapping(value = "/delete/{aid}")
	public ResultBean delete(@PathVariable("aid")Integer aid) {
		int line = clientService.delete(aid);
		ResultBean r = null;
		if (line == 1) {
			r = new ResultBean(200,true,"删除客户成功",null);
		}else {
			r = new ResultBean(500,false,"删除客户失败",null);
		}
		return r;
	}
	
	/**
	 * 新增员工
	 * @param employee
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增员工")
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Client client,BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getField()+": "+f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5004,false,msg.toString(),null);
			return r;
		}
		Client c = clientService.save(client);
		if (c != null) {
			r = new ResultBean(200,true,"新增客户成功,编号为:"+c.getAid(),null);
		}else {
			r = new ResultBean(500,false,"新增客户失败",null);
		}
		return r;
	}
	
	/**
	 * 显示一个员工信息界面
	 * @param eid
	 * @return
	 */
	@ApiOperation(value = "显示一个员工信息界面")
	@GetMapping(value = "/{aid}")
	public ResultBean detail(@PathVariable("aid")Integer aid) {
		Client client = clientService.findByid(aid);
		ResultBean r = new ResultBean(200,true,"查询成功。。。",client);
		return r;
	}
	
	/**
	 * 更新一个员工信息
	 * @param id
	 * @param employee
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "更新一个员工信息")
	@PutMapping(value = "/update/{aid}")
	public ResultBean update(@PathVariable("aid")String aid,@Validated Client client,BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getDefaultMessage()+"\n");
			}
			r = new ResultBean(5004,false,msg.toString(),null);
			return r;
		}
		int line = clientService.update(client.getAid(), client.getAname(), client.getAsex(), client.getAage(), client.getAIDnumber(),
				client.getAtelephone(), client.getAaddress(), client.getGenetichistory(), 
				client.getConditiondescription(), client.getClevel());
		if (line == 1) {
			r = new ResultBean(200,true,"修改客户信息成功",null);
		}else {
			r = new ResultBean(500,false,"修改客户信息失败",null);
		}
		return r;
	}
}
