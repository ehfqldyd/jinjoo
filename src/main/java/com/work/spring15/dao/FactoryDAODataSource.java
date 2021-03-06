package com.work.spring15.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class FactoryDAODataSource {
	private DataSource ds;
	private static FactoryDAODataSource instance = new FactoryDAODataSource();
	public FactoryDAODataSource() {
		try {
			ds = (DataSource)new InitialContext().lookup("java:comp/env/jdbc/Oracle");
		} catch(NamingException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static FactoryDAODataSource getInstance(){
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void close(Connection conn, Statement stmt) {
		
			close(conn,stmt,null);
		
		
	}
}
