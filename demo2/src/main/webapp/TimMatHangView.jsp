<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tim Mat Hang View</title>
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
.btn-foot {
margin-top: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<form action="mathang" method="GET">
			<input type="text" placeholder="Tìm kiếm mặt hàng" name="name_mh" />
			<input type="hidden" name="ncc_id" value="${ncc_id}"/>
			<button type="submit" value="Tim kiem">Tìm kiếm</button>
		</form>
		<h4>${message}</h4>
		<c:if test="${message != ''}">
			<a href="./ThemMoiHang.jsp?nccId=${ncc_id}" class="btn btn-info">Thêm mới hàng</a>
		</c:if>
		<div class="tbl_customer">
			Danh sách các mặt hàng
			<table class="fixed_header">
				<thead>
					<tr>
						<th>Stt</th>
						<th>Mã</th>
						<th>Tên</th>
						<th>Mô tả</th>
						<th>Giá</th>
						<th>Số lượng</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listhh}" var="listhh" varStatus="hhIndex">
						<tr>
							<td>${hhIndex.index+1}</td>
							<td>${listhh.id}</td>
							<td>${listhh.name}</td>
							<td>${listhh.description}</td>
							<td>${listhh.price}</td>
							<td>
								<form action="cart">
									<input type="number" name="amount" />
									<input type="hidden" name="hh_id" value="${listhh.id}" />
									<input type="hidden" name="ncc_id" value="${ncc_id}" />
									<button type="submit" value="Add to cart">Add to cart</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="./phieunhap?nccId=${ncc_id}" class="btn-foot btn btn-info">Nhập xong</a>
		</div>
	</div>
</body>
<%@include file="footer.html"%>
</html>