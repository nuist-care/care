package com.neuedu.care.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Integer gid;
	
	/**
	 * 客户编号
	 */
	private Integer aid;
	
	/**
	 * 外出原因
	 */
	private String goreason;
	
	/**
	 * 外出时间
	 */
	private Date gotime;
	
	/**
	 * 申请外出时长
	 */
	private String applytime;
	
	/**
	 * 陪同人
	 */
	private String escort;
	
	/**
	 * 审批人
	 */
	private String approver;
	
	/**
	 * 审批状态
	 */
	private String approvalstatus;
}
