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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *JPA实体类Serve：设置服务对象
 * @author 马梦瑶
 *
 */
@ApiModel(value = "JPA实体类Serve设置服务对象")
@Entity
@Table(name = "serve")
@SecondaryTables({
	@SecondaryTable(name = "employee"),
	@SecondaryTable(name = "client")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Serve implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 141047235368642556L;

	/**
	 * 服务编号
	 */
	@ApiModelProperty(value = "服务编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serveid", table = "serve")
	private Integer serveid;
	
	/**
	 * 员工编号
	 */
	@ApiModelProperty(value = "员工编号")
	@NotNull
	@Range(min = 10001,message = "员工编号长度错误！")
	@Column(name = "eid", table = "serve")
	private Integer eid;

	/**
	 * 员工姓名
	 */
	@ApiModelProperty(value = "员工姓名")
//	@NotBlank(message = "员工姓名不能为空！")
//	@Length(min = 2,message = "员工姓名不合法！")
	@Column(name = "ename", table = "employee")
	private String ename;
	
	/**
	 * 员工电话
	 */
	@ApiModelProperty(value = "员工电话")
//	@NotBlank(message = "员工电话不能为空！")
//	@Pattern(regexp = "^\\d{11}$",message = "电话不合法！请输入11位正确电话号码！")
	@Column(name = "etelephone", table = "employee")
	private String etelephone;
	
	/**
	 * 员工职位
	 */
	@ApiModelProperty(value = "员工职位")
//	@NotBlank(message = "员工职位不能为空！")
//	@Length(min = 2,max = 2,message = "员工职位不合法！")
	@Column(name = "position", table = "employee")
	private String position;
	
	/**
	 * 客户编号
	 */
	@ApiModelProperty(value = "客户编号")
	@NotNull
	@Column(name = "aid", table = "serve")
	private Integer aid;

	/**
	 * 客户姓名
	 */
	@ApiModelProperty(value = "客户姓名")
//	@NotBlank(message = "客户姓名不能为空！")
//	@Length(min = 2,message = "客户姓名不合法！")
	@Column(name = "aname", table = "client")
	private String aname;
}
