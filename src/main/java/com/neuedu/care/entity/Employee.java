package com.neuedu.care.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * JPA实体类Employee
 * 
 *
 */
@ApiModel(value = "JPA实体类Employee员工信息表")
@Entity
@Table(name = "employee")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * 编号
	 */
	@ApiModelProperty(value = "员工编号")
	private Integer eid;
	
	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "员工姓名")
	@NotBlank(message = "员工姓名不能为空！")
	@Length(min = 2,message = "员工姓名不合法！")
	private String ename;
	
	/**
	 * 性别
	 */
	@ApiModelProperty(value = "员工性别")
	@NotBlank(message = "员工性别不能为空！")
	private String esex;
	
	/**
	 * 年龄
	 */
	@ApiModelProperty(value = "员工年龄")
	@NotNull(message = "员工年龄不能为空！")
	@Range(min = 18,max = 100,message = "员工年龄不合法！")
	private Integer eage;
	
	/**
	 * 身份证号码
	 */
	@ApiModelProperty(value = "员工身份证号")
	@NotBlank(message = "员工身份证号码不能为空！")
	@Length(min = 18,max = 18,message = "员工身份证号码不合法！")
	private String eIDnumber;
	
	/**
	 * 电话号码
	 */
	@ApiModelProperty(value = "员工电话号码")
	@NotBlank(message = "员工电话不能为空！")
	@Pattern(regexp = "^\\d{11}$",message = "电话不合法！请输入11位正确电话号码！")
	private String etelephone;
	
	/**
	 * 地址
	 */
	@ApiModelProperty(value = "员工住址")
	private String eaddress;
	
	/**
	 * 入职时间
	 */
	@ApiModelProperty(value = "员工入职时间")
	private Date worktime;
	
	/**
	 * 工龄
	 */
	@ApiModelProperty(value = "员工工龄")
	private Integer workage;
	
	/**
	 * 职位
	 */
	@ApiModelProperty(value = "员工职位")
	private String position;
	
	/**
	 * 密码
	 */
	@ApiModelProperty(value = "员工密码")
	private String password;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8751636362591655458L;
}
