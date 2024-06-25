<%@page import="com.dbo.EmpInfo"%>
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
                     <h2>Manage Employee</h2>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- our_room -->
      <hr><br>
      <br>
 		 <center>
     <h3>Note:- Remember all the details of employee</h3>
     <table  width=85%>
      <tr>		
            	<th><font color=black size=3>Employee ID</font></th>
            	<th><font color=black size=3>Name</font></th>
            	<th><font color=black size=3>Date of Birth</font></th>
            	<th><font color=black size=3>Gender</font></th>
            	<th><font color=black size=3>Job</font></th>
            	<th><font color=black size=3>Salary</font></th>
            	<th><font color=black size=3>Email</font></th>
            	<th><font color=black size=3>phone no</font></th>
            	<th><font color=black size=3>status</font></th>
            	<th><font color=black size=3>Duty at</font></th>
            	<th><font color=black size=3>Btn</font></th>
            </tr>
           
            
            <%
            
            ArrayList al =(ArrayList) request.getAttribute("allemployee");
            //for(int i=0; i<al.size(); i++)
            	int i=1;
            	for(Object obj : al)
            {
            	EmpInfo s = (EmpInfo)obj;
            	%>
            	<tr>
            	
					
            		
            		
            		<td><%=s.getEmpid()%></td>
            		<td><%=s.getEmpname()%></td>
            		<td><%=s.getEmpdob()%></td>
            		<td><%=s.getEmpgender()%></td>
            		<td><%=s.getEmpjob()%></td>
            		<td><%=s.getEmpsalary()%></td>
            		<td><%=s.getEmpemail()%></td>
            		<td><%=s.getEmpphno()%></td>
            		<td><%=s.getEmpstatus()%></td>
            		<td><%=s.getDutyat()%></td>
					<td><a href="DelOn.jsp"><button class="book_btn">Click</button></a></td>					          		
					          		
            	
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