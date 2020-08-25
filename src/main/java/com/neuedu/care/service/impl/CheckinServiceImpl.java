package com.neuedu.care.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.care.dao.CheckinRepository;
import com.neuedu.care.entity.Checkin;
import com.neuedu.care.service.CheckinService;

public class CheckinServiceImpl implements CheckinService{
	@Autowired
	private CheckinRepository checkinRepository;

	@Override
	public List<Checkin> findAll() {

		return null;
	}

}
