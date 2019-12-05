package com.alvin.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

/**
 * @Title       : DBUtil.java 
 * @Company		: 永硕
 * @Package     : com.yongshuo.psycloud.common 
 * @Description : TODO(数据库工具类，获取数据源) 
 * @author      : fxd
 * @date        : 2019-6-5 下午3:41:49 
 * @version     : 版本 3.0
 */
public class DBUtil {

	
	

	public DataSource getDataSource(String xmlFilePath){
		DataSource ds=null;
		try {
			Map<String, Object> map=XML_Tool.xmlElement(xmlFilePath);
			// 加载属性文件中的数据库配置信息
			// 1. 加载驱动类
			Class.forName(map.get("SQL_DRIVER").toString());

			// 设置连接数据库的配置信息
			DataSource ds_unpooled = DataSources.unpooledDataSource(map.get("SQL_URL").toString(),map.get("USERNAME").toString(), map.get("PASSWORD").toString());
			map.put("usesTraditionalReflectiveProxies", false);
			if (ds == null) {
				ds = DataSources.pooledDataSource(ds_unpooled, map);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	/**
	 * 获取properties
	 * @author fxd
	 * @param filepath 文件名
	 * @return 
	 * @date  : 2019-5-15 上午10:27:29 
	 * @since JDK 1.6
	 */
	protected Map<String, Object> properties(String filepath){
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream(filepath);
		Properties props = new Properties();
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			props.load(inputStream);
			Set<Object> p=  props.keySet();
			for (Object key : p) {
				map.put(key.toString(), props.get(key));
			}
			p.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
