package com.neuedu.care.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA实体类Level：护理级别管理
 * @author 马梦瑶
 *
 */
@ApiModel(value = "JPA实体类Level护理级别管理")
@Entity
@Table(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Level implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -5009268163873364328L;
	
	/**
	 * 客户编号
	 */
	@ApiModelProperty(value = "客户编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aid")
	private Integer aid;
	
	/**
	 * 客户姓名
	 */
	@ApiModelProperty(value = "客户姓名")
	@Column(name = "aname")
	@Length(min = 2, message = "客户姓名不合法！")
	@NotBlank(message = "客户姓名不能为空！")
	private String aname;
	
	/**
	 * 护理级别
	 */
	@ApiModelProperty(value = "护理级别")
	@Column(name = "clevel")
	@Range(min = 1, max = 5, message = "护理级别不合法！请输入1~5范围内的级别！")
	@NotNull
	private Integer clevel;
	
}
