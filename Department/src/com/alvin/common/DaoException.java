package com.alvin.common;

import java.util.HashMap;

/**
 * ��ݲ��Զ����쳣
 * 
 * @Start time:2016-5-31
 */
public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Exception exception;
	private HashMap<String, Object> hashMap;

	public DaoException(Exception exception) {
		hashMap = new HashMap<String, Object>();
		this.exception = exception;
	}

	public void print() {
		this.exception.printStackTrace();
	}

	public void save() {

	}

	public void setHashMap(String key, Object val) {
		this.hashMap.put(key, val);
	}

	@Override
	public void printStackTrace() {
		this.exception.printStackTrace();
	}

}
