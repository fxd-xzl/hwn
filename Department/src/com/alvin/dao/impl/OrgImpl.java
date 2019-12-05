package com.alvin.dao.impl;

import com.alvin.dao.DBSource;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import com.alvin.dao.IorgDao;
import com.alvin.entity.Org;
import com.alvin.common.ObjectConvertStr;
import com.alvin.common.DaoException;

/**
 @Title 		:IorgDao.java
 @Company 		:永硕
 @Package 		:com.alvin.dao.impl
 @Description 	:接口实现类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class OrgImpl extends DBSource implements IorgDao{

	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public Integer addOrg(Org org,Connection conn) throws DaoException{
		 String sql="insert into org(orgName) values(?)";
		 Object[] pramas = { org.getOrgName()};
		 return super.getSql(conn).executeUpdate(sql,  pramas); 
	 };
	 /**
	  * 通过编号删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void delOrgById(String orgIds) throws DaoException{
		 String sql="delete from  org where orgId in("+orgIds+")";
		 super.getSql().executeUpdate(sql); 
	 }
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void updOrg(Org org) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("update org set orgId=orgId");
		 ObjectConvertStr.cUpdSql(org,sql);
		 sql.append(" where orgId="+org.getOrgId()); 

		super.getSql().executeUpdate(sql.toString()); 
	 }
	 /**
	  * 通过条件查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public List<Org> selectByMapOrg(Org org,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from org where 1=1");
		 commonSqlByMap(org,map,sql); 
		 return super.getSql().selectList(sql.toString(), Org.class);
		 
	 }
	 /**
	  * 公共的条件转换sql
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private String commonSqlByMap(Org Org,Map<String,Object> map,StringBuffer sql) {
		 
		 ObjectConvertStr.cSelectSql(Org,sql,true);
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
	public Integer countByMapOrg(Org org,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select count(1) as count from org where 1=1");
		 commonSqlByMap(org,map,sql); 
		 return super.getSql().selectCount(sql.toString());
		 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Org selectOneByID(Integer ID)throws DaoException {
		 
		String sql="select * from org where  orgId="+ID;
		return super.getSql().selectOne(sql, Org.class); 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Org selectOneByObj(Org entity)throws DaoException {
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from org where 1=1 ");
		 commonSqlByMap(entity,null,sql); 

		return super.getSql().selectOne(sql.toString(), Org.class); 
	 }
}