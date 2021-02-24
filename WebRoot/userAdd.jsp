<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<style type="text/css">
		.container {width:500px;}
		body{
			background-image: url("img/adduser.jpg");
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
    <nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="#">User Manage	</a></li>
	    <li class="breadcrumb-item" aria-current="page">User List</li>
	    <li class="breadcrumb-item active" aria-current="page">Add User</li>
	  </ol>
	</nav>
    <div class="container">
    <h2>Input Field and Add User.</h2> <br>
    <form  method="post" action="userAction_add" enctype="multipart/form-data">  
    	<div class="form-group">
		    <label for="UserName">User Name</label>
		    <input type="text" class="form-control" id="userName" name="userName" >		   
	    </div>
	    <div class="form-group">
		    <label for="Password">Password</label>
		    <input type="password" class="form-control" id="password"  name="password">		   
	    </div>
	   
	  <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    </div>
  </body>
</html>
