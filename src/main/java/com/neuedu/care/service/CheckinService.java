package com.neuedu.care.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.neuedu.care.entity.Checkin;

public interface CheckinService {
	List<Checkin> findAll();
}
