<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Đăng ký</title> 
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
    <div class="form-container">
        <center>
            <h2>Đăng ký</h2>

            <form action="RegisterServlet" method="post">
                <div class="form-group">
                    <label for="username">Tên đăng nhập:</label>
                    <input type="text" id="username" name="username" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" class="form-control" required>
                </div>
<% if (request.getAttribute("registerSuccess") != null && (Boolean) request.getAttribute("registerSuccess")) { %>
                <div class="registration-success">
                    <h3>Đăng ký thành công!</h3>
  					<h4>Thông tin đăng ký của bạn</h4>
                    <p>Tên đăng nhập: ${param.username}</p>
                    <p>Email: ${param.email}</p>               	               
        </div>
            <% } %>
                <button type="submit" class="btn-submit">Đăng ký</button>
            </form>
            	<p>Đã có tài khoản đăng nhập <a href="login.jsp">Quay về đăng nhập </a></p>         
        </center>
    </div>
</body>
</html>
