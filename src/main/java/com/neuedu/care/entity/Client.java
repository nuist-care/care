package com.neuedu.care.entity;

import java.io.Serializable;

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

@ApiModel(value = "JPA实体类Client客户员工信息表")
@Entity
@Table(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * 客户编号
	 */
	private Integer aid;
	
	/**
	 * 客户姓名
	 */
	@ApiModelProperty(value = "客户姓名")
	@NotBlank(message = "客户姓名不能为空！")
	@Length(min = 2,message = "客户姓名不合法！")
	private String aname;
	
	/**
	 * 客户性别
	 */
	@ApiModelProperty(value = "客户性别")
	@NotBlank(message = "客户性别不能为空！")
	private String asex;
	
	/**
	 * 客户年龄
	 */
	@ApiModelProperty(value = "客户年龄")
	@NotNull(message = "客户年龄不能为空！")
	@Range(min = 18,max = 100,message = "客户年龄不合法！")
	private Integer aage;
	
	/**
	 * 客户身份证
	 */
	@ApiModelProperty(value = "客户身份证号")
	@NotBlank(message = "客户身份证号码不能为空！")
	@Length(min = 18,max = 18,message = "客户身份证号码不合法！")
	private String aIDnumber;
	
	/**
	 * 客户电话号码
	 */
	@ApiModelProperty(value = "客户电话号码")
	@NotBlank(message = "客户电话不能为空！")
	@Pattern(regexp = "^\\d{11}$",message = "电话不合法！请输入11位正确电话号码！")
	private String atelephone;
	
	/**
	 * 客户住址
	 */
	@ApiModelProperty(value = "客户住址")
	private String aaddress;
	
	/**
	 * 客户遗传病史
	 */
	@ApiModelProperty(value = "客户遗传病史")
	private String genetichistory;
	
	/**
	 * 客户身体状况
	 */
	@ApiModelProperty(value = "客户身体状况")
	private String conditiondescription;
	
	/**
	 * 客户病情等级
	 */
	@ApiModelProperty(value = "客户病情等级")
	private Integer clevel;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -654679686738782434L;
}
