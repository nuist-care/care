package com.neuedu.care.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


import lombok.extern.slf4j.Slf4j;
/**
 * 登录控制类LoginController测试类
 * @author 姚季
 *
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	/**
	 * 测试登录checklogin
	 * @throws Exception
	 */
	@Test
	void test_checklogin() throws Exception {
		String json= "{\"eid\":\"10000\",\"password\":\"123456\"}";
		
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders
						.request(HttpMethod.POST, "/checklogin")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
	}

}
