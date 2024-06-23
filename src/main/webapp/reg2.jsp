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
      <title>reg2</title>
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
<hr>
<br><br>
<!-- Reg Form -->
  <!-- banner -->
<center>
         <div >
            <div >
               <div >
                  <div >
                     <div >
                        <h1>Registration Form of Employee</h1><br><br>
                        <form  action="EmpRegServelet" method="post">
                           <div >
                              <div class="col-md-12">
                                 <span>Employee ID</span>
                                 <input placeholder="101" type="number" name="empid">
                              </div><br>
                              <div >
                                 <span>Employee Name</span>                                 
                                 <input  type="text" name="empname">                               
                              </div><br>
                              <div >
                                 <span>Date of Birth</span>
                                 <input  type="date" name="empdob"><br>
                              </div><br>
                              <div >
                                 <span>Gender </span>
                                 <input type="Radio" name="empgender" value="Male"> Male  <input type="Radio" name="empgender" value="Female"> Female
                              </div><br>
                               
                              <div >
                                 <span>Phone Number</span>
                                 <input placeholder="1234567890" type="text" name="empphno">
                              </div><br>
                              <div >
                                 <span>Email</span>                                 
                                 <input  type="Email" name="empemail">                                 
                              </div><br>
                              <div >
                                 <span>Password</span>
                                 <input  type="Password" name="emppass">
                              </div><br>
                              <div >
                                 <span>Job Needed</span>
                                 <input  type="text" name="empjob">
                              </div><br>
                     			   <div >
                                 <span>Salary Expected</span>
                                 <input  type="number" name="empsalary">
                              </div><br>
                              <div >
                                 <button  class="book_btn" type="submit">Submit</button>
                           
                              </div><br>
                             </div>
                        </form>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
</center>
       
     
      <!-- end banner -->
      <br><br>
      <hr>
      <!-- end banner -->
<!-- End Reg Form -->
<!-- Footer -->
<%@include file="Footer.jsp" %>
<!-- end Footer -->
</body>
</html>