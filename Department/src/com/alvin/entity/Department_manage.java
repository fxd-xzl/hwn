package com.alvin.entity;

import lombok.Data;

/**
 @Title 		:Department_manage.java
 @Company 		:永硕
 @Package 		:com.alvin.entity
 @Description 	:实体类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
@Data
public class Department_manage{
	 private Integer departmentManageId;//部门管理编号
	 private String defectPerson;//负责人
	 private Integer contactPhone;//联系电话
	 private Integer departmentId;//所属部门
	 private Integer ORG_ID;//机构编号
	 private String departmentNames;//部门名称

}