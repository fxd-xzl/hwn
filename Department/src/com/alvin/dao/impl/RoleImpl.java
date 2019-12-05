package com.alvin.dao.impl;

import com.alvin.dao.DBSource;
import java.util.List;
import java.util.Map;
import com.alvin.dao.IroleDao;
import com.alvin.entity.Role;
import com.alvin.common.ObjectConvertStr;
import com.alvin.common.DaoException;

/**
 @Title 		:IroleDao.java
 @Company 		:永硕
 @Package 		:com.alvin.dao.impl
 @Description 	:角色表接口实现类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class RoleImpl extends DBSource implements IroleDao{

	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void addRole(Role role) throws DaoException{
		 String sql="insert into role(roleName,useState,remark,roleType,orgId) values(?,?,?,?,?)";
		 Object[] pramas = { role.getRoleName(),role.getUseState(),role.getRemark(),role.getRoleType(),role.getOrgId()};
		 super.getSql().executeUpdate(sql,  pramas); 
	 };
	 /**
	  * 通过编号删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void delRoleById(String roleIds) throws DaoException{
		 String sql="delete from  role where roleId in("+roleIds+")";
		 super.getSql().executeUpdate(sql); 
	 }
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void updRole(Role role) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("update role set roleId=roleId");
		 ObjectConvertStr.cUpdSql(role,sql);
		 sql.append(" where roleId="+role.getRoleId()); 

		super.getSql().executeUpdate(sql.toString()); 
	 }
	 /**
	  * 通过条件查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public List<Role> selectByMapRole(Role role,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from role where 1=1");
		 commonSqlByMap(role,map,sql); 
		 return super.getSql().selectList(sql.toString(), Role.class);
		 
	 }
	 /**
	  * 公共的条件转换sql
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private String commonSqlByMap(Role Role,Map<String,Object> map,StringBuffer sql) {
		 
		 ObjectConvertStr.cSelectSql(Role,sql,true);
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
	public Integer countByMapRole(Role role,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select count(1) as count from role where 1=1");
		 commonSqlByMap(role,map,sql); 
		 return super.getSql().selectCount(sql.toString());
		 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Role selectOneByID(Integer ID)throws DaoException {
		 
		String sql="select * from role where  roleId="+ID;
		return super.getSql().selectOne(sql, Role.class); 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Role selectOneByObj(Role entity)throws DaoException {
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from role where 1=1 ");
		 commonSqlByMap(entity,null,sql); 

		return super.getSql().selectOne(sql.toString(), Role.class); 
	 }
}