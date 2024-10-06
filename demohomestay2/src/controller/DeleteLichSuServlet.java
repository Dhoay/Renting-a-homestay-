package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DBconnect;
import Model.LichSuDatPhong;

@WebServlet("/delete-booking")
public class DeleteLichSuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int lichSuId = Integer.parseInt(request.getParameter("id"));

        try {
            LichSuDatPhong lichSuDatPhong = DBconnect.getLichSuDatPhongById(lichSuId);
            request.setAttribute("lichSuDatPhong", lichSuDatPhong);
            request.getRequestDispatcher("delete.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int lichSuId = Integer.parseInt(request.getParameter("lichSuId"));

        int result = DBconnect.deleteLichSuDatPhong(lichSuId);

		if (result == 1) {
		    response.sendRedirect("huythanhcong.jsp");
		} else {
		    response.getWriter().println("Có lỗi xảy ra khi xoá lịch sử đặt phòng.");
		}
    }
}
