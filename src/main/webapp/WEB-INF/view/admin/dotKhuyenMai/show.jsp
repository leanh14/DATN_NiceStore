<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý đợt khuyến mãi </title>
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
                                <li><a href="#">Quản lý đợt giảm giá</a></li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="content" style="margin-top: 5px;">
        <div class="animated fadeIn">
            <div class="card col-lg-12">
                <div class="card-header">
                    <div class="row">
                        <div class="col-lg-10">
                            <strong class="card-title" ><h3>Danh sách đợt giảm giá </h3></strong>
                        </div>
                        <div class="col-lg-2">
                            <a href="/dot-khuyen-mai/view-them" class="btn btn-primary"> <i class="menu-icon fa fa-plus"></i> Thêm mới </a>
                        </div>
                    </div>
                    <br>
                    <form action="/dot-khuyen-mai/hien-thi" method="get">
                        <div class="row d-flex" style=" margin-left: 3px;">
                            <div class="col-lg-3">
                                <p>Tìm kiếm</p>
                                <input  class="form-control " id="textsearch" name="textsearch" type="text" placeholder="Tìm theo tên hoặc mã" >
                                <span style="margin: 0px 5px;"></span>
                            </div>
                            <div class="col-lg-7">
                                <p>Trạng thái</p>
                                <div class="d-flex">
                                    <input type="radio" name="trangThai" value="0" style="height: 20px; width: 20px;" class="form-control " checked> <span style="margin-left: 5px; margin-right:15px;" >Tất cả</span>
                                    <input type="radio" name="trangThai" value="1" style="height: 20px; width: 20px;" class="form-control"> <span style="margin-left: 5px; margin-right:15px;">Sắp diễn ra</span>
                                    <input type="radio" name="trangThai" value="2" style="height: 20px; width: 20px;" class="form-control"> <span style="margin-left: 5px; margin-right:15px;">Đang diễn ra</span>
                                    <input type="radio" name="trangThai" value="3" style="height: 20px; width: 20px;" class="form-control"> <span style="margin-left: 5px; margin-right:15px;">Đã kết thúc</span>

                                </div>

                            </div>
                            <div class="col-lg-2" style="margin-top: 30px;margin-left: -100px;">
                                <button class="btn btn-secondary" type="submit" > <i class="menu-icon fa fa-search"></i> Tìm kiếm</button>

                            </div>
                        </div>
                    </form>

                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover no-wrap">
                            <thead>
                            <tr style="text-align: center;">
                                <th scope="col">ID</th>
                                <th scope="col">Mã</th>
                                <th scope="col">Tên khuyến mãi</th>
                                <th scope="col">Giá trị giảm</th>
                                <th scope="col">Ngày bắt đầu</th>
                                <th scope="col">Ngày kết thúc</th>
                                <th scope="col">Trạng thái</th>
                                <th scope="col" colspan="2" >Tác động</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${dsDotKhuyenMai}" var="dotKhuyenMai" varStatus="loop">
                                <tr>
                                    <th scope="row">${loop.index +1}</th>
                                    <td > ${dotKhuyenMai.ma}</td>
                                    <td > ${dotKhuyenMai.tenDotKhuyenMai}</td>
                                    <td > <fmt:formatNumber type = "number"
                                                            maxFractionDigits = "0" value = "${dotKhuyenMai.giaTriGiam}" />
                                    </td>
                                    <td > <fmt:formatDate value="${dotKhuyenMai.ngayBatDau}" pattern="dd-MM-yyyy"/> </td>
                                    <td > <fmt:formatDate value="${dotKhuyenMai.ngayKetThuc}" pattern="dd-MM-yyyy"/> </td>
                                    <td > ${dotKhuyenMai.trangThai == 1 ? 'Hoạt động': 'Ngưng hoạt động'}</td>
                                    <td > <a href="/dot-khuyen-mai/view-sua/${dotKhuyenMai.id}" class="btn btn-success">Xem <i class="menu-icon fa fa-pencil-square-o"></i> </a> </td>
                                    <td > <a href="/dot-khuyen-mai/xoa/${dotKhuyenMai.id}" class="btn btn-warning"
                                             onclick="return confirm('Bạn chắc chắn muốn xóa đợt khuyến mãi : ${dotKhuyenMai.tenDotKhuyenMai} ?')"> <i class="menu-icon fa fa-trash-o"></i> Xóa</a> </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div class="row" style="margin-top: 20px;">
                        <div class="col-lg-4">
                        </div>
                        <div class="col-lg-8"  style="text-align: center;">
                            <nav aria-label="...">
                                <c:if test="${totalPage>0}">
                                    <ul class="pagination justify-content-end">
                                        <li class="page-item">
                                            <a class="page-link" href="/dot-khuyen-mai/hien-thi?page=0" tabindex="-1" aria-disabled="true">Previous</a>
                                        </li>
                                        <c:forEach begin="0" end="${totalPage - 1}" varStatus="loop">
                                            <c:choose>
                                                <c:when test="${pageChoosedNumber==loop.index}">
                                                    <li class="page-item active" aria-current="page" >
                                                        <a name="page" class="page-link"   href="/dot-khuyen-mai/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                    </li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item" aria-current="page">
                                                        <a name="page" class="page-link" href="/dot-khuyen-mai/hien-thi?page=${loop.index}">${loop.index + 1}</a>
                                                    </li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li class="page-item">
                                            <a class="page-link" href="/dot-khuyen-mai/hien-thi?page=${totalPage-1}">Next</a>
                                        </li>
                                    </ul>
                                </c:if>
                            </nav>
                        </div>
                    </div>


                </div>
            </div>
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

    // function validation
    function myValidationFormBeforeAdd(){
        let sizeGiay = document.getElementById("sizeGiay").value;
        let ma = document.getElementById("maMuiGiay").value;
        let moTa = document.getElementById("moTa").value;
        let check=true;

        // kiem tra ma
        if(ma===null || ma.trim()===""){
            document.getElementById("messagemaKichThuoc").innerHTML = "Vui lòng nhập mã";
            return  false;
        }else{
            document.getElementById("messagemaKichThuoc").innerHTML = "";
        }


        // kiem tra size giay - rong, null, ko phai so, trung du lieu
        if(isNaN(sizeGiay) || sizeGiay===null || sizeGiay.trim()===""){
            document.getElementById("messageSizeGiay").innerHTML = "Vui lòng nhập size giày dạng số và không để trống";
            return  false;
        }else if(sizeGiay< 34 || sizeGiay>50){
            document.getElementById("messageSizeGiay").innerHTML = "Vui lòng nhập size giày >=34 hoặc <=50";
            return  false;
        }else{
            document.getElementById("messageSizeGiay").innerHTML = "";
        }

        // ko nhất thiết nhưng cứ check
        // kiem tra mo ta - check trong
        // if(moTa.trim().length===0){
        //     document.getElementById("messageMoTa").innerHTML = "Vui lòng nhập mô tả";
        //     return  false;
        // }else if(moTa.trim().length>50 || moTa.trim().length<15){
        //     document.getElementById("messageMoTa").innerHTML = "Vui lòng nhập ít nhất 10 ký tự, nhiều nhất 50 ký tự";
        //     return  false;
        // }

        alert("Dữ liệu bạn nhập hợp lệ, sẽ được thêm vào csdl");

        return check;
    }

    <%--function myValidationFormBeforeAdd() {--%>
    <%--    console.log("Chạy vào function validation kiểm tra");--%>
    <%--    let sizeGiay = document.getElementById("sizeGiay").value;--%>
    <%--    &lt;%&ndash;let dsKichThuoc = ${kichThuocValidation};&ndash;%&gt;--%>
    <%--    &lt;%&ndash;let dsKichThuoc = <%= new org.json.JSONArray(kichThuocValidation) %>;&ndash;%&gt;--%>
    <%--    let moTa = document.getElementById("moTa").value;--%>
    <%--    let check=true;--%>

    <%--    // kiem tra sizeGiay co trung dữ liệu đã có trong database hay không ? phía server side--%>

    <%--    // kiem tra size giay - rong, null, ko phai so, trung du lieu--%>
    <%--    if(isNaN(sizeGiay) || sizeGiay===null || sizeGiay.trim()===""){--%>
    <%--        document.getElementById("messageSizeGiay").innerHTML = "Vui lòng nhập size giày dạng số và không để trống";--%>
    <%--        return  false;--%>
    <%--    }--%>
    <%--    if(sizeGiay< 34 || sizeGiay>50){--%>
    <%--        document.getElementById("messageSizeGiay").innerHTML = "Vui lòng nhập size giày >=34 hoặc <=50";--%>
    <%--        return  false;--%>
    <%--    }--%>

    <%--    // for(var i=0; i< dsKichThuoc.length; i++){--%>
    <%--    //     if(sizeGiay === dsKichThuoc[i].ten){--%>
    <%--    //         document.getElementById("messageSizeGiay").innerHTML = "Size giày này đã tồn tại, vui lòng nhập size giày khác";--%>
    <%--    //         return false;--%>
    <%--    //     }--%>
    <%--    // }--%>

    <%--    document.getElementById("messageSizeGiay").innerHTML = "";--%>

    <%--    // kiem tra mo ta - check trong--%>
    <%--    // if(moTa.trim().length===0){--%>
    <%--    //     document.getElementById("messageMoTa").innerHTML = "Vui lòng nhập mô tả";--%>
    <%--    //     return  false;--%>
    <%--    // }else if(moTa.trim().length>50 || moTa.trim().length<15){--%>
    <%--    //     document.getElementById("messageMoTa").innerHTML = "Vui lòng nhập ít nhất 10 ký tự, nhiều nhất 50 ký tự";--%>
    <%--    //     return  false;--%>
    <%--    // }else{--%>
    <%--    //     document.getElementById("messageMoTa").innerHTML = "";--%>
    <%--    // }--%>

    <%--    console.log("Không có lỗi gì ");--%>
    <%--    return check;--%>
    <%--};--%>


</script>

</body>
</html>
