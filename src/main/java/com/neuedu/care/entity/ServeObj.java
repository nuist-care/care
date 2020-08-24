package com.neuedu.care.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类ServeObj————服务对象
 * @author ASUS
 *
 */
@Entity
@Table(name = "serve")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServeObj implements Serializable{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -6316740311990221665L;

	/**
	 * 服务编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serveid")
	private Integer severid;
	
	/**
	 * 护工编号
	 */
	@Column(name = "eid")
	private Integer eid;
	
	/**
	 * 客户编号
	 */
	@Column(name = "aid")
	private Integer aid;
}
