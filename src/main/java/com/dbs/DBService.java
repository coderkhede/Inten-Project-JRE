package com.dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbo.User;
import com.dto.LoginInfo;

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
	public boolean check(LoginInfo u)throws Exception {
		boolean isValid = false;
		String Roll=u.getRoll();
			if(Roll=="user") {
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
				isValid = false;
			}
		
		
		}else if(Roll=="employee") {
			PreparedStatement ps = con.prepareStatement("select * from employeeinfos where username = ? and password = ?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()==true)
			{
				isValid = true;
			}
			else
			{
				isValid = false;
			}
		
		
		}else if(Roll=="administrator") {
			PreparedStatement ps = con.prepareStatement("select * from Admininfos where username = ? and password = ?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()==true)
			{
				isValid = true;
			}
			else
			{
				isValid = false;
			}
		
		
		}
			return isValid;
			
	}
		
	}

	


