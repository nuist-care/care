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

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类ServeObj————服务对象
 * @author ASUS
 *
 */
@ApiModel(value = "实体类ServeObj————服务对象")
@Entity
@Table(name = "serve")
@SecondaryTables({
	@SecondaryTable(name = "client"),
	@SecondaryTable(name = "bed")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServeObj implements Serializable{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -6316740311990221665L;

	/**
	 * 服务编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serveid",table = "serve")
	private Integer severid;
	
	/**
	 * 护工编号
	 */
	@Column(name = "eid",table = "serve")
	private Integer eid;
	
	/**
	 * 客户编号
	 */
	@Column(name = "aid",table = "serve")
	private Integer aid;
	
	/**
	 * 客户姓名
	 */
	@Column(name = "aname",table = "client")
	private String aname;
	
	/**
	 * 楼层号
	 */
	@Column(name = "floor",table = "bed")
	private Integer floor;
	
	/**
	 * 房间号
	 */
	@Column(name = "room",table = "bed")
	private Integer room;
	
	/**
	 * 床位号
	 */
	@Column(name = "bnum",table = "bed")
	private Integer bnum;
}
