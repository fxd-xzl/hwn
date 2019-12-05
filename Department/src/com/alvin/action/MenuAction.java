package com.alvin.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alvin.common.CodeResult;
import com.alvin.entity.Menu;
import com.alvin.service.select.SelectMenu;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

/**
 @Title 		:MenuAction.java
 @Company 		:永硕
 @Package 		:com.alvin.action
 @Description 	:菜单表控制器类
 @author 		:fxd
 @date 			:2019-11-28 21:13
 @version 		:版本 3.0
*/
@Controller
@RequestMapping(value={"menu"})
@Api(value="menu",description="菜单表")
public class MenuAction extends BaseAction {

 
	 /**
	  * 通过条件查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-11-28 21:13
	 */
	 @ApiOperation(httpMethod="GET",value="分页查询")
	 @RequestMapping("getMenuList")
	 public void getMenuList(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Menu Menu,@RequestParam String pageIndex,@RequestParam String pageSize) {
		 
		jsonObj=new JSONObject();
		 try {
			
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("pageIndex", pageIndex);
			map.put("pageSize", pageSize);
			SelectMenu service=new  SelectMenu(jsonObj);
			service.getResult(Menu,map);

		 } catch(Exception e) {
			e.printStackTrace();
			CodeResult.setResult(jsonObj,99);
		 }finally{
			super.out(response, jsonObj); 
		 } 
	 }
}