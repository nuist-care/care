package com.neuedu.care.placard;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.entity.Placard;
import com.neuedu.care.service.PlacardService;

import lombok.extern.slf4j.Slf4j;

/**
 * 公告逻辑层接口测试类PlacardServiceTests
 * @author ASUS
 *
 */
@SpringBootTest
@Slf4j
public class PlacardServiceTests {
	@Autowired
	private PlacardService placardService;
	
	/**
	 * 对selectByPid方法测试
	 */
	@Test
	void test_selectByPid() {
		Integer pid = new Integer(1);
		Placard placard = placardService.selectByPid(pid);
		assertEquals(pid.intValue(),placard.getPid().intValue());
	}

}
