package com.alvin.service.upd;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.IdepartmentDao;
import com.alvin.common.Time_Tool;
import com.alvin.dao.impl.DepartmentImpl;
import com.alvin.entity.Department;

import net.sf.json.JSONObject;

/**
 @Title 		:UpdDepartment.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:修改部门表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class UpdDepartment {

	private IdepartmentDao departmentDao;

	private JSONObject jsonObj;

	private Department department;

	public UpdDepartment(JSONObject jsonObj){
		departmentDao=new DepartmentImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject upd(Department department) throws DaoException{
		this.department=department;
		if(validate()==false){
			return jsonObj;
		}
		departmentDao.updDepartment(department);
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

		if(StringUtil.isBlank(department.getDepartmentId())){
			CodeResult.setResult(jsonObj,11,"ID"); 
			return false; 
		}
		return true; 
	}

}