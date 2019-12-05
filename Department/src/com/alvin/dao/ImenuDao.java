package com.alvin.dao;

import com.alvin.entity.Menu;

import java.util.List;
import java.util.Map;
import com.alvin.common.DaoException;

/**
 @Title 		:Menu.java
 @Company 		:永硕
 @Package 		:com.alvin.dao
 @Description 	:菜单表接口类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public interface ImenuDao{
	 /**
	  * 添加
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void addMenu(Menu menu) throws DaoException;
	 /**
	  * 删除
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void delMenuById(String menuIds) throws DaoException;
	 /**
	  * 修改
	  * @author  alvin
	  * @return
	  *@since
	 */
	 void updMenu(Menu menu) throws DaoException;
	 /**
	  * 查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 List<Menu> selectByMapMenu(Menu menu,Map<String,Object> map) throws DaoException;
	 /**
	  * 统计总数
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Integer countByMapMenu(Menu menu,Map<String,Object> map) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Menu selectOneByID(Integer ID) throws DaoException;
	 /**
	  * 通过编号查询
	  * @author  alvin
	  * @return
	  *@since
	 */
	 Menu selectOneByObj(Menu entity) throws DaoException;

}