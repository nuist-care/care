package com.neuedu.care.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.neuedu.care.entity.Placard;

/**
 * 数据访问层 公告 接口PlacardMapper
 * @author ASUS
 *
 */
@Mapper
@CacheNamespace
public interface PlacardMapper {
	
	/**
	 * 根据公告编号搜索公告信息
	 * @param pid
	 * @return
	 */
	@Select({
		"select",
		"pid,pauthor,ptype,ptime,ptitle,pcontent",
		"from placard",
		"where pid = #{pid,jdbcType=INTEGER}"
	})
	@Results({
		@Result(column="pid",property="pid",jdbcType=JdbcType.INTEGER,id=true),
		@Result(column="pauthor",property="pauthor",jdbcType=JdbcType.VARCHAR),
		@Result(column="ptype",property="ptype",jdbcType=JdbcType.VARCHAR),
		@Result(column="ptime",property="ptime",jdbcType=JdbcType.DATE),
		@Result(column="ptitle",property="ptitle",jdbcType=JdbcType.VARCHAR),
		@Result(column="pcontent",property="pcontent",jdbcType=JdbcType.VARCHAR),
	})
	Placard selectByPrimaryKey(Integer pid);
	
	
	/**
	 * 根据公告编号删除公告信息
	 * @param pid
	 * @return
	 */
	@Delete({
		"delete from placard",
		"where pid = #{pid,jdbcType=INTEGER}"
	})
	int deleteByPrimaryKey(Integer pid);
	
	/**
	 * 新增全参公告：不考虑为null的情况
	 * @param record
	 * @return
	 */
	@Insert({
		"insert into placard(pid,pauthor,ptype,ptime,ptitle,pcontent",
		"value(#{pid,jdbcType=INTEGER},#{pauthor,jdbcType=VARCHAR},",
		"#{ptype,jdbcType=VARCHAR},#{ptime,jdbcType=DATE},",
		"#{ptitle,jdbcType=VARCHAR},#{pcontent,jdbcType=VARCHAR})"
	})
	int insert(Placard record);
	
	/**
	 * 新增全参公告：考虑为null情况，若为空，不向数据库插入数据
	 * @param record
	 * @return
	 */
	@Options(useGeneratedKeys = true,keyColumn = "pid",keyProperty = "pid")
	@InsertProvider(type = PlacardSqlProvider.class,method = "insertSelective")
	int insertSelective(Placard record);
	
	/**
	 * 查询所有公告
	 * @return
	 */
	@Select({
		"select",
		"pid,pauthor,ptype,ptime,ptitle,pcontent",
		"from placard"
	})
	List<Placard> selectAll();
	
	/**
	 * 全参修改公告：考虑为null的情况，若为空，不会修改数据库中数据
	 * @param record
	 * @return
	 */
	@UpdateProvider(type = PlacardSqlProvider.class,method = "updateByPrimaryKsySelective")
	int updateByPrimaryKsySelective(Placard record);
	
	/**
	 * 全参修改公告：不考虑null情况，若为空，数据库中对应内容将重置为null
	 * @param record
	 * @return
	 */
	@Update({
		"update placard",
		"set pauthor = #{pauthor,jdbcType=VARCHAR},",
		"ptype = #{ptype,jdbcType=VARCHAR},",
		"ptime = #{ptime,jdbcType=DATE},",
		"ptitle = #{ptitle,jdbcType=VARCHAR},",
		"pcontent = #{pcontent,jdbcType=VARCHAR}",
		"where pid = #{pid,jdbcType=INTEGER}"
	})
	int updateByPrimaryKsy(Placard record);
}
