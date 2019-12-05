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
import com.alvin.entity.Role_permission;
import com.alvin.service.add.AddRole_permission;
import com.alvin.service.upd.UpdRole_permission;
import com.alvin.service.select.SelectRole_permission;
import com.alvin.service.del.DelRole_permissionById;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 @Title 		:Role_permissionAction.java
 @Company 		:永硕
 @Package 		:com.alvin.action
 @Description 	:角色权限表控制器类
 @author 		:fxd
 @date 			:2019-11-28 21:13
 @version 		:版本 3.0
*/
@Controller
@RequestMapping(value={"permission"})
@Api(value="permission",description="角色权限表")
public class Role_permissionAction extends BaseAction {


	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-11-28 21:13
	 */
	 @ApiOperation(httpMethod="GET",value="添加")
	 @RequestMapping("addRole_permission")
	 public void addRole_permission(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Role_permission Role_permission) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(Role_permission, jsonObj)==false){
				return;
			}
			AddRole_permission service=new  AddRole_permission(jsonObj);
			service.add(Role_permission);

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
	 @RequestMapping("updRole_permission")
	 public void updRole_permission(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Role_permission Role_permission) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(Role_permission, jsonObj)==false){
				return;
			}
			UpdRole_permission service=new  UpdRole_permission(jsonObj);
			service.upd(Role_permission);

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
	 @RequestMapping("delRole_permission")
	 public void delRole_permission(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(ids, jsonObj)==false){
				return;
			}
			DelRole_permissionById service=new  DelRole_permissionById(jsonObj);
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
	 @RequestMapping("getRole_permissionList")
	 public void getRole_permissionList(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Role_permission Role_permission,@RequestParam String pageIndex,@RequestParam String pageSize) {
		 
		jsonObj=new JSONObject();
		 try {
			
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("pageIndex", pageIndex);
			map.put("pageSize", pageSize);
			SelectRole_permission service=new  SelectRole_permission(jsonObj);
			service.getResult(Role_permission,map);

		 } catch(Exception e) {
			e.printStackTrace();
			CodeResult.setResult(jsonObj,99);
		 }finally{
			super.out(response, jsonObj); 
		 } 
	 }
}