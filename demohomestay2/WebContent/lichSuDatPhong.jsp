<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lịch Sử Đặt Phòng</title>
     <style>
    body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    color: #333;
    margin: 20px;
}

h2 {
    color: #800000;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    border: 1px solid #ddd;
    padding: 10px;
    text-align: left;
}

th {
    background-color: #800000;
    color: #fff;
}

a {
    text-decoration: none;
    color: #800000;
    margin-right: 10px;
}

a:hover {
    text-decoration: underline;
}

a.add-homestay {
    display: inline-block;
    background-color: #800000;
    color: #fff;
    padding: 10px 15px;
    text-decoration: none;
    margin-top: 20px;
}

a.add-homestay:hover {
    background-color: #800000;
}
     </style>
</head>
<body>
    <h2>Lịch Sử Đặt Phòng</h2>
    
    <table border="1">
        <tr>
            <th>Tên Người Đặt</th>
            <th>Email Người Đặt</th>
            <th>Số Điện Thoại Người Đặt</th>
            <th>Tên Homestay</th>
            <th>Ngày Đặt</th>
            <th>Sửa thông tin</th>
            <th>Huỷ đặt phòng</th>
        </tr>
        <c:forEach var="lichSu" items="${lichSuDatPhong}">
            <tr>
                <td>${lichSu.tennguoidat}</td>
                <td>${lichSu.emailnguoidat}</td>
                <td>${lichSu.sodienthoainguoidat}</td>
                <td>${lichSu.idhomestay}</td>
                <td>${lichSu.ngaydat}</td>
                <td>
                    <a href="Sua.jsp?id=${lichSu.id}">Sửa</a>
                </td>
                <td>
                    <a href="DeleteLichSuServlet?id=${lichSu.id}">Huỷ</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    
    <a href="HomestayServlet">Đặt thêm homestay</a>
</body>
</html>
