<%@ page import="com.example.duantn.Request.SanPhamTrongGioHang" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>


<!DOCTYPE html>
<html lang="en">


<!-- molla/cart.html  22 Nov 2019 09:55:06 GMT -->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Giỏ hàng</title>
    <meta name="keywords" content="HTML5 Template">
    <meta name="description" content="Molla - Bootstrap eCommerce Template">
    <meta name="author" content="p-themes">
    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="/user/assets/images/icons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/user/assets/images/icons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/user/assets/images/icons/favicon-16x16.png">
    <link rel="manifest" href="/user/assets/images/icons/site.html">
    <link rel="mask-icon" href="/user/assets/images/icons/safari-pinned-tab.svg" color="#666666">
    <link rel="shortcut icon" href="/user/assets/images/icons/favicon.ico">
    <meta name="apple-mobile-web-app-title" content="Molla">
    <meta name="application-name" content="Molla">
    <meta name="msapplication-TileColor" content="#cc9966">
    <meta name="msapplication-config" content="/user/assets/images/icons/browserconfig.xml">
    <meta name="theme-color" content="#ffffff">
    <!-- Plugins CSS File -->
    <link rel="stylesheet" href="/user/assets/css/bootstrap.min.css">
    <!-- Main CSS File -->
    <link rel="stylesheet" href="/user/assets/css/style.css">
</head>

<body>


