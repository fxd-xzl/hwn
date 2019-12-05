package com.alvin.common;

/**
 * String or Integer is null or notNull 
 */
public class StringUtil {
	
	public static boolean isNotBlank(String str){
		if(str!=null && !"".equals(str)&&!str.equals("null")){
			return true;
		}else{
			return false;
		}
	} 
	
	public static boolean isNotBlank(Integer value){
		if(value !=null ){
			return true;
		}else{
			return false;
		}
	} 
	
	public static boolean isBlank(String str){
		if(str==null || "".equals(str)){
			return true;
		}else{
			return false;
		}
	} 
	public static boolean isBlank(Object str){
		if(str==null || "".equals(str)){
			return true;
		}else{
			return false;
		}
	} 
	
	/**
	 * 切割最后一位字符，例如：逗号
	 * @author fxd
	 * @param str 原字符
	 * @param symbol 需要切割的符号
	 * @return 
	 * @date  : 2019年9月16日 下午4:22:04 
	 * @since JDK 1.6
	 */
	public static String splitLastStr(String str,String symbol){
		if(str.substring(str.length()-1,str.length()).equals(symbol)){
			str=str.substring(0,str.length()-1);
		};
		return str;
	}
}
