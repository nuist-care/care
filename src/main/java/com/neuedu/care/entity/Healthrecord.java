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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "JPA实体类healthrecord设置服务对象")
@Entity
@Table(name = "healthrecord")
@SecondaryTable(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Healthrecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6392050178220214297L;
	/**
	 * 健康档案编号
	 **/
	@ApiModelProperty(value = "健康档案编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rid", table = "healthrecord")
	private Integer rid;
	/**
	 * 老人编号
	 **/
	@ApiModelProperty(value = "客户编号")
	@Range(min = 10000,message = "老人编号错误！")
	@Column(name = "aid", table = "healthrecord")
	private Integer aid;
	/**
	 * 老人姓名
	 **/
	@ApiModelProperty(value = "客户姓名")
	@Column(name = "aname", table = "client")
	private String aname;
	/**
	 * 血压
	 **/
	@ApiModelProperty(value = "血压")
	@NotNull(message = "血压不能为空")
	@Column(name = "bpressure", table = "healthrecord")
	private Integer bpressure;
	/**
	 * 血脂
	 **/
	@ApiModelProperty(value = "血脂")
	@NotNull(message = "血脂不能为空")
	@Column(name = "bfat", table = "healthrecord")
	private Integer bfat;
	/**
	 * 血糖
	 **/
	@ApiModelProperty(value = "血糖")
	@NotNull(message = "血糖")
	@Column(name = "bsugar", table = "healthrecord")
	private Integer bsugar;
	/**
	 * 心率
	 **/
	@ApiModelProperty(value = "心率")
	@NotNull(message = "心率不能为空")
	@Column(name = "heartrate", table = "healthrecord")
	private Integer heartrate;

}
