<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>welcome</title>
    <style type="text/css">
    	<%@include file="WEB-INF/template/css/bootstrap.min.css" %>
    	.login {
    	text-align: center;
    	}
    	.alert {
    		color:red;
    		text-align: center;
    	}
	</style>
</head>
<body>
<div class="container">
<h3 class="login">Login</h3>
<h4 class="alert">${message}</h4>
<form action="Login" method="POST">
<div class="form-group">
    <label for="username">Tên đăng nhập</label>
    <input type="text" name="username" class="form-control" required>
  </div>
  <div class="form-group">
    <label for="username">Mật khẩu</label>
    <input type="password" name="password" class="form-control" required>
  </div>
    <input type="submit" value="Đăng nhập">
</form>
</div>
</body>
<%@include file="footer.html"%>
</html>