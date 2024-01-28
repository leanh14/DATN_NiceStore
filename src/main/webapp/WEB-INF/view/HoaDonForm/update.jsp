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
<form:form modelAttribute="hoaDon" action="/hoa-don/update/${hoaDon.id}" method="post">

    <div class="form-group">
        <label>Ma</label>
        <form:input path="ma" cssClass="form-control" value="${hoaDon.ma}" />
    </div>
    <div class="form-group">
        <label>Ten PhieuGiamGia</label>
        <form:select path="phieuGiamGia.id" class="form-control">
            <c:forEach var="pg" items="${listPG}">
                <form:option value="${pg.id}">${pg.tenPhieu}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <div class="form-group">
        <label>NgayMua</label>
        <form:input path="ngayMua" type="date" cssClass="form-control"  value="${hoaDon.ngayMua}"/>
    </div>
    <div class="form-group">
        <label>NgayNhan</label>
        <form:input path="ngayNhan" type="date" cssClass="form-control" value="${hoaDon.ngayNhan}" />
    </div>
    <div class="form-group">
        <label>NgayGiao</label>
        <form:input path="ngayGiao" type="date" cssClass="form-control" value="${hoaDon.ngayGiao}" />
    </div>
    <div class="form-group">
        <label>NgayThanhToan</label>
        <form:input path="ngayThanhToan" type="date" cssClass="form-control" value="${hoaDon.ngayThanhToan}" />
    </div>
    <div class="form-group">
        <label>TongTienThanhToan</label>
        <form:input path="tongTienThanhToan" cssClass="form-control" value="${hoaDon.tongTienThanhToan}" />
    </div>
    <div class="form-group">
        <label>TienVanChuyen</label>
        <form:input path="tienVanChuyen" cssClass="form-control" value="${hoaDon.tienVanChuyen}" />
    </div>
    <div class="form-group">
        <label>TongTienGiamGia</label>
        <form:input path="tongTienGiamGia" cssClass="form-control" value="${hoaDon.tongTienGiamGia}" />
    </div>
    <div class="form-group">
        <label>TenKH</label>
        <form:input path="tenKH" cssClass="form-control" value="${hoaDon.tenKH}" />
    </div>
    <div class="form-group">
        <label>DiaChi</label>
        <form:input path="diaChi" cssClass="form-control" value="${hoaDon.diaChi}" />
    </div>
    <div class="form-group">
        <label>SoDT</label>
        <form:input path="soDT" cssClass="form-control" value="${hoaDon.soDT}" />
    </div>
    <div class="form-group">
        <label>GhiCHu</label>
        <form:input path="ghiChu" cssClass="form-control" value="${hoaDon.ghiChu}" />
    </div>
    <div class="form-group">
        <label>HinhThucTT</label>
        <form:input path="hinhThucTT" cssClass="form-control" value="${hoaDon.hinhThucTT}" />
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
