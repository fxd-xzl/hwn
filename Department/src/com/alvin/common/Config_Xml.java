package com.alvin.common;

import java.util.Map;


/**
 * @Title       : GetPropertiesValue.java 
 * @Company		: 永硕
 * @Package     : com.yongshuo.psycloud.common 
 * @Description : TODO(获取配置文件的值) 
 * @author      : ys-developer 
 * @date        : 2017-12-15 下午5:19:34 
 * @version     : 版本 3.0
 */
public class Config_Xml {

	
	private static Map<String, Object> map;
	 
	public static String config_path;
	
 
	public static void getConfig(){
		 
	}
	

	 
	/**
	 * 初始化配置，保存到map中
	 * @author fxd 
	 * @date  : 2019-6-5 下午4:15:39 
	 * @since JDK 1.6
	 */
	public void init(String path){
		try {
			config_path=path;
			path =path+PATH.CONFIG_XML;
			map=XML_Tool.xmlElement(path);
			getConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	
	
}
