package com.neuedu.care.entity;

import java.io.Serializable;
import java.util.Date;

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
	private Integer pid;
	
	/**
	 * 公告作者
	 */
	@NotBlank
	private String pauthor;
	
	/**
	 * 公告类型
	 */
	@NotBlank
	private String ptype;
	
	/**
	 * 公告发布日期
	 */
	@NotBlank
	private Date ptime;
	
	/**
	 * 公告标题
	 */
	@NotBlank
	private String ptitle;
	
	/**
	 * 公告内容
	 */
	@NotBlank
	private String pcontent;
}
