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
    
    <title>My JSP 'studentList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/dataTables.bootstrap.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	<style>
		.container {
			width:100%;
			margin:10px 0px;            
		}
	</style>
	<script>
		$(function(){
    		$("#infoTable").dataTable({//注意#infoTable是需创建为dataTable的表格,使用jQuery选择器
                        
                        "searching":true,//是否允许Datatables开启本地搜索
                        "autoWidth":true,//控制Datatables是否自适应宽度
                        "scrollY": 330,  //设置垂直滚动
                        "paging":true,   //是否开启本地分页
                        //"pagingType":"full_numbers",
                        "processing" : true, //是否显示处理状态(排序的时候，数据很多耗费时间长的话，也会显示这个)
                        "ordering":true, //是否允许Datatables开启排序
                        "stateSave" : true, //保存状态 - 在页面重新加载的时候恢复状态（页码等内容）
                        "deferRender":true, //控制Datatables的延迟渲染，可以提高初始化的速度
			})
    	})
	</script>
  </head>
  
  <body>
    <nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="#">Student Manage	</a></li>
	    <li class="breadcrumb-item active" aria-current="page">Student List</li>
	  </ol>
	</nav>
	 <div class="container">
     	KeyWord:<input type="text" id="keyword" name="keyword" />    
     	<button class="btn btn-info" onclick="search();">search</button> 
   		<button class="btn btn-success" id="add_hw" onclick="add();">add Student</button>
   	 </div>  
	<div class="container">
		<table id="infoTable" class="table table-striped table-bordered table-condensed table-hover datatable">
		  <thead>
		    <tr>
		      <th scope="col">Id</th>
		      <th scope="col">No</th>
		      <th scope="col">Name</th>
		       <th scope="col">Age</th>
		      <th scope="col">Gender</th>	      
		  </thead>
		  <tbody>
		  <s:iterator var="item" status="st" value="#list">
                <tr>		      
			      <td><s:property value="#item.Id"/></td>
			      <td><s:property value="#item.No"/></td>
			      <td><s:property value="#item.Name"/></td>
			      <td><s:property value="#item.Age"/></td>
			      <td><s:property value="#item.Gender"/></td>
			      <td> 
			      	<button class="btn btn-xs btn-info" onclick="edit('<s:property value="#item.Id"/>');">edit</button>
			      	<button class="btn btn-xs btn-danger" onclick="del('<s:property value="#item.Id"/>');">delete</button>
			      </td>
			    </tr>	
           </s:iterator>
		  </tbody>
		</table>
	</div>
	<script type="text/javascript">
		function search(){
		    var keyWord = $('#keyword').val();
			window.location.href = "studentAction_query?keyWord=" + keyWord;
		}
		
		function del(id){
			if(confirm("Are you sure to delete the record?")){
				window.location.href = "studentAction_delete?id=" + id;
			}
		}
		
		function add(){
			window.location.href = "studentAdd.jsp";
		}
		
		function edit(id){
			window.location.href = "studentEdit.jsp?id="+id;
		}
	</script>
  </body>
</html>
