package com.alvin.entity;

import lombok.Data;

/**
 @Title 		:Department.java
 @Company 		:永硕
 @Package 		:com.alvin.entity
 @Description 	:部门表实体类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
@Data
public class Department{
	 private Integer departmentId;//ID
	 private String dmName;//名称 
	 private Integer pid;//父级编号
	 private String pids;//父级连编号
	 private Integer orgId;//机构编号 
	 private String createTime;//创建时间
	 private String updateTime;//修改时间

}