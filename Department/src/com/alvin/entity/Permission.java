package com.alvin.entity;

import lombok.Data;

/**
 @Title 		:Permission.java
 @Company 		:永硕
 @Package 		:com.alvin.entity
 @Description 	:权限表实体类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
@Data
public class Permission{
	 private Integer permissionId;//权限编号
	 private String permissionName;//权限名称 
	 private Integer menuId;//所在页面ID
	 private String styleID;//前端样式编号

}