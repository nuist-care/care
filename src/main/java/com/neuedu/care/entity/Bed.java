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

import io.swagger.annotations.ApiModel;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid",table = "bed")
	private Integer bid;
	
	/**
	 * 楼层号
	 */
//	@NotBlank
	@Column(name = "floor",table = "bed")
	private Integer floor;
	
	/**
	 * 房间号
	 */
//	@NotBlank
	@Column(name = "room",table = "bed")
	private Integer room;
	
	/**
	 * 床位号
	 */
//	@NotBlank
	@Column(name = "bnum",table = "bed")
	private Integer bnum;
	
	/**
	 * 客户编号
	 */
	@Column(name = "aid",table = "bed")
	private Integer aid;
	
	/**
	 * 客户姓名
	 */
	@Column(name = "aname",table = "client")
	private String aname;
}
