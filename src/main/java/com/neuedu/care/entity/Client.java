package com.neuedu.care.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * 客户编号
	 */
	private Integer aid;
	
	/**
	 * 客户姓名
	 */
	private String aname;
	
	/**
	 * 客户性别
	 */
	private String asex;
	
	/**
	 * 客户年龄
	 */
	private Integer aage;
	
	/**
	 * 客户身份证
	 */
	private Integer aIDnumber;
	
	/**
	 * 客户电话号码
	 */
	private String atelephone;
	
	/**
	 * 客户遗传病史
	 */
	private String genetichistory;
	
	/**
	 * 客户身体状况
	 */
	private String conditiondescription;
	
	/**
	 * 客户病情等级
	 */
	private Integer clevel;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -654679686738782434L;
}
