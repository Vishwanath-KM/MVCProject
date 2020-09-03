package com.vishu.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCHelper {
	
	public static void close(ResultSet x)
	{
		if(x!=null)
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void close(Statement x)
	{
		if(x!=null)
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void close(Connection x)
	{
		if(x!=null)
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName(Constants.MySQL_DRIVER );
			con = DriverManager.getConnection(Constants.MySQL_URL,Constants.MySQL_UID,Constants.MySQL_PWD);
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		return con;
		
	}

}