<div class="page-wrapper">
    <header class="header">
        <div class="header-top">
            <div class="container">
                <div class="header-left">

                </div><!-- End .header-left -->

                <div class="header-right">
                    <ul class="top-menu">
                        <li>
                            <a href="#">Links</a>
                            <ul>
                                <li><a href="tel:#"><i class="icon-phone"></i>Gọi điện: +0123 456 789</a></li>
                                <li><a href="about.html">Về chúng tôi</a></li>
                                <li><a href="#signin-modal" data-toggle="modal"><i class="icon-user"></i>Login</a></li>
                            </ul>
                        </li>
                    </ul><!-- End .top-menu -->
                </div><!-- End .header-right -->
            </div><!-- End .container -->
        </div><!-- End .header-top -->

        <div class="header-middle sticky-header">
            <div class="container">
                <div class="header-left">
                    <button class="mobile-menu-toggler">
                        <span class="sr-only">Toggle mobile menu</span>
                        <i class="icon-bars"></i>
                    </button>

                    <a href="index.html" class="logo">
                        <img src="/user/assets/images/logo-black.png" alt="Molla Logo" width="100" height="25" >
                    </a>

                    <nav class="main-nav">
                        <ul class="menu sf-arrows">
                            <li class="megamenu-container active">
                                <a href="/gio-hang/view-trangChu" >Home</a>
                            </li>
                            <li>
                                <a href="product.html" class="sf-with-ul">Product</a>

                                <div class="megamenu megamenu-sm">
                                    <div class="row no-gutters">
                                        <div class="col-md-6">
                                            <div class="menu-col">
                                                <div class="menu-title">Product Details</div><!-- End .menu-title -->
                                                <ul>
                                                    <li><a href="product.html">Giày bán chạy</a></li>
                                                    <li><a href="product-centered.html">Giày nữ</a></li>
                                                    <li><a href="product-extended.html"><span>Giày nam<span class="tip tip-new">New</span></span></a></li>
                                                    <li><a href="product-gallery.html">Giày unisex</a></li>
                                                </ul>
                                            </div><!-- End .menu-col -->
                                        </div><!-- End .col-md-6 -->

                                        <div class="col-md-6">
                                            <div class="banner banner-overlay">
                                                <a href="category.html">
                                                    <img src="/user/assets/images/shoe_running_1.png" alt="Banner">

                                                    <div class="banner-content banner-content-bottom">
                                                        <div class="banner-title text-white">New Trends<br><span><strong>spring 2024</strong></span></div><!-- End .banner-title -->
                                                    </div><!-- End .banner-content -->
                                                </a>
                                            </div><!-- End .banner -->
                                        </div><!-- End .col-md-6 -->
                                    </div><!-- End .row -->
                                </div><!-- End .megamenu megamenu-sm -->
                            </li>
                            <li>
                                <a href="#" class="sf-with-ul">Pages</a>

                                <ul>
                                    <li>
                                        <a href="about.html" class="sf-with-ul">About</a>

                                        <ul>
                                            <li><a href="about.html">About 01</a></li>
                                            <li><a href="about-2.html">About 02</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="contact.html" class="sf-with-ul">Contact</a>

                                        <ul>
                                            <li><a href="contact.html">Contact 01</a></li>
                                            <li><a href="contact-2.html">Contact 02</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="login.html">Login</a></li>
                                </ul>
                            </li>

                        </ul><!-- End .menu -->
                    </nav><!-- End .main-nav -->
                </div><!-- End .header-left -->

                <div class="header-right">
                    <div class="header-search">
                        <a href="#" class="search-toggle" role="button" title="Tìm kiếm"><i class="icon-search"></i></a>
                        <form action="#" method="get">
                            <div class="header-search-wrapper">
                                <label for="q" class="sr-only">Search</label>
                                <input type="search" class="form-control" name="q" id="q" placeholder="Nhập nội dung tìm kiếm..." required>
                            </div><!-- End .header-search-wrapper -->
                        </form>
                    </div><!-- End .header-search -->
                    <div class="dropdown compare-dropdown">
                        <a href="#" class="dropdown-toggle" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-display="static" title="Đăng nhập" aria-label="Đăng nhập">
                            <i class="icon-user" ></i>
                        </a>

                        <!-- <div class="dropdown-menu dropdown-menu-right">

                            <div class="compare-actions">
                                <a href="#" class="btn btn-outline-primary-2"><span>Đăng nhập</span><i class="icon-long-arrow-right"></i></a>
                            </div>
                        </div> -->
                        <!-- End .dropdown-menu -->

                    </div>
                    <!-- </div> End .compare-dropdown -->

                    <div class="dropdown cart-dropdown">
                        <a href="#" class="dropdown-toggle" title="Xem giỏ hàng" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-display="static">
                            <i class="icon-shopping-cart"></i>
                            <span class="cart-count">
                                ${totalCartProducts>0?totalCartProducts:0}
                            </span>
                        </a>

                        <div class="dropdown-menu dropdown-menu-right">
                            <div class="dropdown-cart-products">
                                    <div class="product">
                                    <div class="product-cart-details">
                                        <h4 class="product-title">
                                            <a href="product.html">Beige knitted elastic runner shoes</a>
                                        </h4>

                                        <span class="cart-product-info">
                                                <span class="cart-product-qty">1</span>
                                                x $84.00
                                            </span>
                                    </div><!-- End .product-cart-details -->

                                    <figure class="product-image-container">
                                        <a href="product.html" class="product-image">
                                            <img src="/user/assets/images/products/cart/product-1.jpg" alt="product">
                                        </a>
                                    </figure>
                                    <a href="#" class="btn-remove" title="Remove Product"><i class="icon-close"></i></a>
                                </div><!-- End .product -->
                                <div class="product">
                                    <div class="product-cart-details">
                                        <h4 class="product-title">
                                            <a href="product.html">Blue utility pinafore denim dress</a>
                                        </h4>

                                        <span class="cart-product-info">
                                                <span class="cart-product-qty">1</span>
                                                x $76.00
                                            </span>
                                    </div><!-- End .product-cart-details -->

                                    <figure class="product-image-container">
                                        <a href="product.html" class="product-image">
                                            <img src="/user/assets/images/products/cart/product-2.jpg" alt="product">
                                        </a>
                                    </figure>
                                    <a href="#" class="btn-remove" title="Remove Product"><i class="icon-close"></i></a>
                                </div><!-- End .product -->


                            </div><!-- End .cart-product -->

                            <div class="dropdown-cart-total">
                                <span>Total</span>

                                <span class="cart-total-price">$160.00</span>
                            </div><!-- End .dropdown-cart-total -->

                            <div class="dropdown-cart-action">
                                <a href="cart.html" class="btn btn-primary">View Cart</a>
                                <a href="checkout.html" class="btn btn-outline-primary-2"><span>Checkout</span><i class="icon-long-arrow-right"></i></a>
                            </div><!-- End .dropdown-cart-total -->
                        </div><!-- End .dropdown-menu -->
                    </div><!-- End .cart-dropdown -->
                </div><!-- End .header-right -->
            </div><!-- End .container -->
        </div><!-- End .header-middle -->
    </header><!-- End .header -->

    <main class="main">
        <div class="page-header text-center" style="background-image: url('/user/assets/images/page-header-bg.jpg')">
            <div class="container">
                <h1 class="page-title">Giỏ hàng <span>của bạn</span></h1>
            </div><!-- End .container -->
        </div><!-- End .page-header -->
        <nav aria-label="breadcrumb" class="breadcrumb-nav">
            <div class="container">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Giỏ hàng</li>
                </ol>
            </div><!-- End .container -->
        </nav><!-- End .breadcrumb-nav -->

        <div class="page-content">
            <div class="cart">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-9">

                                    <table class="table table-cart table-mobile">
                                        <thead>
                                        <tr>
                                            <th>Chọn mua</th>
                                            <th>Sản phẩm</th>
                                            <th>Size giày</th>
                                            <th >Màu sắc</th>
                                            <th>Giá bán</th>
                                            <th>Số lượng</th>
                                            <th>Tổng tiền</th>
                                            <th></th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                                <c:forEach items="${sanPhamTrongGio}" var="sanPhamTrongGio">

                                                <tr>
                                                        <td>
                                                            <input type="checkbox" id="${sanPhamTrongGio.idSanPhamCT}" onchange="kiemTraDuocChonKhong('${sanPhamTrongGio.idSanPhamCT}','${sanPhamTrongGio.soLuong}');" ${sanPhamTrongGio.numberCheck==1?'checked':''}  value="${sanPhamTrongGio.idSanPhamCT}" class="form-control" style="height: 25px; width: 25px;">

                                                        </td>
                                                        <td class="product-col">
                                                            <div class="product">
                                                                <figure class="product-media">
                                                                    <a href="#">
                                                                        <img src="${sanPhamTrongGio.hinhAnh}" alt="Product image">
                                                                    </a>
                                                                </figure>

                                                                <h3 class="product-title">
                                                                    <a href="#">
                                                                        ${sanPhamTrongGio.sanPham.ten}
                                                                    </a>
                                                                </h3><!-- End .product-title -->
                                                            </div><!-- End .product -->
                                                        </td>
                                                        <td class="price-col">
                                                            ${sanPhamTrongGio.kichCo.ten}
                                                        </td>
                                                        <td class="price-col" >
                                                            ${sanPhamTrongGio.mauSac.ten}
                                                        </td>
                                                        <td class="price-col">
                                                            <fmt:formatNumber type = "number"
                                                                              maxFractionDigits = "0" value = "${sanPhamTrongGio.getGia()}" />
                                                               </td>
                                                        <td class="quantity-col">
                                                            <div class="cart-product-quantity">
                                                                <input type="number"  value="${sanPhamTrongGio.soLuong}" min="0" step="1"
                                                                       onchange="changeNumberProduct('${sanPhamTrongGio.idSanPhamCT}',this.value)" />

                                                            </div>
                                                        </td>

                                                        <td class=" total-col " >
                                                            <fmt:formatNumber  type = "number"
                                                                              maxFractionDigits = "0" value="${sanPhamTrongGio.soLuong*sanPhamTrongGio.gia}" />

                                                        </td>
                                                        <td class="remove-col">
                                                            <a href="/gio-hang/xoa/${sanPhamTrongGio.idSanPhamCT}" onclick="return confirm('Bạn chắc chắn muốn xóa sản phẩm này khỏi giỏ hàng ?') ? true : false;"
                                                               class="btn-remove"><i class="icon-close"></i> </a></td>

                                                    </tr>
                                                </c:forEach>

                                        </tbody>
                                     </table><!-- End .table table-wishlist -->



                            <div class="  cart-bottom">
                                    <h5>Tổng tiền tất cả sản phẩm: </h5>
                                    <h4 id="totalPriceInCart" style="font-size: large; color: black; margin-left: 10px;"><fmt:formatNumber type = "number" maxFractionDigits = "0" value = "${totalPriceResult}" /></h4> <h5 style="margin-left: 10px;">VNĐ</h5>

                            </div><!-- End .cart-bottom -->
                        </div><!-- End .col-lg-9 -->
                        <aside class="col-lg-3">
                            <div class="summary summary-cart">
                                <h3 class="summary-title">Đơn hàng</h3><!-- End .summary-title -->

                                <div class="cart-discount">
                                    <form action="#">
                                        <div class="input-group">
                                            <input type="text" class="form-control" required placeholder="Nhập mã giảm giá">
                                            <div class="input-group-append">
                                                <button class="btn btn-outline-primary-2" type="submit"><i class="icon-long-arrow-right"></i></button>
                                            </div><!-- .End .input-group-append -->
                                        </div><!-- End .input-group -->
                                    </form>
                                </div><!-- End .cart-discount -->

                                <table class="table table-summary">
                                    <tbody>
                                    <tr class="summary-subtotal">
                                        <td>Tổng giá trị đơn hàng</td>
                                        <td id="totalPriceInCartThanhToan" >
                                            <fmt:formatNumber type = "number"
                                                              maxFractionDigits = "0" value = "${totalPriceCartThanhToan>0?totalPriceCartThanhToan:0}" />

                                        </td>
                                    </tr><!-- End .summary-subtotal -->
                                    <tr class="summary-subtotal">
                                        <td>Tiền được giảm</td>
                                        <td>0</td>
                                    </tr><!-- End .summary-subtotal -->


                                    <tr class="summary-total">
                                        <td>Tiền cần thanh toán:</td>
                                        <td>
                                            <fmt:formatNumber type = "number"
                                                              maxFractionDigits = "0" value = "${totalPriceCartThanhToan>0?totalPriceCartThanhToan:0}" />

                                        </td>
                                    </tr><!-- End .summary-total -->
                                    </tbody>
                                </table><!-- End .table table-summary -->

                                <a href="/gio-hang/view-thanhToan" class="btn btn-outline-primary-2 btn-order btn-block">Thanh toán</a>
                            </div><!-- End .summary -->

                            <a href="category.html" class="btn btn-outline-dark-2 btn-block mb-3"><span>Tiếp tục mua sắm</span><i class="icon-refresh"></i></a>
                        </aside><!-- End .col-lg-3 -->
                    </div><!-- End .row -->
                </div><!-- End .container -->
            </div><!-- End .cart -->
        </div><!-- End .page-content -->
    </main><!-- End .main -->

    <footer class="footer">
        <div class="footer-middle">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-lg-4 " style="justify-content: center;">
                        <div class="widget widget-about">
                            <img src="/user/assets/images/logo-black.png" class="footer-logo" alt="Footer Logo" width="105" height="25" style="margin-left: 45px;">
                            <p>
                                Chúng tôi mong rằng bạn sẽ có trải nghiệm mua hàng tiện lợi, tiết kiệm thời gian. Chúc bạn mua sắm vui vẻ ^^
                            </p>
                            <div class="social-icons">
                                <a href="#" class="social-icon" target="_blank" title="Facebook"><i class="icon-facebook-f"></i></a>
                                <a href="#" class="social-icon" target="_blank" title="Twitter"><i class="icon-twitter"></i></a>
                                <a href="#" class="social-icon" target="_blank" title="Instagram"><i class="icon-instagram"></i></a>
                                <a href="#" class="social-icon" target="_blank" title="Youtube"><i class="icon-youtube"></i></a>
                                <a href="#" class="social-icon" target="_blank" title="Pinterest"><i class="icon-pinterest"></i></a>
                            </div><!-- End .soial-icons -->
                        </div><!-- End .widget about-widget -->
                    </div><!-- End .col-sm-6 col-lg-3 -->

                    <div class="col-sm-6 col-lg-3">
                        <div class="widget">
                            <h4 class="widget-title">Dịch vụ khách hàng</h4><!-- End .widget-title -->

                            <ul class="widget-list">
                                <li><a href="#">Phương thức thanh tóa</a></li>
                                <li><a href="#">Đổi trả</a></li>
                                <li><a href="#">Ship đơn hàng</a></li>
                                <li><a href="#">Chính sách</a></li>
                            </ul><!-- End .widget-list -->
                        </div><!-- End .widget -->
                    </div><!-- End .col-sm-6 col-lg-3 -->

                    <div class="col-sm-6 col-lg-3">
                        <div class="widget">
                            <h4 class="widget-title">Tài khoản</h4><!-- End .widget-title -->

                            <ul class="widget-list">
                                <li><a href="#">Đăng nhập</a></li>
                                <li><a href="cart.html">Xem giỏ hàng</a></li>
                                <li><a href="#">Giúp đỡ</a></li>
                            </ul><!-- End .widget-list -->
                        </div><!-- End .widget -->

                    </div><!-- End .col-sm-6 col-lg-3 -->

                    <div class="col-sm-6 col-lg-3" style="margin-left: -100px;">
                        <div class="widget">
                            <h4 class="widget-title">Chúng tôi</h4><!-- End .widget-title -->

                            <ul class="widget-list">
                                <li><a href="about.html">Về cửa hàng NiceSport</a></li>
                            </ul><!-- End .widget-list -->
                        </div><!-- End .widget -->

                    </div><!-- End .col-sm-6 col-lg-3 -->
                </div><!-- End .row -->
            </div><!-- End .container -->
        </div><!-- End .footer-middle -->

        <div class="footer-bottom">
            <div class="container">
                <p class="footer-copyright">Edit © 2024 Nice Sport. Design by team SD-09.</p><!-- End .footer-copyright -->
                <figure class="footer-payments">
                    <img src="/user/assets/images/payments.png" alt="Payment methods" width="272" height="20">
                </figure><!-- End .footer-payments -->
            </div><!-- End .container -->
        </div><!-- End .footer-bottom -->
    </footer><!-- End .footer -->


