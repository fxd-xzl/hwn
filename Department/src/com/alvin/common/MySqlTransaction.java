package com.alvin.common;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * @Title       : MySqlTransaction.java 
 * @Company		: 永硕
 * @Package     : com.alvin.jdbc 
 * @Description : TODO(事务处理类) 
 * @author      : fxd
 * @date        : 2019-4-17 下午6:13:50 
 * @version     : 版本 3.0
 */
public class MySqlTransaction{

	private Connection con;
	/**
	 * 初始化连接
	 * Creates a new instance of  MySqlTransaction. 
	 * @throws DaoException
	 */
	public MySqlTransaction(Connection conn) throws DaoException{
		try {
			this.con=conn;
			con.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	/**
	 * 提交事务
	 * @author fxd
	 * @throws DaoException 
	 * @date  : 2019-4-17 下午6:30:55 
	 * @since JDK 1.6
	 */
	public void commit() throws DaoException{
		try {
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e1) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DaoException(e);
			}
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con=null;
		}
		 
	}
	
	/**
	 * 事务回滚
	 * @author fxd
	 * @throws DaoException 
	 * @date  : 2019年9月16日 上午11:25:34 
	 * @since JDK 1.6
	 */
	public void rollback() throws DaoException {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
 
	/**
	 * 获取连接
	 * @author fxd
	 * @return 
	 * @date  : 2019-4-17 下午6:31:04 
	 * @since JDK 1.6
	 */
	public Connection getConnection() {
		return con;
	}



}
