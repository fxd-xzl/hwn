package com.alvin.service.add;

import java.sql.Connection;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.IdepartmentDao;
import com.alvin.dao.impl.DepartmentImpl;
import com.alvin.entity.Department;

import net.sf.json.JSONObject;

/**
 @Title 		:AddDepartment.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:添加部门表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class AddDepartment {

	private IdepartmentDao departmentDao;

	private JSONObject jsonObj;

	private Department department;

	public AddDepartment(JSONObject jsonObj){
		departmentDao=new DepartmentImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject add(Department department) throws DaoException{
		this.department=department;
		if(validate()==false){
			return jsonObj;
		}
		departmentDao.addDepartment(department);
		CodeResult.setResult(jsonObj,00,"添加");
		return jsonObj;
	}
	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public void add(String orgName,Integer orgId,Connection conn) throws DaoException{
		 Department department=new Department();
		 department.setDmName(orgName);
		 department.setOrgId(orgId);
		 department.setPid(0);
		departmentDao.addDepartment(department,conn);
	}
	
	 /**
	  * 验证
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 private Boolean validate(){ 

		if(StringUtil.isBlank(department.getDmName())){
			CodeResult.setResult(jsonObj,11,"名称 "); 
			return false; 
		}
		if(StringUtil.isBlank(department.getPid())){
			CodeResult.setResult(jsonObj,11,"父级编号"); 
			return false; 
		}
		if(StringUtil.isBlank(department.getPids())){
			CodeResult.setResult(jsonObj,11,"父级连编号"); 
			return false; 
		}
		if(StringUtil.isBlank(department.getOrgId())){
			CodeResult.setResult(jsonObj,11,"机构编号 "); 
			return false; 
		}
		return true; 
	}

}