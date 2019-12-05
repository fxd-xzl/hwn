package com.alvin.dao;

import com.alvin.entity.Role_permission;

import java.util.List;
import java.util.Map;
import com.alvin.common.DaoException;

/**
 @Title 		:Role_permission.java
 @Company 		:永硕
 @Package 		:com.alvin.dao
 @Description 	:角色权限表接口类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public interface Irole_permissionDao{
	 /**
	  * 添加
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void addRole_permission(Role_permission role_permission) throws DaoException;
	 /**
	  * 删除
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void delRole_permissionById(String rolePermissionIds) throws DaoException;
	 /**
	  * 修改
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void updRole_permission(Role_permission role_permission) throws DaoException;
	 /**
	  * 查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 List<Role_permission> selectByMapRole_permission(Role_permission role_permission,Map<String,Object> map) throws DaoException;
	 /**
	  * 统计总数
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Integer countByMapRole_permission(Role_permission role_permission,Map<String,Object> map) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Role_permission selectOneByID(Integer ID) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Role_permission selectOneByObj(Role_permission entity) throws DaoException;

}