package com.alvin.entity;

import lombok.Data;

/**
 @Title 		:Menu.java
 @Company 		:永硕
 @Package 		:com.alvin.entity
 @Description 	:菜单表实体类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
@Data
public class Menu{
	 private Integer menuId;//菜单编号
	 private String menuTitle;//菜单名称
	 private String menuIcon;//菜单的图标
	 private String menuTo;//菜单跳转的位置
	 private Integer pid;//父级编号
	 private Integer orgId;//机构编号 

}