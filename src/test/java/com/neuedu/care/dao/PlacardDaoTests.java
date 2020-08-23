package com.neuedu.care.dao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.boot.test.context.SpringBootTest;

import com.neuedu.care.dao.PlacardRepository;
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
	private PlacardRepository placardRepository;
	
	/**
	 * 对selectById()函数进行测试
	 */
//	@Test
//	public void test_selectById() {
//		Integer pid = new Integer(1);
//		Placard placard = placardRepository.findById(pid).get();
//		Assertions.assertEquals(pid.intValue(),placard.getPid().intValue());
//		log.debug("测试通过");
//	}
	
	/**
	 * 对findAll()函数进行测试
	 */
//	@Test
//	void test_findAll() {
//		List<Placard> placards = placardRepository.findAll();
//		for(Placard placard : placards) {
//			log.info(placard.toString());
//		}
//	}
	
	/**
	 * 对findByPidAndPauthorContainingAndPtypeContaining()函数进行测试
	 */
//	@Test
//	void test_findByPidContainingAndPauthorContainingAndPtype() {
//		Integer pid = new Integer(1);
//		String pauthor = "姚季";
//		String ptype = "常驻";
//		List<Placard> placards = placardRepository.findByPidAndPauthorContainingAndPtype(pid, pauthor, ptype);
//		for(Placard placard : placards) {
//			log.info(placard.toString());
//		}
//	}
	
	/**
	 * 对save()函数进行测试
	 * @throws ParseException
	 */
//	@Test
//	void test_save() throws ParseException{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Placard placard = Placard.builder()
//				.pauthor("张强")
//				.ptype("暂时")
//				.ptime(sdf.parse("2020-8-20"))
//				.ptitle("收费通知")
//				.pcontent("交钱")
//				.build();
//		Placard p = placardRepository.save(placard);
//		log.info(p.toString());
//	}
	
	/**
	 * 对delete()函数进行测试
	 */
//	@Test
//	void test_delete() {
//		int line = 0;
//		try {
//			placardRepository.deleteById(2);
//			line = 1;
//		} catch (Exception e) {
//			line = 0;
//		}
//		log.info(line+"删除成功");
//	}
	
	/**
	 * 对updateByPid()函数进行测试
	 * @throws ParseException
	 */
	@Test
	void test_updateByPid() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Integer pid = 1;
		String pauthor = "姚季";
		String ptype = "常驻";
		Date ptime = sdf.parse("2020-08-22");
		String ptitle = "入院须知";
		String pcontent = "保持环境卫生";
		int line = placardRepository.updateByPid(pid, pauthor, ptype, ptime, ptitle, pcontent);
		log.info(line + "更新成功");
	}
}
