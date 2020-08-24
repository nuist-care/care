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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA实体类Medicinerecord：用药记录管理
 * @author 马梦瑶
 *
 */
@ApiModel(value = "JPA实体类Medicinerecord用药记录管理")
@Entity
@Table(name = "medicinerecord")
@SecondaryTables({
	@SecondaryTable(name = "medicine"),
	@SecondaryTable(name = "client")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medicinerecord implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -679171867711289466L;
	
	/**
	 * 用药记录编号
	 */
	@ApiModelProperty(value = "用药记录编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mrid", table = "medicinerecord")
	private Integer mrid;
	
	/**
	 * 药品名称
	 */
	@ApiModelProperty(value = "药品名称")
	@NotBlank(message = "药品名称不得为空！")
	@Column(name = "mname", table = "medicine")
	private String mname;
	
	/**
	 * 客户姓名
	 */
	@ApiModelProperty(value = "客户姓名")
	@NotBlank(message = "客户姓名不能为空！")
	@Length(min = 2,message = "客户姓名不合法！")
	@Column(name = "aname", table = "client")
	private String aname;
	
	/**
	 * 医嘱用药时间
	 */
	@ApiModelProperty(value = "医嘱用药时间")
	@NotBlank(message = "医嘱用药时间不得为空！")
	@Column(name = "prescribedtime", table = "medicine")
	private String prescribedtime;
	
	/**
	 * 用药量
	 */
	@ApiModelProperty(value = "用药量")
	@NotBlank(message = "用药量不得为空！")
	@Column(name = "msize", table = "medicine")
	private String msize;
	
	/**
	 * 实际用药时间
	 */
	@ApiModelProperty(value = "实际用药时间")
	@NotBlank(message = "实际用药时间不得为空！")
	@Column(name = "actualtime", table = "medicinerecord")
	private String actualtime;
}
