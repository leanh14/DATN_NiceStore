<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>KieuDang</title>
</head>
<body class="container">
<form:form modelAttribute="kieuDang" action="/kieu-dang/update/${kieuDang.id}" method="post">

    <div class="form-group">
        <label>Mã</label>
        <form:input path="ma" cssClass="form-control" value="${kieuDang.ma}" />
    </div>

    <div class="form-group">
        <label>Tên</label>
        <form:input path="ten" cssClass="form-control" value="${kieuDang.ten}"  />
    </div>
    <div class="form-group">
        <label>Mô tả</label>
        <form:input path="moTa" cssClass="form-control" value="${kieuDang.moTa}"  />
    </div>
    <div class="form-group">
        <label>Ngày tạo</label>
        <form:input path="ngayTao" type="date" cssClass="form-control" value="${kieuDang.ngayTao}"  />
    </div>
    <div class="form-group">
        <label>Ngày sửa</label>
        <form:input path="ngaySua" type="date" cssClass="form-control" value="${kieuDang.ngaySua}"  />
    </div>
    <div class="form-group">
        <label>Người tạo</label>
        <form:input path="nguoiTao" cssClass="form-control" value="${kieuDang.nguoiTao}"  />
    </div>
    <div class="form-group">
        <label>Người sửa</label>
        <form:input path="nguoiSua" cssClass="form-control" value="${kieuDang.nguoiSua}"  />
    </div>
    <div class="form-group">
        <label>Trạng thái</label>
        <form:radiobutton path="trangThai"  value="1"/>Còn hàng
        <form:radiobutton path="trangThai"  value="0"/>Hết hàng
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
</form:form>
</body>
</html>
