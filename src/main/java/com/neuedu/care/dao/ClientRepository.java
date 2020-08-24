package com.neuedu.care.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neuedu.care.entity.Client;

/**
 * JPA数据访问层ClientRepository
 * @author 姚季
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	/**
	 * 根据编号查询一个客户
	 * @param aid
	 * @return
	 */
	Client findByAid(Integer aid);
}
