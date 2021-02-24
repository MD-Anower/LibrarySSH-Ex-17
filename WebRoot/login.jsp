<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<style type="text/css">
		.container {width:500px;}
		body{
			background-image: url("img/bacground.jpg");
			background-repeat: no-repeat;
  			background-attachment: fixed;
  			background-position: center;
  			
		}
		h2{
			color: red;
		}
		a,label{
			color: white;
		}
	</style>

  </head>
  
  <body>
    <div class="container">
    <h2>The Library login page.</h2> <br>
    <form method="post" action="userAction_login">  
    	<div class="form-group">
		    <label for="userName">User Name</label>
		    <input type="text" class="form-control" id="userName" name="userName" >		   
	    </div>
	    <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" class="form-control" id="password"  name="password">		   
	    </div>
	    
	    <button type="submit" class="btn btn-primary">Login</button>
	    &nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="register.jsp">Register</a>
    </form>
    ${msg }
    </div>
  </body>
</html>
