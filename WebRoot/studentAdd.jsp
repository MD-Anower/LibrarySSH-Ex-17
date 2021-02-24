<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentAdd.jsp' starting page</title>
    
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
			background-image: url("img/addstudent.jpg");
			background-repeat: no-repeat;
  			background-attachment: fixed;
  			background-position: center;
  			
		}
		h2{
			color: white;
		}
		a,label{
			color: blue;
		}
	</style>
  </head>
  
  <body>       
  <nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="#">Student Manage	</a></li>
	    <li class="breadcrumb-item" aria-current="page">Student List</li>
	    <li class="breadcrumb-item active" aria-current="page">Add Student</li>
	  </ol>
	</nav>
    <div class="container">
    <h2>Fill the Information Add the Student.</h2> <br>
    <form  method="post" action="studentAction_add" enctype="multipart/form-data">  
    
         <div class="form-group">
		    <label for="No">No</label>
		    <input type="text" class="form-control" id="No"  name="no">		   
	    </div>
	    
	   <div class="form-group">
		    <label for="Name">Name</label>
		    <input type="text" class="form-control" id="Name"  name="name">		   
	    </div>
	    
	     <div class="form-group">
		    <label for="Age">Age</label>
		    <input type="text" class="form-control" id="Age"  name="age">		   
	    </div>
	    
	    <div class="form-group">
		    <label for="Gender">Gender</label>
		    <select class="form-control" id="Gender" name="gender">
		      <option value="Male">Male</option>
		      <option value="Female">Female</option>
		    </select>	   
	    </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    </div>
  
  </body>
</html>
