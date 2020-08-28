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
 * 实体类food————膳食
 * @author ASUS
 *
 */
@Entity
@Table(name = "food")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Food implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -6812963240054799679L;

	/**
	 * 膳食编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fid")
	private Integer fid;
	
	/**
	 * 客户编号
	 */
//	@NotBlank
	@Column(name = "aid")
	private Integer aid;
	
	/**
	 * 用餐时间
	 */
	@Column(name = "ftime")
	private Date ftime;
	
	/**
	 * 用餐类型
	 */
	@NotBlank(message = "用餐类型不能为空")
	@Column(name = "ftype")
	private String ftype;
	
	/**
	 * 用餐内容
	 */
	@NotBlank(message = "用餐内容不能为空")
	@Column(name = "fcontent")
	private String fcontent;
}
