package com.neuedu.care.dao;

import org.apache.ibatis.jdbc.SQL;

import com.neuedu.care.entity.Placard;

/**
 * 数据访问层PlacardSqlProvider：是接口PlacardMapper的补充，专门编写复杂的SQL语句
 * @author ASUS
 *
 */
public class PlacardSqlProvider {

	/**
	 * 对insertSelective方法的补充
	 * @param record
	 * @return
	 */
	public String insertSelective(Placard record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("placard");
		
		if (record.getPid() != null) {
			sql.VALUES("pid", "#{pid,jdbcType=Integer}");
		}
		
		if (record.getPauthor() != null) {
			sql.VALUES("pauthor", "#{pauthor,jdbcType=VARCHAR}");
		}
		
		if (record.getPtype() != null) {
			sql.VALUES("ptype", "#{ptype,jdbcType=VARCHAR}");
		}
		
		if (record.getPtime() != null) {
			sql.VALUES("ptime", "#{ptime,jdbcType=DATE}");
		}
		
		if (record.getPtitle() != null) {
			sql.VALUES("ptitle", "#{ptitle,jdbcType=VARCHAR}");
		}
		
		if (record.getPcontent() != null) {
			sql.VALUES("pcontent", "#{pcontent,jdbcType=VARCHAR}");
		}
		return sql.toString();
	}
	
	/**
	 * 对updateByPrimaryKsySelective方法的补充
	 * @param record
	 * @return
	 */
	public String updateByPrimaryKsySelective(Placard record) {
		SQL sql = new SQL();
		sql.UPDATE("placard");
		
		if (record.getPauthor() != null) {
			sql.SET("pauthor = #{pauthor,jdbcType=VARCHAR}");
		}
		
		if (record.getPtype() != null) {
			sql.SET("ptype = #{ptype,jdbcType=VARCHAR}");
		}
		
		if (record.getPtime() != null) {
			sql.SET("ptime = #{ptime,jdbcType=DATE}");
		}
		
		if (record.getPtitle() != null) {
			sql.SET("ptitle = #{ptitle,jdbcType=VARCHAR}");
		}
		
		if (record.getPcontent() != null) {
			sql.SET("pcontent = #{pcontent,jdbcType=VARCHAR}");
		}
		
		sql.WHERE("pid = #{pid,jdbcType=Integer}");
		
		return sql.toString();
	}
}
