package com.alvin.common;

import org.springframework.util.DigestUtils;

/**
 * MD5加密
 * @author Alvin
 *
 */
public class MD5Util {
	/**
	 * 生成md5
	 * @param seckillId
	 * @return
	 */
	public static String getMD5(String str) {
		String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
		return md5;
	} 
	
 
	
}
