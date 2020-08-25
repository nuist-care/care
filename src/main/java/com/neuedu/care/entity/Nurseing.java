package com.neuedu.care.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * JPA实体类Nurseing：护理记录管理
 * @author 马梦瑶
 *
 */
@ApiModel(value = "JPA实体类Nurseing护理记录管理")
@Entity
@Table(name = "nurseing")
@SecondaryTables({
	@SecondaryTable(name = "client"),
	@SecondaryTable(name = "employee")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Nurseing implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 2862328113742319768L;
	
	/**
	 * 护理记录编号
	 */
	@ApiModelProperty(value = "护理记录编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid", table = "nurseing")
	private Integer cid;
	
	/**
	 * 客户姓名
	 */
	@ApiModelProperty(value = "客户姓名")
	@Length(min = 2, message = "客户姓名不合法！")
	@NotBlank(message = "客户姓名不能为空！")
	@Column(name = "aname", table = "client")
	private String aname;
	
	/**
	 * 护理内容
	 */
	@ApiModelProperty(value = "护理内容")
	@NotBlank(message = "护理内容不能为空！")
	@Column(name = "ccontent", table = "nurseing")
	private String ccontent;
	
	/**
	 * 护理时间
	 */
	@ApiModelProperty(value = "护理时间")
	@Past(message = "护理时间不合法！请勿填写未来日期！")
	@NotNull(message = "护理时间不能为空！")
	@Column(name = "ctime", table = "nurseing")
	private Date ctime;
	
	/**
	 * 员工编号
	 */
	@ApiModelProperty(value = "员工编号")
	@Range(min = 10001,message = "员工编号不合法！")
	@NotNull(message = "员工编号不能为空！")
	@Column(name = "eid", table = "nurseing")
	private Integer eid;
	
	/**
	 * 员工姓名
	 */
	@ApiModelProperty(value = "员工姓名")
	@Length(min = 2,message = "员工姓名不合法！")
	@NotBlank(message = "员工姓名不能为空！")
	@Column(name = "ename", table = "employee")
	private String ename;
	
}
