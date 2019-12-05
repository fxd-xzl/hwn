package com.alvin.service.select;

import  java.util.List;
import  java.util.Map;
import com.alvin.common.DaoException;
import com.alvin.dao.Idepartment_manageDao;
import com.alvin.dao.impl.Department_manageImpl;
import com.alvin.entity.Department_manage;

import com.alvin.common.CodeResult;

import net.sf.json.JSONObject;

/**
 @Title 		:SelectDepartment_manage.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:通过条件查询
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class SelectDepartment_manage {

	private Idepartment_manageDao department_manageDao;

	private JSONObject jsonObj;

	public SelectDepartment_manage(JSONObject jsonObj){
		department_manageDao=new Department_manageImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject getResult(Department_manage department_manage,Map<String, Object> map) throws DaoException{
		List<Department_manage> list=department_manageDao.selectByMapDepartment_manage(department_manage,map);
		jsonObj.put("result",list);

		//只有第一页的时候才需要重新的统计，否则不需要再次的统计数量
		if (map.get("pageIndex")!=null&&map.get("pageIndex").equals(1)) {
			int totalCount=department_manageDao.countByMapDepartment_manage(department_manage,map);
			jsonObj.put("total",totalCount);
		}
		CodeResult.setResult(jsonObj, 00);
		return jsonObj;
	}

}