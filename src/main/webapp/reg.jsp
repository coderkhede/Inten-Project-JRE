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
      <title>reg</title>
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
                        <h1>Registration Form of User</h1><br><br>
                        <form  action="RegistrationServlet" method="post">
                           <div >
                              <div class="col-md-12">
                                 <span>Username</span>
                                 <input placeholder="Your Username" type="text" name="Username">
                              </div><br>
                              <div >
                                 <span>Full Name</span>                                 
                                 <input  type="text" name="Name">                               
                              </div><br>
                              <div >
                                 <span>Date of Birth</span>
                                 <input  type="date" name="DOB"><br>
                              </div><br>
                              <div >
                                 <span></span>
                                 <input type="Radio" name="Gender" value="Male"> Male  <input type="Radio" name="Gender" value="Female"> Female
                              </div><br>
                               
                              <div >
                                 <span>Phone Number</span>
                                 <input placeholder="1234567890" type="text" name="Number">
                              </div><br>
                              <div >
                                 <span>Email</span>                                 
                                 <input  type="Email" name="Email">                                 
                              </div><br>
                              <div >
                                 <span>Password</span>
                                 <input  type="Password" name="Password">
                              </div><br>
                              <div >
                                 <span>Confirm Password</span>
                                 <input  type="Password" name="cPassword">
                              </div><br>
                     
                              <div >
                                 <button  class="book_btn" type="submit">Submit</button>
                           
                              </div><br>
                              You are not a Visiter<a href="reg2.jsp"><font color=red>Sign Up as Employeee</font></a>
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
<!-- End Reg Form -->
<!-- Footer -->
<%@include file="Footer.jsp" %>
<!-- end Footer -->
</body>
</html>