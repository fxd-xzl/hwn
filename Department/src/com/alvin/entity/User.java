package com.alvin.entity;

import lombok.Data;

/**
 @Title 		:User.java
 @Company 		:永硕
 @Package 		:com.alvin.entity
 @Description 	:用户表实体类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
@Data
public class User{
	 private Integer userId;//ID
	 private String userNo;//编号 
	 private String userJobNo;//工号 
	 private String userName;//姓名  
	 private Integer userType;//类型  1.内部
	 private Integer departmentId;//部门
	 private String userLoginName;//用户名 
	 private String userPwd;//密码
	 private Integer roleId;//角色
	 private String userIDcard;//身份证号
	 private Integer gender;//性别
	 private String address;//地址
	 private Integer occupation;//岗位
	 private String userPhone;//联系电话
	 private String userPhoto;//照片
	 private Integer userState;//状态  1.正常 0.禁用
	 private Integer orgId;//机构编号
	 private String createTime;//创建时间
	 private String updateTime;//修改时间
	 public User(){}
	 public User(String userLoginName,Integer orgId){
		 this.userLoginName=userLoginName;
		 this.orgId=orgId;
	 }

}