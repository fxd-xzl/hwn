package com.alvin.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.alvin.common.BaseDao;
import com.alvin.common.Config_Xml;
import com.alvin.common.DBUtil;
import com.alvin.common.PATH;

/**
 * @Title       : DataSource.java 
 * @Company		: 永硕
 * @Package     : com.yongshuo.psycloud.common.psyassessment 
 * @Description : TODO(数据源) 
 * @author      : fxd
 * @date        : 2019-5-16 上午9:14:58 
 * @version     : 版本 3.0
 */
public class DBSource extends DBUtil{
	public static DataSource ds;
	private BaseDao sql;
	/**
	 * 不带事务 
	 * @author fxd
	 * @return 
	 * @date  : 2019年9月16日 上午11:42:58 
	 * @since JDK 1.6
	 */
	public BaseDao getSql() {
		sql=new BaseDao(getConnection());
		return sql;
	}
	/**
	 * 带事务 
	 * @author fxd
	 * @param conn
	 * @return 
	 * @date  : 2019年9月16日 上午11:34:57 
	 * @since JDK 1.6
	 */
	public BaseDao getSql(Connection conn) {
		sql=new BaseDao(conn);
		return sql;
	}
	public DBSource() {
		if (ds==null) {
			try {
				 ds=getDataSource(Config_Xml.config_path+PATH.DB_XML);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 获取连接
	 * @author fxd
	 * @return 
	 * @date  : 2019-5-16 上午9:14:50 
	 * @since JDK 1.6
	 */
	public static Connection getConnection() {
		Connection conn=null;
		if (ds==null) {
			new DBSource();
		}
		try {
			conn= ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
