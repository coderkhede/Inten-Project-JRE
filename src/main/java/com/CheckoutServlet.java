package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbo.Roominfo;
import com.dbs.DBService;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Roominfo r =new Roominfo();
		String op=request.getParameter("a1");
		int a=Integer.parseInt(request.getParameter("roomno"));
		int b=Integer.parseInt(request.getParameter("buildingno"));
		int x=0;
		DBService db=new DBService();
		if(op.equals("Checkout")==true) {
			try {
				db.Checkout(a);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			try {
				db.DeleteRoom(a);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Admininterface.jsp");
		rd.forward(request, response);
		
	}

}
