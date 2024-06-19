package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbs.DBService;
import com.dto.LoginInfo;


@WebServlet("/LoginServelate")
public class LoginServelate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServelate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		LoginInfo l=new LoginInfo();
		l.setUsername(request.getParameter("t1"));
		l.setPassword(request.getParameter("t2"));
		l.setRoll(request.getParameter("poll"));
		DBService db = new DBService();
		boolean isVlid=false;
		try {
			isVlid = db.check(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String target="";
		if(isVlid==true)
		{
			target="/.jsp";
		}
		else
		{
			request.setAttribute("sms", "Invalid Username/Password");
			target="/login.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
