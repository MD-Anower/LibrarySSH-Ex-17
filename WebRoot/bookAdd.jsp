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
    
    <title>My JSP 'bookAdd.jsp' starting page</title>
    
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
	</style>
  </head>
  
  <body>       
  <nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="#">BookCategory Manage	</a></li>
	    <li class="breadcrumb-item" aria-current="page">BookCategory List</li>
	    <li class="breadcrumb-item active" aria-current="page">Add BookCategory</li>
	  </ol>
	</nav>
    <div class="container">
    <h2>This is add BookAdd page.</h2> <br>
    <form  method="post" action="bookAction_add" enctype="multipart/form-data">  
    	<div class="form-group">
		    <label for="BookName">BookName</label>
		    <input type="text" class="form-control" id="bookName" name="bookName" >		   
	    </div>
	    
	    <div class="form-group">
		    <label for="Category">Category</label>
		    <select class="form-control" id="categoryId" name="categoryId">
		     <s:iterator var="item" status="st" value="#listCategory">
                <option value='<s:property value="#item.Id"/>'>
                   <s:property value="#item.CategoryName"/>
                </option>
             </s:iterator>
		    </select>	   
	    </div>
	    
	    <div class="form-group">
		    <label for="Picture">Picture</label>
		    <s:file name="file" label="upload file"></s:file>	   
	    </div>
	    
	    <div class="form-group">
		    <label for="Description">Description</label>
		    <textarea class="form-control" id="description" name="description" rows="3"></textarea>		   
	    </div>
	    
	    <div class="form-group">
		    <label for="Remark">Remark</label>
		    <input type="text" class="form-control" id="Remark"  name="remark">		   
	    </div>
	   
	  <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    </div>
  
  </body>
</html>
