package com.alvin.dao.impl;

import com.alvin.dao.DBSource;
import java.util.List;
import java.util.Map;
import com.alvin.dao.IuserDao;
import com.alvin.entity.User;
import com.alvin.common.ObjectConvertStr;
import com.alvin.common.DaoException;

/**
 @Title 		:IuserDao.java
 @Company 		:永硕
 @Package 		:com.alvin.dao.impl
 @Description 	:用户表接口实现类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class UserImpl extends DBSource implements IuserDao{

	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void addUser(User user) throws DaoException{
		 String sql="insert into user(userNo,userJobNo,userName,userType,departmentId,userLoginName,userPwd,roleId,userIDcard,gender,address,occupation,userPhone,userPhoto,userState,orgId) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 Object[] pramas = {user.getUserNo(),user.getUserJobNo(),user.getUserName(),user.getUserType(),user.getDepartmentId(),user.getUserLoginName(),user.getUserPwd(),user.getRoleId(),user.getUserIDcard(),user.getGender(),user.getAddress(),user.getOccupation(),user.getUserPhone(),user.getUserPhoto(),user.getUserState(),user.getOrgId()};
		 super.getSql().executeUpdate(sql,  pramas); 
	 };
	 /**
	  * 通过编号删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void delUserById(String userIds) throws DaoException{
		 String sql="delete from  user where userId in("+userIds+")";
		 super.getSql().executeUpdate(sql); 
	 }
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public void updUser(User user) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("update user set userId=userId");
		 ObjectConvertStr.cUpdSql(user,sql);
		 sql.append(" where userId="+user.getUserId()); 

		super.getSql().executeUpdate(sql.toString()); 
	 }
	 /**
	  * 通过条件查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 @Override
	public List<User> selectByMapUser(User user,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from user where 1=1");
		 commonSqlByMap(user,map,sql); 
		 return super.getSql().selectList(sql.toString(), User.class);
		 
	 }
	 /**
	  * 公共的条件转换sql
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private String commonSqlByMap(User User,Map<String,Object> map,StringBuffer sql) {
		 
		 ObjectConvertStr.cSelectSql(User,sql,true);
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
	public Integer countByMapUser(User user,Map<String,Object> map) throws DaoException{
		 StringBuffer sql=new StringBuffer();
		 sql.append("select count(1) as count from user where 1=1");
		 commonSqlByMap(user,map,sql); 
		 return super.getSql().selectCount(sql.toString());
		 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public User selectOneByID(Integer ID)throws DaoException {
		 
		String sql="select * from user where  userId="+ID;
		return super.getSql().selectOne(sql, User.class); 
	 }
	 /**
	  * 通过编号查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public User selectOneByObj(User entity)throws DaoException {
		 StringBuffer sql=new StringBuffer();
		 sql.append("select * from user where 1=1 ");
		 commonSqlByMap(entity,null,sql); 

		return super.getSql().selectOne(sql.toString(), User.class); 
	 }
}