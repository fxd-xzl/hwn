package com.alvin.dao;

import com.alvin.entity.Role;

import java.util.List;
import java.util.Map;
import com.alvin.common.DaoException;

/**
 @Title 		:Role.java
 @Company 		:永硕
 @Package 		:com.alvin.dao
 @Description 	:角色表接口类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public interface IroleDao{
	 /**
	  * 添加
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void addRole(Role role) throws DaoException;
	 /**
	  * 删除
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void delRoleById(String roleIds) throws DaoException;
	 /**
	  * 修改
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void updRole(Role role) throws DaoException;
	 /**
	  * 查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 List<Role> selectByMapRole(Role role,Map<String,Object> map) throws DaoException;
	 /**
	  * 统计总数
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Integer countByMapRole(Role role,Map<String,Object> map) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Role selectOneByID(Integer ID) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Role selectOneByObj(Role entity) throws DaoException;

}