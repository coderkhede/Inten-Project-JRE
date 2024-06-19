package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbo.User;
import com.dbs.DBService;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User();
		u.setUsername(request.getParameter("Username"));
		u.setName(request.getParameter("Name"));
		u.setDOB(request.getParameter("DOB"));
		u.setGender(request.getParameter("Gender"));
		u.setEmail(request.getParameter("Email"));
		u.setNumber(request.getParameter("Number"));
		u.setPassword(request.getParameter("Password"));
		u.setCPassword(request.getParameter("CPassword"));
		DBService db = new DBService();
		int x=0;
		try {
			x = db.Add(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(x>=1)
		{
			System.out.println("Valid User");
		}
	}

}
