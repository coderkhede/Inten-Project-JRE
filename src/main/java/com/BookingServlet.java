package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbo.Roominfo;
import com.dbs.DBService;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Roominfo r=new Roominfo();
		r.setBookby(request.getParameter("Username"));
		r.setBookfrom(request.getParameter("bookfrom"));
		r.setBookto(request.getParameter("bookto"));
		r.setNoofCostumer(Integer.parseInt(request.getParameter("noofcostumer")));
		
		int x=0;
		DBService db=new DBService();
		x=db.Insertdetails(r);
	}

}
