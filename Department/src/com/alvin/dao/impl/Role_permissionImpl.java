package com.alvin.dao.impl;

import com.alvin.dao.DBSource;
import java.util.List;
import java.util.Map;
import com.alvin.dao.Irole_permissionDao;
import com.alvin.entity.Role_permission;
import com.alvin.common.ObjectConvertStr;
import com.alvin.common.DaoException;

/**
 @Title 		:Irole_permissionDao.java
 @Company 		:永硕
 @Package 		:com.alvin.dao.impl
 @Description 	:角色权限表接口实现类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class Role_permissionImpl extends DBSource implements Irole_permissionDao{

	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void addRole_permission(Role_permission role_permission) throws DaoException{
		 String sql="insert into role_permission(roleId,permissionId) values(?,?)";
		 Object[] pramas = { role_permission.getRoleId(),role_permission.getPermissionId()};
		 super.getSql().executeUpdate(sql,  pramas); 
	 };
	 /**
	  * 通过编号删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void delRole_permissionById(String rolePermissionIds) throws DaoException{
		 String sql="delete from  role_permission where rolePermissionId in("+rolePermissionIds+")";
		 super.getSql().executeUpdate(sql); 
	 }
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void updRole_permission(Role_permission role_permission) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("update role_permission set rolePermissionId=rolePermissionId");
		 ObjectConvertStr.cUpdSql(role_permission,sql);
		 sql.append(" where rolePermissionId="+role_permission.getRolePermissionId()); 

		super.getSql().executeUpdate(sql.toString()); 
	 }
	 /**
	  * 通过条件查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public List<Role_permission> selectByMapRole_permission(Role_permission role_permission,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from role_permission where 1=1");
		 commonSqlByMap(role_permission,map,sql); 
		 return super.getSql().selectList(sql.toString(), Role_permission.class);
		 
	 }
	 /**
	  * 公共的条件转换sql
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private String commonSqlByMap(Role_permission Role_permission,Map<String,Object> map,StringBuffer sql) {
		 
		 ObjectConvertStr.cSelectSql(Role_permission,sql,true);
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
	public Integer countByMapRole_permission(Role_permission role_permission,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select count(1) as count from role_permission where 1=1");
		 commonSqlByMap(role_permission,map,sql); 
		 return super.getSql().selectCount(sql.toString());
		 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Role_permission selectOneByID(Integer ID)throws DaoException {
		 
		String sql="select * from role_permission where  rolePermissionId="+ID;
		return super.getSql().selectOne(sql, Role_permission.class); 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Role_permission selectOneByObj(Role_permission entity)throws DaoException {
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from role_permission where 1=1 ");
		 commonSqlByMap(entity,null,sql); 

		return super.getSql().selectOne(sql.toString(), Role_permission.class); 
	 }
}