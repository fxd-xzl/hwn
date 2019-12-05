package com.alvin.service.add;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.common.MySqlTransaction;
import com.alvin.common.StringUtil;
import com.alvin.dao.DBSource;
import com.alvin.dao.IdepartmentDao;
import com.alvin.dao.IorgDao;
import com.alvin.dao.impl.DepartmentImpl;
import com.alvin.dao.impl.OrgImpl;
import com.alvin.entity.Org;

import net.sf.json.JSONObject;

/**
 @Title 		:AddOrg.java
 @Company 		:永硕
 @Package 		:com.alvin.service
 @Description 	:添加
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
public class AddOrg {

	private IorgDao orgDao;

	private JSONObject jsonObj;

	private Org org;

	public AddOrg(JSONObject jsonObj){
		orgDao=new OrgImpl();
		this.jsonObj=jsonObj;
	}
	 /**
	  * 添加
	  * @author	:fxd
	  * @return	:
	  * @date	:2019-12-02 22:56
	 */
	 public JSONObject add(Org org) throws DaoException{
		this.org=org;
		if(validate()==false){
			return jsonObj;
		}
		MySqlTransaction tran=null;
		try {
			tran=new MySqlTransaction(DBSource.getConnection());
			Integer orgId=orgDao.addOrg(org,tran.getConnection());
			new AddDepartment(jsonObj).add(org.getOrgName(),orgId,tran.getConnection());
			tran.commit();
			CodeResult.setResult(jsonObj,00,"添加");
		} catch (Exception e) {
			tran.rollback();
			throw e;
		}
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

		if(StringUtil.isBlank(org.getOrgName())){
			CodeResult.setResult(jsonObj,11,"机构名称"); 
			return false; 
		}
		Org result= orgDao.selectOneByObj(new Org(org.getOrgName()));
		if (result!=null) {
			CodeResult.setResult(jsonObj,14,"机构"); 
			return false;
		}
		return true; 
	}
	 

}