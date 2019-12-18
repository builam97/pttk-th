<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Them moi nha cung cap</title>
    <style type="text/css">
    	<%@include file="WEB-INF/template/css/bootstrap.min.css" %>
    	.login {
    	text-align: center;
    	}
	</style>
</head>
<body>
<div class="container">
<h3 class="login">Thêm mới nhà cung cấp</h3>
<form action="themmoi_ncc" method="POST">
<div class="form-group">
    <label for="name_ncc">Tên nhà cung cấp</label>
    <input type="text" name="name_ncc" class="form-control" required>
  </div>
  <div class="form-group">
    <label for="address_ncc">Địa chỉ</label>
    <input type="text" name="address_ncc" class="form-control" required>
  </div>
  <div class="form-group">
    <label for="sdt_ncc">Số điện thoại</label>
    <input type="text" name="sdt_ncc" class="form-control" required>
  </div>
    <input type="submit" value="Thêm mới">
</form>
</div>
</body>
<%@include file="footer.html"%>
</html>