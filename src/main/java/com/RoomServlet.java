package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dbo.Roominfo;
import com.dbs.DBService;

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Roominfo r=new Roominfo();
		r.setRoomno(Integer.parseInt(request.getParameter("roomno")));
		r.setRoomtype(request.getParameter("roomtype"));
		r.setRoomcap(Integer.parseInt(request.getParameter("roomcap")));
		r.setRoomcost(Integer.parseInt(request.getParameter("roomcost")));
		r.setBuildingno(Integer.parseInt(request.getParameter("bulidingno")));
		 DBService db = new DBService();
	        int x =0;
	        Part filePart = request.getPart("images");
	     
	        // Check if the request contains a file part
	        if (filePart != null)
	         {
	            String imageFileName = filePart.getSubmittedFileName(); // get selected image file name
	            System.out.println("Selected Images File Name: " + imageFileName);
	           
	            x = db.addroom(r,imageFileName);
	            // Specify the upload path where the image will be stored
	            String uploadPath = "/java/Project 1/Pr1/src/main/webapp/images/" + imageFileName;
	            System.out.println("Upload Path: " + uploadPath);

	            try (FileOutputStream fos = new FileOutputStream(uploadPath);
	                 InputStream is = filePart.getInputStream()) {

	                // Read and write the file data
	                byte[] data = new byte[is.available()];
	                is.read(data);
	                fos.write(data);

	                // Set the file name in the AddRoom object
	                //ar.setRoomimg(imageFileName);
	                
	                
	            } catch (IOException e) {
	                e.printStackTrace();
	                // Handle the exception, log it, or send an error response
	                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error during file upload");
	                return; // Stop further processing
	            }
	        } else {
	            System.out.println("No file part in the request.");
	        }
	        if(x>=1)
	        {
	        	System.out.println("Image Uploaded");
	        }
	}

}
