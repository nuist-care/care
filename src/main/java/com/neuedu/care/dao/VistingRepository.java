package com.neuedu.care.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neuedu.care.entity.Visiting;



/**
 * Jpa访问数据层接口VistingRepository*/

@Repository
public interface VistingRepository extends JpaRepository<Visiting, Integer>{
	@Query(nativeQuery = true,value = "select v.vid,v.aid,v.aname,v.vhospital,v.vtime,v.vroom,v.vresult from visiting v where v.vid like concat('%',?1,'%') or v.aid like concat('%',?2,'%') or v.aname like concat('%',?3,'%')")
	List<Visiting> findByVidAidAname(@Param("vid")Integer vid,@Param("aid")Integer aid,@Param("aname")String aname);

}
