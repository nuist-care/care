package com.neuedu.care.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.dao.FoodRepository;
import com.neuedu.care.entity.Food;
import com.neuedu.care.service.FoodService;

/**
 * 业务逻辑接口实现类 FoodServiceImpl
 * @author ASUS
 *
 */
@Service
@Transactional
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodRepository foodRepository;

	/**
	 * 新增膳食
	 */
	@Override
	public Food insert(Food food) {
		Food f = foodRepository.save(food);
		return f;
	}

	/**
	 * 根据膳食编号修改膳食信息
	 */
	@Override
	public int update(Integer fid, Integer aid, Date ftime, String ftype, String fcontent) {
		int line = foodRepository.updateByFid(fid, aid, ftime, ftype, fcontent);
		return line;
	}

	/**
	 * 根据膳食编号删除膳食信息
	 */
	@Override
	public int delete(Integer fid) {
		int line = 0;
		try {
			foodRepository.deleteById(fid);
			line = 1;
		} catch (Exception e) {
			line = 0;
		}
		return line;
	}

	/**
	 * 根据膳食编号查询膳食信息
	 */
	@Override
	public Food selectByFid(Integer fid) {
		Food food = foodRepository.findByFid(fid);
		return food;
	}

	/**
	 * 查询所有膳食信息
	 */
	@Override
	public List<Food> selectAll() {
		List<Food> foods = foodRepository.findAll();
		return foods;
	}

	/**
	 * 根据客户编号查询膳食信息
	 */
	@Override
	public List<Food> findByAid(Integer aid) {
		List<Food> foods = foodRepository.findByAid(aid);
		return foods;
	}

	/**
	 * 查询所有膳食信息，并按时间排序
	 */
	@Override
	public List<Food> selectAll2() {
		List<Food> foods = foodRepository.findAll2();
		return foods;
	}

	
}
