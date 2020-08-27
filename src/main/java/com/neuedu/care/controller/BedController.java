package com.neuedu.care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.care.bean.ResultBean;
import com.neuedu.care.dao.BedRepository;
import com.neuedu.care.dao.ClientRepository;
import com.neuedu.care.entity.Bed;
import com.neuedu.care.entity.Client;
import com.neuedu.care.service.BedService;
import com.neuedu.care.service.ClientService;
import com.neuedu.care.service.impl.ClientServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 床位控制器
 * @author ASUS
 *
 */
@RestController
@Api(tags = "床位控制器")
@RequestMapping(value = "bed")
public class BedController {
	@Autowired
	private BedService bedService;
	@Autowired
	private BedRepository bedRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	/**
	 * 显示所有床位信息页面
	 * @return
	 */
	@ApiOperation(value = "显示所有床位信息页面")
	@GetMapping(value = "/list")
	public ResultBean list() {
		List<Bed> beds = bedService.selectAll();
		System.out.println("请求所有床位信息：" + beds);
		ResultBean r = new ResultBean(200,true,"查询所有床位成功",beds);
		return r;
	}
	
	/**
	 * 新增床位
	 * @param bed
	 * @return
	 */
	@ApiOperation(value = " 新增床位")
	@PostMapping(value = "/insert")
    public ResultBean insert(@Validated Integer floor,@Validated Integer room,@Validated Integer bnum,@Validated Integer aid){
  	    ResultBean r = null;
  	    System.out.println("判断开始");
  	    //客户必须存在客户表中
  	  String n = clientRepository.findByAid2(aid);
	 	System.out.println(n);
		if (null == n) {
			return r = new ResultBean(5005,false,"客户不存在",null);
		}
		//一个客户只能有一张床位
		Bed b = bedRepository.findByAid2(aid);
		if (null != b) {
			return r = new ResultBean(5005,false,"客户已拥有床位",null);
		}
		//楼层号：1-6
		if (floor <1 && floor > 6) {
			return r = new ResultBean(5005,false,"楼层号错误",null);
		}
		//房间号：1-10
		if (room < 1 && room > 10) {
			return r = new ResultBean(5005,false,"房间号错误",null);
		}
		//床位号：1-2
		if (bnum < 1 && bnum > 2) {
			return r = new ResultBean(5005,false,"床位号错误",null);
		}
		System.out.println("判断结束");
		boolean flag = bedService.insert(floor, room, bnum, aid);
     	Bed bed = bedRepository.findByAid2(aid);
		if (flag) {
			r = new ResultBean(200,true,"新增床位成功~~\n新增床位编号为" + bed.getBid() ,null);
		}else {
			r = new ResultBean(500,false,"新增床位失败",null);
		}
		System.out.println(r);
  	    return r;
	}
	
	/**
	 * 根据编号查询床位信息
	 * @param bid
	 * @return
	 */
	@ApiOperation(value="根据编号查询床位信息")
    @GetMapping(value = "/{bid}")
    public ResultBean detail(@PathVariable("bid")Integer bid) {
		Bed bed = bedService.selectByBid(bid);
		ResultBean r = new ResultBean(200,true,"查询成功",bed);
		return r;
	}
	
	/**
	 * 修改床位信息
	 * @param bid
	 * @param aid
	 * @return
	 */
	@ApiOperation(value="根据编号修改床位客户")
	@PutMapping(value = "/update/{bid}/{aid}")
    public ResultBean update(@PathVariable("bid")Integer bid,@PathVariable("aid")Integer aid){
  	    ResultBean r = null;
  	    System.out.println("判断开始");
  	    //客户必须存在客户表中
  	    String n = clientRepository.findByAid2(aid);
	 	System.out.println("客户名称:" + n);
		if (n == null) {
			return r = new ResultBean(5005,false,"客户不存在",null);
		}
		//一个客户只能有一张床位
		Bed b = bedRepository.findByAid2(aid);
		if (null != b) {
			return r = new ResultBean(5005,false,"客户已拥有床位",null);
		}
  	    System.out.println("判断结束");
  	    boolean flag = bedService.update(bid, aid);
	    if (flag) {
			r = new ResultBean(200,true,"修改床位成功",null);
		}else {
			r = new ResultBean(500,false,"修改床位失败",null);
		}
  	return r;
	}
	
	/**
	 * 删除床位信息
	 * @param bid
	 * @return
	 */
	@ApiOperation(value="根据编号删除床位信息")
	@DeleteMapping(value = "/delete/{bid}")
    public ResultBean delete(@PathVariable("bid")Integer bid) {
		boolean flag = bedService.delete(bid);
		System.out.println("删除开始");
	   	ResultBean r = null;
	   	if (flag) {
				r = new ResultBean(200,true,"删除床位成功",null);
			}else {
				r = new ResultBean(500,false,"删除床位失败",null);
			}
	   	return r;
	}
	
	/**
	  * 根据楼层号，房间号，床位号查询
	  * @param pid
	  * @param pauthor
	  * @param ptype
	  * @return
	  */
	 @ApiOperation(value="根据楼层号，房间号，床位号查询")
	 @GetMapping(value = "/find")
	 public ResultBean find(Integer floor,Integer room,Integer bnum) {
	 	List<Bed> beds = bedService.findByFloorAndRoomAndBnum(floor, room, bnum);
	  	ResultBean r = new ResultBean(200, true, "组合模糊查询成功", beds);
	   	return r;
    }
}
