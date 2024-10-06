<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Model.HomestayDAO"%>
<%@ page import="Model.homestays"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Booking Form</title>
    <link rel="stylesheet" href="css/booking.css">
</head>
<body>
    <div class="center-content">
        <center>
            <header>
                <nav id="hnav">
                    <div id="logo">
                        <a href="index.jsp">DANH HOMESTAY</a>
                    </div>
                    <ul class="menu">
                	    <li><a href="ServletLichSuDatPhong">LỊCH SỬ ĐẶT PHÒNG</a></li>
                        <li>
                            <a href="#">CONTACT</a>
                            <ul class="submenu">
                                <li><a href="https://www.facebook.com/profile.php?id=100031713337004&mibextid=ZbWKwL" target="_blank">Facebook</a></li>
                                <li><a href="https://instagram.com/dhoay_467?igshid=NGVhN2U2NjQ0Yg==" target="_blank">Instagram</a></li>
                                <li><a href="https://www.tiktok.com/@danhkoluumanh?_t=8hbhDEnWZMN&_r=1" target="_blank">Tiktok</a></li>
                            </ul>
                        </li>
                        <li>
                            <c:if test="${not empty sessionScope.welcomeMessage}">
                                <div class="welcome-message">${sessionScope.welcomeMessage}</div>
                                <c:set var="sessionScope.welcomeMessage" value="" scope="session"/>
                            </c:if>
                        </li>
                        <li>
                            <%
    if (session.getAttribute("welcomeMessage") != null) {
%>
    <a href="LogoutServlet">ĐĂNG XUẤT</a> 
<%
    } else {
%>
    <li><a href="login.jsp">ĐĂNG NHẬP</a></li>
    <li><a href="register.jsp">ĐĂNG KÝ</a><li>
<%
    }
%>  
                        </li>
                        <li><a href="register.jsp">ĐĂNG KÝ</a></li>                
                    </ul>
                </nav>
            </header>

            <main>
                <div id="banner">
                    <img class="banner" src="Images/da-lat-1.jpg">
                </div>
                <div class="bookroom">
					<img src="Images/HomestayLOGO.png" alt="Homestay Logo" width="200" height="200">
                    <center>
            <h2>THÔNG TIN ĐẶT PHÒNG</h2>
           <div class="form-container">
    <form action="BookRoomServlet" method="post">
        <div class="form-group">
      	  <label for="tenNguoiDat"><span>Tên người đặt:</span></label>
            <input type="text" id="tenNguoiDat" name="tenNguoiDat" required>
        </div>

        <div class="form-group">
        <label for="emailNguoiDat"><span>Email người đặt:</span></label>
            <input type="email" id="emailNguoiDat" name="emailNguoiDat" required>
        </div>

        <div class="form-group">
        <label for="soDienThoaiNguoiDat"><span>Số điện thoại người đặt:</span></label>
            <input type="tel" id="soDienThoaiNguoiDat" name="soDienThoaiNguoiDat" required>
        </div>

        <!-- Include other necessary input fields for booking -->

        <!-- Hidden field to store homestay ID -->
        <input type="hidden" name="homestayId" value="${param.homestayId}">

        <button type="submit">Đặt phòng</button>
    </form>
</div>
            <!-- Include a back button to return to the homestay details -->
            <button onclick="history.go(-1);">Quay lại</button>
        </center>
                </div>

                <section class="homestay">
                    <h2> HOMESTAY ĐÀ LẠT</h2>
                    <form action="HomestayServlet" method="get">
                        <input type="submit" value="Hiển thị danh sách Homestay">
                    </form>
                    <div class="homestay-grid">
                        <c:forEach items="${homestayList}" var="homestay">
                            <div class="homestay-item">
                                <img src="${homestay.anh}" alt="Homestay Image">
                                <p class="homestay-name">${homestay.ten}</p>
                                <p>Địa chỉ: ${homestay.diachi}</p>
                                <p>Số điện thoại: ${homestay.dienthoai}</p>
                                <p>Email: ${homestay.email}</p>
                                <p>${homestay.mota} </p>
                                <p>Dịch vụ: ${homestay.dichVu}</p>
                                <p>Tiện nghi: ${homestay.tiennghi}</p>
                                <p>Giá thuê: ${homestay.gia} VNĐ/1 ngày</p>
                                <form action="BookRoomServlet" method="post">
                                    <input type="hidden" name="homestayId" value="${homestay.id}">
                                    <button type="submit">Đặt phòng</button>
                                </form>
                            </div>
                        </c:forEach>
                    </div>
                </section>
            </main>

            <footer>
                <div id="extend-f">
                    <nav class="footnav3">
                        <h3>SOCIAL NETWORK LINK</h3>
                        <ul>
                            <li><a href="#">Facebook</a></li>
                            <li><a href="#">Google +</a></li>
                            <li><a href="#">Twitter</a></li>
                        </ul>
                    </nav>
                </div>
                <div id="root-f">
                    <h4>220&copy;Design by Hiển Danh</h4>
                </div>
            </footer>
        </center>
    </div> 
</body>
</html>
