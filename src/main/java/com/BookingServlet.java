package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbo.BookingInfo;
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
		r.setRoomno(Integer.parseInt(request.getParameter("roomno")));
		int x=0;
		DBService db=new DBService();
		try {
			x=db.Insertdetails(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
		int Cost=0;
		BookingInfo b= new BookingInfo();
		
		b.setUsername(request.getParameter("Username"));
		b.setRoomno(Integer.parseInt(request.getParameter("roomno")));
		b.setBuildingno(Integer.parseInt(request.getParameter("buildingno") ));
		b.setBookfrom(request.getParameter("bookfrom"));
		b.setBookto(request.getParameter("bookto"));
		b.setNoofcostumer(Integer.parseInt(request.getParameter("noofcostumer")));
		b.setEmail(request.getParameter("email"));
		b.setPhno(request.getParameter("phno"));
		b.setPrice(Cost);
		b.setBookingid(Integer.parseInt(request.getParameter("bookingid")));
		int Elements=(Integer.parseInt(request.getParameter("noofcostumer")));
		try {
			 db.Giveprice(b);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
		Cost=b.getPrice();
		Cost=Cost*Elements;
		b.setPrice(Cost);
		try {
			int y=db.RecordBooking(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ArrayList al = db.getbookingdetail();
		request.setAttribute("bookingdetails", al);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/BookingDetail.jsp");
		rd.forward(request, response);
		
	}

}
