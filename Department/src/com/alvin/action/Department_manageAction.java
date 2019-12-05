package com.alvin.action;

import java.util.HashMap;import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import net.sf.json.JSONObject;

import com.alvin.common.CodeResult;
import com.alvin.entity.Department_manage;
import com.alvin.service.add.AddDepartment_manage;
import com.alvin.service.upd.UpdDepartment_manage;
import com.alvin.service.select.SelectDepartment_manage;
import com.alvin.service.del.DelDepartment_manageById;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 @Title 		:Department_manageAction.java
 @Company 		:永硕
 @Package 		:com.alvin.action
 @Description 	:控制器类
 @author 		:fxd
 @date 			:2019-11-28 21:13
 @version 		:版本 3.0
*/
@Controller
@RequestMapping(value={"manage"})
@Api(value="manage",description="")
public class Department_manageAction extends BaseAction {


	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-11-28 21:13
	 */
	 @ApiOperation(httpMethod="GET",value="添加")
	 @RequestMapping("addDepartment_manage")
	 public void addDepartment_manage(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Department_manage Department_manage) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(Department_manage, jsonObj)==false){
				return;
			}
			AddDepartment_manage service=new  AddDepartment_manage(jsonObj);
			service.add(Department_manage);

		 } catch(Exception e) {
			e.printStackTrace();
			CodeResult.setResult(jsonObj,99);
		 }finally{
			super.out(response, jsonObj); 
		 } 
	 }
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-11-28 21:13
	 */
	 @ApiOperation(httpMethod="GET",value="修改")
	 @RequestMapping("updDepartment_manage")
	 public void updDepartment_manage(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Department_manage Department_manage) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(Department_manage, jsonObj)==false){
				return;
			}
			UpdDepartment_manage service=new  UpdDepartment_manage(jsonObj);
			service.upd(Department_manage);

		 } catch(Exception e) {
			e.printStackTrace();
			CodeResult.setResult(jsonObj,99);
		 }finally{
			super.out(response, jsonObj); 
		 } 
	 }
	 /**
	  * 删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-11-28 21:13
	 */
	 @ApiOperation(httpMethod="GET",value="删除")
	 @RequestMapping("delDepartment_manage")
	 public void delDepartment_manage(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(ids, jsonObj)==false){
				return;
			}
			DelDepartment_manageById service=new  DelDepartment_manageById(jsonObj);
			service.del(ids);

		 } catch(Exception e) {
			e.printStackTrace();
			CodeResult.setResult(jsonObj,99);
		 }finally{
			super.out(response, jsonObj); 
		 } 
	 }
	 /**
	  * 通过条件查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-11-28 21:13
	 */
	 @ApiOperation(httpMethod="GET",value="分页查询")
	 @RequestMapping("getDepartment_manageList")
	 public void getDepartment_manageList(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Department_manage Department_manage,@RequestParam Integer pageIndex,@RequestParam Integer pageSize) {
		 
		jsonObj=new JSONObject();
		 try {
			
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("pageIndex", pageIndex);
			map.put("pageSize", pageSize);
			SelectDepartment_manage service=new  SelectDepartment_manage(jsonObj);
			service.getResult(Department_manage,map);

		 } catch(Exception e) {
			e.printStackTrace();
			CodeResult.setResult(jsonObj,99);
		 }finally{
			super.out(response, jsonObj); 
		 } 
	 }
}