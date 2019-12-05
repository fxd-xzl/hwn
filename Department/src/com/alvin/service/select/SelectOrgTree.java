package com.alvin.service.select;

import java.util.Map;

import com.alvin.dao.IdepartmentDao;
import com.alvin.dao.impl.DepartmentImpl;
import com.alvin.entity.Department;

import net.sf.json.JSONObject;

/***
 * 查询机构数
 * @author Alvin
 *
 */
public class SelectOrgTree {
	
	private JSONObject jsonObj;
	private IdepartmentDao departemntDao;
	private Map<Object, Department> map;
	public SelectOrgTree(JSONObject jsonObj){
		this.jsonObj=jsonObj;
		this.departemntDao=new DepartmentImpl();
	}
	
	public JSONObject getResult(Integer orgId) throws Exception{
		getMap(orgId);
		return jsonObj;
		
	} 
	
	private void getMap(Integer orgId) throws Exception{
		map= this.departemntDao.selectMapByOrgId(orgId);
	}
	
	
	
}
