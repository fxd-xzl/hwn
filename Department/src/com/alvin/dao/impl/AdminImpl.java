package com.alvin.dao.impl;

import com.alvin.dao.DBSource;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alvin.dao.IadminDao;
import com.alvin.entity.Admin;
import com.alvin.common.ObjectConvertStr;
import com.alvin.common.DaoException;

/**
 @Title 		:IadminDao.java
 @Company 		:永硕
 @Package 		:com.alvin.dao.impl
 @Description 	:管理人员表接口实现类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
@Service("adminDao")
public class AdminImpl extends DBSource implements IadminDao{

	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void addAdmin(Admin admin) throws DaoException{
		 String sql="insert into admin(adminName,adminLoginName,adminPwd,roleId,adminPhone,userState,orgId) values(?,?,?,?,?,?,?)";
		 Object[] pramas = { admin.getAdminName(),admin.getAdminLoginName(),admin.getAdminPwd(),admin.getRoleId(),admin.getAdminPhone(),admin.getUserState(),admin.getOrgId()};
		 super.getSql().executeUpdate(sql,  pramas); 
	 };
	 /**
	  * 通过编号删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void delAdminById(String adminIds) throws DaoException{
		 String sql="delete from  admin where adminId in("+adminIds+")";
		 super.getSql().executeUpdate(sql); 
	 }
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void updAdmin(Admin admin) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("update admin set adminId=adminId");
		 ObjectConvertStr.cUpdSql(admin,sql);
		 sql.append(" where adminId="+admin.getAdminId()); 

		super.getSql().executeUpdate(sql.toString()); 
	 }
	 /**
	  * 通过条件查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public List<Admin> selectByMapAdmin(Admin admin,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from admin where 1=1");
		 commonSqlByMap(admin,map,sql); 
		 return super.getSql().selectList(sql.toString(), Admin.class);
		 
	 }
	 /**
	  * 公共的条件转换sql
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private String commonSqlByMap(Admin Admin,Map<String,Object> map,StringBuffer sql) {
		 
		 ObjectConvertStr.cSelectSql(Admin,sql,true);
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
	public Integer countByMapAdmin(Admin admin,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select count(1) as count from admin where 1=1");
		 commonSqlByMap(admin,map,sql); 
		 return super.getSql().selectCount(sql.toString());
		 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Admin selectOneByID(Integer ID)throws DaoException {
		 
		String sql="select * from admin where  adminId="+ID;
		return super.getSql().selectOne(sql, Admin.class); 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Admin selectOneByObj(Admin entity)throws DaoException {
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from admin where 1=1 ");
		 commonSqlByMap(entity,null,sql); 

		return super.getSql().selectOne(sql.toString(), Admin.class); 
	 }
}