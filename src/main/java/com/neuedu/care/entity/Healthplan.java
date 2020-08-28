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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "JPA实体类Healthplan设置服务对象")
@Entity
@Table(name = "healthplan")
@SecondaryTables({
	@SecondaryTable(name = "employee"),
	@SecondaryTable(name = "client")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Healthplan implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 7912578280643127121L;
	@ApiModelProperty(value = "健康计划编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid", table = "healthplan")
	private Integer pid;
	
	@ApiModelProperty(value = "客户编号")
	@NotNull(message = "客户编号不能为空")
	@Range(min = 10000,message = "客户编号错误！")
	@Column(name = "aid", table = "healthplan")
	private Integer aid;
	
	@ApiModelProperty(value = "医生编号")
	@NotNull(message = "医生编号不能为空")
	@Range(min = 10000,message = "医生编号错误！")
	@Column(name = "eid", table = "healthplan")
	private Integer eid;
	
	@ApiModelProperty(value = "客户姓名")
	@Length(min = 1,message = "客户名字不合法")
	@Column(name = "aname", table = "client")
	private String aname;
	
	@ApiModelProperty(value = "医生姓名")
	@Length(min = 1,message = "医生姓名不合法")
	@Column(name = "ename", table = "employee")
	private String ename;
	
	@ApiModelProperty(value = "身体状况")
	@NotBlank(message = "身体状况不能为空！")
	@Column(name = "phycondition", table = "healthplan")
	private String phycondition;
	
	@ApiModelProperty(value = "康复计划")
	@NotBlank(message = "康复计划不能为空！")
	@Column(name = "plan", table = "healthplan")
	private String plan;
	
	@ApiModelProperty(value = "预计康复时间")
	@NotBlank(message = "预计康复时间不能为空！")
	@Column(name = "recoverydays", table = "healthplan")
	private String recoverydays;
	

}
