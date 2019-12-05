package com.alvin.service.select;

import  java.util.List;
import  java.util.Map;
import com.alvin.common.DaoException;
import com.alvin.dao.IpermissionDao;
import com.alvin.dao.impl.PermissionImpl;
import com.alvin.entity.Permission;

import com.alvin.common.CodeResult;

import net.sf.json.JSONObject;

/**
 @Title 		:SelectPermission.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:通过条件查询权限表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class SelectPermission {

	private IpermissionDao permissionDao;

	private JSONObject jsonObj;

	public SelectPermission(JSONObject jsonObj){
		permissionDao=new PermissionImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject getResult(Permission permission,Map<String, Object> map) throws DaoException{
		List<Permission> list=permissionDao.selectByMapPermission(permission,map);
		jsonObj.put("result",list);

		//只有第一页的时候才需要重新的统计，否则不需要再次的统计数量
		if (map.get("pageIndex")!=null&&map.get("pageIndex").equals(1)) {
			int totalCount=permissionDao.countByMapPermission(permission,map);
			jsonObj.put("total",totalCount);
		}
		CodeResult.setResult(jsonObj, 00);
		return jsonObj;
	}

}