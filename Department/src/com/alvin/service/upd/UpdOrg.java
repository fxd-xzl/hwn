package com.alvin.service.upd;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.StringUtil;
import com.alvin.dao.IorgDao;
import com.alvin.common.Time_Tool;
import com.alvin.dao.impl.OrgImpl;
import com.alvin.entity.Org;

import net.sf.json.JSONObject;

/**
 @Title 		:UpdOrg.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:修改
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class UpdOrg {

	private IorgDao orgDao;

	private JSONObject jsonObj;

	private Org org;

	public UpdOrg(JSONObject jsonObj){
		orgDao=new OrgImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 修改
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject upd(Org org) throws DaoException{
		this.org=org;
		if(validate()==false){
			return jsonObj;
		}
		orgDao.updOrg(org);
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

		if(StringUtil.isBlank(org.getOrgId())){
			CodeResult.setResult(jsonObj,11,"机构编号"); 
			return false; 
		}
		return true; 
	}

}