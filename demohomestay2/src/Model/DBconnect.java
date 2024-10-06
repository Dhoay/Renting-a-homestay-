package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.User;

public class DBconnect {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homestay", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public int inserthomestays(homestays p) {
        Connection con = null;
        PreparedStatement ps = null;
        int row = 0;
        try {
            con = this.getConnection();
            ps = con.prepareStatement("insert into homestay (ten, diachi, dienthoai, email, anh, mota, gia, tiennghi, dichvu) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, p.getTen());
            ps.setString(2, p.getdiachi());
            ps.setString(3, p.getdienthoai());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getAnh());
            ps.setString(6, p.getmota());
            ps.setInt(7, p.getGia());
            ps.setString(8, p.gettiennghi());
            ps.setString(9, p.getDichVu());
            row = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;
    }
    public boolean authenticateUser(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = this.getConnection();
            ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            // If there is a matching user in the database, return true
            return rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // Other methods for handling homestays data can be added here
    // ...

    public static void main(String[] args) {
        // Example of usage
        DBconnect db = new DBconnect();
        boolean isAuthenticated = db.authenticateUser("testuser", "testpassword");
        if (isAuthenticated) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
        }
    }
    public int registerUser(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();
            ps = con.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");
	            ps.setString(1, user.getUsername());
	            ps.setString(2, user.getPassword());
	            ps.setString(3, user.getEmail());

            rowsAffected = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rowsAffected;
    }

	 public static void insertDBconnect(Connection conn, User user) throws SQLException {
        String sql = "INSERT INTO Users (username, password, email) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
	 public static void insertLichSuDatPhong(Connection conn, String tennguoidat, String emailnguoidat, String sodienthoainguoidat, int idhomestay) throws SQLException {
	        String sql = "INSERT INTO lichsudatphong (tennguoidat, emailnguoidat, sodienthoainguoidat, idhomestay, ngaydat) VALUES (?, ?, ?, ?, NOW())";

	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, tennguoidat);
	            pstmt.setString(2, emailnguoidat);
	            pstmt.setString(3, sodienthoainguoidat);
	            pstmt.setInt(4, idhomestay);

	            pstmt.executeUpdate();
	        }  
	    }
	 public static List<LichSuDatPhong> getLichSuDatPhong() throws SQLException, ClassNotFoundException {
	        List<LichSuDatPhong> lichSuDatPhongList = new ArrayList<>();

	        try (Connection connection = getConnection();
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
	        } // Tự động đóng kết nối sau khi kết thúc try

	        return lichSuDatPhongList;
	    }
	 public static int updateLichSuDatPhong(LichSuDatPhong lichSuDatPhong) throws SQLException, ClassNotFoundException {
		    try (Connection connection = getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(
		                 "UPDATE lichsudatphong SET tennguoidat=?, emailnguoidat=?, sodienthoainguoidat=?, ngaydat=? WHERE id=?")) {

		        preparedStatement.setString(1, lichSuDatPhong.gettennguoidat());
		        preparedStatement.setString(2, lichSuDatPhong.getemailnguoidat());
		        preparedStatement.setString(3, lichSuDatPhong.getsodienthoainguoidat());
		        preparedStatement.setDate(4, new java.sql.Date(lichSuDatPhong.getngaydat().getTime()));
		        preparedStatement.setInt(5, lichSuDatPhong.getId());

		        return preparedStatement.executeUpdate();
		    }
		}

	 public static LichSuDatPhong getLichSuDatPhongById(int lichSuId) throws SQLException {
		    try {
		        try (Connection connection = getConnection();
		             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM lichsudatphong WHERE id = ?")) {

		            preparedStatement.setInt(1, lichSuId);

		            try (ResultSet resultSet = preparedStatement.executeQuery()) {
		                if (resultSet.next()) {
		                    LichSuDatPhong lichSuDatPhong = new LichSuDatPhong();
		                    lichSuDatPhong.setId(resultSet.getInt("id"));
		                    lichSuDatPhong.settennguoidat(resultSet.getString("tennguoidat"));
		                    lichSuDatPhong.setemailnguoidat(resultSet.getString("emailnguoidat"));
		                    lichSuDatPhong.setsodienthoainguoidat(resultSet.getString("sodienthoainguoidat"));
		                    lichSuDatPhong.setidhomestay(resultSet.getInt("idhomestay"));
		                    lichSuDatPhong.setngaydat(resultSet.getDate("ngaydat"));
		                    return lichSuDatPhong;
		                }
		            }
		        }
		    } catch (ClassNotFoundException | SQLException e) {
		        // Handle or log the exception
		        e.printStackTrace();
		    }

		    return null;
		}

	 public static int deleteLichSuDatPhong(int lichSuId) {
		    try {
		        try (Connection connection = getConnection();
		             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM lichsudatphong WHERE id=?")) {

		            preparedStatement.setInt(1, lichSuId);
		            return preparedStatement.executeUpdate();
		        }
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }

		    return 0; 
		}

	}

    

