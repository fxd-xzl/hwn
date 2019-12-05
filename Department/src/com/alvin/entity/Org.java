package com.alvin.entity;

import lombok.Data;

/**
 @Title 		:Org.java
 @Company 		:永硕
 @Package 		:com.alvin.entity
 @Description 	:实体类
 @author 		:fxd
 @date 			:2019-12-02 22:56
 @version 		:版本 3.0
*/
@Data
public class Org{
	 private Integer orgId;//机构编号
	 private String orgName;//机构名称
	 private String createTime;//创建时间
	 private String updateTime;//修改时间
	 public Org(){};
	 public Org(String orgName){
		 this.orgName=orgName;
	 }

}