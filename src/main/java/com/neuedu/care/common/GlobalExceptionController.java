package com.neuedu.care.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.care.bean.ResultBean;


@ControllerAdvice(basePackages = {"com.neuedu.care","com.neuedu.care.controller","com.neuedu.care.service.impl","com.neuedu.care.dao"})
public class GlobalExceptionController {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResultBean n(RuntimeException ex) {
		return new ResultBean(5005,false,ex.getMessage(),ex);
	}
}
