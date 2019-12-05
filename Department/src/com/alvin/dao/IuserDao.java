package com.alvin.dao;

import com.alvin.entity.User;

import java.util.List;
import java.util.Map;
import com.alvin.common.DaoException;

/**
 @Title 		:User.java
 @Company 		:永硕
 @Package 		:com.alvin.dao
 @Description 	:用户表接口类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public interface IuserDao{
	 /**
	  * 添加
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void addUser(User user) throws DaoException;
	 /**
	  * 删除
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void delUserById(String userIds) throws DaoException;
	 /**
	  * 修改
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void updUser(User user) throws DaoException;
	 /**
	  * 查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 List<User> selectByMapUser(User user,Map<String,Object> map) throws DaoException;
	 /**
	  * 统计总数
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Integer countByMapUser(User user,Map<String,Object> map) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 User selectOneByID(Integer ID) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 User selectOneByObj(User entity) throws DaoException;

}