<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>Login</title>
</head>
<body>

    <div class="rlform">
  <div class="rlform rlform-wrapper">
   <div class="rlform-box">
    <div class="rlform-box-inner">
      <form action="LogInt.jsp" method="POST">
         <p>Login Here...!</p>

           <div class="rlform-group">
               <label>Email</label>
               <input type="text" name="email" class="rlform-input" value="${param.email}" required>
          </div>

          <div class="rlform-group password-group">
           <label>Password</label>
           <input type="password" name="pass" class="rlform-input" required>
          </div>

    <button type="submit" class="rlform rlform-box rlform-btn" >Sign In
    </button>

    <div class="text-foot">
    Don't have an account? <a href="Register.jsp">Register</a><br/>
      ${errorMsg}
    </div>
   </form>
  </div>
   </div>
     </div>
 </div>
   
</body>
</html>