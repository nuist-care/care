package com.neuedu.care.placard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.dao.PlacardMapper;
import com.neuedu.care.entity.Placard;

import lombok.extern.slf4j.Slf4j;

/**
 * 公告接口测试类
 * @author ASUS
 *
 */
@SpringBootTest
@Slf4j
public class PlacardDaoTests {
	@Autowired
	private PlacardMapper placardMapper;
	
	/**
	 * 对根据编号搜索公告方法进行测试
	 */
	@Test
	public void test_selectByPrimaryKey() {
		Integer pid = new Integer(1);
		Placard placard = placardMapper.selectByPrimaryKey(pid);
		Assertions.assertEquals(pid.intValue(),placard.getPid().intValue());
		log.debug("测试通过");
	}
}
