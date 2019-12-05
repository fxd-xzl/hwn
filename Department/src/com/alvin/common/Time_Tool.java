package com.alvin.common;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Title       : Time_Tool.java 
 * @Company		: 永硕
 * @Package     : com.alvin.common 
 * @Description : TODO(日期工具类) 
 * @author      : fxd
 * @date        : 2019-4-19 下午5:30:13 
 * @version     : 版本 3.0
 */
public class Time_Tool {

	private static SimpleDateFormat sdr;

	/*
	 * ���ڸ�ʽ
	 * 
	 * ��ʽΪ:2015-01-01
	 */
	public static final String DATE_NOT_TIME = "yyyy-MM-dd";

	/*
	 * ���ڸ�ʽ
	 * 
	 * ��ʽΪ:2015-01-01 10:01:01
	 */
	public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE_TIME2 = "yyyy-MM-dd HH:mm";

	public static final String DATE_TIME3 = "yyyy-MM-dd-HH-mm";
	
	/**
	 * ʱ��ת��
	 * 
	 * @param ����
	 * @param ���ڵĸ�ʽ_ȡֵΪ�������
	 *            ��DATE_NOT_TIME��or��DATE_TIME��
	 * @return
	 */
	public static String toString(Date date, String dateForm) {
		sdr = new SimpleDateFormat(dateForm);
		return sdr.format(date);
	}

	/**
	 * 获取当前日期
	 * @author fxd
	 * @param dateForm 日期格式
	 * @return 
	 * @date  : 2019-4-19 下午5:26:47 
	 * @since JDK 1.6
	 */
	public static String getDate_Now(String dateForm) {
		sdr = new SimpleDateFormat(dateForm);
		return sdr.format(new Date());
	}
	public static void main(String[] args) {
	 System.out.println(getAge("1976-12-01"));	
	}
	/**
	 * 获取当前日期
	 * @author fxd
	 * @return 
	 * @date  : 2019-4-19 下午5:27:25 
	 * @since JDK 1.6
	 */
	public static Date getDate_Now() {
		return new Date();
	}
	/**
	 * ���ʱ��
	 * @param date
	 * @param dateForm
	 * @return
	 */
	public static Date getDate(String date,String dateForm){
		sdr = new SimpleDateFormat(dateForm);
		try {
			return sdr.parse(date);
		} catch (ParseException e) {
			System.out.println("ʱ���ʽ����");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过日期获取年龄
	 * @author fxd
	 * @param date
	 * @return 
	 * @date  : 2019-4-19 下午5:27:48 
	 * @since JDK 1.6
	 */
	public static double getAge(String date){
		String t1 = getDate_Now(DATE_TIME).replace("-", "/"); 
		String t2 = date.replace('-','/').replace(".", "/").split(" ")[0]; 
		Date dt1= new Date(t1); 
		Date dt2= new Date(t2); 
		Integer i=(int) (((dt1.getTime() - dt2.getTime())/(1000*60*60*24))/365); 
		DecimalFormat df = new DecimalFormat("0.00");
		String age=df.format((double)((dt1.getTime() - dt2.getTime())/(1000*60*60*24))/365);
		return Double.parseDouble(age);
	}
	
	
	/**
	 * ��ݷ��ӵõ��淶��ʱ�� HH:mm
	 * @author THINK 
	 * @param h
	 * @return 
	 * @since JDK 1.6
	 */
	public static String getSHMByH(int h,int s){
		String hms="";
		if (h>60) {
			int newh= h/60;//�õ�ʱ
			int m=h-60*newh;
			if (newh>=10) {
				hms=newh+":"+m+":"+s;
			}else{
				hms="0:"+newh+":"+m+":"+s;
			}
		}else{
			if (h>=10) {
				hms="00:"+h+":"+s;
			}else{
				hms="00:0"+h+":"+s;
			}
		}
		return hms;
	}
	/**
	 * 比较日期大小
	 * @author fxd
	 * @param comparetime
	 * @return 
	 * @date  : 2019-4-19 下午5:28:26 
	 * @since JDK 1.6
	 */
	public static boolean compare_date(String comparetime){
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			 Calendar c = Calendar.getInstance(); 
			 Date dt1 = df.parse(getDate_Now(DATE_NOT_TIME));
			 c.setTime(dt1);
			 int day=c.get(Calendar.DATE); 
			 c.set(Calendar.DATE,day-1); 
			String datanow= new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
			  dt1 =df.parse(datanow);
	         Date dt2 = df.parse(comparetime);
	         if ( dt2.getTime()>dt1.getTime()) {
	        	 return true;
	         }else{
	        	 return false;
	         }
		} catch (Exception e) {
			return false;
		}
		
	}
}
