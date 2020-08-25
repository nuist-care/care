package com.neuedu.care.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类bed————床位
 * @author ASUS
 *
 */
@Entity
@Table(name = "bed")
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
	@Column(name = "bid")
	private Integer bid;
	
	/**
	 * 楼层号
	 */
//	@NotBlank
	@Column(name = "floor")
	private Integer floor;
	
	/**
	 * 房间号
	 */
//	@NotBlank
	@Column(name = "room")
	private Integer room;
	
	/**
	 * 床位号
	 */
//	@NotBlank
	@Column(name = "bnum")
	private Integer bnum;
	
	/**
	 * 客户编号
	 */
	@Column(name = "aid")
	private Integer aid;
}
