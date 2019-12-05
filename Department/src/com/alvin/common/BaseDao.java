package com.alvin.common;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Title       : BaseDao.java 
 * @Package     : com.alvin.jdbc 
 * @Description : TODO(数据库操作方法类) 
 * @author      : fxd
 * @date        : 2019-3-21 下午2:19:07 
 * @version     : 版本 3.0
 */
public class BaseDao {  
	
	//数据库连接
	protected Connection connection;
	protected PreparedStatement ps;
	protected ResultSet rs;
    protected boolean isTran;
	
	public BaseDao(Connection conn){
		this.connection=conn;
		this.isTran=true;
	}
	/**
	 * 增删改
	 * @author fxd
	 * @param sql sql 语句
	 * @param params 参数
	 * @return true 成功 false 失败
	 * @throws SQLException 
	 * @date  : 2019-3-21 下午2:26:11 
	 * @since JDK 1.6
	 */
	public Integer executeUpdate(String sql, Object... params) throws DaoException  {
		int key= -1;
		try {
			if (isTran==false) {
				connection.setAutoCommit(true);//自动提交
			}
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			 ps.executeUpdate();
			rs = ps.getGeneratedKeys(); // 获取自增主键编号
			if (rs.next()) {
				key = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("error sql:"+sql);
			DaoException dao=new DaoException(e);
			throw dao;
		}finally{
			if (this.isTran) {
				this.release();
			}else{
				this.releaseConn();
			}
		}
		return key;
	}
	 

   
	 
	/**
	 * 查询单条记录(反射机制)
	 * @author fxd
	 * @param sql sql 语句
	 * @param entity 实体类
	 * @param params 参数
	 * @return 对应的实体类结果
	 * @throws Exception 
	 * @date  : 2019-3-21 下午6:03:15 
	 * @since JDK 1.6
	 */
    public <T> T selectOne(String sql,Class<T> entity,Object... params) throws DaoException{  
    	T resultObject = null;
        
        try {
        	 getResult(sql, params);
         	 
             ResultSetMetaData metaData = rs.getMetaData(); //取出查询的所有列 
             int col_len = metaData.getColumnCount(); //列的数量
             if(rs.next()){  
            	 resultObject=entity.newInstance(); //创建实例
            	 Method[] ms=entity.getMethods(); //取出这个反射实例的所有方法 get/set
            	 //开始循环所有列，将结果添加到实例中
                 for(int i=0; i<col_len; i++ ){  
                	 String cols_name = metaData.getColumnName(i+1);  //获取属性名
                	 setResult(ms, resultObject, cols_name);
                 }  
             }  
		}catch (InstantiationException e) {
			System.err.println("fxd:实例化异常,不允许使用内部类");
		}
        catch (SQLException e) {
			System.out.println("error sql:"+sql);
			DaoException dao=new DaoException(e);
			throw dao;
		}catch (Exception e) {
			DaoException dao=new DaoException(e);
			throw dao;
		}
        finally{
			this.releaseConn();
		}
        return resultObject;  
    }  
    
    /**
	 * 查询单条记录(反射机制)
	 * @author fxd
	 * @param sql sql 语句
	 * @param entity 实体类
	 * @param params 参数
	 * @return 对应的实体类结果
	 * @throws Exception 
	 * @date  : 2019-3-21 下午6:03:15 
	 * @since JDK 1.6
	 */
    public <T> T selectOne(String sql,Class<T> entity,Connection conn,Object... params) throws DaoException{  
    	T resultObject = null;
        
        try {
        	 getResult(sql,conn, params);
         	 
             ResultSetMetaData metaData = rs.getMetaData(); //取出查询的所有列 
             int col_len = metaData.getColumnCount(); //列的数量
             if(rs.next()){  
            	 resultObject=entity.newInstance(); //创建实例
            	 Method[] ms=entity.getMethods(); //取出这个反射实例的所有方法 get/set
            	 //开始循环所有列，将结果添加到实例中
                 for(int i=0; i<col_len; i++ ){  
                	 String cols_name = metaData.getColumnName(i+1);  //获取属性名
                	 setResult(ms, resultObject, cols_name);
                 }  
             }  
		}catch (InstantiationException e) {
			System.err.println("fxd:实例化异常,不允许使用内部类");
		}
        catch (SQLException e) {
			System.out.println("error sql:"+sql);
			DaoException dao=new DaoException(e);
			throw dao;
		}catch (Exception e) {
			DaoException dao=new DaoException(e);
			throw dao;
		}
        finally{
			this.release();
		}
        return resultObject;  
    }  
   
     
    /**
     * 查询多条数据返回Map （可自定义 key）
     * @author fxd
     * @param sql 查询语句
     * @param entity 返回对象
     * @param keyName 自定义key，如果为空默认按实体类的第一个属性做为key (可选择实体类的任何一个属性做为key)
     * @param params 查询参数
     * @return key--entity
     * @throws Exception 
     * @date  : 2019-4-2 上午10:45:46 
     * @since JDK 1.6
     */
    public <T> Map<Object, T> selectListByMap(String sql,Class<T> entity,String keyName,Object...params) throws Exception{
    	
    	Map<Object, T> resultMap=new HashMap<Object, T>();
    	//获取查询结果
    	List<T> list=selectList(sql, entity, params);
    	
    	//循环查询结果，添加到map 中
    	for (T t : list) {
    		//将对象转成 field 数组
			Field[] declaredFile=t.getClass().getDeclaredFields();
			//如果keyName 为空，默认设置实体类的第一个属性为key
			if (keyName==null) {
				declaredFile[0].setAccessible(true);
				resultMap.put(declaredFile[0].get(t), t);
				continue;
			}
			//循环所有的属性，找到key
			for (Field item : declaredFile) {
				item.setAccessible(true);
				if (item.getName().equals(keyName)) {
					resultMap.put(item.get(t), t);
					break;
				}
			}
		}
    	return resultMap;
    	
    }
    
    
    /**
     * 查询多条数据(反射机制)
     * @author fxd
     * @param sql sql 语句
     * @param entity 实例类
     * @param params 参数
     * @return 多条数据结果
     * @throws Exception 
     * @date  : 2019-3-21 下午6:08:31 
     * @since JDK 1.6
     */
    public  <T> List<T> selectList(String sql,Class<T> entity,Object... params) throws DaoException{
    	List<T> resultList=new ArrayList<T>();
    	 try {
    		 T resultObject = null;
    		 
    		 getResult(sql, params);
         	 
             ResultSetMetaData metaData = rs.getMetaData(); //取出查询的所有列 
             int col_len = metaData.getColumnCount(); //列的数量
             while(rs.next()){  
            	 resultObject=entity.newInstance(); //创建实例
            	 Method[] ms=entity.getMethods(); //取出这个反射实例的所有方法 get/set
            	 //开始循环所有列，将结果添加到实例中
                 for(int i=0; i<col_len; i++ ){  
                	 String cols_name = metaData.getColumnName(i+1);  //获取属性名
                	 setResult(ms, resultObject, cols_name);
                 }  
                 resultList.add(resultObject);
             }  
		}catch (InstantiationException e) {
			System.err.println("fxd:实例化异常,不允许使用内部类");
		}
        catch (Exception e) {
			System.out.println("error sql:"+sql);
			DaoException dao=new DaoException(e);
			throw dao;
		}finally{
			this.releaseConn();
		}
        return resultList;  
    }
    
    /**
     * 获取数据库的返回结果
     * @author fxd
     * @param sql sql语句
     * @param params 参数
     * @throws SQLException 
     * @date  : 2019-3-21 下午6:14:31 
     * @since JDK 1.6
     */
    private void getResult(String sql,Object... params) throws SQLException{
    	 int index  = 1;
         ps = connection.prepareStatement(sql);  
         if(params != null ){  
             for(int i=0; i<params.length; i++){  
                 ps.setObject(index++, params[i]);  
             }  
         }  
         rs = ps.executeQuery();//返回查询结果  
    }
    
    /**
     * 获取数据库的返回结果
     * @author fxd
     * @param sql sql语句
     * @param params 参数
     * @throws SQLException 
     * @date  : 2019-3-21 下午6:14:31 
     * @since JDK 1.6
     */
    private void getResult(String sql,Connection conn,Object... params) throws SQLException{
    	 int index  = 1;
         ps = conn.prepareStatement(sql);  
         if(params != null ){  
             for(int i=0; i<params.length; i++){  
                 ps.setObject(index++, params[i]);  
             }  
         }  
         rs = ps.executeQuery();//返回查询结果  
    }
    /**
     * 设置结果值
     * @author fxd
     * @param ms 反射实例的所有方法 get/set
     * @param t 实例对象
     * @param cols_name 列名
     * @throws SQLException 
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException 
     * @throws NoSuchFieldException 
     * @throws SecurityException 
     * @date  : 2019-3-21 下午5:36:08 
     * @since JDK 1.6
     */
    private  void setResult(Method[] ms,Object t,String cols_name ) throws SQLException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException{
    	if (rs.getObject(cols_name)==null) {
			return;
		}
    	//获取当前列的类型
    	String ctypename=rs.getObject(cols_name).getClass().getName();
    	//列名加set 用于和发射的方法判断
    	String setName="set"+cols_name;
    	String name=null;
    	//循环反射方法
    	for (Method m : ms) {
    		name=m.getName();
    		//如果当前的方法不等于里面，继续循环
    		if (!name.equalsIgnoreCase(setName)) {
				continue;
			}
    		
			if("java.lang.Integer".equals(ctypename)||"java.lang.Long".equals(ctypename)){
				m.invoke(t,rs.getInt(cols_name));
				break;
			}
			if("java.lang.String".equals(ctypename)){
				m.invoke(t, rs.getString(cols_name));
				break;
			}
			if("java.math.BigDecimal".equals(ctypename)){
				try{
					m.invoke(t, rs.getBigDecimal(cols_name));
				}catch(Exception e1){
					m.invoke(t, rs.getDouble(cols_name));
				}
				break;
			}
			if("java.sql.Timestamp".equals(ctypename)){
				m.invoke(t, rs.getString(cols_name));
				break;
			}
			if("java.sql.Date".equals(ctypename)){
				m.invoke(t, rs.getString(cols_name));
				break;
			} 
			if("java.sql.Time".equals(ctypename)){
				m.invoke(t, rs.getString(cols_name));
				break;
			} 
			if("java.lang.Float".equals(ctypename)){
				m.invoke(t, rs.getFloat(cols_name));
				break;
			} 
			if("java.lang.Double".equals(ctypename)){
				m.invoke(t, rs.getDouble(cols_name));
				break;
			}else{
				m.invoke(t, rs.getString(cols_name));
			}
		}
    }
    
    
    /**
     * 查询数量
     * @author fxd
     * @param sql
     * @param params
     * @return 单个数量
     * @throws Exception 
     * @date  : 2019-4-2 上午9:39:06 
     * @since JDK 1.6
     */
    public Integer selectCount(String sql,Object... params) throws DaoException {
    	Integer count=0;
    	try {
    		getResult(sql, params);
			ResultSetMetaData metaData = rs.getMetaData(); //取出查询的列 
	        if(rs.next()){  
                count=rs.getInt(metaData.getColumnName(1));//获取第一列
	        }
		} catch (Exception e) {
			System.out.println("error sql:"+sql);
			DaoException dao=new DaoException(e);
			throw dao;
		}finally{
			this.releaseConn();
		}
    	return count;
    }
    
    /**
     * 查询数量
     * @author fxd
     * @param sql
     * @param params
     * @return 单个数量
     * @throws Exception 
     * @date  : 2019-4-2 上午9:39:06 
     * @since JDK 1.6
     */
    public Integer selectCount(String sql,Connection conn,Object... params) throws DaoException {
    	Integer count=0;
    	try {
    		getResult(sql,conn, params);
			ResultSetMetaData metaData = rs.getMetaData(); //取出查询的列 
	        if(rs.next()){  
                count=rs.getInt(metaData.getColumnName(1));//获取第一列
	        }
		} catch (Exception e) {
			System.out.println("error sql:"+sql);
			DaoException dao=new DaoException(e);
			throw dao;
		}finally{
			this.release();
		}
    	return count;
    }
    /**
     * 批量处理，增删改
     * @author fxd
     * @param insert_sql
     * @param list
     * @throws Exception 
     * @date  : 2019-4-1 下午5:20:45 
     * @since JDK 1.6
     */
    public  void batchUpdate(String sql, List<Object[]> list) throws DaoException {
    	try {
			connection.setAutoCommit(true);//自动提交
			ps= connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
            if (list != null && list.size() > 0) {
            	for (int i = 0; i < list.size(); i++) {
    				Object[] obj= list.get(i);
    				for (int j = 0; j < obj.length; j++) {
    					ps.setObject(j + 1, obj[j]); 
    				}
    				ps.addBatch();   //加入批处理
    			}
    		}
            ps.executeBatch(); // 执行批量处理  
		} catch (SQLException e) {
			System.out.println("error sql:"+sql);
			DaoException dao=new DaoException(e); 
			throw dao;
		}finally{
			this.releaseConn();
		}
    	
	}
     
    /**
     * 批量处理，增删改
     * @author fxd
     * @param insert_sql
     * @param list
     * @param con 
     * @throws Exception 
     * @date  : 2019-4-1 下午5:20:45 
     * @since JDK 1.6
     */
    public void batchUpdateTran(String sql, List<Object[]> list) throws DaoException {
    	try {
            ps= connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
            if (list != null && list.size() > 0) {
            	for (int i = 0; i < list.size(); i++) {
    				Object[] obj= list.get(i);
    				for (int j = 0; j < obj.length; j++) {
    					ps.setObject(j + 1, obj[j]); 
    				}
    				ps.addBatch();   //加入批处理
    			}
    		}
            ps.executeBatch(); // 执行批量处理  
		} catch (SQLException e) {
			System.out.println("error sql:"+sql);
			DaoException dao=new DaoException(e);
			throw dao;
		}finally{
			this.release();
		}
    	
	}
    /**
     * 批量新增 （泛型对象）
     * @author fxd
     * @param insert_sql
     * @param list
     * @throws Exception 
     * @date  : 2019-4-1 下午5:20:45 
     * @since JDK 1.6
     */
    public <T> void batchInsert_T(String sql, List<T> list) throws DaoException  {
    	
    	if (sql.indexOf("insert")<0) {
    		 
			Exception e= new Exception("fxd：只允许insert操作");
			DaoException dao=new DaoException(e);
			throw dao;
		}
    	try {
    	
			connection.setAutoCommit(true);//自动提交
			ps= connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
			
			String[] params=new String[]{};
			//截取 参数
			if (list!=null&&list.size()>0) {
				String sql2=sql.split("values")[0];
				sql2=sql2.substring(sql2.indexOf("(")+1,sql2.lastIndexOf(")"));
				params=sql2.split(",");
				
			}
			//循环 参数值，添加到ps 中
            if (list != null && list.size() > 0) {
            	for (int i = 0; i < list.size(); i++) {
            		//获取属性值
            		Map<String, String> paramsValue= getParamsValue(list.get(i));
            		//循环需要添加的参数
            		for (int j = 0; j < params.length; j++) {
            			//赋值
                		ps.setObject(j + 1, paramsValue.get(params[j])); 
                	}
            		ps.addBatch();   //加入批处理
				}
    		}
            ps.executeBatch(); // 执行批量处理  
		}catch (Exception e) {
			System.out.println("error sql:"+sql);
			DaoException dao=new DaoException(e);
			throw dao;
		}finally{
			this.releaseConn();
		}
	}  
    
    /**
     * 获取object 的属性和属性值
     * @author fxd
     * @param obj
     * @return map 集合
     * @date  : 2019-4-2 上午9:13:59 
     * @since JDK 1.6
     */
    private Map<String, String> getParamsValue(Object obj){
    	Map<String, String> paramsValue=new HashMap<String, String>();
    	Field[] declaredFields= obj.getClass().getDeclaredFields();
		for (Field item : declaredFields) {
			item.setAccessible(true);  
			try {
				paramsValue.put(item.getName(), item.get(obj).toString());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return paramsValue;
    }
      
    
    
	/**
	 * 释放数据库连接
	 * @author fxd 
	 * @date  : 2019-3-21 下午6:18:16 
	 * @since JDK 1.6
	 */
    public void releaseConn(){  
    	if (rs != null) {
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
				ps=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
				connection=null;
				
			} catch (SQLException e) {
				e.printStackTrace();
				connection=null;
			}
		}
    }  
    
    /**
     * 释放数据库返回结果
     * @author fxd 
     * @date  : 2019-3-21 下午6:18:11 
     * @since JDK 1.6
     */
    public void release(){  
    	if (rs != null) {
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
				ps=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }  
    
  
	
   
  
}  
