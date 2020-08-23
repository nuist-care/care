package com.neuedu.care.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JPA实体类visiting
 * */
@Entity
@Table(name = "visiting")
@SecondaryTable(name="client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visiting {
	/**
	 * 就诊编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotBlank
    @Column(name="vid",table = "visiting")	
	private Integer vid;
	
	/** 
	 * 病人编号 
	 */
//	@NotBlank
	@Column(name="aid",table = "visiting")	
	private Integer aid;
	
	/**
	 * 姓名
	 */
//	@NotBlank
	@Column(name="aname",table = "client")
	@Length(min = 1,message = "名字不合法")
	private String aname;
	
	/**
	 *  就诊医院 */
//	@NotBlank
	@Column(name="vhospital",table = "visiting")
	@Length(min = 1,message = "医院信息不合法")
	private String vhospital;
	
	/** 
	 * 就诊时间 */
//	@NotBlank
	@Column(name="vtime",table = "visiting")
	private Date vtime;
	
	/**
	 *  就诊室 */
//	@NotBlank
	@Column(name="vroom",table = "visiting")
	@Length(min = 1,max=3,message = "楼层不合法")
	private String vroom;
	
	/**
	 *  就诊结果 */
//	@NotBlank
	@Column(name="vresult",table = "visiting")
	private String vresult;
	

}
