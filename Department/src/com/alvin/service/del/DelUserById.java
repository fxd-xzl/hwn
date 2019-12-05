package com.alvin.service.del;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.IuserDao;
import com.alvin.dao.impl.UserImpl;

import net.sf.json.JSONObject;

/**
 @Title 		:DelUserById.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:通过编号删除用户表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class DelUserById {

	private IuserDao userDao;

	private JSONObject jsonObj;

	public DelUserById(JSONObject jsonObj){
		userDao=new UserImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 删除
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject del(String ids) throws DaoException{
		 //把最后的逗号切割掉
		ids=StringUtil.splitLastStr(ids, ",");
		userDao.delUserById(ids);
		CodeResult.setResult(jsonObj,00,"删除");
		return jsonObj;	

	}

}