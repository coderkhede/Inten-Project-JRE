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
 * Servlet implementation class DutyServlet
 */
@WebServlet("/DutyServlet")
public class DutyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DutyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpInfo d=new EmpInfo();
		d.setEmpid(Integer.parseInt(request.getParameter("empid")));
		d.setDutyat(request.getParameter("dutyat"));
		DBService db= new DBService();
		try {
			db.Dutyat(d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Admininterface.jsp");
		rd.forward(request, response);
	}

}
