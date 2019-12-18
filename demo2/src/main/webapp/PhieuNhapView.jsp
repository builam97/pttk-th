<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phieu Nhap View</title>
<style type="text/css">
    <%@include file="WEB-INF/template/css/bootstrap.min.css" %>
    .s-material {
    	padding: 20px;
    }
    .title-customer {
    	text-align: center;
    }
    .content {
    	padding: 10px;
    	border: 1px solid black;
    }
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
border:1px solid black;
}
.at-in {
 padding-top: 5px;
 padding-bottom: 5px;
}
</style>
</head>
<body>
<div class="container">
	<h3 class="title-customer">Phiếu nhập chi tiết</h3>
	<div class="content">
		<p>Name : ${ncc.name}</p>
		<p>Address : ${ncc.address}</p>
		<p>Phone : ${ncc.phone}</p>
		<div>
		<h4 class="title-customer">Danh sách các mặt hàng đã nhập</h4>
		<div class="tbl_customer">
			<table class="fixed_header">
				<thead>
					<tr>
						<th>STT</th>
						<th>Tên</th>
						<th>Mô tả</th>
						<th>Giá</th>
						<th>Số lượng</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="hh" varStatus="hhIndex" items="${listhh}">
						<tr>
							<td>${hhIndex.index+1}</td>
							<td>${hh.name}</td>
							<td>${hh.description}</td>
							<td>${hh.price.intValue()}</td>
							<td>${hh.amount}</td>
							<td><a href="./phieunhap?removeHangId=${hh.id}&nccId=${ncc.id}">Xóa</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			<div>
				<p class ="badge badge-warning" style="float:left;">Tổng số tiền: ${tong.intValue()}</p>
			</div>
			<div class="at-in">
				<a href="./bill?nccId=${ncc.id}&isBill=true" class="btn btn-info float-right">In hóa đơn</a>
				<a href="./mathang?ncc_id=${ncc.id}" class="btn btn-info float-right">Thêm mới</a>
			</div>
			<div style="clear:both"></div>
		</div>
	</div>
</div>
</body>
<%@include file="footer.html"%>
</html>