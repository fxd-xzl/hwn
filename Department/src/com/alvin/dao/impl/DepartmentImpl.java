package com.alvin.dao.impl;

import com.alvin.dao.DBSource;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import com.alvin.dao.IdepartmentDao;
import com.alvin.entity.Department;
import com.alvin.common.ObjectConvertStr;
import com.alvin.common.DaoException;

/**
 @Title 		:IdepartmentDao.java
 @Company 		:永硕
 @Package 		:com.alvin.dao.impl
 @Description 	:部门表接口实现类
 @author 		:fxd
 @date 			:2019-12-02 22:49
 @version 		:版本 3.0
*/
public class DepartmentImpl extends DBSource implements IdepartmentDao{

	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:49
	 */
	 @Override
	public void addDepartment(Department department) throws DaoException{
		 String sql="insert into department(dmName,pid,pids,orgId) values(?,?,?,?)";
		 Object[] pramas = { department.getDmName(),department.getPid(),department.getPids(),department.getOrgId()};
		 super.getSql().executeUpdate(sql,  pramas); 
	 };
	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:49
	 */
	 @Override
	public void addDepartment(Department department,Connection conn) throws DaoException{
		 String sql="insert into department(dmName,pid,pids,orgId) values(?,?,?,?)";
		 Object[] pramas = { department.getDmName(),department.getPid(),department.getPids(),department.getOrgId()};
		 super.getSql(conn).executeUpdate(sql,  pramas); 
	 };
	 /**
	  * 通过编号删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:49
	 */
	 @Override
	public void delDepartmentById(String departmentIds) throws DaoException{
		 String sql="delete from  department where departmentId in("+departmentIds+")";
		 super.getSql().executeUpdate(sql); 
	 }
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:49
	 */
	 @Override
	public void updDepartment(Department department) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("update department set departmentId=departmentId");
		 ObjectConvertStr.cUpdSql(department,sql);
		 sql.append(" where departmentId="+department.getDepartmentId()); 

		super.getSql().executeUpdate(sql.toString()); 
	 }
	 /**
	  * 通过条件查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:49
	 */
	 @Override
	public List<Department> selectByMapDepartment(Department department,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from department where 1=1");
		 commonSqlByMap(department,map,sql); 
		 return super.getSql().selectList(sql.toString(), Department.class);
		 
	 }
	 /**
	  * 公共的条件转换sql
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:49
	 */
	 private String commonSqlByMap(Department Department,Map<String,Object> map,StringBuffer sql) {
		 
		 ObjectConvertStr.cSelectSql(Department,sql,true);
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
	  * @date	:2019-12-02 22:49
	 */
	 @Override
	public Integer countByMapDepartment(Department department,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select count(1) as count from department where 1=1");
		 commonSqlByMap(department,map,sql); 
		 return super.getSql().selectCount(sql.toString());
		 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:49
	 */
	 public Department selectOneByID(Integer ID)throws DaoException {
		 
		String sql="select * from department where  departmentId="+ID;
		return super.getSql().selectOne(sql, Department.class); 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:49
	 */
	 public Department selectOneByObj(Department entity)throws DaoException {
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from department where 1=1 ");
		 commonSqlByMap(entity,null,sql); 

		return super.getSql().selectOne(sql.toString(), Department.class); 
	 }
	@Override
	public Map<Object, Department> selectMapByOrgId(Integer orgId) throws Exception {
		String sql="select * from department where orgId="+orgId;
		return super.getSql().selectListByMap(sql, Department.class,"departemtnId");
	}
}