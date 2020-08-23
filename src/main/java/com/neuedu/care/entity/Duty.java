package com.neuedu.care.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA实体类Duty：护士值班管理
 * @author 马梦瑶
 *
 */
@ApiModel(value = "JPA实体类Duty护士值班管理")
@Entity
@Table(name = "duty")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Duty implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1121063616311984644L;

	/**
	 * 值班编号
	 */
	@ApiModelProperty(value = "值班编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "did")
	private Integer did;
	
	/**
	 * 值班时间
	 */
	@ApiModelProperty(value = "值班时间")
	@Column(name = "dtime")
	@NotBlank(message = "值班时间不能为空！")
	private String dtime;
	
	/**
	 * 值班人员
	 */
	@ApiModelProperty(value = "值班人员")
	@Column(name = "dnurse")
	@NotBlank(message = "值班人员不能为空！")
	private String dnurse;

}
