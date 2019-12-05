package com.alvin.dao;

import com.alvin.entity.Permission;

import java.util.List;
import java.util.Map;
import com.alvin.common.DaoException;

/**
 @Title 		:Permission.java
 @Company 		:永硕
 @Package 		:com.alvin.dao
 @Description 	:权限表接口类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public interface IpermissionDao{
	 /**
	  * 添加
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void addPermission(Permission permission) throws DaoException;
	 /**
	  * 删除
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void delPermissionById(String permissionIds) throws DaoException;
	 /**
	  * 修改
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void updPermission(Permission permission) throws DaoException;
	 /**
	  * 查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 List<Permission> selectByMapPermission(Permission permission,Map<String,Object> map) throws DaoException;
	 /**
	  * 统计总数
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Integer countByMapPermission(Permission permission,Map<String,Object> map) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Permission selectOneByID(Integer ID) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Permission selectOneByObj(Permission entity) throws DaoException;

}