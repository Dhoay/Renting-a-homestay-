<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

    <div class="form-container">
        <center>
            <h2>Đăng nhập</h2>

            <% if (request.getParameter("error") != null) { %>
                <p class="error-message">Tên đăng nhập hoặc mật khẩu không chính xác. Hãy thử lại.</p>
            <% } %>

            <form action="LoginServlet" method="post">
                <div class="form-group">
                    <label for="username">Tên đăng nhập:</label>
                    <input type="text" id="username" name="username" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" required>
                </div>

                <button type="submit" class="btn-submit">Login</button>
            </form>
			<p>Chưa có tài khoản đăng nhập? <a href="register.jsp">Đăng ký ngay</a></p>
            
        </center>
    </div>
</body>
</html>
