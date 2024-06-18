<%@page import="com.DBService"%>
<%@page import="com.dbo.User"%>
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
      <title>Login</title>
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
<%
	User u=new User();
	String Username=request.getParameter("Username");
	String Name=request.getParameter("Name");
	String DOB=request.getParameter("DOB");
	String Gender=request.getParameter("Gender");
	String Email=request.getParameter("Email");
	String Number=request.getParameter("Number");
	String Password=(request.getParameter("Password"));
	String CPassword=(request.getParameter("CPassword"));
	
	u.setUsername(Username);
	u.setName(Name);
	u.setDOB(DOB);
	u.setGender(Gender);
	u.setEmail(Email);
	u.setNumber(Number);
	u.setPassword(Password);
	u.setCPassword(CPassword);
	
	DBService db=new DBService();
	int x=db.Add(u);
	if(x==1){
		%>
		<center>
		<br>
		<br>
		<font color=green size=8px>Registration Succsesfull</font>
		</center> <%} %>

<!-- Footer -->
<%@include file="Footer.jsp" %>
<!-- end Footer -->
</body>
</html>