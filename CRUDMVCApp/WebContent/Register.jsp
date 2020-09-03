<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>Register</title>
</head>
<body>
    
    <div class="rlform">
  <div class="rlform rlform-wrapper">
   <div class="rlform-box">
  <div class="rlform-box-inner">
   <form action="RegInt.jsp" method="POST">
    <p>Let's create your account</p>

     <div class="rlform-group">
    <label>Full Name</label>
    <input type="text" name="uname" value="${param.uname}"class="rlform-input" required>
   </div>
    
   <div class="rlform-group">         
    <label>Email</label>
    <input type="email" name="email" value="${param.email}" class="rlform-input" required>
   </div>
    
   <div class="rlform-group">         
    <label>Password</label>
    <input type="password" name="pass" class="rlform-input" required>
     </div>

     <div class="rlform-group">
    <label>Confirm password</label>
    <input type="password" name="rpass"  class="rlform-input" required>
     </div>

    <button class="rlform rlform-box rlform-btn" name="signUp">Sign Up
    </button>

    <div class="text-foot">
     Already have an account? <a href="Login.jsp">Login</a>
      ${errorMsg}
    </div>
   </form>
  </div>
   </div>
  </div>
 </div>
   
</body>
</html>