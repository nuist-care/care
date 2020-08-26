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

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类bed————床位
 * @author ASUS
 *
 */
@ApiModel(value = "JPA实体类Bed床位管理")
@Entity
@Table(name = "bed")
@SecondaryTable(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bed implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 5578535657191543222L;
	
	/**
	 * 床位编号
	 */
	@ApiModelProperty(value = "床位编号")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid",table = "bed")
	private Integer bid;
	
	/**
	 * 楼层号
	 */
	@ApiModelProperty(value = "楼层号")
//	@NotBlank
	@Column(name = "floor",table = "bed")
	@Range(min = 1,max = 6,message = "楼层号不合法")
	private Integer floor;
	
	/**
	 * 房间号
	 */
	@ApiModelProperty(value = "房间号")
//	@NotBlank
	@Column(name = "room",table = "bed")
	@Range(min = 1,max = 10,message = "房间号不合法")
	private Integer room;
	
	/**
	 * 床位号
	 */
	@ApiModelProperty(value = "床位号")
//	@NotBlank
	@Column(name = "bnum",table = "bed")
	@Range(min = 1,max = 2,message = "床位号不合法")
	private Integer bnum;
	
	/**
	 * 客户编号
	 */
	@ApiModelProperty(value = "客户编号")
	@Column(name = "aid",table = "bed")
	private Integer aid;
	
	/**
	 * 客户姓名
	 */
	@ApiModelProperty(value = "客户姓名")
	@Column(name = "aname",table = "client")
	private String aname;
}