</div><!-- End .page-wrapper -->
<button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>

<!-- Mobile Menu -->
<div class="mobile-menu-overlay"></div><!-- End .mobil-menu-overlay -->

<div class="mobile-menu-container">
    <div class="mobile-menu-wrapper">
        <span class="mobile-menu-close"><i class="icon-close"></i></span>

        <form action="#" method="get" class="mobile-search">
            <label for="mobile-search" class="sr-only">Search</label>
            <input type="search" class="form-control" name="mobile-search" id="mobile-search" placeholder="Search in..." required>
            <button class="btn btn-primary" type="submit"><i class="icon-search"></i></button>
        </form>

        <nav class="mobile-nav">
            <ul class="mobile-menu">
                <li class="active">
                    <a href="index.html">Home</a>

                </li>
                <li>
                    <a href="category.html">Shop</a>
                </li>
                <li>
                    <a href="product.html" class="sf-with-ul">Product</a>
                    <ul>
                        <li><a href="product.html">Tất cả sản phẩm</a></li>
                        <li><a href="product-centered.html">Giày nữ</a></li>
                        <li><a href="product-extended.html"><span>Giày nam<span class="tip tip-new">New</span></span></a></li>
                        <li><a href="product-gallery.html">Unisex</a></li>
                    </ul>
                </li>

            </ul>
        </nav><!-- End .mobile-nav -->

        <div class="social-icons">
            <a href="#" class="social-icon" target="_blank" title="Facebook"><i class="icon-facebook-f"></i></a>
            <a href="#" class="social-icon" target="_blank" title="Twitter"><i class="icon-twitter"></i></a>
            <a href="#" class="social-icon" target="_blank" title="Instagram"><i class="icon-instagram"></i></a>
            <a href="#" class="social-icon" target="_blank" title="Youtube"><i class="icon-youtube"></i></a>
        </div><!-- End .social-icons -->
    </div><!-- End .mobile-menu-wrapper -->
