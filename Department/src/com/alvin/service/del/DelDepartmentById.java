package com.alvin.service.del;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.IdepartmentDao;
import com.alvin.dao.impl.DepartmentImpl;

import net.sf.json.JSONObject;

/**
 @Title 		:DelDepartmentById.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:通过编号删除部门表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class DelDepartmentById {

	private IdepartmentDao departmentDao;

	private JSONObject jsonObj;

	public DelDepartmentById(JSONObject jsonObj){
		departmentDao=new DepartmentImpl();
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
		departmentDao.delDepartmentById(ids);
		CodeResult.setResult(jsonObj,00,"删除");
		return jsonObj;	

	}

}