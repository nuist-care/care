package com.neuedu.care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.dao.BedRepository;
import com.neuedu.care.entity.Bed;
import com.neuedu.care.service.BedService;

/**
 * 业务逻辑接口实现类BedServiceImpl
 * @author ASUS
 *
 */
@Service
@Transactional
public class BedServiceImpl implements BedService{

	@Autowired
	private BedRepository bedRepository;
	
	/**
	 * 新增床位信息
	 */
	@Override
	public Bed insert(Bed bed) {
		Bed b = bedRepository.save(bed);
		return b;
	}

	/**
	 * 修改床位信息
	 */
	@Override
	public int update(Integer bid, Integer floor, Integer room, Integer bnum, Integer aid) {
		int line = bedRepository.updateByBid(bid, floor, room, bnum, aid);
		return line;
	}

	/**
	 * 删除床位信息
	 */
	@Override
	public int delete(Integer bid) {
		int line = 0;
		try {
			bedRepository.deleteById(bid);
			line = 1; 
		} catch (Exception e) {
			line = 0;
		}
		return line;
	}

	/**
	 * 根据编号查询床位信息
	 */
	@Override
	public Bed selectByBid(Integer bid) {
		Bed bed = bedRepository.findByBid(bid);
		return bed;
	}

	/**
	 * 查询所有床位信息
	 */
	@Override
	public List<Bed> selectAll() {
		List<Bed> beds = bedRepository.findAll();
		return beds;
	}

}