</div><!-- End .mobile-menu-container -->

<!-- Sign in / Register Modal -->
<div class="modal fade" id="signin-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="icon-close"></i></span>
                </button>

                <div class="form-box">
                    <div class="form-tab">
                        <ul class="nav nav-pills nav-fill" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="signin-tab" data-toggle="tab" href="#signin" role="tab" aria-controls="signin" aria-selected="true">Sign In</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="register-tab" data-toggle="tab" href="#register" role="tab" aria-controls="register" aria-selected="false">Register</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="tab-content-5">
                            <div class="tab-pane fade show active" id="signin" role="tabpanel" aria-labelledby="signin-tab">
                                <form action="#">
                                    <div class="form-group">
                                        <label for="singin-email">Username or email address *</label>
                                        <input type="text" class="form-control" id="singin-email" name="singin-email" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-group">
                                        <label for="singin-password">Password *</label>
                                        <input type="password" class="form-control" id="singin-password" name="singin-password" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-footer">
                                        <button type="submit" class="btn btn-outline-primary-2">
                                            <span>LOG IN</span>
                                            <i class="icon-long-arrow-right"></i>
                                        </button>

                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="signin-remember">
                                            <label class="custom-control-label" for="signin-remember">Remember Me</label>
                                        </div><!-- End .custom-checkbox -->

                                        <a href="#" class="forgot-link">Forgot Your Password?</a>
                                    </div><!-- End .form-footer -->
                                </form>
                                <div class="form-choice">
                                    <p class="text-center">or sign in with</p>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login btn-g">
                                                <i class="icon-google"></i>
                                                Login With Google
                                            </a>
                                        </div><!-- End .col-6 -->
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login btn-f">
                                                <i class="icon-facebook-f"></i>
                                                Login With Facebook
                                            </a>
                                        </div><!-- End .col-6 -->
                                    </div><!-- End .row -->
                                </div><!-- End .form-choice -->
                            </div><!-- .End .tab-pane -->
                            <div class="tab-pane fade" id="register" role="tabpanel" aria-labelledby="register-tab">
                                <form action="#">
                                    <div class="form-group">
                                        <label for="register-email">Your email address *</label>
                                        <input type="email" class="form-control" id="register-email" name="register-email" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-group">
                                        <label for="register-password">Password *</label>
                                        <input type="password" class="form-control" id="register-password" name="register-password" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-footer">
                                        <button type="submit" class="btn btn-outline-primary-2">
                                            <span>SIGN UP</span>
                                            <i class="icon-long-arrow-right"></i>
                                        </button>

                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="register-policy" required>
                                            <label class="custom-control-label" for="register-policy">I agree to the <a href="#">privacy policy</a> *</label>
                                        </div><!-- End .custom-checkbox -->
                                    </div><!-- End .form-footer -->
                                </form>
                                <div class="form-choice">
                                    <p class="text-center">or sign in with</p>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login btn-g">
                                                <i class="icon-google"></i>
                                                Login With Google
                                            </a>
                                        </div><!-- End .col-6 -->
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login  btn-f">
                                                <i class="icon-facebook-f"></i>
                                                Login With Facebook
                                            </a>
                                        </div><!-- End .col-6 -->
                                    </div><!-- End .row -->
                                </div><!-- End .form-choice -->
                            </div><!-- .End .tab-pane -->
                        </div><!-- End .tab-content -->
                    </div><!-- End .form-tab -->
                </div><!-- End .form-box -->
            </div><!-- End .modal-body -->
        </div><!-- End .modal-content -->
    </div><!-- End .modal-dialog -->
