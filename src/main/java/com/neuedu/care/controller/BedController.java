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
import com.neuedu.care.entity.Bed;
import com.neuedu.care.service.BedService;

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
	
//	/**
//	 * 新增床位
//	 * @param bed
//	 * @param bindingResult
//	 * @return
//	 */
//	@PostMapping(value = "/insert")
//    public ResultBean insert(@Validated Bed bed,BindingResult bindingResult){
//  	ResultBean r = new ResultBean();
//  	if (bindingResult.hasErrors()) {
//  		StringBuffer msg = new StringBuffer();
//  		for (FieldError f:bindingResult.getFieldErrors()) {
//				msg.append(f.getField() + ":" + f.getDefaultMessage() + "\n");
//			}
//  		    r = new ResultBean(500,false,msg.toString(),null);
//  		    return r;
//		}
//     	Bed b= bedService.insert(bed);
//		if (b != null) {
//			r = new ResultBean(200,true,"新增床位成功~~\n新增床位编号为" + bed.getBid() ,null);
//		}else {
//			r = new ResultBean(500,false,"新增床位失败",null);
//		}
//  	return r;
//	}
	
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
	@PutMapping(value = "/update/{bid}/{aid}")
    public ResultBean update(@PathVariable("bid")Integer bid,@PathVariable("aid")Integer aid){
  	    ResultBean r = null;
  	    boolean flag = bedService.update(bid, aid);
	    if (flag) {
			r = new ResultBean(200,true,"修改床位成功",null);
		}else {
			r = new ResultBean(500,false,"修改床位失败",null);
		}
  	return r;
	}
	
//	/**
//	 * 删除床位信息
//	 * @param bid
//	 * @return
//	 */
//	@DeleteMapping(value = "/delete/{bid}")
//    public ResultBean delete(@PathVariable("bid")Integer bid) {
//   	int line = bedService.delete(bid);
//   	ResultBean r = null;
//   	if (line == 1) {
//			r = new ResultBean(200,true,"删除床位成功",null);
//		}else {
//			r = new ResultBean(500,false,"删除床位失败",null);
//		}
//   	return r;
//	}
	
	/**
	  * 根据楼层号，房间号，
	  * @param pid
	  * @param pauthor
	  * @param ptype
	  * @return
	  */
	 @ApiOperation(value="根据部门编号，作者，类型组合模糊查询")
	 @GetMapping(value = "/find")
	 public ResultBean find(Integer floor,Integer room,Integer bnum) {
	 	List<Bed> beds = bedService.findByFloorAndRoomAndBnum(floor, room, bnum);
	  	ResultBean r = new ResultBean(200, true, "组合模糊查询成功", beds);
	   	return r;
    }
}
