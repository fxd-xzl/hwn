package com.alvin.entity;

import lombok.Data;

/**
 @Title 		:Admin.java
 @Company 		:永硕
 @Package 		:com.alvin.entity
 @Description 	:管理人员表实体类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
@Data
public class Admin{
	 private Integer adminId;//ID
	 private String adminName;//姓名 
	 private String adminLoginName;//用户名 
	 private String adminPwd;//密码
	 private Integer roleId;//角色
	 private String adminPhone;//联系电话
	 private Integer userState;//状态  1.正常 0.禁用
	 private Integer orgId;//机构编号
	 private String createTime;//创建时间
	 private String updateTime;//修改时间
	 public Admin(){};
	 public Admin(String adminLoginName,Integer orgId){
		 this.adminLoginName=adminLoginName;
		 this.orgId=orgId;
	 }
	  
}