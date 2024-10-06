package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DBconnect;
import Model.HomestayDAO;

/**
 * Servlet implementation class BookRoomServlet
 */
@WebServlet("/BookRoomServlet")
public class BookRoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Read booking information from the request parameters
        String tenNguoiDat = request.getParameter("tenNguoiDat");
        String emailNguoiDat = request.getParameter("emailNguoiDat");
        String soDienThoaiNguoiDat = request.getParameter("soDienThoaiNguoiDat");
        int homestayId = Integer.parseInt(request.getParameter("homestayId"));

        // Perform the booking
        HomestayDAO homestayDAO = new HomestayDAO();
        int rowsAffected = 0;
        try {
            rowsAffected = homestayDAO.bookHomestay(tenNguoiDat, emailNguoiDat, soDienThoaiNguoiDat, homestayId);

            // Check the result and redirect accordingly
            if (rowsAffected > 0) {
                // Thêm lịch sử đặt phòng
                try {
                    DBconnect.insertLichSuDatPhong(DBconnect.getConnection(), tenNguoiDat, emailNguoiDat, soDienThoaiNguoiDat, homestayId);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

                // Redirect hoặc hiển thị thông báo thành công
                response.sendRedirect("success.jsp");
            } else {
                // Xử lý khi đặt phòng thất bại
                response.sendRedirect("error.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
