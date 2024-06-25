<%@page import="java.util.ArrayList"%>
<%@page import="com.dbo.BookingInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>keto</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
   </head>
   <!-- body -->
   <body class="main-layout">
   <!-- header -->
     <%@include file="Header.jsp" %>
      <!-- end header -->
 <div class="back_re">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="title">
                     <h2>Booking Details</h2>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- our_room -->
      <hr><br>
      <br>
      <center>
      <h3>Note:- Scan QR to pay</h3><br>
      <table  width=85%>
      <tr>		
            	<font color=black size=3>Details</font>
            	
            </tr>
           
            
            <%
            
            ArrayList al =(ArrayList) request.getAttribute("bookingdetails");
            //for(int i=0; i<al.size(); i++)
            	int i=1;
            	for(Object obj : al)
            {
            	BookingInfo s = (BookingInfo)obj;
            	%>
            	
            		<tr><%=s.getUsername()%></tr>
					<tr><%=s.getRoomno()%></tr>
					<tr><%=s.getBuildingno()%></tr>
					<tr><%=s.getNoofcostumer()%></tr>
					<tr><%=s.getBookfrom()%></tr>
					<tr><%=s.getBookto()%></tr>
					<tr><%=s.getBookingid()%></tr>
					<tr><%=s.getEmail()%></tr>
					<tr><%=s.getPhno()%></tr>
					<tr><%=s.getPrice()%></tr>           		
            	
            	<%
            	i++;
            }
            %>
      
      </table><br>
      <img src="images\Qr.jpg">
      </center>
<hr>
      <!-- Footer -->
    <%@include file="Footer.jsp" %>

   </body>
</html>