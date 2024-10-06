package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomestayDAO {

    public List<homestays> getAllHomestays() throws ClassNotFoundException {
        List<homestays> homestayList = new ArrayList<>();

        try (Connection connection = DBconnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM homestay");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                homestays homestay = new homestays();
                homestay.setId(resultSet.getInt("id"));
                homestay.setTen(resultSet.getString("ten"));
                homestay.setdiachi(resultSet.getString("diachi"));
                homestay.setdienthoai(resultSet.getString("dienthoai"));
                homestay.setEmail(resultSet.getString("email"));
                homestay.setAnh(resultSet.getString("anh"));
                homestay.setmota(resultSet.getString("mota"));
                homestay.setGia(resultSet.getInt("gia"));
                homestay.settiennghi(resultSet.getString("tiennghi"));
                homestay.setDichVu(resultSet.getString("dichvu"));

                homestayList.add(homestay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return homestayList;
    }

    public int addHomestay(homestays homestay) throws ClassNotFoundException {
        try (Connection connection = DBconnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO homestay (ten, dia_chi, dien_thoai, email, anh, mo_ta, gia, tien_nghi, dich_vu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, homestay.getTen());
            preparedStatement.setString(2, homestay.getdiachi());
            preparedStatement.setString(3, homestay.getdienthoai());
            preparedStatement.setString(4, homestay.getEmail());
            preparedStatement.setString(5, homestay.getAnh());
            preparedStatement.setString(6, homestay.getmota());
            preparedStatement.setInt(7, homestay.getGia());
            preparedStatement.setString(8, homestay.gettiennghi());
            preparedStatement.setString(9, homestay.getDichVu());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    public int bookHomestay(String tennguoidat, String emailnguoidat, String sodienthoainguoidat, int idhomestay) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;

        try {
            connection = DBconnect.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO dathomestay (tennguoidat, emailnguoidat, sodienthoainguoidat, idhomestay, ngaydat) VALUES (?, ?, ?, ?, NOW())");
            preparedStatement.setString(1, tennguoidat);
            preparedStatement.setString(2, emailnguoidat);
            preparedStatement.setString(3, sodienthoainguoidat);
            preparedStatement.setInt(4, idhomestay);

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rowsAffected;
    }
    public static List<LichSuDatPhong> getLichSuDatPhong() throws ClassNotFoundException {
        List<LichSuDatPhong> lichSuDatPhongList = new ArrayList<>();

        try (Connection connection = DBconnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM lichsudatphong");
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                LichSuDatPhong lichSuDatPhong = new LichSuDatPhong();
                lichSuDatPhong.setId(resultSet.getInt("id"));
                lichSuDatPhong.settennguoidat(resultSet.getString("tennguoidat"));
                lichSuDatPhong.setemailnguoidat(resultSet.getString("emailnguoidat"));
                lichSuDatPhong.setsodienthoainguoidat(resultSet.getString("sodienthoainguoidat"));
                lichSuDatPhong.setidhomestay(resultSet.getInt("idhomestay"));
                lichSuDatPhong.setngaydat(resultSet.getDate("ngaydat"));

                lichSuDatPhongList.add(lichSuDatPhong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lichSuDatPhongList;
    }
}