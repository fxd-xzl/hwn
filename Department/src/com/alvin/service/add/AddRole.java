package com.alvin.service.add;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.IroleDao;
import com.alvin.dao.impl.RoleImpl;
import com.alvin.entity.Role;

import net.sf.json.JSONObject;

/**
 @Title 		:AddRole.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:添加角色表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class AddRole {

	private IroleDao roleDao;

	private JSONObject jsonObj;

	private Role role;

	public AddRole(JSONObject jsonObj){
		roleDao=new RoleImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject add(Role role) throws DaoException{
		this.role=role;
		if(validate()==false){
			return jsonObj;
		}
		roleDao.addRole(role);
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

		if(StringUtil.isBlank(role.getRoleName())){
			CodeResult.setResult(jsonObj,11,"角色名"); 
			return false; 
		}
		if(StringUtil.isBlank(role.getUseState())){
			CodeResult.setResult(jsonObj,11,"启用状态"); 
			return false; 
		}
		if(StringUtil.isBlank(role.getRemark())){
			CodeResult.setResult(jsonObj,11,"备注"); 
			return false; 
		}
		if(StringUtil.isBlank(role.getRoleType())){
			CodeResult.setResult(jsonObj,11,"角色类型"); 
			return false; 
		}
		if(StringUtil.isBlank(role.getOrgId())){
			CodeResult.setResult(jsonObj,11,"机构编号"); 
			return false; 
		}
		Role result=roleDao.selectOneByObj(new Role(role.getRoleName(),role.getOrgId()));
		if (result!=null) {
			CodeResult.setResult(jsonObj, 14,"角色");
			return false;
		}
		return true; 
	}

}