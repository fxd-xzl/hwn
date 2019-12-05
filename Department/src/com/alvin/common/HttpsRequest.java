package com.alvin.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import net.sf.json.JSONObject;
/**
 * @Title       : HttpsRequest.java 
 * @Company		: 永硕
 * @Package     : com.yongshuo.psycloud.common 
 * @Description : TODO(http 请求) 
 * @author      : ys-developer 
 * @date        : 2017-12-27 上午11:33:07 
 * @version     : 版本 3.0
 */
public class HttpsRequest {
	
	public static JSONObject httpsRequest(String requestUrl,String requestMethod,String message){
		JSONObject json=null;
		try {
			TrustManager[] tm={new MyX509TrustManager()};
			SSLContext ssl=SSLContext.getInstance("SSL", "SunJSSE");
			ssl.init(null, tm, new SecureRandom());
			
			SSLSocketFactory ssf=ssl.getSocketFactory();
			
			URL urlGet=new URL(requestUrl);
			
			HttpsURLConnection http=(HttpsURLConnection) urlGet.openConnection(); 
			
			http.setSSLSocketFactory(ssf);
			http.setDoOutput(true);
			http.setDoInput(true);
			http.setUseCaches(false);
			http.setRequestMethod(requestMethod);
			
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
			System.setProperty("sun.net.client.defaultReadTimeout", "30000");
			
			if(message!=null){
				OutputStream outputStream=http.getOutputStream();
				outputStream.write(message.getBytes("UTF-8"));
				outputStream.close();
			}
			
			InputStream is=http.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			BufferedReader reader=new BufferedReader(isr);
			String str=null;
			StringBuffer sb=new StringBuffer();
			
			while((str=reader.readLine())!=null){
				sb.append(str);
			}
			
			//�ͷ���Դ
			isr.close();
			reader.close();
			is.close();
			is=null;
			http.disconnect();
			json=JSONObject.fromObject(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return json;
	}
	
	
	
	public static JSONObject httpRequest(String requestUrl,String requestMethod,String message){
		JSONObject json=null;
		try {
			URL urlGet=new URL(requestUrl);
			HttpURLConnection http=(HttpURLConnection) urlGet.openConnection(); 
			
			http.setDoOutput(true);
			http.setDoInput(true);
			http.setUseCaches(false);
			http.setRequestMethod(requestMethod);
			
			if(message!=null){
				OutputStream outputStream=http.getOutputStream();
				outputStream.write(message.getBytes("UTF-8"));
				outputStream.close();
			}
			
			InputStream is=http.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			BufferedReader reader=new BufferedReader(isr);
			String str=null;
			StringBuffer sb=new StringBuffer();
			
			while((str=reader.readLine())!=null){
				sb.append(str);
			}
			
			//�ͷ���Դ
			isr.close();
			reader.close();
			is.close();
			is=null;
			http.disconnect();
			json=JSONObject.fromObject(sb.toString());
		} catch (Exception e) {
			System.out.println("----------请求连接失败："+requestUrl);
			//e.printStackTrace();
		} 
		return json;
	}
}

class MyX509TrustManager implements X509TrustManager{

	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		
	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}
