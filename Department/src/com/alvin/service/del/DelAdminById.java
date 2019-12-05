package com.alvin.service.del;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.IadminDao;
import com.alvin.dao.impl.AdminImpl;

import net.sf.json.JSONObject;

/**
 @Title 		:DelAdminById.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:通过编号删除管理人员表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class DelAdminById {

	private IadminDao adminDao;

	private JSONObject jsonObj;

	public DelAdminById(JSONObject jsonObj){
		adminDao=new AdminImpl();
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
		adminDao.delAdminById(ids);
		CodeResult.setResult(jsonObj,00,"删除");
		return jsonObj;	

	}

}