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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA实体类Medicine：医嘱管理
 * 
 *
 */
@ApiModel(value = "JPA实体类Medicine医嘱管理")
@Entity
@Table(name = "medicine")
@SecondaryTables({
	@SecondaryTable(name = "medicinerecord"),
	@SecondaryTable(name = "client")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medicine implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -679171867711289466L;
	
	/**
	 * 医嘱编号
	 */
	@ApiModelProperty(value = "医嘱编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mid", table = "medicine")
	private Integer mid;
	
	/**
	 * 药品名称
	 */
	@ApiModelProperty(value = "药品名称")
	@NotBlank(message = "药品名称不得为空！")
	@Column(name = "mname", table = "medicine")
	private String mname;
	
	/**
	 * 用药量
	 */
	@ApiModelProperty(value = "用药量")
	@NotBlank(message = "用药量不得为空！")
	@Column(name = "msize", table = "medicine")
	private String msize;
	
	/**
	 * 医嘱用药时间
	 */
	@ApiModelProperty(value = "医嘱用药时间")
	@NotBlank(message = "医嘱用药时间不得为空！")
	@Column(name = "prescribedtime", table = "medicine")
	private String prescribedtime;
	
	
	/**
	 * 用药记录编号
	 */
	@ApiModelProperty(value = "用药记录编号")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Range(min = 10000,message = "用药记录编号错误！")
	@Column(name = "mrid", table = "medicinerecord")
	private Integer mrid;
	
	/**
	 * 老人编号
	 */
	@ApiModelProperty(value = "客户编号")
	@Range(min = 10000,message = "老人编号错误！")
	@Column(name = "aid", table = "medicinerecord")
	private Integer aid;
	/**
	 * 老人姓名
	 */
	@ApiModelProperty(value = "客户姓名")
	@Length(min = 2,message = "客户姓名不合法！")
	@Column(name = "aname", table = "client")
	private String aname;
	
	

}
