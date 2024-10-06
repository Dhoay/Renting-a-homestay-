<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xác Nhận Huỷ</title>
    
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
            margin-top: 10px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #800000;
            color: #fff;
        }

        form {
            margin-top: 20px;
        }

        input[type="submit"] {
            background-color: #800000;
            color: #fff;
            padding: 10px 15px;
            border: none;
            cursor: pointer;
        }

        a {
            text-decoration: none;
            color: #800000;
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <h2>Xác Nhận Huỷ Đặt Phòng</h2>

    <table>
        <tr>
            <th></th>
            <th>Thông Tin</th>
        </tr>
        <tr>
            <td>Tên Người Đặt:</td>
            <td>${lichSuDatPhong.tennguoidat}</td>
        </tr>
        <tr>
            <td>Email Người Đặt:</td>
            <td>${lichSuDatPhong.emailnguoidat}</td>
        </tr>
        <tr>
            <td>Số Điện Thoại Người Đặt:</td>
            <td>${lichSuDatPhong.sodienthoainguoidat}</td>
        </tr>
        <tr>
       		 	<td>Tên Homestay:</td>
                <td>${lichSuDatPhong.idhomestay}</td>
		 <tr>
		 <tr>
				 <td>Ngày đặt:</td>
				 <td>${lichSuDatPhong.ngaydat}</td>
		 <tr>
    </table>

    <form action="delete-booking" method="post">
        <input type="hidden" name="lichSuId" value="${lichSuDatPhong.id}" />
        <input type="submit" value="Xác Nhận Huỷ" />
    </form>

    <a href="ServletLichSuDatPhong">Hủy Bỏ</a>
</body>
</html>
