package com.alvin.service.select;

import  java.util.List;
import  java.util.Map;
import com.alvin.common.DaoException;
import com.alvin.dao.IdepartmentDao;
import com.alvin.dao.impl.DepartmentImpl;
import com.alvin.entity.Department;

import com.alvin.common.CodeResult;

import net.sf.json.JSONObject;

/**
 @Title 		:SelectDepartment.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:通过条件查询部门表
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class SelectDepartment {

	private IdepartmentDao departmentDao;

	private JSONObject jsonObj;

	public SelectDepartment(JSONObject jsonObj){
		departmentDao=new DepartmentImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject getResult(Department department,Map<String, Object> map) throws DaoException{
		List<Department> list=departmentDao.selectByMapDepartment(department,map);
		jsonObj.put("result",list);

		//只有第一页的时候才需要重新的统计，否则不需要再次的统计数量
		if (map.get("pageIndex")!=null&&map.get("pageIndex").equals(1)) {
			int totalCount=departmentDao.countByMapDepartment(department,map);
			jsonObj.put("total",totalCount);
		}
		CodeResult.setResult(jsonObj, 00);
		return jsonObj;
	}

}