</div><!-- End .modal -->

<!-- Plugins JS File -->
<script src="/user/assets/js/jquery.min.js"></script>
<script src="/user/assets/js/bootstrap.bundle.min.js"></script>
<script src="/user/assets/js/jquery.hoverIntent.min.js"></script>
<script src="/user/assets/js/jquery.waypoints.min.js"></script>
<script src="/user/assets/js/superfish.min.js"></script>
<script src="/user/assets/js/owl.carousel.min.js"></script>
<script src="/user/assets/js/bootstrap-input-spinner.js"></script>
<!-- Main JS File -->
<script src="/user/assets/js/main.js"></script>

<script>

    // làm cách nào để lấy được xem sản phẩm đó có được tích hay không ?
    // nếu được tích - truyền number = +1 , lấy theo id, lấy theo giá sản phẩm, số lượng nữa
    // nếu ko được tích - truyền number = -1, để thực hiện + thêm hoặc xóa đi

    // Hàm để gửi dữ liệu về server để lưu vào session
    function changeNumberProduct(idSanPhamCT, soLuong) {
        // console.log("id sản phẩm:" + idSanPhamCT + "số lượng sản phẩm: " + soLuong);
        // /gio-hang/view-gio
        $.ajax({
            type: "POST",
            url: "/gio-hang/capNhatSoLuongSPCT", // Đường dẫn đến endpoint xử lý yêu cầu Ajax
            data: JSON.stringify({ idSanPhamCT: idSanPhamCT, soLuong: soLuong }),
            contentType: "application/json",
            success : function(jsonResult) {
                console.log('Xử lý xong cập nhật số lượng xử lý bên server');

                / alert(jsonResult.code + ": " + jsonResult.message); /
                let totalProducts = jsonResult.totalCartProducts;
                let totalPrice = jsonResult.totalPriceResult;

                $("#totalCartProductsId").html(totalProducts);
                $("#totalPriceInCart").html(totalPrice);
                // console.log("totalPriceInCart: " + totalPriceInCart);
                // console.log("totalPrice: " + totalPrice);

                window.location.href = "/gio-hang/view-gio";
                window.location.reload();
            },
            error: function(xhr, status, error) {
                // Xử lý lỗi nếu có
                console.error(xhr.responseText);
            }
        });
    }
