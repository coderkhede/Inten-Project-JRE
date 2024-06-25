package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbs.DBService;


@WebServlet("/EmpmanagementServlet")
public class EmpmanagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmpmanagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBService db = new DBService();
		ArrayList al = db.getAllemployee();
		request.setAttribute("allemployee", al);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Empmanagement.jsp");
		rd.forward(request, response);
	}

	

}
