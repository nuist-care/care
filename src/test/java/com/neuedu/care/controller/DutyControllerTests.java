package com.neuedu.care.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import lombok.extern.slf4j.Slf4j;

/**
 * 值班信息控制器测试类
 * @author 马梦瑶
 *
 */
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class DutyControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/duty/dutylist"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
