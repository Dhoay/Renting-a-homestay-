package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DBconnect;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra thông tin đăng nhập trong cơ sở dữ liệu
        DBconnect db = new DBconnect();
        boolean isValidUser = db.authenticateUser(username, password);

        if (isValidUser) {
            // Tạo đối tượng User và lưu vào session
        	HttpSession session = request.getSession();
        	session.setAttribute("welcomeMessage", "Xin chào: " + username + "!");
        	response.sendRedirect("index.jsp");

            // Chuyển hướng đến trang chính sau khi đăng nhập thành công
        } else {
            // Chuyển hướng lại trang đăng nhập nếu thông tin không hợp lệ
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
