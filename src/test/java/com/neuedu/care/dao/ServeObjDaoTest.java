package com.neuedu.care.dao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.dao.ServeObjRepository;
import com.neuedu.care.entity.ServeObj;

import lombok.extern.slf4j.Slf4j;

/**
 * 服务对象接口测试类
 * @author ASUS
 *
 */
@SpringBootTest
@Slf4j
public class ServeObjDaoTest {

	@Autowired
	private ServeObjRepository serveObjRepository;
	
	/**
	 * 对findByEid()函数进行测试
	 */
	@Test
	public void test_findByEid() throws ParseException{
		Integer eid = new Integer(1);
		List<ServeObj> serveObjs = serveObjRepository.findByEid(eid);
		for(ServeObj serveObj : serveObjs) {
			log.info(serveObj.toString());
		}
	}
}
