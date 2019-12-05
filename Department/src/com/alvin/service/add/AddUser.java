package com.alvin.service.add;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.MD5Util;
import com.alvin.common.StringUtil;
import com.alvin.dao.IuserDao;
import com.alvin.dao.impl.UserImpl;
import com.alvin.entity.User;

import net.sf.json.JSONObject;

/**
 @Title 		:AddUser.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:添加用户表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class AddUser {

	private IuserDao userDao;

	private JSONObject jsonObj;

	private User user;

	public AddUser(JSONObject jsonObj){
		userDao=new UserImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject add(User user) throws DaoException{
		this.user=user;
		if(validate()==false){
			return jsonObj;
		}
		user.setUserPwd(MD5Util.getMD5(user.getUserPwd()));
		userDao.addUser(user);
		CodeResult.setResult(jsonObj,00,"添加");
		return jsonObj;
	}

	
	 /**
	  * 验证
	  * @author	:fxd
	  * @return	:
	 * @throws DaoException 
	  * @date	:2019-12-02 22:56
	 */
	 private Boolean validate() throws DaoException{ 

		if(StringUtil.isBlank(user.getUserNo())){
			CodeResult.setResult(jsonObj,11,"编号 "); 
			return false; 
		}
		if(StringUtil.isBlank(user.getUserJobNo())){
			CodeResult.setResult(jsonObj,11,"工号 "); 
			return false; 
		}
		if(StringUtil.isBlank(user.getUserName())){
			CodeResult.setResult(jsonObj,11,"姓名  "); 
			return false; 
		}
		if(StringUtil.isBlank(user.getUserType())){
			CodeResult.setResult(jsonObj,11,"类型"); 
			return false; 
		}
		if(StringUtil.isBlank(user.getDepartmentId())){
			CodeResult.setResult(jsonObj,11,"部门"); 
			return false; 
		}
		if(StringUtil.isBlank(user.getUserLoginName())){
			CodeResult.setResult(jsonObj,11,"用户名 "); 
			return false; 
		}
		if(StringUtil.isBlank(user.getUserPwd())){
			CodeResult.setResult(jsonObj,11,"密码"); 
			return false; 
		}
		if(StringUtil.isBlank(user.getRoleId())){
			CodeResult.setResult(jsonObj,11,"角色"); 
			return false; 
		}
	 
		if(StringUtil.isBlank(user.getGender())){
			CodeResult.setResult(jsonObj,11,"性别"); 
			return false; 
		}
		 
		if(StringUtil.isBlank(user.getUserState())){
			CodeResult.setResult(jsonObj,11,"状态"); 
			return false; 
		}
		if(StringUtil.isBlank(user.getOrgId())){
			CodeResult.setResult(jsonObj,11,"机构编号"); 
			return false; 
		}
		User result=userDao.selectOneByObj(new User(user.getUserLoginName(),user.getOrgId()));
		if (result!=null) {
			CodeResult.setResult(jsonObj,14,"用户"); 
			return false;
		}
		return true; 
	}

}