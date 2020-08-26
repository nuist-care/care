package com.neuedu.care.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA实体类Medicine：医嘱管理
 * 
 *
 */
@ApiModel(value = "JPA实体类Medicine医嘱管理")
@Entity
@Table(name = "medicine")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Drug implements Serializable{
	/**
	 * 序列化
	 */
	
	private static final long serialVersionUID = -2206977519092109938L;

	/**
	 * 医嘱编号
	 */
	@ApiModelProperty(value = "医嘱编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mid", table = "medicine")
	private Integer mid;
	
	/**
	 * 药品名称
	 */
	@ApiModelProperty(value = "药品名称")
	@NotBlank(message = "药品名称不得为空！")
	@Column(name = "mname", table = "medicine")
	private String mname;
	
	/**
	 * 用药量
	 */
	@ApiModelProperty(value = "用药量")
	@NotBlank(message = "用药量不得为空！")
	@Column(name = "msize", table = "medicine")
	private String msize;
	
	/**
	 * 医嘱用药时间
	 */
	@ApiModelProperty(value = "医嘱用药时间")
	@NotBlank(message = "医嘱用药时间不得为空！")
	@Column(name = "prescribedtime", table = "medicine")
	private String prescribedtime;
	
	
}
