package com.neuedu.care.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

/**
 * 首页控制器
 * @author ASUS
 *
 */
@ApiIgnore
@Controller
public class IndexController {

	/**
	 * 进入首页
	 * @return
	 */
	@GetMapping(value = {"","index"})
	public String index(){
		return "index";
	}
	
	/**
	 * 内容页
	 */
	@GetMapping(value = "content")
	public String content() {
		return "content";
	}
}
