package com.survey.sql;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	private ConnectionFactory(){
		
	}
	/**
	 * 链接数据库
	 * @return
	 */
	public static Connection getConnection(){
		try {
			String JNDIname=(String)new javax.naming.InitialContext().lookup("java:comp/env/JNDIname");
			return ConnectionFactory.getConnection(JNDIname);
		} catch (NamingException e) {
			 
			System.out.print("数据库链接失败："+e.getMessage());
		}
		return null;
	}
	/**
	 * ͨ链接数据库
	 * @param JNDIname
	 * @return Connection
	 */
	public static Connection getConnection(String JNDIname){
		 
		try {
			Context initCtx = new InitialContext();
		      Context envCtx = (Context) initCtx.lookup("java:comp/env");
		      DataSource ds = (DataSource) envCtx.lookup(JNDIname);

			return ds.getConnection();
		} catch (NamingException e1) {
		 
			System.out.print("数据库链接失败："+e1.getMessage());
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		

	}
}
