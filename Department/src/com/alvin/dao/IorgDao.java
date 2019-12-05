package com.alvin.dao;

import com.alvin.entity.Org;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import com.alvin.common.DaoException;

/**
 @Title 		:Org.java
 @Company 		:永硕
 @Package 		:com.alvin.dao
 @Description 	:接口类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public interface IorgDao{
	 /**
	  * 添加
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Integer addOrg(Org org,Connection conn) throws DaoException;
	 /**
	  * 删除
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void delOrgById(String orgIds) throws DaoException;
	 /**
	  * 修改
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void updOrg(Org org) throws DaoException;
	 /**
	  * 查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 List<Org> selectByMapOrg(Org org,Map<String,Object> map) throws DaoException;
	 /**
	  * 统计总数
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Integer countByMapOrg(Org org,Map<String,Object> map) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Org selectOneByID(Integer ID) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Org selectOneByObj(Org entity) throws DaoException;

}