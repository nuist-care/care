package com.neuedu.care.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * JPA实体类Duty：护士值班管理
 * @author 马梦瑶
 *
 */
@ApiModel(value = "JPA实体类Duty护士值班管理")
@Entity
@Table(name = "duty")
@SecondaryTable(name = "employee")
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
	@Column(name = "did", table = "duty")
	private Integer did;
	
	/**
	 * 值班时间
	 */
	@ApiModelProperty(value = "值班时间")
	@Column(name = "dtime", table = "duty")
	@NotBlank(message = "值班时间不能为空！")
	@Length(min = 2,max = 2,message = "值班时间不合法！")
	private String dtime;
	
	/**
	 * 员工编号
	 */
	@ApiModelProperty(value = "员工编号")
	@Column(name = "eid", table = "duty")
	@Range(min = 10001,message = "员工编号不合法！")
	@NonNull
	private Integer eid;
	
	/**
	 * 员工姓名
	 */
	@ApiModelProperty(value = "员工姓名")
	@NotBlank(message = "员工姓名不能为空！")
	@Length(min = 2,message = "员工姓名不合法！")
	@Column(name = "ename", table = "employee")	
	private String ename;
	
	/**
	 * 员工职位
	 */
	@ApiModelProperty(value = "员工职位")
	@NotBlank(message = "员工职位不能为空！")
	@Length(min = 2,max = 2,message = "员工职位不合法！")
	@Column(name = "position", table = "employee")
	private String position;

}
