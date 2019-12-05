package com.alvin.common;

import java.lang.reflect.Field;

/**
 * @Title       : ObjectConvertStr.java 
 * @Company		: 永硕
 * @Package     : com.alvin.jdbc 
 * @Description : TODO(对象转换成字符串) 
 * @author      : fxd
 * @date        : 2019-4-19 下午2:42:14 
 * @version     : 版本 3.0
 */
public class ObjectConvertStr {
	
	/**
	 * 转换查询Sql 语句
	 * @author fxd
	 * @param obj
	 * @return 
	 * @date  : 2019-4-19 下午2:43:08 
	 * @since JDK 1.6
	 */
	public static String cSelectSql(Object obj,StringBuffer sb,Boolean... isLike){
		
		slipce_And(sb);
		Field[] field=obj.getClass().getDeclaredFields();
		for (Field f : field) {
			f.setAccessible(true);
			try {
				//如果等于空，则不添加条件中
				if (f.get(obj)==null||f.get(obj).equals("null")) {
					continue;
				}
				StringBuilder cond=new StringBuilder();
				Object value=f.get(obj);
				if(value instanceof Integer||value instanceof Boolean||value instanceof Double) {
					cond.append(f.getName()).append("=").append(f.get(obj)).append(" and ");
				}
				else{
					//模糊查询
					if (isLike.length>0) {
						cond.append(f.getName()).append(" like '%").append(f.get(obj)).append("%' and ");
					}else{
						cond.append(f.getName()).append("='").append(f.get(obj)).append("' and ");
					}
				}
				//如果条件中已存在，则不需要再添加
				if (sb.toString().indexOf(cond.toString())>-1) {
					continue;
				}
				sb.append(cond.toString());
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//截取掉 多余的 and
		if (sb.length()>0) {
			sb.delete(sb.length()-4, sb.length());
		}
		return sb.toString();
	}
	
	/**
	 * 拼接 and
	 * @author fxd
	 * @param sb 
	 * @date  : 2019-4-19 下午3:21:47 
	 * @since JDK 1.6
	 */
	private static void slipce_And(StringBuffer sb){
		
		if (sb.length()==0) {
			return;
		}
		//将字符串分解成char 数组
		char[] str=sb.toString().toCharArray();
		String and="";
		int num=0;
		//倒序循环，找到最后的三位字符，判断是否是and
		for (int i = str.length-1; i >=0; i--) {
			if (num==3) {
				break;
			}
			if ((str[i]>='a'&&str[i]<='z')||(str[i]>='A'&&str[i]<='Z')) {
				num++;
				and+=str[i];
			}
		}
		//如果不是and ,那就拼接
		if (!and.equals("dna")) {
			sb.append(" and "); 
		}
	}
	
	/**
	 * 转换编辑 sql语句
	 * @author fxd
	 * @param obj
	 * @param sb
	 * @return 
	 * @date  : 2019-4-19 下午3:32:51 
	 * @since JDK 1.6
	 */
	public static String cUpdSql(Object obj,StringBuffer sb){
		Field[] field=obj.getClass().getDeclaredFields();
		for (Field f : field) {
			f.setAccessible(true);
			try {
				//如果等于空，则不添加条件中
				if (f.get(obj)==null||f.get(obj).equals("null")) {
					continue;
				}
				//如果条件中已存在，则不需要再添加
				if (sb.toString().indexOf(f.getName())>-1) {
					continue;
				}
				
				
				Object value=f.get(obj);
				if(value instanceof Integer||value instanceof Boolean||value instanceof Double) {
					sb.append(",").append(f.getName()).append("=").append(f.get(obj));
				}
				else{
					sb.append(",").append(f.getName()).append("='").append(f.get(obj)).append("'");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	 

}
