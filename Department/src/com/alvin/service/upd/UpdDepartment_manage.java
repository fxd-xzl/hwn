package com.alvin.service.upd;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.Idepartment_manageDao;
import com.alvin.common.Time_Tool;
import com.alvin.dao.impl.Department_manageImpl;
import com.alvin.entity.Department_manage;

import net.sf.json.JSONObject;

/**
 @Title 		:UpdDepartment_manage.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:修改
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class UpdDepartment_manage {

	private Idepartment_manageDao department_manageDao;

	private JSONObject jsonObj;

	private Department_manage department_manage;

	public UpdDepartment_manage(JSONObject jsonObj){
		department_manageDao=new Department_manageImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject upd(Department_manage department_manage) throws DaoException{
		this.department_manage=department_manage;
		if(validate()==false){
			return jsonObj;
		}
		department_manageDao.updDepartment_manage(department_manage);
		CodeResult.setResult(jsonObj,00,"修改");
		return jsonObj;
	}

	
	 /**
	  * 验证
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private Boolean validate(){ 

		if(StringUtil.isBlank(department_manage.getDepartmentManageId())){
			CodeResult.setResult(jsonObj,11,"部门管理编号"); 
			return false; 
		}
		return true; 
	}

}