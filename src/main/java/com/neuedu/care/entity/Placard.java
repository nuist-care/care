package com.neuedu.care.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类Placard——公告
 * @author ASUS
 *
 */
@Entity
@Table(name = "placard")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Placard implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -6881881002025175226L;

	/**
	 * 公告编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private Integer pid;
	
	/**
	 * 公告作者
	 */
	@NotBlank
	@Column(name = "pauthor")
	private String pauthor;
	
	/**
	 * 公告类型
	 */
	@NotBlank
	@Column(name = "ptype")
	private String ptype;
	
	/**
	 * 公告发布日期
	 */
	@Column(name = "ptime")
	private Date ptime;
	
	/**
	 * 公告标题
	 */
//	@NotBlank
	@Column(name = "ptitle")
	private String ptitle;
	
	/**
	 * 公告内容
	 */
//	@NotBlank
	@Column(name = "pcontent")
	private String pcontent;
}
