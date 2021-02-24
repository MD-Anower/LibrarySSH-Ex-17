<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
			background-image: url("img/background.jpg");
			background-repeat: no-repeat;
  			background-attachment: fixed;
  			background-position: center;
  			
		}
		h2{
			color: navy-blue;
		}
		a,label{
			color: blue;
		}
	</style>
  </head>
  
  <body>
  <div class="container">
    <h2>User register page.</h2> <br>
    <form  method="post" action="userAction_register">  
    	<div class="form-group">
		    <label for="userName">User Name</label>
		    <input type="text" class="form-control" id="userName" name="userName" >		   
	    </div>
	    <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" class="form-control" id="password"  name="password">		   
	    </div>
	    <div class="form-group">
		    <label for="repeatPassword">Confirm Password</label>
		    <input type="password" class="form-control" id="repeatPassword"  name="repeatPassword">		   
	    </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    ${msg }
    </div>
  </body>
</html>
