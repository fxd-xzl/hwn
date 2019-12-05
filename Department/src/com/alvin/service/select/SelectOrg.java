package com.alvin.service.select;

import  java.util.List;
import  java.util.Map;
import com.alvin.common.DaoException;
import com.alvin.dao.IorgDao;
import com.alvin.dao.impl.OrgImpl;
import com.alvin.entity.Org;

import com.alvin.common.CodeResult;

import net.sf.json.JSONObject;

/**
 @Title 		:SelectOrg.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:通过条件查询
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class SelectOrg {

	private IorgDao orgDao;

	private JSONObject jsonObj;

	public SelectOrg(JSONObject jsonObj){
		orgDao=new OrgImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 查询
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject getResult(Org org,Map<String, Object> map) throws DaoException{
		List<Org> list=orgDao.selectByMapOrg(org,map);
		jsonObj.put("result",list);

		//只有第一页的时候才需要重新的统计，否则不需要再次的统计数量
		if (map.get("pageIndex")!=null&&map.get("pageIndex").equals(1)) {
			int totalCount=orgDao.countByMapOrg(org,map);
			jsonObj.put("total",totalCount);
		}
		CodeResult.setResult(jsonObj, 00);
		return jsonObj;
	}

}