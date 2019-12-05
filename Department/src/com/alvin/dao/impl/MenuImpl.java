package com.alvin.dao.impl;

import com.alvin.dao.DBSource;
import java.util.List;
import java.util.Map;
import com.alvin.dao.ImenuDao;
import com.alvin.entity.Menu;
import com.alvin.common.ObjectConvertStr;
import com.alvin.common.DaoException;

/**
 @Title 		:ImenuDao.java
 @Company 		:永硕
 @Package 		:com.alvin.dao.impl
 @Description 	:菜单表接口实现类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class MenuImpl extends DBSource implements ImenuDao{

	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void addMenu(Menu menu) throws DaoException{
		 String sql="insert into menu(menuId,menuTitle,menuIcon,menuTo,pid,orgId) values(?,?,?,?,?,?)";
		 Object[] pramas = { menu.getMenuId(),menu.getMenuTitle(),menu.getMenuIcon(),menu.getMenuTo(),menu.getPid(),menu.getOrgId()};
		 super.getSql().executeUpdate(sql,  pramas); 
	 };
	 /**
	  * 通过编号删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void delMenuById(String menuIds) throws DaoException{
		 String sql="delete from  menu where menuId in("+menuIds+")";
		 super.getSql().executeUpdate(sql); 
	 }
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void updMenu(Menu menu) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("update menu set menuId=menuId");
		 ObjectConvertStr.cUpdSql(menu,sql);
		 sql.append(" where menuId="+menu.getMenuId()); 

		super.getSql().executeUpdate(sql.toString()); 
	 }
	 /**
	  * 通过条件查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public List<Menu> selectByMapMenu(Menu menu,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from menu where 1=1");
		 commonSqlByMap(menu,map,sql); 
		 return super.getSql().selectList(sql.toString(), Menu.class);
		 
	 }
	 /**
	  * 公共的条件转换sql
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private String commonSqlByMap(Menu Menu,Map<String,Object> map,StringBuffer sql) {
		 
		 ObjectConvertStr.cSelectSql(Menu,sql,true);
		if(map==null){
			return sql.toString();
		};
		if(map.get("pageIndex")!=null&&!map.get("pageIndex").equals("")){
			Integer pageindex = Integer.parseInt(map.get("pageIndex").toString());
			Integer pagesize = Integer.parseInt(map.get("pageSize").toString());
			sql.append(" limit "+ ((pageindex - 1) * pagesize)+","+pagesize);
		}
		return sql.toString(); 
	 }
	 /**
	  * 通过条件查询数量
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public Integer countByMapMenu(Menu menu,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select count(1) as count from menu where 1=1");
		 commonSqlByMap(menu,map,sql); 
		 return super.getSql().selectCount(sql.toString());
		 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Menu selectOneByID(Integer ID)throws DaoException {
		 
		String sql="select * from menu where  menuId="+ID;
		return super.getSql().selectOne(sql, Menu.class); 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Menu selectOneByObj(Menu entity)throws DaoException {
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from menu where 1=1 ");
		 commonSqlByMap(entity,null,sql); 

		return super.getSql().selectOne(sql.toString(), Menu.class); 
	 }
}