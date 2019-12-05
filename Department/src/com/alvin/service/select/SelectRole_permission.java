package com.alvin.service.select;

import  java.util.List;
import  java.util.Map;
import com.alvin.common.DaoException;
import com.alvin.dao.Irole_permissionDao;
import com.alvin.dao.impl.Role_permissionImpl;
import com.alvin.entity.Role_permission;

import com.alvin.common.CodeResult;

import net.sf.json.JSONObject;

/**
 @Title 		:SelectRole_permission.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:通过条件查询角色权限表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class SelectRole_permission {

	private Irole_permissionDao role_permissionDao;

	private JSONObject jsonObj;

	public SelectRole_permission(JSONObject jsonObj){
		role_permissionDao=new Role_permissionImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject getResult(Role_permission role_permission,Map<String, Object> map) throws DaoException{
		List<Role_permission> list=role_permissionDao.selectByMapRole_permission(role_permission,map);
		jsonObj.put("result",list);

		//只有第一页的时候才需要重新的统计，否则不需要再次的统计数量
		if (map.get("pageIndex")!=null&&map.get("pageIndex").equals(1)) {
			int totalCount=role_permissionDao.countByMapRole_permission(role_permission,map);
			jsonObj.put("total",totalCount);
		}
		CodeResult.setResult(jsonObj, 00);
		return jsonObj;
	}

}