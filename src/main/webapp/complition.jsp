<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>complition</title>
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
<body>
<!-- Header -->
<%@include file="Header.jsp" %>
<!-- End Header -->
 <div class="back_re">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="title">
                      <h2>User Details</h2>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!--  contact -->
      <div class="contact">
         <div class="container">
            <div class="row">
               <div class="col-md-6">
               <%	
            String Username=request.getParameter("Username");
           	String Name=request.getParameter("Name");
        	String DOB=request.getParameter("DOB");
        	String Gender=request.getParameter("Gender");
        	String Email=request.getParameter("Email");
        	String Number=request.getParameter("Number");
        	String Password=(request.getParameter("Password"));
        	String CPassword=(request.getParameter("CPassword"));
        	PrintWriter eut=response.getWriter();
        	%>
                  <form id="request" class="main_form">
                     <div class="row">
                        <div class="col-md-12 ">
                           Username <input class="contactus" placeholder="<%eut.print(Username); %>" type=text name="Usename"> 
                        </div>
                        <div class="col-md-12">
                           Name<input class="contactus" type=text placeholder="<%eut.print((Name));%>"  name="Name"> 
                        </div>
                        <div class="col-md-12">
                           Date Of Birth<input class="contactus" placeholder="<%eut.print(("DOB"));%>" type=text name="DOB">                          
                        </div>
                        <div class="col-md-12">
                          Gender <input class="contactus" placeholder="<% eut.print(("Gender"));%>" type=text name="Gender">
                        </div>
                        <div class="col-md-12">
                           <button class="send_btn">Send</button>
                        </div>
                     </div>
                  </form>
               </div>
            
            </div>
         </div>
      </div>
<!-- Footer -->
<%@include file="Footer.jsp" %>
<!-- end Footer -->
</body>
</html>