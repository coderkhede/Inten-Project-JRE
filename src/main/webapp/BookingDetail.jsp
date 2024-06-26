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
      <table width=85%>
      <caption>Details</caption>
      <tr>	
          <th>Username</th>
          <th>Roono</th>
          <th>BuildingNo</th>
          <th>BoofCostumer</th>
          <th>Bookfrom</th>
          <th>Bookto</th>
          <th>Booking id</th>
          <th>Email</th>
          <th>Ph.no</th>
          <th>Price</th>           	
     </tr>
           
            
            <%
            
            BookingInfo s =(BookingInfo) request.getAttribute("bookingdetails");
            //for(int i=0; i<al.size(); i++)
            	//int i=1;
            if(s!=null)
            { 
            %><tr>
            		<td><%=s.getUsername()%></td>
					<td><%=s.getRoomno()%></td>
					<td><%=s.getBuildingno()%></td>
					<td><%=s.getNoofcostumer()%></td>
					<td><%=s.getBookfrom()%></td>
					<td><%=s.getBookto()%></td>
					<td><%=s.getBookingid()%></td>
					<td><%=s.getEmail()%></td>
					<td><%=s.getPhno()%></td>
					<td><%=s.getPrice()%></td>           		
            	</tr>
            <%
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