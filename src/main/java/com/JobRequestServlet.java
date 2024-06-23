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

/**
 * Servlet implementation class JobRequestServlet
 */
@WebServlet("/JobRequestServlet")
public class JobRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**S
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBService db = new DBService();
		ArrayList al = db.getAllRequests();
		request.setAttribute("allRequests", al);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/JobRequests.jsp");
		rd.forward(request, response);
	}

}
