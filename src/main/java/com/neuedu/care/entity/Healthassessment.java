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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@ApiModel(value = "JPA实体类healthassessment设置服务对象")
@Entity
@Table(name = "healthassessment")
@SecondaryTable(name="client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Healthassessment implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8312600291530253870L;

	/**
	 * 评估编号
	 */
	@ApiModelProperty(value = "评估编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="assid",table = "healthassessment")	
	private Integer assid;
	
	/** 
	 * 病人编号 
	 */
	@ApiModelProperty(value = "病人编号")
	@Column(name="aid",table = "healthassessment")	
	@Range(min = 10000,message = "老人编号错误！")
	private Integer aid;
	
	/**
	 * 病人姓名
	 */
	@ApiModelProperty(value = "病人姓名")
	@Column(name="aname",table = "client")
	@Length(min = 1,message = "名字不合法")
	private String aname;
	
	/**
	 *  评估人 */
	@ApiModelProperty(value = "评估人")
	@Column(name="assesser",table = "healthassessment")
	@Length(min = 1,message = "评估人不合法")
	private String assesser;
	

	/**
	 *  评估理由 */
	@ApiModelProperty(value = "评估理由")
	@Column(name="assreason",table = "healthassessment")
	private String assreason;
	
	/**
	 *  评估类型 */
	@ApiModelProperty(value = "评估类型")
	@Column(name="asstype",table = "healthassessment")
	private String asstype;
	
	/** 
	 * 评估时间 */
	@ApiModelProperty(value = "评估时间")
	@Column(name="asstime",table = "healthassessment")
	private Date asstime;
	
	/**
	 *  评估结果 */
	@ApiModelProperty(value = "评估结果")
	@Column(name="assresult",table = "healthassessment")
	private String assresult;
	

}
