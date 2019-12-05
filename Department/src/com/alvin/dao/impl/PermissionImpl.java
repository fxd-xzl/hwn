package com.alvin.dao.impl;

import com.alvin.dao.DBSource;
import java.util.List;
import java.util.Map;
import com.alvin.dao.IpermissionDao;
import com.alvin.entity.Permission;
import com.alvin.common.ObjectConvertStr;
import com.alvin.common.DaoException;

/**
 @Title 		:IpermissionDao.java
 @Company 		:永硕
 @Package 		:com.alvin.dao.impl
 @Description 	:权限表接口实现类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class PermissionImpl extends DBSource implements IpermissionDao{

	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void addPermission(Permission permission) throws DaoException{
		 String sql="insert into permission(permissionName,menuId,styleID) values(?,?,?)";
		 Object[] pramas = { permission.getPermissionName(),permission.getMenuId(),permission.getStyleID()};
		 super.getSql().executeUpdate(sql,  pramas); 
	 };
	 /**
	  * 通过编号删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void delPermissionById(String permissionIds) throws DaoException{
		 String sql="delete from  permission where permissionId in("+permissionIds+")";
		 super.getSql().executeUpdate(sql); 
	 }
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void updPermission(Permission permission) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("update permission set permissionId=permissionId");
		 ObjectConvertStr.cUpdSql(permission,sql);
		 sql.append(" where permissionId="+permission.getPermissionId()); 

		super.getSql().executeUpdate(sql.toString()); 
	 }
	 /**
	  * 通过条件查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public List<Permission> selectByMapPermission(Permission permission,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from permission where 1=1");
		 commonSqlByMap(permission,map,sql); 
		 return super.getSql().selectList(sql.toString(), Permission.class);
		 
	 }
	 /**
	  * 公共的条件转换sql
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private String commonSqlByMap(Permission Permission,Map<String,Object> map,StringBuffer sql) {
		 
		 ObjectConvertStr.cSelectSql(Permission,sql,true);
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
	public Integer countByMapPermission(Permission permission,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select count(1) as count from permission where 1=1");
		 commonSqlByMap(permission,map,sql); 
		 return super.getSql().selectCount(sql.toString());
		 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Permission selectOneByID(Integer ID)throws DaoException {
		 
		String sql="select * from permission where  permissionId="+ID;
		return super.getSql().selectOne(sql, Permission.class); 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Permission selectOneByObj(Permission entity)throws DaoException {
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from permission where 1=1 ");
		 commonSqlByMap(entity,null,sql); 

		return super.getSql().selectOne(sql.toString(), Permission.class); 
	 }
}