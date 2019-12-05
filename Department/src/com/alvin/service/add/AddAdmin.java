package com.alvin.service.add;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.MD5Util;
import com.alvin.common.StringUtil;
import com.alvin.dao.IadminDao;
import com.alvin.dao.impl.AdminImpl;
import com.alvin.entity.Admin;

import net.sf.json.JSONObject;

/**
 @Title 		:AddAdmin.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:添加管理人员表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class AddAdmin {

	private IadminDao adminDao;

	private JSONObject jsonObj;

	private Admin admin;

	public AddAdmin(JSONObject jsonObj){
		adminDao=new AdminImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject add(Admin admin) throws DaoException{
		this.admin=admin;
		if(validate()==false){
			return jsonObj;
		}
		admin.setAdminPwd(MD5Util.getMD5(admin.getAdminPwd()));
		adminDao.addAdmin(admin);
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

		if(StringUtil.isBlank(admin.getAdminName())){
			CodeResult.setResult(jsonObj,11,"姓名 "); 
			return false; 
		}
		if(StringUtil.isBlank(admin.getAdminLoginName())){
			CodeResult.setResult(jsonObj,11,"用户名 "); 
			return false; 
		}
		if(StringUtil.isBlank(admin.getAdminPwd())){
			CodeResult.setResult(jsonObj,11,"密码"); 
			return false; 
		}
		if(StringUtil.isBlank(admin.getRoleId())){
			CodeResult.setResult(jsonObj,11,"角色"); 
			return false; 
		}
		 
		if(StringUtil.isBlank(admin.getUserState())){
			CodeResult.setResult(jsonObj,11,"状态 "); 
			return false; 
		}
		if(StringUtil.isBlank(admin.getOrgId())){
			CodeResult.setResult(jsonObj,11,"机构编号"); 
			return false; 
		}
		Admin result=adminDao.selectOneByObj(new Admin(admin.getAdminLoginName(),admin.getOrgId()));
		if (result!=null) {
			CodeResult.setResult(jsonObj,14,"管理员账号"); 
			return false;
		}
		return true; 
	}

}