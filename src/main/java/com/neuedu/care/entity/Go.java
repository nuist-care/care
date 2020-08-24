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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gid;
	private Integer aid;
	private String goreason;
	private Date gotime;
	private String applytime;
	private String escort;
	private String approver;
	private String approvalstatus;
}
