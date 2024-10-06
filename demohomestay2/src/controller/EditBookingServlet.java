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

@WebServlet("/edit-booking")
public class EditBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy ID lịch sử đặt phòng từ request
        int lichSuId = Integer.parseInt(request.getParameter("id"));

        try {
            // Lấy thông tin lịch sử đặt phòng từ cơ sở dữ liệu dựa trên ID
            LichSuDatPhong lichSuDatPhong = DBconnect.getLichSuDatPhongById(lichSuId);

            // Chuyển thông tin lịch sử đặt phòng vào request attribute để hiển thị trên trang sửa
            request.setAttribute("lichSuDatPhong", lichSuDatPhong);

            // Chuyển hướng đến trang sửa lịch sử đặt phòng
            request.getRequestDispatcher("edit-booking.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ form sửa lịch sử đặt phòng
        String tenNguoiDat = request.getParameter("tennguoidat");
        String emailNguoiDat = request.getParameter("emailnguoidat");
        String soDienThoaiNguoiDat = request.getParameter("sodienthoainguoidat");
        String ngayDat = request.getParameter("ngaydat");

        try {
            // Tạo đối tượng LichSuDatPhong với thông tin mới
            LichSuDatPhong lichSuDatPhong = new LichSuDatPhong();
            lichSuDatPhong.settennguoidat(tenNguoiDat);
            lichSuDatPhong.setemailnguoidat(emailNguoiDat);
            lichSuDatPhong.setsodienthoainguoidat(soDienThoaiNguoiDat);
            // Chuyển định dạng ngày từ String sang Date nếu cần
            // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // lichSuDatPhong.setNgayDat(dateFormat.parse(ngayDat));

            // Gọi phương thức cập nhật lịch sử đặt phòng từ DBconnect
            int result = DBconnect.updateLichSuDatPhong(lichSuDatPhong);

            if (result == 1) {
                // Nếu cập nhật thành công, chuyển hướng đến trang hiển thị lịch sử đặt phòng
                response.sendRedirect("view-booking.jsp");
            } else {
                response.getWriter().println("Có lỗi xảy ra khi cập nhật lịch sử đặt phòng.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}