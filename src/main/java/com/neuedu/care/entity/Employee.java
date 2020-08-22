package com.neuedu.care.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * JPA实体类Employee
 * 
 *
 */
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
	@NotBlank(message = "登录账号不能为空")
	@Length(min = 5,max = 5,message = "账号长度错误")
	private Integer eid;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	/**
	 * 身份证号码
	 */
	private String IDnumber;
	
	/**
	 * 电话号码
	 */
	private String telephone;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 入职时间
	 */
	private Date worktime;
	
	/**
	 * 工龄
	 */
	private Integer workage;
	
	/**
	 * 职位
	 */
	private String position;
	
	/**
	 * 密码
	 */
	@NotBlank(message = "登录密码不能为空")
	@Length(min = 6,message = "登录密码不能少于六位")
	private String password;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8751636362591655458L;
}
