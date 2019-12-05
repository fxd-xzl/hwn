package com.alvin.service.add;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.Irole_permissionDao;
import com.alvin.dao.impl.Role_permissionImpl;
import com.alvin.entity.Role_permission;

import net.sf.json.JSONObject;

/**
 @Title 		:AddRole_permission.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:添加角色权限表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class AddRole_permission {

	private Irole_permissionDao role_permissionDao;

	private JSONObject jsonObj;

	private Role_permission role_permission;

	public AddRole_permission(JSONObject jsonObj){
		role_permissionDao=new Role_permissionImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject add(Role_permission role_permission) throws DaoException{
		this.role_permission=role_permission;
		if(validate()==false){
			return jsonObj;
		}
		role_permissionDao.addRole_permission(role_permission);
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

		if(StringUtil.isBlank(role_permission.getRoleId())){
			CodeResult.setResult(jsonObj,11,"角色ID"); 
			return false; 
		}
		if(StringUtil.isBlank(role_permission.getPermissionId())){
			CodeResult.setResult(jsonObj,11,"权限编号"); 
			return false; 
		}
		return true; 
	}

}