package com.alvin.dao;

import com.alvin.entity.Department_manage;

import java.util.List;
import java.util.Map;
import com.alvin.common.DaoException;

/**
 @Title 		:Department_manage.java
 @Company 		:永硕
 @Package 		:com.alvin.dao
 @Description 	:接口类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public interface Idepartment_manageDao{
	 /**
	  * 添加
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void addDepartment_manage(Department_manage department_manage) throws DaoException;
	 /**
	  * 删除
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void delDepartment_manageById(String departmentManageIds) throws DaoException;
	 /**
	  * 修改
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void updDepartment_manage(Department_manage department_manage) throws DaoException;
	 /**
	  * 查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 List<Department_manage> selectByMapDepartment_manage(Department_manage department_manage,Map<String,Object> map) throws DaoException;
	 /**
	  * 统计总数
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Integer countByMapDepartment_manage(Department_manage department_manage,Map<String,Object> map) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Department_manage selectOneByID(Integer ID) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Department_manage selectOneByObj(Department_manage entity) throws DaoException;

}