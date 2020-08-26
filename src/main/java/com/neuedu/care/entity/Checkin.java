package com.neuedu.care.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 入住记录实体类Checkin
 * @author 姚季
 *
 */
@ApiModel(value = "JPA实体类Checkin入住记录信息表")
@Entity
@Table(name = "checkin")
@SecondaryTable(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Checkin implements Serializable{
	/**
	 * 入住表记录编号
	 */
	@ApiModelProperty(value = "入住表记录编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(table = "checkin",name = "iid")
	private Integer iid;
	
	/**
	 * 客户编号
	 */
	@ApiModelProperty(value = "客户编号")
	@Column(table = "checkin",name = "aid")
	private Integer aid;
	
	/**
	 * 入住时间
	 */
	@ApiModelProperty(value = "入住时间")
	@Column(table = "checkin",name = "intime")
	private Date intime;
	
	/**
	 * 到期时间
	 */
	@ApiModelProperty(value = "到期时间")
	@Column(table = "checkin",name = "outtime")
	private Date outtime;
	
	/**
	 * 客户姓名
	 */
	@ApiModelProperty(value = "客户姓名")
	@Column(table = "client",name = "aname")
	private String aname;
	
	/**
	 * 客户性别
	 */
	@ApiModelProperty(value = "客户性别")
	@Column(table = "client",name = "asex")
	private String asex;
	
	/**
	 * 客户年龄
	 */
	@ApiModelProperty(value = "客户年龄")
	@Column(table = "client",name = "aage")
	private Integer aage;
	
	/**
	 * 
	 */
	@ApiModelProperty(value = "客户身份证号码")
	@Column(table = "client",name = "aIDnumber")
	private String aIDnumber;
	
	/**
	 * 
	 */
	@ApiModelProperty(value = "客户电话号码")
	@Column(table = "client",name = "atelephone")
	private String atelephone;
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -3903905880577356211L;
}
