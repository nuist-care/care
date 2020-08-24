package com.neuedu.care.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

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
public class Go {
	/**
	 * 编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(table = "go",name = "gid")
	private Integer gid;
	
	/**
	 * 客户编号
	 */
	@Column(table = "go",name = "aid")
	private Integer aid;
	
	/**
	 * 外出原因
	 */
	@Column(table = "go",name = "goreason")
	private String goreason;
	
	/**
	 * 外出时间
	 */
	@Column(table = "go",name = "gotime")
	private Date gotime;
	
	/**
	 * 申请外出时长
	 */
	@Column(table = "go",name = "applytime")
	private String applytime;
	
	/**
	 * 陪同人
	 */
	@Column(table = "go",name = "escort")
	private String escort;
	
	/**
	 * 审批人
	 */
	@Column(table = "go",name = "approver")
	private String approver;
	
	/**
	 * 审批状态
	 */
	@Column(table = "go",name = "approvalstatus")
	private String approvalstatus;
	
	/**
	 * 客户姓名
	 */
	@Column(table = "client",name = "aname")
	private String aname;
}
