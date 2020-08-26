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
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA实体类visiting
 * */
@ApiModel(value = "JPA实体类Visiting设置服务对象")
@Entity
@Table(name = "visiting")
@SecondaryTable(name="client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visiting implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3166098100788128426L;

	/**
	 * 就诊编号
	 */
	@ApiModelProperty(value = "就诊编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vid",table = "visiting")	
	private Integer vid;
	
	/** 
	 * 病人编号 
	 */
	@ApiModelProperty(value = "病人编号 ")
	@Column(name="aid",table = "visiting")	
	@Range(min = 10000,message = "老人编号错误！")
	private Integer aid;
	
	/**
	 * 病人姓名
	 */
	@ApiModelProperty(value = "病人姓名")
	@Column(name="aname",table = "client")
	@Length(min = 1,message = "老人名字不合法")
	private String aname;
	
	/**
	 *  就诊医院 */
	@ApiModelProperty(value = "就诊医院")
	@Column(name="vhospital",table = "visiting")
	@Length(min = 1,message = "医院信息不合法")
	private String vhospital;
	
	/** 
	 * 就诊时间 */
	@ApiModelProperty(value = "就诊时间")
	@Column(name="vtime",table = "visiting")
	private Date vtime;
	
	/**
	 *  就诊室 */
	@ApiModelProperty(value = "就诊室")
	@Column(name="vroom",table = "visiting")
	@Length(min = 1,max=3,message = "就诊室不合法")
	private String vroom;
	
	/**
	 *  就诊结果 */
	@ApiModelProperty(value = "就诊结果")
	@Column(name="vresult",table = "visiting")
	private String vresult;
	

}
