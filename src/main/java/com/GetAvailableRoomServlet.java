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
 * Servlet implementation class GetAvailableRoomServlet
 */
@WebServlet("/GetAvailableRoomServlet")
public class GetAvailableRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetAvailableRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBService db = new DBService();
		ArrayList al = db.getAllRoom();
		request.setAttribute("allRooms", al);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Room.jsp");
		rd.forward(request, response);
	}

	

}
