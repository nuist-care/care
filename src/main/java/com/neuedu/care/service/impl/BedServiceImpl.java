package com.neuedu.care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.dao.BedRepository;
import com.neuedu.care.dao.ClientRepository;
import com.neuedu.care.entity.Bed;
import com.neuedu.care.entity.Client;
import com.neuedu.care.service.BedService;

/**
 * 业务逻辑接口实现类BedServiceImpl
 * @author ASUS
 *
 */
@Service
public class BedServiceImpl implements BedService{

	@Autowired
	private BedRepository bedRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	/**
	 * 新增床位信息
	 */
	@Override
	public boolean insert(Integer floor,Integer room,Integer bnum,Integer aid) {
		System.out.println("新增床位");
		//客户必须存在客户表中
		Client client = clientRepository.findByAid(aid);
		System.out.println(client);
		if (null == client) {
			return false;
		}
		//一个客户只能有一张床位
		Bed b = bedRepository.findByAid2(aid);
		if (null != b) {
			return false;
		}
		//楼层号：1-6
		if (floor <1 && floor > 6) {
			return false;
		}
		//房间号：1-10
		if (room < 1 && room > 10) {
			return false;
		}
		//床位号：1-2
		if (bnum < 1 && bnum > 2) {
			return false;
		}
		int line = bedRepository.insert(floor, room, bnum, aid);
		return line == 1 ? true : false;
	}

	/**
	 * 修改床位信息
	 */
	@Override
	public boolean update(Integer bid, Integer aid) {
		System.out.println("修改床位");
//		//客户必须存在客户表中
//		Client client = clientRepository.findByAid(aid);
//		System.out.println("修改床位1");
//		System.out.println(client);
//		System.out.println("修改床位2");
//		if (client == null) {
//			return false;
//		}
		//一个客户只能有一张床位
		Bed b = bedRepository.findByAid2(aid);
		if (null != b) {
			return false;
		}
		int line = bedRepository.updateByBid(bid, aid);
		return line == 1 ? true :false;
	}

	/**
	 * 删除床位信息
	 */
	@Override
	public boolean delete(Integer bid) {
		if (null == bid || bid <1) {
			return false;
		}
		int line = bedRepository.deleteByPrimaryKey(bid);
		return line == 1 ? true : false;
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
		System.out.println("查询所有");
		return bedRepository.findAll();
	}

	/**
	 * 根据客户编号查询床位信息 by马梦瑶
	 */
	@Override
	public Bed findByAid(Integer aid) {
		if (null == aid) {
			return null;
		}
		return bedRepository.findByAid(aid);
	}

	/**
	 * 根据楼层号，房间号，床位号查询床位信息
	 */
	@Override
	public List<Bed> findByFloorAndRoomAndBnum(Integer floor, Integer room, Integer bnum) {
		List<Bed> beds = bedRepository.findByFloorAndRoomAndBnum(floor, room, bnum);
		return beds;
	}
}
