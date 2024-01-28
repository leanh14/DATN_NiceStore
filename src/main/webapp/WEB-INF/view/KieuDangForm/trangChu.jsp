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

    <title>KieuDang</title>
</head>
<body class="container">
<button type="button"  class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    Thêm KieuDang
</button>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Thêm KieuDang</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form:form modelAttribute="kieuDang" action="/kieu-dang/add" method="post">
                    <div class="form-group">
                        <label>Ma</label>
                        <form:input path="ma" cssClass="form-control" />
                    </div>

                    <div class="form-group">
                        <label>Ten</label>
                        <form:input path="ten" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>MoTa</label>
                        <form:input path="moTa" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>NgayTao</label>
                        <form:input path="ngayTao" type="date" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>NgaySua</label>
                        <form:input path="ngaySua" type="date" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>NguoiTao</label>
                        <form:input path="nguoiTao" cssClass="form-control" />
                    </div>
                    <div class="form-group">
                        <label>NguoiSua</label>
                        <form:input path="nguoiSua" cssClass="form-control" />
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

<h1 style="text-align: center">Danh sach KieuDang</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Ma</th>
        <th scope="col">Ten </th>
        <th scope="col">MoTa </th>
        <th scope="col">NgayTao</th>
        <th scope="col">NgaySua</th>
        <th scope="col">NguoiTao</th>
        <th scope="col">NguoiSua </th>
        <th scope="col">TrangThai </th>
        <th scope="col">Action</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach items="${listKD}" var="kd">
        <tr>
            <td>${kd.id}</td>
            <td>${kd.ma}</td>
            <td>${kd.ten}</td>
            <td>${kd.moTa}</td>
            <td>${kd.ngayTao}</td>
            <td>${kd.ngaySua}</td>
            <td>${kd.nguoiTao}</td>
            <td>${kd.nguoiSua}</td>
            <td>${kd.trangThai == 1? "Con hang" :"Het hang"}</td>

            <td>
                <a href="/kieu-dang/delete/${kd.id}" class="btn btn-primary">Delete</a>
            </td>
            <td>  <a href="/kieu-dang/detail/${kd.id}" class="btn btn-primary">Detail</a></td>
        </tr>
    </c:forEach>


    </tbody>
</table>

<div>
    <c:forEach begin="1" end="${totalPage}" varStatus="status">
        <a><a href="/kieu-dang/hien-thi?page=${status.index-1}">${status.index-1}</a></a>
    </c:forEach>
</div>
</body>
</html>