package com.neuedu.care.entity;

import java.io.Serializable;
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


@Entity
@Table(name = "checkin")
@SecondaryTable(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Checkin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3903905880577356211L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(table = "checkin",name = "iid")
	private Integer iid;
	
	@Column(table = "checkin",name = "aid")
	private Integer aid;
	
	@Column(table = "checkin",name = "intime")
	private Date intime;
	
	@Column(table = "checkin",name = "outtime")
	private Date outtime;
	
	@Column(table = "client",name = "aname")
	private String aname;
	
	@Column(table = "client",name = "asex")
	private String asex;
	
	@Column(table = "client",name = "aage")
	private Integer aage;
	
	@Column(table = "client",name = "aIDnumber")
	private String aIDnumber;
	
	@Column(table = "client",name = "atelephone")
	private String atelephone;
}
