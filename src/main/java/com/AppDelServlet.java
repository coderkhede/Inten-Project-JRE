package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbo.EmpInfo;
import com.dbs.DBService;

/**
 * Servlet implementation class AppDelServlet
 */
@WebServlet("/AppDelServlet")
public class AppDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpInfo u=new EmpInfo();
		String op = request.getParameter("s1");
		int z=Integer.parseInt(request.getParameter("empid"));
		String y=request.getParameter("empname");
		RequestDispatcher rd=null;
		int x=0;
		DBService db = new DBService();
		String target="";
		if(op.equals("Appoint")) {
			try {
				x=db.appoint(z);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(x>=1)
			{
				request.setAttribute("sms", "Employee appointed Successfully");
				target="/Admininterface.jsp";
			}
			else
			{
				request.setAttribute("sms", "Employee Coult Not Be appointed");
				target="/Requestaction.jsp";
			}
		}
		if(op.equals("Delete")) {
			try {
				x=db.delete(z);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(x>=1)
			{
				request.setAttribute("sms", "Employee Deleted Successfully");
				target="/Admininterface.jsp";
			}
			else
			{
				request.setAttribute("sms", "Employee Coult Not Be deleted");
				target="/Requestaction.jsp";
			}
		}
		rd = getServletContext().getRequestDispatcher("/Requestaction.jsp");
		rd.forward(request, response);
		
}
	}


