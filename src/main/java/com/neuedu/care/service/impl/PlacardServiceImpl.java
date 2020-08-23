package com.neuedu.care.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.dao.PlacardRepository;
import com.neuedu.care.entity.Placard;
import com.neuedu.care.service.PlacardService;

/**
 * 业务逻辑接口实现类PlacardServiceImpl
 * @author ASUS
 *
 */
@Service
@Transactional
public class PlacardServiceImpl implements PlacardService{
	@Autowired
	private PlacardRepository placardRepository;
	
	/**
	 * 新增公告
	 */
	@Override
//	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public Placard insert(Placard placard) {
		Placard p = placardRepository.save(placard);
		return p;
	}

	/**
	 * 修改公告
	 */
	@Override
//	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int update(Integer pid,String pauthor,String ptype,Date ptime,String ptitle,String pcontent) {
		int line = placardRepository.updateByPid(pid, pauthor, ptype, ptime, ptitle, pcontent);
		return line;
	}

	/**
	 * 根据编号删除公告
	 */
	@Override
//	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public int delete(Integer pid) {
		int line = 0;
		try {
			placardRepository.deleteById(pid);
			line = 1;
		} catch (Exception e) {
			line = 0;
		}
		return line;
	}

	/**
	 * 根据编号查询公告
	 */
	@Override
//	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public Placard selectByPid(Integer pid) {
		Placard placard = placardRepository.findByPid(pid);
		return placard;
	}

	/**
	 *查询所有公告信息
	 */
	@Override
//	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<Placard> selectAll() {
		List<Placard> placards = placardRepository.findAll();
		return placards;
	}

	/**
	 * 根据编号，作者，类型进行多条件组合查询
	 */
	@Override
//	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public List<Placard> findByCondition(Integer pid, String pauthor, String ptype) {
		List<Placard> placards = placardRepository.findByPidAndPauthorContainingAndPtype(pid, pauthor, ptype);
		return placards;
	}

	
}
