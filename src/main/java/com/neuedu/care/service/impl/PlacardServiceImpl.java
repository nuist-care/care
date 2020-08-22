package com.neuedu.care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.PlacardMapper;
import com.neuedu.care.entity.Placard;
import com.neuedu.care.service.PlacardService;

/**
 * 业务逻辑接口实现类PlacardServiceImpl
 * @author ASUS
 *
 */
@Service
public class PlacardServiceImpl implements PlacardService{
	@Autowired
	private PlacardMapper placardMapper;
	
	/**
	 * 新增公告
	 */
	@Override
	public boolean insert(Placard placard) {
		// TODO Auto-generated method stub
		int line = placardMapper.insertSelective(placard);
		return line == 1 ? true : false;
	}

	/**
	 * 修改公告
	 */
	@Override
	public boolean update(Placard placard) {
		// TODO Auto-generated method stub
		int line = placardMapper.updateByPrimaryKsySelective(placard);
		return line == 1 ? true : false;
	}

	/**
	 * 根据编号删除公告
	 */
	@Override
	public boolean delete(Integer pid) {
		// TODO Auto-generated method stub
		int line = placardMapper.deleteByPrimaryKey(pid);
		return line == 1 ? true : false;
	}

	/**
	 * 根据编号查询公告
	 */
	@Override
	public Placard selectByPid(Integer pid) {
		// TODO Auto-generated method stub
		return placardMapper.selectByPrimaryKey(pid);
	}

	/**
	 *查询所有公告信息
	 */
	@Override
	public List<Placard> selectAll() {
		// TODO Auto-generated method stub
		return placardMapper.selectAll();
	}
}
