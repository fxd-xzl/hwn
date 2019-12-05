package com.alvin.service.upd;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.IpermissionDao;
import com.alvin.common.Time_Tool;
import com.alvin.dao.impl.PermissionImpl;
import com.alvin.entity.Permission;

import net.sf.json.JSONObject;

/**
 @Title 		:UpdPermission.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:修改权限表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class UpdPermission {

	private IpermissionDao permissionDao;

	private JSONObject jsonObj;

	private Permission permission;

	public UpdPermission(JSONObject jsonObj){
		permissionDao=new PermissionImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject upd(Permission permission) throws DaoException{
		this.permission=permission;
		if(validate()==false){
			return jsonObj;
		}
		permissionDao.updPermission(permission);
		CodeResult.setResult(jsonObj,00,"修改");
		return jsonObj;
	}

	
	 /**
	  * 验证
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private Boolean validate(){ 

		if(StringUtil.isBlank(permission.getPermissionId())){
			CodeResult.setResult(jsonObj,11,"权限编号"); 
			return false; 
		}
		return true; 
	}

}