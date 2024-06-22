package com.dbs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.catalina.connector.Response;
import org.apache.jasper.tagplugins.jstl.core.Out;

import com.dbo.LoginInfo;
import com.dbo.User;

public class DBService {
	Connection con=null;
	

	public DBService(){
		// TODO Auto-generated constructor stub
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=Mysqlpass2774@");
		}
		catch(Exception e)
		{
			System.out.println("Error in loading drivers"+e);
		}

	}
	
	public int Add(User u) throws Exception {
	
		
		
		PreparedStatement pr=con.prepareStatement("insert into userinfos values(?,?,?,?,?,?,?)");
		pr.setString(1,u.getUsername());
		pr.setString(2,u.getName());
		pr.setString(3,u.getDOB());
		pr.setString(4,u.getGender());
		pr.setString(5,u.getNumber());
		pr.setString(6,u.getEmail());
		pr.setString(7,u.getPassword());
		int x=pr.executeUpdate();
		
		return x;
		}
	
	public boolean check(User u)throws Exception {
		boolean isValid=false;
		
		
			
		if(u.getRoll().equals("user")==true)
		{
			PreparedStatement ps = con.prepareStatement("select * from userinfos where username = ? and password = ?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true)
			{
				isValid = true;
			}
			else
			{
				isValid= false;
			}
		}
		else if(u.getRoll().equals("employee")==true)
		{
			PreparedStatement ps = con.prepareStatement("select * from empinfos where employeeID = ? and password = ?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true)
			{
				isValid = true;
			}
			else
			{
				isValid= false;
			}
		}else {
			PreparedStatement ps = con.prepareStatement("select * from Admininfos where ID = ? and password = ?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true)
			{
				isValid = true;
			}
			else
			{
				isValid= false;
			}
			
		}
				
			
			
			return isValid;
		
	}
	public  ArrayList<?> checkyn() throws Exception{
		
		
		PreparedStatement pr=con.prepareStatement("select from roominfo where cheking='y'");
		ResultSet rs=pr.executeQuery();
		ArrayList b=(ArrayList) rs;
		return b;
	}
	}



