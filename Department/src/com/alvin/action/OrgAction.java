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
import com.alvin.entity.Org;
import com.alvin.service.add.AddOrg;
import com.alvin.service.upd.UpdOrg;
import com.alvin.service.select.SelectOrg;
import com.alvin.service.del.DelOrgById;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 @Title 		:OrgAction.java
 @Company 		:永硕
 @Package 		:com.alvin.action
 @Description 	:控制器类
 @author 		:fxd
 @date 			:2019-11-28 21:13
 @version 		:版本 3.0
*/
@Controller
@RequestMapping(value={"org"})
@Api(value="org",description="")
public class OrgAction extends BaseAction {


	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-11-28 21:13
	 */
	 @ApiOperation(httpMethod="GET",value="添加")
	 @RequestMapping("addOrg")
	 public void addOrg(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Org Org) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(Org, jsonObj)==false){
				return;
			}
			AddOrg service=new  AddOrg(jsonObj);
			service.add(Org);
			

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
	 @RequestMapping("updOrg")
	 public void updOrg(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Org Org) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(Org, jsonObj)==false){
				return;
			}
			UpdOrg service=new  UpdOrg(jsonObj);
			service.upd(Org);

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
	 @RequestMapping("delOrg")
	 public void delOrg(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(ids, jsonObj)==false){
				return;
			}
			DelOrgById service=new  DelOrgById(jsonObj);
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
	 @RequestMapping("getOrgList")
	 public void getOrgList(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Org Org,@RequestParam Integer pageIndex,@RequestParam Integer pageSize) {
		 
		jsonObj=new JSONObject();
		 try {
			
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("pageIndex", pageIndex);
			map.put("pageSize", pageSize);
			SelectOrg service=new  SelectOrg(jsonObj);
			service.getResult(Org,map);

		 } catch(Exception e) {
			e.printStackTrace();
			CodeResult.setResult(jsonObj,99);
		 }finally{
			super.out(response, jsonObj); 
		 } 
	 }
}