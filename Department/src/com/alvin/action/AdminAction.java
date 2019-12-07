package com.alvin.action;

import java.util.HashMap;import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import net.sf.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alvin.common.CodeResult;
import com.alvin.common.Config_Xml;
import com.alvin.common.HttpsRequest;
import com.alvin.common.StringUtil;
import com.alvin.entity.Admin;
import com.alvin.service.add.AddAdmin;
import com.alvin.service.upd.UpdAdmin;
import com.alvin.service.select.SelectAdmin;
import com.alvin.service.del.DelAdminById;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 @Title 		:AdminAction.java
 @Company 		:永硕
 @Package 		:com.alvin.action
 @Description 	:管理人员表控制器类
 @author 		:fxd
 @date 			:2019-11-28 21:13
 @version 		:版本 3.0
*/
@Controller
@RequestMapping(value={"admin"})
@Api(value="admin",description="管理人员表")
public class AdminAction extends BaseAction {


	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-11-28 21:13
	 */
	 @ApiOperation(httpMethod="GET",value="添加")
	 @RequestMapping("addAdmin")
	 public void addAdmin(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Admin admin) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(admin, jsonObj)==false){
				return;
			}
			AddAdmin service=new  AddAdmin(jsonObj);
			service.add(admin);
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
	 @RequestMapping("updAdmin")
	 public void updAdmin(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Admin admin) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(admin, jsonObj)){
				return;
			}
			UpdAdmin service=new  UpdAdmin(jsonObj);
			service.upd(admin);

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
	 @RequestMapping("delAdmin")
	 public void delAdmin(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		 
		jsonObj=new JSONObject();
		 try {
			
			//如果不为空
			if(validateIsNotNull(ids, jsonObj)==false){
				return;
			}
			DelAdminById service=new  DelAdminById(jsonObj);
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
	 @RequestMapping("getAdminList")
	 public void getAdminList(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Admin admin,@RequestParam Integer pageIndex,@RequestParam Integer pageSize) {
		 
		jsonObj=new JSONObject();
		 try {
			
			Map<String, Object> map=new HashMap<String, Object>(2);
			map.put("pageIndex", pageIndex);
			map.put("pageSize", pageSize);
			SelectAdmin service=new  SelectAdmin(jsonObj);
			service.getResult(admin,map);

		 } catch(Exception e) {
			e.printStackTrace();
			CodeResult.setResult(jsonObj,99);
		 }finally{
			super.out(response, jsonObj); 
		 } 
	 }
	 
	 /**
	  * 获取管理员信息
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-11-28 21:13
	 */
	 @ApiOperation(httpMethod="GET",value="通过token获取管理员信息")
	 @RequestMapping("getAdminInfo")
	 public void getAdminInfo(HttpServletRequest request,HttpServletResponse response,@RequestParam String token){
		 JSONObject jsonObj = new JSONObject();
		try {	
			jsonObj=HttpsRequest.httpRequest(Config_Xml.LoginService+"admin/getAdminInfo", "POST","type=2&token="+token);
			if (jsonObj!=null) {
				Admin admin=JSON.parseObject(jsonObj.toString(),new TypeReference<Admin>(){});
				request.getSession().setAttribute(ADMIN_SESSION, admin);
				return;
			}
			else{
				jsonObj=new JSONObject();
				CodeResult.setResult(jsonObj, 99);
			}
		} catch (Exception e) {
			CodeResult.setResult(jsonObj, 99);
			e.printStackTrace();
		} finally {
			super.out(response, jsonObj);
		}
	 }
	 
}