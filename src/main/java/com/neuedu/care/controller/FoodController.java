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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.entity.Food;
import com.neuedu.care.service.FoodService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 膳食控制器
 * 
 * @author ASUS
 *
 */
@RestController
@Api(tags = "膳食控制器")
@RequestMapping(value = "food")
public class FoodController {

	@Autowired
	private FoodService foodService;

	/**
	 * 展示所有膳食信息
	 * 
	 * @return
	 */
	@ApiIgnore(value = "展示所有膳食信息")
	@GetMapping(value = "/list")
	public ResultBean list() {
		List<Food> foods = foodService.selectAll();
		System.out.println("请求所有膳食信息：" + foods);
		ResultBean r = new ResultBean(200, true, "查询所有膳食成功", foods);
		return r;
	}

	/**
	 * 新增膳食
	 * 
	 * @param food
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(value = "/insert")
	public ResultBean insert(@Validated Food food, BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getDefaultMessage() + "\n");
			}
			r = new ResultBean(500, false, msg.toString(), null);
			return r;
		}
		Food f = foodService.insert(food);
		if (f != null) {
			r = new ResultBean(200, true, "新增膳食成功~~\n新增膳食编号为" + food.getFid(), null);
		} else {
			r = new ResultBean(500, false, "新增膳食失败", null);
		}
		return r;
	}

	/**
	 * 根据编号查询膳食信息
	 * 
	 * @param pid
	 * @return
	 */
	@ApiOperation(value = "根据编号查询膳食信息")
	@GetMapping(value = "/{fid}")
	public ResultBean detail(@PathVariable("fid") Integer fid) {
		Food food = foodService.selectByFid(fid);
		ResultBean r = new ResultBean(200, true, "查询成功", food);
		return r;
	}

	/**
	 * 修改膳食信息
	 * 
	 * @param fid
	 * @param food
	 * @param bindingResult
	 * @return
	 */
	@PutMapping(value = "/update/{fid}")
	public ResultBean update(@PathVariable("fid") Integer fid, @Validated Food food, BindingResult bindingResult) {
		ResultBean r = new ResultBean();
		if (bindingResult.hasErrors()) {
			StringBuffer msg = new StringBuffer();
			for (FieldError f : bindingResult.getFieldErrors()) {
				msg.append(f.getDefaultMessage() + "\n");
			}
			r = new ResultBean(500, false, msg.toString(), null);
			return r;
		}
		int line = foodService.update(food.getFid(), food.getAid(), food.getFtime(), food.getFtype(),
				food.getFcontent());
		if (line == 1) {
			r = new ResultBean(200, true, "修改膳食成功", null);
		} else {
			r = new ResultBean(500, false, "修改膳食失败", null);
		}
		return r;
	}

	/**
	 * 删除膳食信息
	 * 
	 * @param fid
	 * @return
	 */
	@DeleteMapping(value = "/delete/{fid}")
	public ResultBean delete(@PathVariable("fid") Integer fid) {
		int line = foodService.delete(fid);
		ResultBean r = null;
		if (line == 1) {
			r = new ResultBean(200, true, "删除膳食成功", null);
		} else {
			r = new ResultBean(500, false, "删除膳食失败", null);
		}
		return r;
	}

	/**
	 * 根据客户编号查询膳食信息
	 * 
	 * @param aid
	 * @return
	 */
	@ApiOperation(value = "根据客户编号查询膳食信息")
	@GetMapping(value = "/find")
	public ResultBean find(Integer aid) {
		List<Food> foods = foodService.findByAid(aid);
		ResultBean r = new ResultBean(200, true, "组合模糊查询成功", foods);
		return r;
	}

	/**
	 * 膳食日历
	 * 
	 * @return
	 */
	@ApiIgnore(value = "膳食日历")
	@GetMapping(value = "/show")
	public ResultBean show() {
		List<Food> foods = foodService.selectAll2();
		System.out.println("请求所有膳食信息：" + foods);
		ResultBean r = new ResultBean(200, true, "查询所有膳食成功", foods);
		return r;
	}
}
