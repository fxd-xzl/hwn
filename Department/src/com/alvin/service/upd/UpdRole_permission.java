package com.alvin.service.upd;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.Irole_permissionDao;
import com.alvin.common.Time_Tool;
import com.alvin.dao.impl.Role_permissionImpl;
import com.alvin.entity.Role_permission;

import net.sf.json.JSONObject;

/**
 @Title 		:UpdRole_permission.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:修改角色权限表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class UpdRole_permission {

	private Irole_permissionDao role_permissionDao;

	private JSONObject jsonObj;

	private Role_permission role_permission;

	public UpdRole_permission(JSONObject jsonObj){
		role_permissionDao=new Role_permissionImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject upd(Role_permission role_permission) throws DaoException{
		this.role_permission=role_permission;
		if(validate()==false){
			return jsonObj;
		}
		role_permissionDao.updRole_permission(role_permission);
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

		if(StringUtil.isBlank(role_permission.getRolePermissionId())){
			CodeResult.setResult(jsonObj,11,"ID"); 
			return false; 
		}
		return true; 
	}

}