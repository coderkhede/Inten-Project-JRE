package com.dbs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.catalina.connector.Response;
import org.apache.jasper.tagplugins.jstl.core.Out;

import com.dbo.EmpInfo;
import com.dbo.LoginInfo;
import com.dbo.Roominfo;
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

	public int addroom(Roominfo r,String y)
	{
		int xx=0;
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into Roominfo(roomno,roomtype,roomcapacity,roomCPP,BuldingNo,imagename) values(?,?,?,?,?,?)");
			ps.setInt(1,r.getRoomno() );
			ps.setString(2,r.getRoomtype() );
			ps.setInt(3,r.getRoomcap() );
			ps.setInt(4,r.getRoomcost() );
			ps.setInt(5,r.getBuildingno() );
			ps.setString(1,y );
			xx = ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
		
		}
		return xx;
	}
	
	public int EmpAdd(EmpInfo u) throws Exception {
		int x=0;
		PreparedStatement pr=con.prepareStatement("insert into empinfos(empid,empname,empdob,empgender,empphno,empemail,emppass,empjob,empsalary) values(?,?,?,?,?,?,?,?,?)");
		pr.setInt(1,u.getEmpid());
		pr.setString(2,u.getEmpname());
		pr.setString(3,u.getEmpdob());
		pr.setString(4,u.getEmpgender());
		pr.setString(5,u.getEmpphno());
		pr.setString(6,u.getEmpemail());
		pr.setString(7,u.getEmppass());
		pr.setString(8,u.getEmpjob());
		pr.setInt(9,u.getEmpsalary());
		x=pr.executeUpdate();
		return x;
	}
	public ArrayList getAllRoom()
	{
		ArrayList<Roominfo>al = new ArrayList<Roominfo>();
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from roominfo where cheking='y'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()==true)
			{
				Roominfo s = new Roominfo();
				s.setRoomno(rs.getInt("roomno"));
				s.setRoomtype(rs.getString("roomtype"));
				s.setRoomcap(rs.getInt("roomcapacity"));
				s.setRoomcost(rs.getInt("roomCPP"));
				s.setBuildingno(rs.getInt("BuldingNo"));
				s.setRoomimagename(rs.getString("imagename"));
				al.add(s);
			}
		}
		catch (Exception e) 
		{
			
		}
	return al;
	}
	
	
	}



