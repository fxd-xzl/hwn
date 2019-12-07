package com.alvin.action;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.alvin.common.CodeResult;
import com.alvin.common.StringUtil;
import com.alvin.entity.Admin;

import net.sf.json.JSONObject;

/**
 * @Title       : BaseAction.java 
 * @Company		: 
 * @Package     : com.alvin.action 
 * @Description : TODO() 
 * @author      : fxd
 * @date        : 2019-4-19 下午2:13:00 
 * @version     : 版本 3.0
 */
public class BaseAction {

	protected final String ADMIN_SESSION="admin";
	protected JSONObject jsonObj;
	protected Admin getAdmin(HttpServletRequest request){
		
		return (Admin) request.getSession().getAttribute(ADMIN_SESSION);
	};
	/**
	 * 结果输出
	 * @author fxd
	 * @param response
	 * @param jsonobj 
	 * @date  : 2019-4-19 下午2:14:08 
	 * @since JDK 1.6
	 */
	protected void out(HttpServletResponse response, Object jsonobj) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(JSON.toJSONString(jsonobj).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 支持跨域请求
	 * @author fxd
	 * @param response 
	 * @since JDK 1.6
	 */
	protected void crossComain(HttpServletResponse response,HttpServletRequest request){
		//设置允许跨域请求
		response.setContentType("textml;charset=UTF-8");
		response.setHeader("Access-Control-Max-Age","0");
		response.setHeader("Access-Control-Allow-Headers", "Origin,No-Cache,X-requested-With,If-Modified-Since,Pragma,last-Modified,Cache-Control-Expires,Content-Type,X-E4M-With,userId,token");
		response.setHeader("XDomainRequestAllowed", "1");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//是否支持跨域请求
		//response.setHeader("Access-Control-Allow-Origin", "http://localhost:8083");//是否支持跨域请求
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials","true");//是否支持cookie 跨域
        response.setHeader("Access-Control-Allow-Credential","true");//是否支持cookie 跨域
        response.setHeader("P3P", "CP=CAO PSA OUR");
        if (request.getHeader("Access-Control-Request-Method")!=null&&"OPTIONS".equals(request.getMethod())) {
			response.setHeader("Access-Control-Allow-Mehtods", "POST,GET,OPTIONS,DELETE");
			response.setHeader("Access-Control-Allow-Headers", "Content-Type,Origin,Accept");
			response.setHeader("Access-Control-Max-age", "120");
		}
	}
	
	
	/**
	 * @Description : TODO(将对象转成String) 
	 * @author fxd 
	 * @return 
	 * @since JDK 1.6
	 */
	protected String objConverString(Object obj) {
		StringBuffer sb=new StringBuffer();
		 Field[] declaredFields = obj.getClass().getDeclaredFields();
		   for (Field field : declaredFields) {    
	            field.setAccessible(true);  
	            try {
	            	if (field.get(obj)!=null&&!field.get(obj).equals("null")) {
	            		sb.append(field.getName()+"="+field.get(obj)+"&");
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
	        }  
		   return sb.toString();
	}
	
	
	/**
	 * 验证对象不为空
	 * @author fxd
	 * @param obj
	 * @return 
	 * @since JDK 1.6
	 */
	protected boolean validateIsNotNull(Object obj,JSONObject jsonObj){
		 String validateIsNull=objConverString(obj);
		 if (validateIsNull.length()==0) {
			 CodeResult.setResult(jsonObj, 11, "");
			 return false;
		 }
		 return true;
	}
	

	/**
	 * 验证编号不为空
	 * @author fxd
	 * @param obj
	 * @return 
	 * @since JDK 1.6
	 */
	protected boolean validateIsNotNull(String ids,JSONObject jsonObj){
		 if (StringUtil.isBlank(ids)) {
			 CodeResult.setResult(jsonObj, 11, "");
			 return false;
		 }
		 return true;
	}
	/**
	 * 文件上传
	 * @author fxd
	 * @param request
	 * @return 
	 * @date  : 2019年9月25日 下午3:41:46 
	 * @since JDK 1.6
	 */
	protected boolean  fileUpload(HttpServletRequest request,String savePath,String fileName) {
		boolean isok=false;
		try {
			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			// 判断 request 是否有文件上传,即多部分请求
			if (multipartResolver.isMultipart(request)) {
				// 转换成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					// 记录上传过程起始时的时间，用来计算上传时间
					// 取得上传文件
					MultipartFile file = multiRequest.getFile(iter.next());
					if (file != null) {
						 	String filepath = savePath + File.separator + fileName;
							File localFile = new File(filepath);
							try {
								file.transferTo(localFile);
							} catch (IllegalStateException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							isok= true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isok;
	}
}
