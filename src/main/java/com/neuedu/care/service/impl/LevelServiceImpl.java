package com.neuedu.care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.LevelRepository;
import com.neuedu.care.entity.Level;
import com.neuedu.care.service.LevelService;

/**
 * 护理级别信息管理业务逻辑接口LevelService实现类LevelServiceImpl
 * @author 马梦瑶
 *
 */
@Service
public class LevelServiceImpl implements LevelService{
	
	@Autowired
	private LevelRepository levelRepository;

	/**
	 *  根据客户编号修改护理等级
	 */
	@Override
	public boolean update(Integer aid, Integer clevel) {
		// 业务判断：非空属性判断
		if (null == aid || null == clevel) {
			return false;
		}
		// 护理等级范围在1~5之间
		if (clevel < 1 && clevel >5) {
			return false;
		}
		int line = levelRepository.updateLevel(aid, clevel);
		return line == 1 ? true : false;
	}

	/**
	 * 根据客户姓名进行模糊查询
	 */
	@Override
	public List<Level> findByCondition(String aname) {
		// 字符串主动去除空格
		if (null != aname) {
			aname = aname.trim();
			if (aname.length() == 0) {
				aname = "";
			}
		}
		return levelRepository.findByAnameContaining(aname);
	}

	/**
	 * 查询所有护理级别信息
	 */
	@Override
	public List<Level> selectAll() {
		return levelRepository.findAll();
	}

	/**
	 * 根据客户编号查询护理级别信息
	 */
	@Override
	public Level findByAid(Integer aid) {
		// 业务判断：客户编号不能为空且不能少于1
		if (null == aid || aid < 1) {
			aid = null;
		}
		return levelRepository.findByAid(aid);
	}

}
