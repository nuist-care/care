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
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 外出表实体类Go
 * @author 姚季
 *
 */

@Entity
@Table(name = "go")
@SecondaryTable(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Go implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7586861061451825586L;

	/**
	 * 外出记录编号
	 */
	@ApiModelProperty(value = " 外出记录编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(table = "go",name = "gid")
	private Integer gid;
	
	/**
	 * 客户编号
	 */
	@ApiModelProperty(value = "客户编号")
	@NotNull(message = "客户编号不能为空！")
	@Column(table = "go",name = "aid")
	private Integer aid;
	
	/**
	 * 外出原因
	 */
	@ApiModelProperty(value = "外出原因")
	@NotBlank(message = "外出理由不能为空！")
	@Column(table = "go",name = "goreason")
	private String goreason;
	
	/**
	 * 外出时间
	 */
	@ApiModelProperty(value = " 外出时间")
	@Column(table = "go",name = "gotime")
	private Date gotime;
	
	/**
	 * 申请外出时长
	 */
	@ApiModelProperty(value = "申请外出时长")
	@NotBlank(message = "申请外出时长不能为空！")
	@Column(table = "go",name = "applytime")
	private String applytime;
	
	/**
	 * 陪同人
	 */
	@ApiModelProperty(value = "陪同人")
	@Column(table = "go",name = "escort")
	private String escort;
	
	/**
	 * 审批人
	 */
	@ApiModelProperty(value = "审批人")
	@NotBlank(message = "审批人不能为空！")
	@Column(table = "go",name = "approver")
	private String approver;
	
	/**
	 * 审批状态
	 */
	@ApiModelProperty(value = "审批状态")
	@NotBlank(message = "审批状态不能为空！")
	@Column(table = "go",name = "approvalstatus")
	private String approvalstatus;
	
	/**
	 * 客户姓名
	 */
	@ApiModelProperty(value = "客户姓名")
	@Column(table = "client",name = "aname")
	private String aname;
}
