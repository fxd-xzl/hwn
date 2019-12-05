package com.alvin.dao.impl;

import com.alvin.dao.DBSource;
import java.util.List;
import java.util.Map;
import com.alvin.dao.Idepartment_manageDao;
import com.alvin.entity.Department_manage;
import com.alvin.common.ObjectConvertStr;
import com.alvin.common.DaoException;

/**
 @Title 		:Idepartment_manageDao.java
 @Company 		:永硕
 @Package 		:com.alvin.dao.impl
 @Description 	:接口实现类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class Department_manageImpl extends DBSource implements Idepartment_manageDao{

	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void addDepartment_manage(Department_manage department_manage) throws DaoException{
		 String sql="insert into department_manage(defectPerson,contactPhone,departmentId,ORG_ID,departmentNames) values(?,?,?,?,?)";
		 Object[] pramas = { department_manage.getDefectPerson(),department_manage.getContactPhone(),department_manage.getDepartmentId(),department_manage.getORG_ID(),department_manage.getDepartmentNames()};
		 super.getSql().executeUpdate(sql,  pramas); 
	 };
	 /**
	  * 通过编号删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void delDepartment_manageById(String departmentManageIds) throws DaoException{
		 String sql="delete from  department_manage where departmentManageId in("+departmentManageIds+")";
		 super.getSql().executeUpdate(sql); 
	 }
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void updDepartment_manage(Department_manage department_manage) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("update department_manage set departmentManageId=departmentManageId");
		 ObjectConvertStr.cUpdSql(department_manage,sql);
		 sql.append(" where departmentManageId="+department_manage.getDepartmentManageId()); 

		super.getSql().executeUpdate(sql.toString()); 
	 }
	 /**
	  * 通过条件查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public List<Department_manage> selectByMapDepartment_manage(Department_manage department_manage,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from department_manage where 1=1");
		 commonSqlByMap(department_manage,map,sql); 
		 return super.getSql().selectList(sql.toString(), Department_manage.class);
		 
	 }
	 /**
	  * 公共的条件转换sql
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private String commonSqlByMap(Department_manage Department_manage,Map<String,Object> map,StringBuffer sql) {
		 
		 ObjectConvertStr.cSelectSql(Department_manage,sql,true);
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
	public Integer countByMapDepartment_manage(Department_manage department_manage,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select count(1) as count from department_manage where 1=1");
		 commonSqlByMap(department_manage,map,sql); 
		 return super.getSql().selectCount(sql.toString());
		 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Department_manage selectOneByID(Integer ID)throws DaoException {
		 
		String sql="select * from department_manage where  departmentManageId="+ID;
		return super.getSql().selectOne(sql, Department_manage.class); 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public Department_manage selectOneByObj(Department_manage entity)throws DaoException {
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from department_manage where 1=1 ");
		 commonSqlByMap(entity,null,sql); 

		return super.getSql().selectOne(sql.toString(), Department_manage.class); 
	 }
}