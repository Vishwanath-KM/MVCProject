<jsp:useBean id="user" class="com.vishu.mvc.LoginBean" scope="request">

   <jsp:setProperty name="user" property="*"/>

</jsp:useBean>
<jsp:forward page="login.do"></jsp:forward>