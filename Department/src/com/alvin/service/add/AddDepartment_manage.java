package com.alvin.service.add;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.Idepartment_manageDao;
import com.alvin.dao.impl.Department_manageImpl;
import com.alvin.entity.Department_manage;

import net.sf.json.JSONObject;

/**
 @Title 		:AddDepartment_manage.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:添加
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class AddDepartment_manage {

	private Idepartment_manageDao department_manageDao;

	private JSONObject jsonObj;

	private Department_manage department_manage;

	public AddDepartment_manage(JSONObject jsonObj){
		department_manageDao=new Department_manageImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject add(Department_manage department_manage) throws DaoException{
		this.department_manage=department_manage;
		if(validate()==false){
			return jsonObj;
		}
		department_manageDao.addDepartment_manage(department_manage);
		CodeResult.setResult(jsonObj,00,"添加");
		return jsonObj;
	}

	
	 /**
	  * 验证
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private Boolean validate(){ 

		if(StringUtil.isBlank(department_manage.getDefectPerson())){
			CodeResult.setResult(jsonObj,11,"负责人"); 
			return false; 
		}
		if(StringUtil.isBlank(department_manage.getContactPhone())){
			CodeResult.setResult(jsonObj,11,"联系电话"); 
			return false; 
		}
		if(StringUtil.isBlank(department_manage.getDepartmentId())){
			CodeResult.setResult(jsonObj,11,"所属部门"); 
			return false; 
		}
		if(StringUtil.isBlank(department_manage.getORG_ID())){
			CodeResult.setResult(jsonObj,11,"机构编号"); 
			return false; 
		}
		if(StringUtil.isBlank(department_manage.getDepartmentNames())){
			CodeResult.setResult(jsonObj,11,"部门名称"); 
			return false; 
		}
		return true; 
	}

}