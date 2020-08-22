package com.neuedu.care.entity;

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

/*
 * JPA实体类visiting
 * */
@Entity
@Table(name = "visiting")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visiting {
	/**
	 * 就诊编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotBlank
//	@Length(min = 5,max = 5,message = "账号长度错误")
	private Integer vid;
	
	/** 
	 * 病人编号 
	 */
//	@NotBlank
//	@Length(min = 5,max = 5,message = "账号长度错误")
	private Integer aid;
	
	/**
	 * 姓名
	 */
//	@NotBlank
	private String aname;
	
	/**
	 *  就诊医院 */
//	@NotBlank
	private String vhospital;
	
	/** 
	 * 就诊时间 */
//	@NotBlank
	private Date vtime;
	
	/**
	 *  就诊室 */
//	@NotBlank
	private String vroom;
	
	/**
	 *  就诊结果 */
//	@NotBlank
	private String vresult;
	

}
