<%@page import="com.dbo.Roominfo"%>
<%@page import="java.util.ArrayList"%>
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
                     <h2>All rooms</h2>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- our_room -->
      <hr><br>
      <br>
      <center>
      <h3>Note:- Remember the details of Selected room to Checkout the correct room Form</h3><br>
      <table  width=85%>
      <tr>		
            	<th><font color=black size=3>Room.No</font></th>
            	<th><font color=black size=3>Room Type</font></th>
            	<th><font color=black size=3>Room Capacity</font></th>
            	<th><font color=black size=3>Room Cost per Night</font></th>
            	<th><font color=black size=3>Building No</font></th>
            	<th><font color=black size=3>Booked From</font></th>
            	<th><font color=black size=3>Booked To</font></th>
            	<th><font color=black size=3>Booked By</font></th>
            	<th><font color=black size=3>No.ofCS</font></th>
            	<th><font color=black size=3>Image</font></th>
            	<th><font color=black size=3>CheckOut.btn</font></th>
            </tr>
           
            
            <%
            
            ArrayList al =(ArrayList) request.getAttribute("getallRooms");
            //for(int i=0; i<al.size(); i++)
            	int i=1;
            	for(Object obj : al)
            {
            	Roominfo s = (Roominfo)obj;
            	%>
            	<tr>
            	
					<form action="Checkout.jsp" >
            		
            		<td><%=s.getRoomno()%></td>
            		
            		<td><%=s.getRoomtype()%></td>
            		<td><%=s.getRoomcap()%></td>
            		<td><%=s.getRoomcost()%></td>
            		<td><%=s.getBuildingno()%></td>
            		<td><%=s.getBookfrom()%></td>
            		<td><%=s.getBookto()%></td>
            		<td><%=s.getBookby()%></td>
            		<td><%=s.getNoofCostumer()%></td>
            		<td><%=s.getRoomimagename()%></td>
					<td><button class="book_btn" name="b1" value="<%=s.getRoomno()%>">Click</button></td>					          		
					</form>            		
            	
            	</tr>
            	<%
            	i++;
            }
            %>
      
      </table>
      </center>
<hr>
      <!-- Footer -->
    <%@include file="Footer.jsp" %>

   </body>
</html>