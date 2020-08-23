//package com.neuedu.care.intercepter;
//
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import com.alibaba.fastjson.JSON;
//import com.neuedu.care.bean.ResultBean;
//import com.neuedu.care.config.Audience;
//import com.neuedu.care.util.JWTTokenUtil;
//
//
//
//@Component
//public class LoginIntercepter implements HandlerInterceptor{
//	@Autowired
//	private Audience audience;
//	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
//			return true;
//		}
//		final String token = request.getHeader(JWTTokenUtil.AUTH_HEAD_KEY);	
//		if (token != null && !JWTTokenUtil.isExpiration(token,audience.getBase64Secret())) {
//			return true;
//		}
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("application/json;charset=utf-8");
//		ResultBean r = new ResultBean(5009,false,"登陆已过期，请重新登录","");
//		PrintWriter writer = response.getWriter();
//		writer.write(JSON.toJSONString(r));
//		return false;
//	}
//	
//}
