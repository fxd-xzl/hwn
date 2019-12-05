package com.alvin.service.del;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.Irole_permissionDao;
import com.alvin.dao.impl.Role_permissionImpl;

import net.sf.json.JSONObject;

/**
 @Title 		:DelRole_permissionById.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:通过编号删除角色权限表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class DelRole_permissionById {

	private Irole_permissionDao role_permissionDao;

	private JSONObject jsonObj;

	public DelRole_permissionById(JSONObject jsonObj){
		role_permissionDao=new Role_permissionImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject del(String ids) throws DaoException{
		 //把最后的逗号切割掉
		ids=StringUtil.splitLastStr(ids, ",");
		role_permissionDao.delRole_permissionById(ids);
		CodeResult.setResult(jsonObj,00,"删除");
		return jsonObj;	

	}

}