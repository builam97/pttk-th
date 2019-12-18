<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>tim nha cung cap view</title>
<style type="text/css">
    <%@include file="WEB-INF/template/css/bootstrap.min.css" %>
table {
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid black;
}
.tbl_customer {
	text-align: center;
}
.tbl_customer .fixed_header {
width: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<form action="nhacungcap" method="GET">
			<input type="text" placeholder="Tìm kiếm nhà cung cấp" name="name_ncc" />
			<button type="submit" value="Tim kiem">Tìm kiếm</button>
		</form>
		<h4>${message}</h4>
		<c:if test="${message != ''}">
			<a href="./ThemmoiNcc.jsp" class="btn btn-info">Thêm mới nhà cung cấp</a>
		</c:if>
		<div class="tbl_customer">
			Danh sách nhà cung cấp
			<table class="fixed_header">
				<thead>
					<tr>
						<th>Stt</th>
						<th>Mã</th>
						<th>Tên nhà cung cấp</th>
						<th>Địa chỉ</th>
						<th>Số điện thoại</th>
						<th>action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listNcc}" var="listNcc" varStatus="nccIndex">
						<tr>
							<td>${nccIndex.index+1}</td>
							<td>${listNcc.id}</td>
							<td>${listNcc.name}</td>
							<td>${listNcc.address}</td>
							<td>${listNcc.phone}</td>
							<td><a
								href="./mathang?ncc_id=${listNcc.id}">Chọn</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
<%@include file="footer.html"%>
</html>