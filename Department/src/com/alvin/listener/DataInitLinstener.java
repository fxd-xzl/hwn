package com.alvin.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.alvin.common.Config_Xml;

/**
 * @Title       : DataInitLinstener.java 
 * @Company		: 永硕
 * @Package     : com.alvin.listener 
 * @Description : TODO(数据初始化监听) 
 * @author      : fxd
 * @date        : 2019-8-22 上午11:13:38 
 * @version     : 版本 3.0
 */
public class DataInitLinstener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			System.out.println("初始化数据");
			String configPath =arg0.getServletContext().getRealPath("").toString();
			configPath+="/WEB-INF/classes/config/";
			new Config_Xml().init(configPath);
			 
			System.out.println("初始化数据完毕");
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
