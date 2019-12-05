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
import com.alvin.entity.Role;
import com.alvin.service.add.AddRole;
import com.alvin.service.upd.UpdRole;
import com.alvin.service.select.SelectRole;
import com.alvin.service.del.DelRoleById;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 @Title 		:RoleAction.java
 @Company 		:永硕
 @Package 		:com.alvin.action
 @Description 	:角色表控制器类
 @author 		:fxd
 @date 			:2019-11-28 21:13
 @version 		:版本 3.0
*/
@Controller
@RequestMapping(value={"role"})
@Api(value="role",description="角色表")
public class RoleAction extends BaseAction {


	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-11-28 21:13
	 */
	 @ApiOperation(httpMethod="GET",value="添加")
	 @RequestMapping("addRole")
	 public void addRole(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Role Role) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(Role, jsonObj)==false){
				return;
			}
			AddRole service=new  AddRole(jsonObj);
			service.add(Role);

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
	 @RequestMapping("updRole")
	 public void updRole(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Role Role) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(Role, jsonObj)==false){
				return ;
			}
			UpdRole service=new  UpdRole(jsonObj);
			service.upd(Role);

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
	 @RequestMapping("delRole")
	 public void delRole(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(ids, jsonObj)==false){
				return;
			}
			DelRoleById service=new  DelRoleById(jsonObj);
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
	 @RequestMapping("getRoleList")
	 public void getRoleList(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Role Role,@RequestParam Integer pageIndex,@RequestParam Integer pageSize) {
		 
		jsonObj=new JSONObject();
		 try {
			
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("pageIndex", pageIndex);
			map.put("pageSize", pageSize);
			SelectRole service=new  SelectRole(jsonObj);
			service.getResult(Role,map);

		 } catch(Exception e) {
			e.printStackTrace();
			CodeResult.setResult(jsonObj,99);
		 }finally{
			super.out(response, jsonObj); 
		 } 
	 }
}