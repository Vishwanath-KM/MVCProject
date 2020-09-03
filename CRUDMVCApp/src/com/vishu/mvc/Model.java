package com.vishu.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Model {
	
	public String register(RegBean rb) {
		String result = rb.validate();
		if(result.equals(Constants.SUCCESS))
		{
			System.out.println("Model-> validation succeded");
			
			Connection con=null; 
			PreparedStatement ps_sel=null,ps_ins=null;
			
			ResultSet rs= null;
			try
			{
				con=JDBCHelper.getConnection();
				
				if(con==null)
					return "Oops cannot connect to db ,contact somebody";
				else
				{
					con.setAutoCommit(false);
					ps_sel=con.prepareStatement("select * from register where email = ?");
					ps_sel.setString(1, rb.getEmail());
					ps_sel.execute();
					rs= ps_sel.getResultSet();
					if(rs.next())
					   return "You Dabba Duplicate !.Enter new email id";
					else
					{
						ps_ins=con.prepareStatement("insert into register (name,email,pass) values(?,?,?)");
						ps_ins.setString(1,rb.getUname());
						ps_ins.setString(2,rb.getEmail());
						ps_ins.setString(3,rb.getPass());
						ps_ins.execute();
						
						con.commit();
						return Constants.SUCCESS;
					}
					
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				try 
				{
				    con.rollback();
				}
				catch(SQLException e1) {
					e.printStackTrace();
				}
				return "Oops something bad happened.."+e.getMessage();
			}
			finally {
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_ins);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
			}
		
		}
		else
			return result;
	}
	
	
	public String authenticate(LoginBean lb) {
		
		String result=lb.validate();
		
		if(result.equals(Constants.SUCCESS))
		{
            System.out.println("Model-> validation succeded");
			
            Connection con=null; 
			PreparedStatement ps_sel=null,ps_ins=null;
		
			ResultSet rs= null;
			try
			{
				con=JDBCHelper.getConnection();
				
				if(con==null)
					return "Oops cannot connect to db ,contact somebody";
				else
				{
					con.setAutoCommit(false);
					ps_sel=con.prepareStatement("select * from register where email = ? and pass = ?");
					ps_sel.setString(1, lb.getEmail());
					ps_sel.setString(2, lb.getPass());
					ps_sel.execute();
					rs= ps_sel.getResultSet();
					if(rs.next())
			        	return Constants.SUCCESS;
					else
					{
						return "Email and Password is wrong, try again...";
					}
					
					
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				try 
				{
				    con.rollback();
				}
				catch(SQLException e1) {
					e.printStackTrace();
				}
				return "Oops something bad happened.."+e.getMessage();
			}
			finally {
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_ins);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
			}
			
			
			
		}
		else
			return result; 
		
	}
	
	public RegBean getDetails(String email)
	{

        Connection con=null; 
		PreparedStatement ps_sel=null,ps_ins=null;
		ResultSet rs= null;
		RegBean rb = null;
		
		try
		{
			con=JDBCHelper.getConnection();
			if(con==null)
			{
				throw new RuntimeException("Connection not established,Please contact admin");
			}
			else
			{
				ps_sel=con.prepareStatement("select name,email,pass from register where email = ?");
				ps_sel.setString(1, email);
				ps_sel.execute();
				rs= ps_sel.getResultSet();
				while(rs.next())
				{
					rb= new RegBean();
					rb.setUname(rs.getString("name"));
					rb.setEmail(rs.getString("email"));
					rb.setPass(rs.getString("pass"));
					
				}
				return rb;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_ins);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}
		
	}
 
}
