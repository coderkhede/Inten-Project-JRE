<%@page import="java.util.ArrayList"%>
<%@page import="com.dbo.EmpInfo"%>
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
     <hr>
     <center>
     <h3>Note:- Remember all the details of employee</h3>
     <table  width=85%>
      <tr>		
            	<th><font color=black size=3>Employee ID</font></th>
            	<th><font color=black size=3>Name</font></th>
            	<th><font color=black size=3>Date of Birth</font></th>
            	<th><font color=black size=3>Gender</font></th>
            	<th><font color=black size=3>Requested Job</font></th>
            	<th><font color=black size=3>Requested Salary</font></th>
            	<th><font color=black size=3>Appointing.btn</font></th>
            </tr>
           
            
            <%
            
            ArrayList al =(ArrayList) request.getAttribute("allRequests");
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
					<td><a href="Requestaction.jsp"><button class="book_btn">Click</button></a></td>					          		
					          		
            	
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