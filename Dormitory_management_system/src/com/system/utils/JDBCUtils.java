﻿package com.system.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
/**
 * 获取连接和释放连接的工具类
 * @author Chunsheng Zhangs
 *
 */
public class JDBCUtils {
	private static DataSource dataSource;
	
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	
	static {
		try {
			//1、读取druip.properties文件
			Properties pro = new Properties();
			pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
			
			//2、连接连接池
			dataSource = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//获取连接
	public static Connection getConnection() {
		Connection connection = threadLocal.get();
		try {
			if(connection == null) {
				connection = dataSource.getConnection();
				threadLocal.set(connection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
//	//获取连接
//		public static Connection getConnection() {
//			Connection connection = null;
//			try {
//				connection = dataSource.getConnection();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return connection;
//		}
	
	//释放连接
		public static void releaseConnection() {
			Connection connection = threadLocal.get();
			if(connection != null) {
				try {
					connection.close();
					threadLocal.remove();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

//	//释放连接
//	public static void releaseConnection(Connection connection) {
//		if(connection != null) {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
