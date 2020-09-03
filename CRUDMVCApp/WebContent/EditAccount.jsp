<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>Edit Account</title>
</head>
<body>
    <div class="rlform">
  <div class="rlform rlform-wrapper">
   <div class="rlform-box">
  <div class="rlform-box-inner">
   <form action="EditAccountInt.jsp" method="POST">
    <p>Edit Account</p>

     <div class="rlform-group">
    <label>Full Name</label>
    <input type="text" name="uname" value="${userDetails.uname}" class="rlform-input" required>
   </div>
    
   <div class="rlform-group">         
    <label>Email</label>
    <input type="email" name="email" value="${userDetails.email}" readonly="readonly" class="rlform-input" required>
   </div>
    
   <div class="rlform-group">         
    <label>Password</label>
    <input type="password" name="pass" value="${userDetails.pass}" class="rlform-input" required>
     </div>

     <div class="rlform-group">
    <label>Confirm password</label>
    <input type="password" name="rpass" value="${userDetails.pass}" class="rlform-input" required>
     </div>

    <button class="rlform rlform-box rlform-btn" name="signUp">Sign Up
    </button>

   </form>
  </div>
   </div>
  </div>
 </div>
    ${errorMsg}
</body>
</html>