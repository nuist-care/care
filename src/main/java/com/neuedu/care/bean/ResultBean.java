package com.neuedu.care.bean;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 实体数据类ResultBean
 * 
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean{
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
}
