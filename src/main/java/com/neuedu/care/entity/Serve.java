package com.neuedu.care.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *JPA实体类Serve：设置服务对象
 * @author 马梦瑶
 *
 */
@Entity
@Table(name = "serve")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Serve implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 141047235368642556L;

	/**
	 * 服务编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serveid")
	private Integer serveid;
	
	/**
	 * 员工编号（医生、护士、护工）
	 */
	@ApiModelProperty(value = "员工编号")
	@NotNull
	@Range(min = 10001,message = "员工编号长度错误！")
	@Column(name = "eid")
	private Integer eid;
	
	/**
	 * 客户编号（老人）
	 */
	@ApiModelProperty(value = "客户编号")
	@NotNull
	@Column(name = "aid")
	private Integer aid;
	
}
