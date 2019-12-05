package com.alvin.service.upd;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.IadminDao;
import com.alvin.dao.impl.AdminImpl;
import com.alvin.entity.Admin;

import net.sf.json.JSONObject;

/**
 @Title 		:UpdAdmin.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:修改管理人员表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class UpdAdmin {

	private IadminDao adminDao;

	private JSONObject jsonObj;

	private Admin admin;

	public UpdAdmin(JSONObject jsonObj){
		adminDao=new AdminImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject upd(Admin admin) throws DaoException{
		this.admin=admin;
		if(validate()==false){
			return jsonObj;
		}
		adminDao.updAdmin(admin);
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

		if(StringUtil.isBlank(admin.getAdminId())){
			CodeResult.setResult(jsonObj,11,"ID"); 
			return false; 
		}
		if (StringUtil.isBlank(admin.getAdminLoginName())) {
			return true;
		}
		
		Admin result=adminDao.selectOneByObj(new Admin(admin.getAdminLoginName(),admin.getOrgId()));
		if (!result.getAdminId().equals(admin.getAdminId())) {
			CodeResult.setResult(jsonObj,14,"管理员账号"); 
			return false;
		}
		return true; 
	}

}