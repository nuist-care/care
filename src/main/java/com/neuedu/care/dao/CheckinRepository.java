package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Checkin;

@Repository
public interface CheckinRepository extends JpaRepository<Checkin, Integer>{
	
	@Query(nativeQuery = true,value = "select checkin.iid,checkin.aid,checkin.intime,checkin.outtime,client.aname,client.asex,client.aage,client.aIDnumber,client.atelephone from checkin,client where checkin.aid = client.aid")
	List<Checkin> findAll();
	
	@Query(nativeQuery = true,value = "select checkin.iid,checkin.aid,checkin.intime,checkin.outtime,client.aname,client.asex,client.aage,client.aIDnumber,client.atelephone from checkin,client where checkin.aid = client.aid and checkin.iid = ?1")
	Checkin findByIid(Integer id);
	
	@Query(nativeQuery = true,value = "select checkin.iid,checkin.aid,checkin.intime,checkin.outtime,client.aname,client.asex,client.aage,client.aIDnumber,client.atelephone"
			+ " from checkin,client where checkin.aid = client.aid and (checkin.iid = ?1 or checkin.aid = ?2 or client.aname like concat ('%',?3,'%'))")
	List<Checkin> findByCondition(Integer iid,Integer aid,String aname);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "delete from checkin where checkin.iid = ?1")
	int insertByIid(Integer iid);
	
	
}
