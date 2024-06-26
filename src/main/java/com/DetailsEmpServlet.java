package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbo.EmpInfo;
import com.dbs.DBService;

/**
 * Servlet implementation class DetailsEmpServlet
 */
@WebServlet("/DetailsEmpServlet")
public class DetailsEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpInfo e= new EmpInfo();
		e.setEmpid(Integer.parseInt(request.getParameter("empid")));
		DBService db=new DBService();
		ArrayList al = db.getDetailsEmployee(e);
	
		request.setAttribute("DetailEmployee", al);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/EmpDetails.jsp");
		rd.forward(request, response);
	}

}
