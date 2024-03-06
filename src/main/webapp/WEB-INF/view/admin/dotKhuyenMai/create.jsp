<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Thêm mới khuyến mãi</title>
    <meta name="description" content="Ela Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
    <link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
    <link rel="stylesheet" href="/admin/assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="/admin/assets/css/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
    <style>
        .messageError{
            color: red;
        }
    </style>
</head>
<body>
<!-- Left Panel -->
<jsp:include page="/WEB-INF/view/admin/layout/left_menu_admin.jsp"></jsp:include>
<!-- /Left Panel -->

<!-- Right Panel -->

<div id="right-panel" class="right-panel">

    <!-- Header-->
    <jsp:include page="/WEB-INF/view/admin/layout/header_admin.jsp"></jsp:include>
    <!-- Header-->

    <div class="breadcrumbs">
        <div class="breadcrumbs-inner">
            <div class="row m-0">
                <div class="col-sm-4">
                    <div class="page-header float-left">
                        <div class="page-title">
                            <h1>Dashboard</h1>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="page-header float-right">
                        <div class="page-title">
                            <ol class="breadcrumb text-right">
                                <li><a href="#">Dashboard</a></li>
                                <li><a href="#">Quản lý đợt khuyến mãi</a></li>
                                <li class="active">Thêm mới</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class=" content">
        <div class= " d-flex animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div>
                        <strong class="card-title" ><h3>Thêm đợt khuyến mãi</h3></strong>
                    </div>

                </div>
                <div class="card-body">
                    <sf:form action="/dot-khuyen-mai/them" method="post" modelAttribute="dotKhuyenMai" class="row">
                        <div class="col-lg-6">
                            <span>Mã (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:input path="ma" type="text" style="margin-top: 5px;" class="form-control"/>
                            <sf:errors path="ma" cssClass="text-danger" />
                            <c:if test="${trungMa==true}">
                                <p class="text-danger">Mã khuyến mãi này đã tồn tại, vui lòng nhập mã mới</p>
                            </c:if>
                        </div>
                        <div class="col-lg-6">
                            <span>Tên đợt khuyến mãi(<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:input path="tenDotKhuyenMai" type="text" style="margin-top: 5px;" class="form-control"/>
                            <sf:errors path="tenDotKhuyenMai" cssClass="text-danger" />
                            <c:if test="${trungTen==true}">
                                <p class="text-danger">Đợt khuyến mãi này đã tồn tại, vui lòng nhập thông tin mới</p>
                            </c:if>
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Giá trị giảm (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <sf:input path="giaTriGiam" style="margin-top: 5px;"  type="text" class="form-control"/>
                            <sf:errors path="giaTriGiam" cssClass="text-danger" />

                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Ngày bắt đầu (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <sf:input path="ngayBatDau" name="ngaySinh" type="date" class="form-control"/>
                            <sf:errors path="ngayBatDau" cssClass="text-danger" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            Ngày kết thúc (<i class="fa fa-asterisk" style="color: red;"></i>)
                            <sf:input path="ngayKetThuc" name="ngaySinh" type="date" class="form-control"/>
                            <sf:errors path="ngayKetThuc" cssClass="text-danger" />
                        </div>
                        <div class="col-lg-6" style="margin-top: 20px;">
                            <span>Trạng thái (<i class="fa fa-asterisk" style="color: red;"></i>)</span>
                            <br>
                            <sf:radiobutton path="trangThai"  value="1" checked="true" />    Hoạt động
                            <sf:radiobutton path="trangThai"  value="0"/>    Ngưng hoạt động
                            <sf:errors path="trangThai" cssClass="text-danger" />

                        </div>
                        <div class="col-lg-9" style="margin-top: 20px;"  >
                            <c:if test="${messageSuccess==true}">
                                <%--                                style="z-index: 9999; position: fixed; top: 10px; right: 10px; width: 350px;"--%>
                                <div id="messageAlertSuccess" class="alert alert-primary alert-dismissible "  style="width: 300px;" >

                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <i class="menu-icon fa fa-check"></i> Thêm dữ liệu thành công!
                                </div>

                                <script>
                                    // Lấy thẻ alert
                                    var alert = document.getElementById('messageAlertSuccess');

                                    // Ẩn thẻ alert sau 3 giây
                                    setTimeout(function() {
                                        alert.style.display = 'none';
                                    }, 3000); // 3000 milliseconds tương ứng với 3 giây
                                </script>
                            </c:if>
                        </div>
                        <div class="col-lg-12 d-flex justify-content-end" style="margin-top: 0px; float: right;">
                            <button class="btn btn-success"><i class="menu-icon fa fa-plus"></i> Thêm  </button>
                            <a href="/dot-khuyen-mai/hien-thi" class="btn btn-secondary" style="margin-left: 10px;" > <i class="menu-icon fa fa-undo"></i> Quay lại</a>
                        </div>
                </div>

            </div>

<%--            <div class="card col-lg-6" style="margin-left: 10px;">--%>
<%--                <div class="card-header">--%>

<%--                    <div>--%>
<%--                        <strong class="card-title" ><h3>Danh sách sản phẩm</h3></strong>--%>
<%--                    </div>--%>
<%--                    <div style="margin-top: 20px;">--%>
<%--                        <form action="/dot-khuyen-mai/view-them" method="get" >--%>
<%--                            <div class="row d-flex" style=" margin-left: 3px;">--%>
<%--                                <input  class="form-control col-lg-12" id="textsearch" name="textsearch" type="text" placeholder="Nhập tên sản phẩm, danh mục tìm kiếm" >--%>
<%--                                <span style="margin: 0px 5px;"></span>--%>
<%--&lt;%&ndash;                                <button class="btn btn-secondary" type="submit" > <i class="menu-icon fa fa-search"></i> Tìm kiếm</button>&ndash;%&gt;--%>
<%--                            </div>--%>
<%--                        </form>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="card-body">--%>
<%--                    <div class="table-responsive">--%>
<%--                        <form action="/san-pham/xoaTheoLuaChon" method="get">--%>
<%--                            <table class="table table-bordered table-hover no-wrap">--%>
<%--                                <thead>--%>
<%--                                <tr style="text-align: center;">--%>
<%--                                    &lt;%&ndash;                                    <th scope="col">Lựa chọn</th>&ndash;%&gt;--%>

<%--                                    <th scope="col"></th>--%>
<%--                                    <th scope="col">ID</th>--%>
<%--                                    <th scope="col">Tên</th>--%>
<%--                                    <th scope="col">Danh mục</th>--%>
<%--                                    <th scope="col">Thương hiệu</th>--%>
<%--                                </tr>--%>
<%--                                </thead>--%>
<%--                                <tbody>--%>
<%--                                <c:forEach items="${dsSanPham}" var="sanPhamCT" varStatus="sanpham">--%>
<%--                                    <tr>--%>
<%--                                        <th scope="row"><input type="checkbox" name="luaChon" class="form-control" style="width: 20px; height: 20px;"  /></th>--%>
<%--&lt;%&ndash;                                        <c:if test="${1==1}">checked</c:if>&ndash;%&gt;--%>
<%--                                        <th scope="row">${sanpham.index +1}</th>--%>
<%--                                        <td > ${sanPhamCT.sanPham.ten}</td>--%>
<%--                                        <td > ${sanPhamCT.danhMuc.ten}</td>--%>
<%--                                        <td > ${sanPhamCT.thuongHieu.ten}</td>--%>
<%--                                      </tr>--%>
<%--                                </c:forEach>--%>
<%--                                </tbody>--%>

<%--                            </table>--%>
<%--                            <div class="row" style="margin-top: 20px;">--%>
<%--                                <div class="col-lg-4">--%>
<%--                                </div>--%>
<%--                                <div class="col-lg-8"  style="text-align: center;">--%>
<%--                                    <nav aria-label="...">--%>
<%--                                        <c:if test="${totalPage>0}">--%>
<%--                                            <ul class="pagination justify-content-end">--%>
<%--                                                <c:if test="${pageChoosedNumber > 0}">--%>
<%--                                                    <li class="page-item">--%>
<%--                                                        <a class="page-link" href="/dot-khuyen-mai/view-them?page=${pageChoosedNumber-1}" tabindex="-1" aria-disabled="true">Previous</a>--%>
<%--                                                    </li>--%>
<%--                                                </c:if>--%>
<%--                                                <c:forEach begin="0" end="${totalPage - 1}" varStatus="loop">--%>
<%--                                                    <c:choose>--%>
<%--                                                        <c:when test="${pageChoosedNumber==loop.index}">--%>
<%--                                                            <li class="page-item active" aria-current="page" >--%>
<%--                                                                <a name="page" class="page-link"   href="/dot-khuyen-mai/view-them?page=${loop.index}">${loop.index + 1}</a>--%>
<%--                                                            </li>--%>
<%--                                                        </c:when>--%>
<%--                                                        <c:otherwise>--%>
<%--                                                            <li class="page-item" aria-current="page">--%>
<%--                                                                <a name="page" class="page-link" href="/dot-khuyen-mai/view-them?page=${loop.index}">${loop.index + 1}</a>--%>
<%--                                                            </li>--%>
<%--                                                        </c:otherwise>--%>
<%--                                                    </c:choose>--%>
<%--                                                </c:forEach>--%>
<%--                                                <c:if test="${pageChoosedNumber < (totalPage - 1)}">--%>
<%--                                                    <li class="page-item">--%>
<%--                                                        <a class="page-link" href="/dot-khuyen-mai/view-them?page=${pageChoosedNumber+1}">Next</a>--%>
<%--                                                    </li>--%>
<%--                                                </c:if>--%>
<%--                                            </ul>--%>
<%--                                        </c:if>--%>
<%--                                    </nav>--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                        </form>--%>
<%--                    </div>--%>

<%--                </div>--%>

<%--                </sf:form>--%>
<%--            </div>--%>



        </div><!-- .animated -->
    </div><!-- .content -->

    <div class=" content" style="margin-top: -60px;">
        <div class= " d-flex animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div>
                        <strong class="card-title" ><h3>Chọn sản phẩm chi tiết áp dụng khuyến mãi</h3></strong>
                    </div>
                    <div style="margin-top: 20px;">
                        <form action="#" method="get" >
                            <div class="row d-flex" style=" margin-left: 3px;">
                                <div class="col-lg-3">
                                    <span>Tên sản phẩm</span>
                                    <input  class="form-control" id="tenSanPhamSearch" name="" type="text" placeholder="Tìm theo tên" >
                                    <span style="margin: 0px 5px;"></span>
                                </div>
                                <div class="col-lg-3">
                                    <span>Kích cỡ</span>
                                    <select name="" id="" class="form-control">
                                        <option value="">Chọn kích cỡ ...</option>
                                        <option value="">34</option>
                                        <option value="">35</option>
                                    </select>
<%--                                    <sf:select path="chucVu.id" name="IdChucVu" class="form-control" >--%>

<%--                                        <c:forEach items="${dsChucVu}" var="chucVu" varStatus="chucvu">--%>
<%--                                            <option <c:if test="${nhanVien.chucVu.id == chucVu.id}">selected="selected"</c:if>   value="${chucVu.id}" >${chucVu.ten}</option>--%>
<%--                                        </c:forEach>--%>
<%--                                    </sf:select>--%>
                                    <span style="margin: 0px 5px;"></span>
                                </div>
                                <div class="col-lg-3">
                                    <span>Màu sắc</span>
                                    <select name="" id="" class="form-control">
                                        <option value="">Chọn màu sắc ...</option>
                                        <option value="">Đen</option>
                                        <option value="">Đỏ</option>
                                    </select>
                                    <span style="margin: 0px 5px;"></span>

                                </div>
                                <div class="col-lg-3" style="margin-top: 24px;">
                                    <button class="btn btn-secondary" type="submit"><i class="menu-icon fa fa-search"></i> Tìm kiếm</button>
                                </div>
                                <%--                                <button class="btn btn-secondary" type="submit" > <i class="menu-icon fa fa-search"></i> Tìm kiếm</button>--%>
                            </div>
                        </form>
                    </div>

                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <form action="/san-pham/xoaTheoLuaChon" method="get">
                            <table class="table table-bordered table-hover no-wrap">
                                <thead>
                                <tr style="text-align: center;">
                                    <%--                                    <th scope="col">Lựa chọn</th>--%>
                                    <th scope="col"></th>
                                    <th scope="col">STT</th>
                                    <th scope="col">Hình ảnh</th>
                                    <th scope="col">Tên sản phẩm</th>
                                        <th scope="col">Danh mục</th>
                                        <th scope="col">Thương hiệu</th>
                                    <th scope="col">Số lượng</th>
                                    <th scope="col">Đơn giá</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${dsSanPham}" var="sanPhamCT" varStatus="sanpham">
                                    <tr>
                                        <th scope="row">
                                            <input type="checkbox" name="luaChonDotKhuyenMai" class="form-control" style="width: 20px; height: 20px;" value="${sanPhamCT.sanPham.ma}" />
                                        </th>

                                        <th scope="row">${sanpham.index +1}</th>
                                        <td ><img src="/admin/images/DM7590-102-1_900x.jpg" alt="" style="width: 70px;height: 70px;"></td>
                                        <td > ${sanPhamCT.sanPham.ten} (${sanPhamCT.kichCo.ten} - ${sanPhamCT.mauSac.ten})</td>
                                        <td > ${sanPhamCT.danhMuc.ten}</td>
                                        <td > ${sanPhamCT.thuongHieu.ten}</td>
                                        <td > ${sanPhamCT.soLuong}</td>
                                        <td >
                                            <fmt:formatNumber type = "number"
                                                              maxFractionDigits = "3" value = "${sanPhamCT.giaTriSanPham}" />
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                            <div class="row" style="margin-top: 20px;">
                                <div class="col-lg-4">
                                </div>
                                <div class="col-lg-8"  style="text-align: center;">
                                    <nav aria-label="...">
                                        <c:if test="${totalPage>0}">
                                            <ul class="pagination justify-content-end">
                                                <c:if test="${pageChoosedNumber > 0}">
                                                    <li class="page-item">
                                                        <a class="page-link" href="/dot-khuyen-mai/view-them?page=${pageChoosedNumber-1}" tabindex="-1" aria-disabled="true">Previous</a>
                                                    </li>
                                                </c:if>
                                                <c:forEach begin="0" end="${totalPage - 1}" varStatus="loop">
                                                    <c:choose>
                                                        <c:when test="${pageChoosedNumber==loop.index}">
                                                            <li class="page-item active" aria-current="page" >
                                                                <a name="page" class="page-link"   href="/dot-khuyen-mai/view-them?page=${loop.index}">${loop.index + 1}</a>
                                                            </li>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <li class="page-item" aria-current="page">
                                                                <a name="page" class="page-link" href="/dot-khuyen-mai/view-them?page=${loop.index}">${loop.index + 1}</a>
                                                            </li>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                                <c:if test="${pageChoosedNumber < (totalPage - 1)}">
                                                    <li class="page-item">
                                                        <a class="page-link" href="/dot-khuyen-mai/view-them?page=${pageChoosedNumber+1}">Next</a>
                                                    </li>
                                                </c:if>
                                            </ul>
                                        </c:if>
                                    </nav>
                                </div>
                            </div>

                        </form>
                    </div>

                </div>

            </div>


            </sf:form>
        </div><!-- .animated -->
    </div><!-- .content -->


    <div class="clearfix"></div>

    <!-- footer -->
    <jsp:include page="/WEB-INF/view/admin/layout/footer.jsp"></jsp:include>
    <!--/ footer -->

</div><!-- /#right-panel -->

<!-- Right Panel -->

<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
<script src="/admin/assets/js/main.js"></script>

<script>
    // Sử dụng JavaScript để đặt giá trị của trường ngày thành ngày hôm nay
    document.getElementById('dateToday').valueAsDate = new Date();

</script>
</body>
</html>
