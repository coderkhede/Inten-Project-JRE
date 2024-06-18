package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
		
		
		
		PreparedStatement pr=con.prepareStatement("insert into User values('?','?','?','?','?','?','?');");
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
		
	}

	


