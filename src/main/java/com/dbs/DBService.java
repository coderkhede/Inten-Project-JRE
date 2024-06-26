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

import com.dbo.BookingInfo;
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
			PreparedStatement ps = con.prepareStatement("select * from empinfos where empid = ? and emppass = ?");
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

	public int addroom(Roominfo r)
	{
		int xx=0;
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into Roominfo(roomno,roomtype,roomcapacity,roomCPP,BuldingNo,imagename,cheking) values(?,?,?,?,?,?,'y')");
			ps.setInt(1,r.getRoomno() );
			ps.setString(2,r.getRoomtype() );
			ps.setInt(3,r.getRoomcap() );
			ps.setInt(4,r.getRoomcost() );
			ps.setInt(5,r.getBuildingno() );
			ps.setString(6,r.getRoomimagename() );
			xx = ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
		
		}
		return xx;
	}
	
	public int EmpAdd(EmpInfo u) throws Exception {
		int x=0;
		PreparedStatement pr=con.prepareStatement("insert into empinfos(empid,empname,empdob,empgender,empphno,empemail,emppass,empjob,empsalary,empstatus) values(?,?,?,?,?,?,?,?,?,?)");
		pr.setInt(1,u.getEmpid());
		pr.setString(2,u.getEmpname());
		pr.setString(3,u.getEmpdob());
		pr.setString(4,u.getEmpgender());
		pr.setString(5,u.getEmpphno());
		pr.setString(6,u.getEmpemail());
		pr.setString(7,u.getEmppass());
		pr.setString(8,u.getEmpjob());
		pr.setInt(9,u.getEmpsalary());
		pr.setString(10,u.getEmpstatus());
		
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
	public ArrayList getAllRequests()
	{
		ArrayList<EmpInfo>al = new ArrayList<EmpInfo>();
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from empinfos where empstatus='notAppointed'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()==true)
			{
				EmpInfo s = new EmpInfo();
				s.setEmpid(rs.getInt("empid"));
				s.setEmpname(rs.getString("empname"));
				s.setEmpdob(rs.getString("empdob"));
				s.setEmpgender(rs.getString("empgender"));
				s.setEmpjob(rs.getString("empjob"));
				s.setEmpsalary(rs.getInt("empsalary"));
				al.add(s);
			}
		}
		catch (Exception e) 
		{
			
		}
	return al;
	}
	public int appoint(int x)throws Exception {
		PreparedStatement pr=con.prepareStatement("update empinfos set empstatus='Appointed' where empid=?");
		pr.setInt(1, x);
		int z=pr.executeUpdate();
		
		
		return z;
	}
	public int delete(int x)throws Exception {
		PreparedStatement pr=con.prepareStatement("delete from empinfos where empid=?");
		pr.setInt(1, x);
		int z=pr.executeUpdate();
		
		
		return z;
	}
	public ArrayList ManageAllRoom()
	{
		ArrayList<Roominfo>al = new ArrayList<Roominfo>();
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from Roominfo");
			ResultSet rs = ps.executeQuery();
			while(rs.next()==true)
			{
				Roominfo s = new Roominfo();
				s.setRoomno(rs.getInt("roomno"));
				s.setRoomtype(rs.getString("roomtype"));
				s.setRoomcap(rs.getInt("roomcapacity"));
				s.setRoomcost(rs.getInt("roomCPP"));
				s.setBookfrom(rs.getString("bookfrom"));
				s.setBookto(rs.getString("bookto"));
				s.setBookby(rs.getString("bookby"));
				s.setNoofCostumer(rs.getInt("NoofCostumer"));
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
	public int Insertdetails(Roominfo r)throws Exception {
		int x=0;
		
		PreparedStatement pr=con.prepareStatement("update roominfo set bookfrom=?,bookto=?,bookby=?,NoofCostumer=?,cheking='n' where roomno=?; ");
		pr.setString(1,r.getBookfrom());
		pr.setString(2,r.getBookto());
		pr.setString(3,r.getBookby());
		pr.setInt(4, r.getNoofCostumer());
		pr.setInt(5,r.getRoomno());
		x=pr.executeUpdate();
		return x;
	}
	public int Giveprice(BookingInfo b)throws Exception{
	int x=0;
		PreparedStatement pr=con.prepareStatement("select roomCPP from roominfo where roomno=?");
		pr.setInt(1, b.getRoomno());
		ResultSet rs=pr.executeQuery();
		if(rs.next()==true)
		{
		x = rs.getInt("roomCPP");
		}
		return x;
	}
	public int RecordBooking(BookingInfo b)throws Exception{
		int x=0;
		PreparedStatement pr=con.prepareStatement("insert into Booking values(?,?,?,?,?,?,?,?,?,?)");
		pr.setString(1, b.getUsername());
		pr.setInt(2,b.getRoomno());
		pr.setInt(3, b.getBuildingno());
		pr.setString(4,b.getBookfrom());
		pr.setString(5,b.getBookto());
		pr.setInt(6, b.getNoofcostumer());
		pr.setString(7,b.getEmail());
		pr.setString(8,b.getPhno());
		pr.setInt(9, b.getBookingid());
		pr.setInt(10, b.getPrice());
		x=pr.executeUpdate();
		return x;
	}
	public ArrayList getbookingdetail()
	{
		ArrayList<BookingInfo>al = new ArrayList<BookingInfo>();
		try 
		{	BookingInfo b=new BookingInfo();
			PreparedStatement ps = con.prepareStatement("select * from Booking where Bookingid=?");
			ps.setInt(1,b.getBookingid());
			ResultSet rs = ps.executeQuery();
			b.setUsername(rs.getString("User"));
			b.setRoomno(rs.getInt("roomno"));
			b.setBuildingno(rs.getInt("buildingNo"));
			b.setBookfrom(rs.getString("bookfrom"));
			b.setBookto(rs.getString("bookto"));
			b.setNoofcostumer(rs.getInt("noofcostumer"));
			b.setEmail(rs.getString("Email"));
			b.setPhno(rs.getString("phno"));
			b.setBookingid(rs.getInt("Bookingid"));
			b.setPrice(rs.getInt("Price"));	
				
				al.add(b);
			
		}
		catch (Exception e) 
		{
			
		}
	return al;
	}
	public ArrayList getAllemployee()
	{
		ArrayList<EmpInfo>al = new ArrayList<EmpInfo>();
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from empinfos");
			ResultSet rs = ps.executeQuery();
			while(rs.next()==true)
			{
				EmpInfo s = new EmpInfo();
				s.setEmpid(rs.getInt("empid"));
				s.setEmpname(rs.getString("empname"));
				s.setEmpdob(rs.getString("empdob"));
				s.setEmpgender(rs.getString("empgender"));
				s.setEmpphno(rs.getString("empphno"));
				s.setEmpemail(rs.getString("empemail"));
				s.setEmpstatus(rs.getString("empstatus"));
				s.setEmpjob(rs.getString("empjob"));
				s.setEmpsalary(rs.getInt("empsalary"));
				s.setDutyat(rs.getString("Dutyat"));
				al.add(s);
			}
		}
		catch (Exception e) 
		{
			
		}
	return al;
	}
	public ArrayList getDetailsEmployee(EmpInfo s)
	{
		ArrayList<EmpInfo>al = new ArrayList<EmpInfo>();
		try 
		{
			
			PreparedStatement ps = con.prepareStatement("select * from empinfos where empid=?");
			ps.setInt(1,s.getEmpid());
			ResultSet rs = ps.executeQuery();
			
				s.setEmpid(rs.getInt("empid"));
				s.setEmpname(rs.getString("empname"));
				s.setEmpdob(rs.getString("empdob"));
				s.setEmpgender(rs.getString("empgender"));
				s.setEmpphno(rs.getString("empphno"));
				s.setEmpemail(rs.getString("empemail"));
				s.setEmpstatus(rs.getString("empstatus"));
				s.setEmpjob(rs.getString("empjob"));
				s.setEmpsalary(rs.getInt("empsalary"));
				s.setDutyat(rs.getString("Dutyat"));
				al.add(s);
			
		}
		catch (Exception e) 
		{
			
		}
	return al;
	}
	public int Checkout(int a) throws Exception{
		int x=0;
		PreparedStatement ps = con.prepareStatement("update roominfo set bookfrom='NULL',bookto='NULL',bookby='NULL',NoofCostumer=0,cheking='y' where roomno=?");
		ps.setInt(1,a);
		x=ps.executeUpdate();
		return x;
	}
	public int DeleteRoom(int a) throws Exception{
		int x=0;
		PreparedStatement ps = con.prepareStatement("delete from roominfo where roomno=?");
		ps.setInt(1,a);
		x=ps.executeUpdate();
		return x;
	}
	public int Dutyat(EmpInfo e)throws Exception{
		int x=0;
		PreparedStatement ps = con.prepareStatement("update empinfos set Dutyat=? where empid=?");
		ps.setString(1,e.getDutyat());
		ps.setInt(2, e.getEmpid());
		x=ps.executeUpdate();
		return x;
		
	}
	public int empdelete(EmpInfo e)throws Exception{
		int x=0;
		PreparedStatement ps = con.prepareStatement("delete from empinfos where empid=?");
		
		ps.setInt(1, e.getEmpid());
		x=ps.executeUpdate();
		return x;
		
	}
	}




