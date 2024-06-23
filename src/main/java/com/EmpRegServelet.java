package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbo.EmpInfo;
import com.dbo.User;
import com.dbs.DBService;


@WebServlet("/EmpRegServelet")
public class EmpRegServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EmpRegServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpInfo u=new EmpInfo();
		u.setEmpid(Integer.parseInt(request.getParameter("empid")));
		u.setEmpname(request.getParameter("empname"));
		u.setEmpdob(request.getParameter("empdob"));
		u.setEmpgender(request.getParameter("empgender"));
		u.setEmpphno(request.getParameter("empphno"));
		u.setEmpemail(request.getParameter("empemail"));
		u.setEmppass(request.getParameter("emppass"));
		u.setEmpjob(request.getParameter("empjob"));
		u.setEmpsalary(Integer.parseInt(request.getParameter("empsalary")));
		DBService db = new DBService();
		int x=0;
		String target="";
		try {
			x = db.EmpAdd(u);
		} catch (Exception e) {
			
			e.printStackTrace();
			
			
		}
		if(x>=1)
		{
			System.out.println("Valid User");
			target="/Succsesfull.jsp";
		}else {
			
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(request, response);
	}
	}


