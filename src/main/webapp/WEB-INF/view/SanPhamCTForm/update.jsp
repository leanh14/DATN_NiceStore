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
<form:form modelAttribute="sanPhamCT" action="/san-phamct/update/${sanPhamCT.id}" method="post">

    <div class="form-group">
        <label>Ten KieuDang</label>
        <form:select path="kieuDang.id" class="form-control">
            <c:forEach var="kd" items="${listKD}">
                <form:option value="${kd.id}">${kd.ten}</form:option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <label>Ten LotGiay</label>
        <form:select path="lotGiay.id" class="form-control">
            <c:forEach var="lg" items="${listLG}">
                <form:option value="${lg.id}">${lg.ten}</form:option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <label>GiaTriSP</label>
        <form:input path="giaTriSanPham"  cssClass="form-control"  value="${sanPhamCT.giaTriSanPham}"/>
    </div>
    <div class="form-group">
        <label>GiaTriGiam</label>
        <form:input path="giaTriGiam"  cssClass="form-control" value="${sanPhamCT.giaTriGiam}" />
    </div>
    <div class="form-group">
        <label>KhoiLuong</label>
        <form:input path="khoiLuong"  cssClass="form-control" value="${sanPhamCT.khoiLuong}" />
    </div>
    <div class="form-group">
        <label>NgayHetGiamGia</label>
        <form:input path="ngayHetGiamGia"  cssClass="form-control" value="${sanPhamCT.ngayHetGiamGia}" />
    </div>

    <div class="form-group">
        <label>MoTa</label>
        <form:input path="moTa" cssClass="form-control" value="${sanPhamCT.moTa}" />
    </div>
    <div class="form-group">
        <label>SoLuong</label>
        <form:input path="soLuong" type="number"  cssClass="form-control"  value="${sanPhamCT.soLuong}"/>
    </div>
    <div class="form-group">
        <label>HinhAnh</label>
        <form:input path="hinhAnh"   cssClass="form-control" value="${sanPhamCT.hinhAnh}" />
    </div>
    <div class="form-group">
        <label>NgayTao</label>
        <form:input path="ngayTao" type="date" cssClass="form-control" value="${sanPhamCT.ngayTao}" />
    </div>
    <div class="form-group">
        <label>NgaySua</label>
        <form:input path="ngaySua" type="date" cssClass="form-control"  value="${sanPhamCT.ngaySua}"/>
    </div>
    <div class="form-group">
        <label>NguoiTao</label>
        <form:input path="nguoiTao" cssClass="form-control" value="${sanPhamCT.nguoiTao}" />
    </div>
    <div class="form-group">
        <label>NguoiSua</label>
        <form:input path="nguoiSua"  cssClass="form-control" value="${sanPhamCT.nguoiSua}" />
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
