<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>Menu</title>
</head>
<body>
  <div class="rlform">
  <div class="rlform rlform-wrapper">
   <div class="rlform-box">
    <div class="rlform-box-inner">
   
   
     <h1>Menu</h1>
    <h2>Welcome ${sessionScope.userId}</h2>
    <a href="openEditAccView.do">Click to edit account</a><br/>
   <a href="logout.do">Click to logout</a>

  </div>
   </div>
     </div>
 </div>

</body>
</html>