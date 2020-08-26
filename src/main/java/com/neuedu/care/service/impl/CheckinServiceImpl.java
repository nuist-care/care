package com.neuedu.care.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neuedu.care.dao.CheckinRepository;
import com.neuedu.care.dao.ClientRepository;
import com.neuedu.care.entity.Checkin;
import com.neuedu.care.entity.Client;
import com.neuedu.care.service.CheckinService;

/**
 * 业务逻辑接口CheckinService实现类CheckinServiceImpl
 * @author 姚季
 *
 *
 */
@Service
public class CheckinServiceImpl implements CheckinService{
	@Autowired
	private CheckinRepository checkinRepository;
	@Autowired
	private ClientRepository clientRepository;

	/**
	 * 查询所有入住记录
	 */
	@Override
	public Page<Checkin> findAll(Pageable pageable) {
		Page<Checkin> checkins = checkinRepository.findAllInfo(pageable);
		return checkins;
	}

	/**
	 *  入住记录编号，客户编号，客户姓名多条件查询入住记录
	 */
	@Override
	public List<Checkin> findByCondition(Integer iid,Integer aid,String aname) {
		List<Checkin> checkins = checkinRepository.findByCondition(iid, aid, aname);
		return checkins;
	}

	/**
	 * 根据入住记录编号查询入住记录
	 */
	@Override
	public Checkin findById(Integer id) {
		Checkin checkin = checkinRepository.findByIid(id);
		return checkin;
	}

	/**
	 * 插入入住记录
	 */
	@Override
	public int insert(Date intime, Date outtime, String aname, String asex, Integer aage, String aIDnumber,
			String atelephone) {
		Client client = Client.builder()
				.aname(aname)
				.asex(asex)
				.aage(aage)
				.aIDnumber(aIDnumber)
				.atelephone(atelephone)
				.build();
		Client client2 = clientRepository.save(client);
		int line = checkinRepository.insert(client2.getAid(), intime, outtime);
		return line;
	}

	/**
	 * 更新入住记录
	 */
	@Override
	public int update(Integer iid, Date intime, Date outtime) {
		int line = checkinRepository.update(iid, intime, outtime);
		return line;
	}

	/**
	 * 删除入住记录
	 */
	@Override
	public int delete(Integer iid) {
		Checkin checkin = checkinRepository.findByIid(iid);
		if (checkin == null) {
			return 2;
		}
		int line = checkinRepository.deleteByIid(iid);
		clientRepository.deleteById(checkin.getAid());
		return line;
	}
}
