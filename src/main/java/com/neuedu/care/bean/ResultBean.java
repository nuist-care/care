package com.neuedu.care.bean;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 实体数据类ResultBean
 * @author 姚季
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean implements Serializable{

	/**
	 * 状态码
	 */
	private Integer code;
	/**
	 * 表示操作是否成功
	 */
	private boolean successed;
	/**
	 * 信息
	 */
	private String message;
	/**
	 * 数据
	 */
	private Object data;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8455780205639977226L;
}
