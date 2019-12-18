<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
    	<%@include file="WEB-INF/template/css/bootstrap.min.css" %>
	.home {
		text-align: center;
	}
	.nav .bnt {
		float:left;
		width:30%;
		padding:10px;
		border:1px solid black;
		margin:10px;
	}
</style>
</head>
<body>
<div class="container">
	<h3 class="home">Home Page</h3>
	<div class="nav">
		<a href="TimNhaccView.jsp" class="bnt">Nhập hàng</a>
		<a href="#" class="bnt">Xuất hàng</a>
		<a href="#" class="bnt">Thống kê</a>
	</div>
	
	</div>
</body>
<%@include file="footer.html"%>
</html>