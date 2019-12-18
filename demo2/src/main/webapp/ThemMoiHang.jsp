<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Them moi hang</title>
    <style type="text/css">
    	<%@include file="WEB-INF/template/css/bootstrap.min.css" %>
    	.login {
    	text-align: center;
    	}
	</style>
</head>
<body>
<div class="container">
<h3 class="login">Thêm mới mặt hàng</h3>
<form action="themmoi_hang" method="POST">
<div class="form-group">
    <label for="name_hang">Tên hàng</label>
    <input type="text" name="name_hang" class="form-control" required>
  </div>
  <div class="form-group">
    <label for="name_hang">Mô tả</label>
    <input type="text" name="des_hang" class="form-control" required>
  </div>
  <div class="form-group">
    <label for="amount_hang">Số lượng</label>
    <input type="number" name="amount_hang" class="form-control" required>
  </div>
  <div class="form-group">
    <label for="price_hang">Giá cả</label>
    <input type="number" name="price_hang" class="form-control" required>
  </div>
    <input type="hidden" name="nccId" value=<%= request.getParameter("nccId") %>><br>
    <input type="submit" value="Thêm mới">
</form>
</div>
</body>
<%@include file="footer.html"%>
</html>