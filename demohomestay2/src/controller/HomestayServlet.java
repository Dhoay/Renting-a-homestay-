package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.HomestayDAO;
import Model.homestays;

@WebServlet("/HomestayServlet")
public class HomestayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HomestayDAO homestayDAO = new HomestayDAO();
            List<homestays> homestayList = homestayDAO.getAllHomestays();
            request.setAttribute("homestayList", homestayList);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Consider logging or handling the exception appropriately
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ten = request.getParameter("ten");
            String diachi = request.getParameter("diachi");
            String dienthoai = request.getParameter("dienthoai");
            String email = request.getParameter("email");
            String anh = request.getParameter("anh");
            String mota = request.getParameter("mota");
            int gia = Integer.parseInt(request.getParameter("gia"));
            String tiennghi = request.getParameter("tiennghi");
            String dichVu = request.getParameter("dichVu");

            homestays homestay = new homestays(ten, diachi, dienthoai, email, anh, mota, gia, tiennghi, dichVu);

            HomestayDAO homestayDAO = new HomestayDAO();
            int rowsAffected = homestayDAO.addHomestay(homestay);

            if (rowsAffected > 0) {
                // If successful, you can use request attributes to display a message on the same page
                request.setAttribute("successMessage", "Homestay added successfully");
            } else {
                // If not successful, you can use request attributes to display an error message on the same page
                request.setAttribute("errorMessage", "Failed to add homestay");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider logging or handling the exception appropriately
            request.setAttribute("errorMessage", "An error occurred");
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
