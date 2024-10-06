<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Lịch Sử Đặt Phòng</title>
     <style>
   body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    color: #800000;
    margin: 20px;
}

h2 {
    color: #800000;
}

form {
    max-width: 400px;
    margin: 20px 0;
}

label {
    display: block;
    margin-bottom: 8px;
}

input {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    box-sizing: border-box;
}

input[type="submit"] {
    background-color: #800000;
    color: #fff;
    cursor: pointer;
}

a {
    display: inline-block;
    text-decoration: none;
    color: #800000;
    margin-top: 10px;
}
     </style>
</head>
<body>
    <h2>Sửa Lịch Sử Đặt Phòng</h2>

    <form action="EditBookingServlet" method="post">
        <input type="hidden" name="lichSuId" value="${lichSuDatPhong.id}" />

        <label for="tenNguoiDat">Tên Người Đặt:</label>
        <input type="text" id="tennguoidat" name="tennguoidat" value="${lichSuDatPhong.tennguoidat}" required /><br/>

        <label for="emailNguoiDat">Email Người Đặt:</label>
        <input type="text" id="emailnguoidat" name="emailnguoidat" value="${lichSuDatPhong.emailnguoidat}" required /><br/>

        <label for="soDienThoaiNguoiDat">Số Điện Thoại Người Đặt:</label>
        <input type="text" id="sodienthoainguoidat" name="sodienthoainguoidat" value="${lichSuDatPhong.sodienthoainguoidat}" required /><br/>

        <label for="ngayDat">Ngày Đặt:</label>
        <input type="text" id="ngaydat" name="ngaydat" value="${lichSuDatPhong.ngaydat}" required /><br/>

        <input type="submit" value="Cập Nhật" />
    </form>

    <a href="ServletLichSuDatPhong">Quay lại</a>
</body>
</html>
