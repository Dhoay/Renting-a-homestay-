package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DBconnect;
import Model.LichSuDatPhong;

/**
 * Servlet implementation class ServletLichSuDatPhong
 */
@WebServlet("/ServletLichSuDatPhong")
public class ServletLichSuDatPhong extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<LichSuDatPhong> lichSuDatPhongList = DBconnect.getLichSuDatPhong();
            
            // Lưu lịch sử đặt phòng vào thuộc tính yêu cầu (request attribute)
            request.setAttribute("lichSuDatPhong", lichSuDatPhongList);            
            // Chuyển tiếp tới trang JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("lichSuDatPhong.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
