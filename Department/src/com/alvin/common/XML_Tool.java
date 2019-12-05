package com.alvin.common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @Title : XML_Tool.java
 * @Company : 永硕
 * @Package : com.yongshuo.psycloud.common
 * @Description : TODO(XML处理工具类)
 * @author : fxd
 * @date : 2019-6-5 下午3:36:43
 * @version : 版本 3.0
 */
public class XML_Tool {

	
	/**
	 * 获取XML第二级所有节点
	 * @author fxd
	 * @param path
	 * @return 
	 * @date  : 2019-6-5 下午4:08:13 
	 * @since JDK 1.6
	 */
	public static Map<String, Object> xmlElement(String path) {
	
		Map<String, Object> map=new HashMap<String, Object>();
		SAXReader reader =null;
		Document doc=null;
		Element rootEle =null;
		try {
			reader = new SAXReader(); // 1.创建一个xml解析器对象

			doc = reader.read(new File(path));// 2.读取xml文档，返回Document对象
			// 通过document对象获取根元素的信息
			rootEle = doc.getRootElement();
			
			// 通过根元素获取下面的所有直接子元素
			List<Element> rchilds = rootEle.elements();

			// 遍历根元素下所有直接子元素
			for (Element e : rchilds) {
				// 获取子元素的属性
				map.put(e.getName(), e.getTextTrim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rootEle.clearContent();
			doc.clearContent();
			reader=null;
			
		}
		return map;
	}
	
 
}
