package com.alvin.service.upd;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.IuserDao;
import com.alvin.dao.impl.UserImpl;
import com.alvin.entity.User;

import net.sf.json.JSONObject;

/**
 @Title 		:UpdUser.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:修改用户表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class UpdUser {

	private IuserDao userDao;

	private JSONObject jsonObj;

	private User user;

	public UpdUser(JSONObject jsonObj){
		userDao=new UserImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject upd(User user) throws DaoException{
		this.user=user;
		if(validate()==false){
			return jsonObj;
		}
		userDao.updUser(user);
		CodeResult.setResult(jsonObj,00,"修改");
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

		if(StringUtil.isBlank(user.getUserId())){
			CodeResult.setResult(jsonObj,11,"ID"); 
			return false; 
		}
		if (StringUtil.isBlank(user.getUserLoginName())) {
			return true;
		}
		User result=userDao.selectOneByObj(new User(user.getUserLoginName(),user.getOrgId()));
		if (!result.getUserId().equals(user.getUserId())) {
			CodeResult.setResult(jsonObj,14,"用户"); 
			return false;
		}
		return true; 
	}

}