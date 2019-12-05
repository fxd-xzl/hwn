package com.alvin.service.add;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.IpermissionDao;
import com.alvin.dao.impl.PermissionImpl;
import com.alvin.entity.Permission;

import net.sf.json.JSONObject;

/**
 @Title 		:AddPermission.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:添加权限表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class AddPermission {

	private IpermissionDao permissionDao;

	private JSONObject jsonObj;

	private Permission permission;

	public AddPermission(JSONObject jsonObj){
		permissionDao=new PermissionImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject add(Permission permission) throws DaoException{
		this.permission=permission;
		if(validate()==false){
			return jsonObj;
		}
		permissionDao.addPermission(permission);
		CodeResult.setResult(jsonObj,00,"添加");
		return jsonObj;
	}

	
	 /**
	  * 验证
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private Boolean validate(){ 

		if(StringUtil.isBlank(permission.getPermissionName())){
			CodeResult.setResult(jsonObj,11,"权限名称 "); 
			return false; 
		}
		if(StringUtil.isBlank(permission.getMenuId())){
			CodeResult.setResult(jsonObj,11,"所在页面ID"); 
			return false; 
		}
		if(StringUtil.isBlank(permission.getStyleID())){
			CodeResult.setResult(jsonObj,11,"前端样式编号"); 
			return false; 
		}
		return true; 
	}

}