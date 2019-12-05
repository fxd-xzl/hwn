package com.alvin.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




/**
 * @Title       : Common.java 
 * @Company		: 永硕
 * @Package     : com.alvin.common 
 * @Description : TODO(获取配置文件信息) 
 * @author      : fxd
 * @date        : 2019-3-21 下午3:48:53 
 * @version     : 版本 3.0
 */
public class ConfigTool {

	
	/**
	 * 读取配置文件
	 * @return
	 * @throws IOException
	 */
	public  Properties Properties() throws IOException{
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("config.properties");
		Properties props = new Properties();
		props.load(inputStream);
		return props;
	}
	  
	/**
	 * 通过名称得到配置文件的值
	 * @author mr.fan 
	 * @param name
	 * @return
	 * @throws IOException 
	 * @since JDK 1.6
	 */
	public static String GetPropertiesByName(String name) {
		try {
			ConfigTool com = new ConfigTool();
			Properties props = com.Properties();
			return	props.getProperty(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}
	

	
}
