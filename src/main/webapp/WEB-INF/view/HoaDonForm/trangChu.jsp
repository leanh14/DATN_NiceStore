<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstr   ap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

    <title>HoaDon</title>
</head>
<body class="container">
<button type="button"  class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    Thêm HoaDon
</button>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Thêm HoaDon</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form:form modelAttribute="hoaDon" action="/hoa-don/add" method="post">
                    <div class="form-group">
                        <label>Ma</label>
                        <form:input path="ma" cssClass="form-control" />
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
                        <form:input path="ngayMua" type="date" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>NgayNhan</label>
                        <form:input path="ngayNhan" type="date" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>NgayGiao</label>
                        <form:input path="ngayGiao" type="date" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>NgayThanhToan</label>
                        <form:input path="ngayThanhToan" type="date" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>TongTienThanhToan</label>
                        <form:input path="tongTienThanhToan" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>TienVanChuyen</label>
                        <form:input path="tienVanChuyen" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>TongTienGiamGia</label>
                        <form:input path="tongTienGiamGia" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>TenKH</label>
                        <form:input path="tenKH" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>DiaChi</label>
                        <form:input path="diaChi" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>SoDT</label>
                        <form:input path="soDT" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>GhiCHu</label>
                        <form:input path="ghiChu" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>HinhThucTT</label>
                        <form:input path="hinhThucTT" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>TrangThai</label>
                        <form:radiobutton path="trangThai"  value="1"/>Con hang
                        <form:radiobutton path="trangThai"  value="0"/>Het hang
                    </div>

                    <button type="submit" class="btn btn-primary">Add</button>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Thoát</button>
            </div>
        </div>
    </div>
</div>

<h1 style="text-align: center">Danh sach HoaDon</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">TenPhieuGiam</th>
        <th scope="col">Ma </th>
        <th scope="col">NgayMua </th>
        <th scope="col">NgayNhan</th>
        <th scope="col">NgayGiao</th>
        <th scope="col">NgayThanhToan</th>
        <th scope="col">TongTienTT </th>
        <th scope="col">TienVanChuyen </th>
        <th scope="col">TongTienGiam</th>
        <th scope="col">TenKh </th>
        <th scope="col">DiaChi </th>
        <th scope="col">SoDT </th>
        <th scope="col">GhiChu </th>
        <th scope="col">HinhThucTT </th>
        <th scope="col">TrangThai </th>
        <th scope="col">Action</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach items="${listHD}" var="hd">
        <tr>
            <td>${hd.phieuGiamGia.tenPhieu}</td>
            <td>${hd.ma}</td>
            <td>${hd.ngayMua}</td>
            <td>${hd.ngayNhan}</td>
            <td>${hd.ngayGiao}</td>
            <td>${hd.ngayThanhToan}</td>
            <td>${hd.tongTienThanhToan}</td>
            <td>${hd.tienVanChuyen}</td>
            <td>${hd.tongTienGiamGia}</td>
            <td>${hd.tenKH}</td>
            <td>${hd.diaChi}</td>
            <td>${hd.soDT}</td>
            <td>${hd.ghiChu}</td>
            <td>${hd.hinhThucTT}</td>
            <td>${hd.trangThai == 1? "Con hang" :"Het hang"}</td>

            <td>
                <a href="/hoa-don/delete/${hd.id}" class="btn btn-primary">Delete</a>
            </td>
            <td>  <a href="/hoa-don/detail/${hd.id}" class="btn btn-primary">Detail</a></td>
        </tr>
    </c:forEach>


    </tbody>
</table>

<div>
    <c:forEach begin="1" end="${totalPage}" varStatus="status">
        <a><a href="/hoa-don/hien-thi?page=${status.index-1}">${status.index-1}</a></a>
    </c:forEach>
</div>
</body>
</html>