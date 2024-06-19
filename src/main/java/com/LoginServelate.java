package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbo.User;
import com.dbs.DBService;
import com.dto.LoginInfo;


@WebServlet("/login")
public class LoginServelate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServelate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		User l=new User();
		l.setUsername(request.getParameter("Username"));
		l.setPassword(request.getParameter("Password"));
		l.setRoll(request.getParameter("bar"));
		DBService db = new DBService();
		boolean isValid = false;
		
			try {
				isValid = db.check(l);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
			
		
		
		String target = "";
		if(isValid==true)
		{
			if(l.getRoll().equals("user")==true)
			{
				System.out.println("11111111111");
				target="/Userinterface.jsp";
			}
			else if(l.getRoll().equals("employee")==true)
			{
				System.out.println("22222222222");
				target="/Employeeinface.jsp";
			}else {
				
				System.out.println("3333333333");
				target="/Admininterface.jsp";
			}
		}
		else
		{
			request.setAttribute("sms", "Invalid Username/Password");
			target="/Login.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
