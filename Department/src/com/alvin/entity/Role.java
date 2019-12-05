package com.alvin.entity;

import lombok.Data;

/**
 @Title 		:Role.java
 @Company 		:永硕
 @Package 		:com.alvin.entity
 @Description 	:角色表实体类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
@Data
public class Role{
	 private Integer roleId;//ID
	 private String roleName;//角色名
	 private Integer useState;//启用状态  0.未启用 1.已启用
	 private String remark;//备注
	 private Integer roleType;//角色类型 1：管理员 2：普通用户
	 private Integer orgId;//机构编号
	 private String createTime;//创建时间
	 private String updateTime;//修改时间
	 
	 public Role(){};
	 public Role(String roleName,Integer orgId){
		 this.roleName=roleName;
		 this.orgId=orgId;
	 }

}