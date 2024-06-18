package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.dbo.User;
import com.mysql.cj.protocol.Resultset;

public class DBService {
	Connection con;
	
	String Username;
	String Name;
	String DOB;
	String Gender;
	String Email;
	String Number;
	String Password;
	String CPassword;
	public DBService(){
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.cj.jdbc.Drivars");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Error Driver not found :"+e);
		}
		try {
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=Mysqlpass2774@");
			
		}catch(SQLException e) {
			System.out.println("ERROR Data not found:"+e);
		}
	}
	public int Add(User u) throws Exception {
		Password=u.getPassword();
		CPassword=u.getCPassword();
		if(Password==CPassword) {
		PreparedStatement pr=con.prepareStatement("insert into User values('?','?','?','?','?','?','?');");
		pr.setString(1,u.getUsername());
		pr.setString(2,u.getName());
		pr.setString(3,u.getDOB());
		pr.setString(4,u.getGender());
		pr.setString(5,u.getNumber());
		pr.setString(6,u.getEmail());
		pr.setString(7,u.getPassword());
		pr.executeUpdate();
		
		return 1;
		}else {
			
		return 0;
		}
		
	}

	

}