</script>

<script type="text/javascript">
    // name of checkbox luaChonSanPhamMua

    kiemTraDuocChonKhong = function (idSanPhamCT, soLuong){
        var checkBoxLuaChon = document.getElementById(idSanPhamCT);
        var numberCheck = 0;
        if(checkBoxLuaChon.checked){
            console.log("id sản phẩm " + idSanPhamCT + " được chọn");
            chonSanPhamThanhToan(idSanPhamCT, soLuong, 1);
        }else{
            console.log("id sản phẩm " + idSanPhamCT + " không được chọn");
            chonSanPhamThanhToan(idSanPhamCT, soLuong, 0);
        }

        // window.location.href = "";
        // window.location.reload();
    }

    chonSanPhamThanhToan = function(idSanPhamCT, soLuong, numberCheck) {
        // console.log("Click vào function addToCart");
        let data = {
            idSanPhamCT: idSanPhamCT, //lay theo id
            soLuong: soLuong,
            numberCheck: numberCheck
        };

        //$ === jQuery
        jQuery.ajax({
            url : "/gio-hang/add-to-cartThanhToan",
            type : "POST",
            contentType: "application/json",
            data : JSON.stringify(data),
            dataType : "json", //Kieu du lieu tra ve tu controller la json

            success : function(jsonResult) {
                let totalPrice = jsonResult.totalPriceCartThanhToan;
                $("#totalPriceInCartThanhToan").html(totalPrice);
            },

            error : function(jqXhr, textStatus, errorMessage) {
                //alert(jsonResult.code + ': Luu thanh cong...!')
            }

        });
    }
</script>


</body>


<!-- molla/cart.html  22 Nov 2019 09:55:06 GMT -->
</html>