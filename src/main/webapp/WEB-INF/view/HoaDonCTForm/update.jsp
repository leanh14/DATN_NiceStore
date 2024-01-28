<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>HoaDon</title>
</head>
<body class="container">
<form:form modelAttribute="hoaDonCT" action="/hoa-donct/update/${hoaDonCT.id}" method="post">

    <div class="form-group">
        <label>Ma HDCT</label>
        <form:input path="maHoaDonCT" cssClass="form-control" value="${hoaDonCT.maHoaDonCT}" />
    </div>
    <div class="form-group">
        <label>Ma HoaDon</label>
        <form:select path="hoaDon.id" class="form-control">
            <c:forEach var="hd" items="${listHD}">
                <form:option value="${hd.id}">${hd.ma}</form:option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <label>DonGia</label>
        <form:input path="donGia"  cssClass="form-control" value="${hoaDonCT.donGia}" />
    </div>
    <div class="form-group">
        <label>SoLuong</label>
        <form:input path="soLuong" type="number" cssClass="form-control" value="${hoaDonCT.soLuong}" />
    </div>
    <div class="form-group">
        <label>NgayTao</label>
        <form:input path="ngayTao" type="date" cssClass="form-control" value="${hoaDonCT.ngayTao}" />
    </div>
    <div class="form-group">
        <label>NgaySua</label>
        <form:input path="ngaySua" type="date" cssClass="form-control" value="${hoaDonCT.ngaySua}" />
    </div>
    <div class="form-group">
        <label>NguoiTao</label>
        <form:input path="nguoiTao" cssClass="form-control" value="${hoaDonCT.nguoiTao}" />
    </div>
    <div class="form-group">
        <label>NguoiSua</label>
        <form:input path="nguoiSua"  cssClass="form-control" value="${hoaDonCT.nguoiSua}" />
    </div>
    <div class="form-group">
        <label>TrangThai</label>
        <form:radiobutton path="trangThai"  value="1"/>Con hang
        <form:radiobutton path="trangThai"  value="0"/>Het hang
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form:form>
</body>
</html>
