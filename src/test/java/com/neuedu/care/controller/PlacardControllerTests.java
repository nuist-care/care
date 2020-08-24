package com.neuedu.care.controller;

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
//import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class PlacardControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * 模拟http请求测试
	 * @throws Exception
	 */
	@Test
	void test() throws Exception{
//		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,"/placard/1"));
//		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
//		MvcResult result = resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
//		log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,"/placard/1").contentType(MediaType.APPLICATION_JSON)).
				andDo(MockMvcResultHandlers.print()).andReturn();
		log.info(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
	}

}
