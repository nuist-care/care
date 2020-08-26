package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.care.entity.Bed;

import lombok.experimental.PackagePrivate;

/**
 * JPA数据访问层接口 BedRepository
 * @author ASUS
 *
 */
@Repository
public interface BedRepository extends JpaRepository<Bed, Integer>{
	
	/**
	 * 根据编号删除床位信息
	 * @param bid
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "delete from bed where bid = ?1")
	int deleteByPrimaryKey(@Param("bid")Integer bid);
	
	/**
	 * 新增床位信息
	 * @param floor
	 * @param room
	 * @param bnum
	 * @param aid
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "insert into bed(floor,room,bnum,aid) value(?1,?2,?3,?4)")
	int insert(@Param("floor")Integer floor ,@Param("room")Integer room ,@Param("bnum")Integer bnum ,@Param("aid")Integer aid);
	
	/**
	 * 查询所有客户信息
	 */
	@Query(nativeQuery = true,value = "select b.bid,b.floor,b.room,b.bnum,b.aid,c.aname from (bed b, client c) where b.aid = c.aid order by bid")
	List<Bed> findAll();
	
	/**
	 * 根据床位编号查询床位信息
	 * @param bid
	 * @return
	 */
	@Query(nativeQuery = true,value = "select b.bid,b.floor,b.room,b.bnum,b.aid,c.aname from (bed b, client c) where b.aid = c.aid and b.bid = ?1")
	Bed findByBid(Integer bid);
	
	/**
	 * 根据床位编号修改床位信息
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "update bed set aid = ?2 where bid = ?1")
	int updateByBid(@Param("bid")Integer bid,@Param("aid")Integer aid);

	/**
	 * 根据楼层号，房间号，床位号查询床位信息
	 */
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "select b.bid,b.floor,b.room,b.bnum,b.aid,c.aname from (bed b, client c) where b.aid = c.aid and b.floor=?1 and b.room=?2 and b.bnum=?3")
	List<Bed> findByFloorAndRoomAndBnum(@Param("floor")Integer floor,@Param("room")Integer room,@Param("bnum")Integer bnum);

	/**
	 * 根据客户编号查询床位信息 by马梦瑶
	 */
	Bed findByAid(Integer aid);
	
	/**
	 * 根据客户编号查询床位信息
	 * @param aid
	 * @return
	 */
	@Transactional
	@Query(nativeQuery = true,value = "select b.bid,b.floor,b.room,b.bnum,b.aid,c.aname from (bed b, client c) where b.aid = c.aid and b.aid = ?1")
	Bed findByAid2(Integer aid);
}
