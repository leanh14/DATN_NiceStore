package com.example.duantn.controller.customer;

import com.example.duantn.Model.*;
import com.example.duantn.Request.GioHang;
import com.example.duantn.Request.HoaDonRequest;
import com.example.duantn.Request.SanPhamTrongGioHang;
import com.example.duantn.Service.impl.ChiTietSPServiceImpl;
import com.example.duantn.Service.impl.HoaDonCTServiceImpl;
import com.example.duantn.Service.impl.HoaDonServiceImpl;
import com.example.duantn.dto.Constant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.apache.catalina.session.StandardSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/gio-hang")
public class CartController {

    @Autowired
    HttpSession session;




    @Autowired
    ChiTietSPServiceImpl chiTietSPService;
    
    @Autowired
    HoaDonServiceImpl hoaDonService;

    @Autowired
    HoaDonCTServiceImpl hoaDonChiTietService;

    @GetMapping("/view-gio")
    public String viewGioHang(
             HttpServletRequest request ,
             HttpServletResponse response ,
             Model model
    ) {
        // lấy giỏ hàng
        HttpSession session = request.getSession();
        Double totalCartPrice = 0.0;

        GioHang cart = null;

        String errorMessage = null;
        String message = null;

        if(session.getAttribute("cart") != null) {
            cart = (GioHang) session.getAttribute("cart");
            totalCartPrice = cart.tongTienTrongGioHang();
            model.addAttribute("totalCartPrice" , totalCartPrice);
            model.addAttribute("totalCartProducts" , session.getAttribute("totalCartProducts"));

//				model.addAttribute("cartProducts", cart.getDs_cartproduct());

            message = "Có " + cart.totalSanPhamTrongGioHangs() + " sản phẩm";
//            System.out.println("Có sản phẩm trong giỏ");
        }else {
            // trường hợp: chưa có trong giỏ hàng
            cart = new GioHang();
            errorMessage = "Không có sản phẩm nào trong giỏ hàng ";

//            System.out.println("Không có sản phẩm nào trong giỏ hàng");
        }

        List<SanPhamTrongGioHang> dsSanPhamTrongGio = new ArrayList<>();
        dsSanPhamTrongGio = cart.getDs_SanPhamTrongGioHang();
//        System.out.println("Size of giỏ hàng : " + dsSanPhamTrongGio.size());
//        System.out.println("Sản phẩm trong giỏ hàng : " + dsSanPhamTrongGio);
        model.addAttribute("sanPhamTrongGio",dsSanPhamTrongGio);
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("message", message);


        return "customer/gioHang/view_gio_hang";
    }

    @GetMapping("/view-thanhToan")
    public String viewThanhToan(
            HttpServletRequest request,
            Model model
    ) {
        model.addAttribute("datHang", new HoaDonRequest());
        HttpSession session = request.getSession();
        GioHang cartThanhToan = (GioHang) session.getAttribute("cartThanhToan");
        List<SanPhamTrongGioHang> dsSanPhamTrongGio = new ArrayList<>();
        if(cartThanhToan!=null){
            dsSanPhamTrongGio = cartThanhToan.getDs_SanPhamTrongGioHang();
        }
        Double tongTienDonHang = dsSanPhamTrongGio.stream().mapToDouble(sp -> sp.getGia()*sp.getSoLuong()).sum();
//        System.out.println("Tổng tiền đơn hàng " +  tongTienDonHang);
        model.addAttribute("dsSanPham", dsSanPhamTrongGio);
        model.addAttribute("tongTienDonHang",tongTienDonHang);

        return "customer/gioHang/thanh_toan";
    }

    @PostMapping("/dat-hang")
    public String datHang(
            HttpServletRequest request,
            @Valid @ModelAttribute("datHang") HoaDonRequest datHangRequest,
            BindingResult result ,
            Model model
    ) throws ParseException {
        if(result.hasErrors()){
            System.out.println("Có lỗi khi đặt hàng ");
            System.out.println("Lỗi khi đặt hàng : " + result.toString());
            return "customer/gioHang/thanh_toan";
        }

        HttpSession session = request.getSession();

        // lấy ra danh sách giỏ hàng thanh toán
        GioHang gioHangThanhToan = (GioHang) session.getAttribute("cartThanhToan");
        HoaDon hoaDon = new HoaDon();

        // tạo mã hóa đơn random
        int randomInt = (int) (Math.random() * 100);
        String maHoaDon = String.valueOf(randomInt);
        hoaDon.setTenKH(datHangRequest.getHoVaTen());
        hoaDon.setDiaChi(datHangRequest.getDiaChi());
        hoaDon.setGhiChu(datHangRequest.getGhiChu());
        hoaDon.setSoDT(datHangRequest.getSoDT());
        hoaDon.setTongTienThanhToan(gioHangThanhToan.tongTienTrongGioHang());
        hoaDon.setEmail(datHangRequest.getEmail());
        hoaDon.setNgayMua(Constant.getDateNow());
        hoaDon.setNgayThanhToan(Constant.getDateNow());
        hoaDon.setTrangThai("1");
        hoaDon.setMa(maHoaDon);

        // thêm thông tin đơn hàng vào hóa đơn - trong database
        hoaDonService.themMoi(hoaDon);

        System.out.println("Thêm mới hóa đơn thành công ");

        // lấy hóa đơn ra theo mã hóa đơn phía trên => thêm sản phẩm vào hóa đơn chi tiết
        HoaDon hoaDon1 = hoaDonService.layHoaDonTheoMa(maHoaDon);
        UUID id_hoaDon = hoaDon1.getId();

        // lấy ra danh sách sản phẩm được thêm vào cart thanh toán
        List<SanPhamTrongGioHang> dsSanPhamTrongGioThanhToan = gioHangThanhToan.getDs_SanPhamTrongGioHang();


        // duyệt list sau đó thêm sản phẩm chi tiết vào hóa đơn chi tiết
        for(SanPhamTrongGioHang sanPhamGio : dsSanPhamTrongGioThanhToan){
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            // chi tiet san pham
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
            chiTietSanPham.setId(sanPhamGio.getIdSanPhamCT());

            hoaDonChiTiet.setChiTietSanPham(chiTietSanPham);
            // hóa đơn
            HoaDon hoaDon2 = new HoaDon();
            hoaDon2.setId(id_hoaDon);
            hoaDonChiTiet.setHoaDon(hoaDon2);

            hoaDonChiTiet.setDonGia(sanPhamGio.getGia());
            hoaDonChiTiet.setSoLuong(sanPhamGio.getSoLuong());
            hoaDonChiTiet.setNgayTao(Constant.getDateNow());


            // them sản phẩm vào hóa đơn chi tiết
            hoaDonChiTietService.themMoi(hoaDonChiTiet);
            // cập nhật số lượng sản phẩm trong DB
            chiTietSPService.capNhatSoLuongSauKhiDatHang(sanPhamGio.getSoLuong(), sanPhamGio.getIdSanPhamCT());

        }

        // duyệt danh sách sản phẩm trong giỏ hàng => kiểm tra cái nào có được chọn mua => xóa
//        HttpSession session = request.getSession();

        // lấy ra danh sách giỏ hàng thanh toán
        GioHang gioHangCuaKhach = (GioHang) session.getAttribute("cart");
        List<SanPhamTrongGioHang> dsSanPhamGioKH = gioHangCuaKhach.getDs_SanPhamTrongGioHang();
//        System.out.println("Danh sách sản phẩm trong giỏ - khi chưa xóa " + dsSanPhamGioKH.size());
//        System.out.println("Danh sách sản phẩm trong giỏ thanh toán - khi chưa xóa " + dsSanPhamTrongGioThanhToan.size());

        Iterator<SanPhamTrongGioHang> dsCart = dsSanPhamGioKH.iterator();
        while (dsCart.hasNext()) {
            SanPhamTrongGioHang element1 = dsCart.next();
            Iterator<SanPhamTrongGioHang> dsCartThanhToan = dsSanPhamTrongGioThanhToan.iterator();
            while (dsCartThanhToan.hasNext()) {
                SanPhamTrongGioHang element2 = dsCartThanhToan.next();
                if (element1.getIdSanPhamCT().equals(element2.getIdSanPhamCT())) {
                    dsCart.remove();
                    dsCartThanhToan.remove();
                }
            }
        }
//        System.out.println("Danh sách sản phẩm trong giỏ - sau khi xóa " + dsSanPhamGioKH.size());
//        System.out.println("Danh sách sản phẩm trong giỏ thanh toán - sau khi xóa " + dsSanPhamTrongGioThanhToan.size());

        // xóa hết cart thanh toán => vì đã hoàn thành đặt hàng rồi
        GioHang capNhatGioHangKhachHang = new GioHang();
        if(dsSanPhamGioKH.size()>0){
            for(SanPhamTrongGioHang sanPhamGio : dsSanPhamGioKH){
                capNhatGioHangKhachHang.getDs_SanPhamTrongGioHang().add(sanPhamGio);
            }
        }

        session.setAttribute("cart", capNhatGioHangKhachHang);
        session.setAttribute("cartThanhToan",new GioHang());
        session.setAttribute("totalCartProducts", capNhatGioHangKhachHang.totalSanPhamTrongGioHangs());


        System.out.println("Đặt hàng thành công");

        return "redirect:/gio-hang/view-trangChu";
    }

    @GetMapping("/view-trangChu")
    public String viewTrangChu(
            Model model ,
            HttpServletRequest httpServletRequest
    ) {
        Page<ChiTietSanPham> pageChiTietSP =   chiTietSPService.layDanhSach(Pageable.unpaged());
        List<ChiTietSanPham> dsSanPhamCT = pageChiTietSP.getContent();

//        System.out.println("Size of dsSanPham : " + dsSanPhamCT.size());
        model.addAttribute("dsSanPham",dsSanPhamCT);

//        session = httpServletRequest.getSession();
//        Integer soLuongSanPhamTrongGio = (Integer) session.getAttribute("totalCartProducts");
//        model.addAttribute("totalCartProducts",soLuongSanPhamTrongGio);

        return "customer/gioHang/trang_chu";
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<Map<String, Object>> addToCart(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody SanPhamTrongGioHang sanPhamTrongGioHang
    ) throws IOException {

//        System.out.println("Chạy vào add-to-cart xử lý : " );
        HttpSession session = request.getSession();  // tạo mới 1 session
        GioHang cart = null; // khởi tạo 1 Object cart = null

        // nếu giỏ hàng không null, thì lấy session có tên cart gán vào giỏ hàng
        if(session.getAttribute("cart")!=null) {
//            System.out.println("có sản phẩm trong giỏ hàng");
            cart = (GioHang) session.getAttribute("cart"); // nếu cart đang tồn tại giá trị thì gán giá trị đang tồn tại của cart này vào
        }else {  // chưa có j thì khởi tạo cart mới
            cart = new GioHang();
            session.setAttribute("cart", cart);
//            System.out.println("giỏ hàng chưa có gì cả ");
        }

//        System.out.println("ID sản phẩm thêm vào cart : " + sanPhamTrongGioHang.getIdSanPhamCT());

        ChiTietSanPham dbSanPhamCT = new ChiTietSanPham();
        if(sanPhamTrongGioHang.getIdSanPhamCT()!=null) {
            dbSanPhamCT = chiTietSPService.chiTietTheoId(sanPhamTrongGioHang.getIdSanPhamCT());
        }
        boolean isExisProduct = false;


//        System.out.println("ID sản phẩm thêm vào giỏ :" + sanPhamTrongGioHang.getIdSanPhamCT());

        // lấy danh sách các sản phẩm trong giỏ hàng thêm vào sản phẩm trong giỏ ( với 1 số thông tin mặc định )
        List<SanPhamTrongGioHang> dsSanPhamTrongGio = cart.getDs_SanPhamTrongGioHang();

//        System.out.println("Danh sách sản phẩm trong giỏ hàng " + dsSanPhamTrongGio.size());


        // nếu sản phẩm có trong giỏ hàng rồi thì sửa số lượng
        for(SanPhamTrongGioHang spTrongGioHang : dsSanPhamTrongGio) {

//            System.out.println("ID trong giỏ" + spTrongGioHang.getIdSanPhamCT());
//            System.out.println("ID mới thêm vào giỏ" + sanPhamTrongGioHang.getIdSanPhamCT());
            if(spTrongGioHang.getIdSanPhamCT().equals( sanPhamTrongGioHang.getIdSanPhamCT())) {
                isExisProduct= true;
//                System.out.println("Sản phẩm này đã có trong giỏ hàng");
                spTrongGioHang.setSoLuong(spTrongGioHang.getSoLuong() + 1);
            }
        }

        // cart ở đây chính là danh sách sản ơphaarm luôn
        // ! ngược lại true = false nghĩa là isExis ko thay đổi => sản phẩm chưa có trong giỏ
        if(isExisProduct==false) {
            sanPhamTrongGioHang.setSanPham(dbSanPhamCT.getSanPham());
            sanPhamTrongGioHang.setMauSac(dbSanPhamCT.getMauSac());
            sanPhamTrongGioHang.setKichCo(dbSanPhamCT.getKichCo());

            sanPhamTrongGioHang.setGia(dbSanPhamCT.getGiaTriSanPham());
            sanPhamTrongGioHang.setHinhAnh(dbSanPhamCT.getHinhAnh());

            cart.getDs_SanPhamTrongGioHang().add(sanPhamTrongGioHang);

        }

        List<SanPhamTrongGioHang> dsSanPhamTrongGios = new ArrayList<>();
        dsSanPhamTrongGio = cart.getDs_SanPhamTrongGioHang();
//        System.out.println("Size of giỏ hàng : " + dsSanPhamTrongGio.size());
//        System.out.println("Sản phẩm trong giỏ hàng : " + dsSanPhamTrongGio);
        model.addAttribute("sanPhamTrongGio",dsSanPhamTrongGios);

        // lưu cart vào giỏ
        session.setAttribute("cart", cart);
        session.setAttribute("totalCartProducts", dsSanPhamTrongGio.size());
        session.setAttribute("totalPriceResult", cart.tongTienTrongGioHang());

        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("totalCartProducts", cart.totalSanPhamTrongGioHangs());
        jsonResult.put("totalPriceResult", cart.tongTienTrongGioHang());


//        System.out.println("Total price : " + cart.tongTienTrongGioHang());
        return ResponseEntity.ok(jsonResult);
    }

    @PostMapping("/capNhatSoLuongSPCT")
    public ResponseEntity<Map<String, Object>> updateNumberOfCart(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody SanPhamTrongGioHang sanPhamTrongGioHang
    ) throws IOException {
        HttpSession session = request.getSession();
        GioHang cart = null;

        // nếu giỏ hàng không null, thì lấy session có tên cart gán vào giỏ hàng
        if(session.getAttribute("cart")!=null) {
//            System.out.println("có sản phẩm trong giỏ hàng");
            cart = (GioHang) session.getAttribute("cart"); // nếu cart đang tồn tại giá trị thì gán giá trị đang tồn tại của cart này vào
        }else {  // chưa có j thì khởi tạo cart mới
            cart = new GioHang();
            session.setAttribute("cart", cart);
//            System.out.println("giỏ hàng chưa có gì cả ");
        }

        boolean isExisProduct = false;


        // lấy danh sách các sản phẩm trong giỏ hàng thêm vào sản phẩm trong giỏ ( với 1 số thông tin mặc định )
        List<SanPhamTrongGioHang> dsSanPhamTrongGio = cart.getDs_SanPhamTrongGioHang();

//        System.out.Danh sách sản phẩm trong giỏ - khi chưa xóa 2println("Danh sách sản phẩm trong giỏ hàng " + dsSanPhamTrongGio.size());


        Map<String, Object> jsonResult = new HashMap<String, Object>();

        // nếu sản phẩm có trong giỏ hàng rồi thì sửa số lượng
        for(SanPhamTrongGioHang spTrongGioHang : dsSanPhamTrongGio) {

            if(spTrongGioHang.getIdSanPhamCT().equals( sanPhamTrongGioHang.getIdSanPhamCT())) {
                isExisProduct= true;
//                System.out.println("Sản phẩm này đã có trong giỏ hàng - đang ở cập nhật số lượng sản phẩm");
                spTrongGioHang.setSoLuong(sanPhamTrongGioHang.getSoLuong());
//                jsonResult.put("thanhTien", spTrongGioHang.getGia()* sanPhamTrongGioHang.getSoLuong());
//                session.setAttribute("thanhTien", spTrongGioHang.getGia()* sanPhamTrongGioHang.getSoLuong());
//                System.out.println("Tong tien x : " + spTrongGioHang.getGia()* sanPhamTrongGioHang.getSoLuong());
                break;
            }
        }

        // lưu cart vào giỏ
        session.setAttribute("cart", cart);
        session.setAttribute("totalCartProducts", cart.totalSanPhamTrongGioHangs());
        session.setAttribute("totalPriceResult", cart.tongTienTrongGioHang());


        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("totalCartProducts", cart.totalSanPhamTrongGioHangs());
        jsonResult.put("totalPriceResult", cart.tongTienTrongGioHang());

//        System.out.println("\n\nCập nhật số lượng sản phẩm trong giỏ hàng thành công");

//        System.out.println("Total price : " + cart.tongTienTrongGioHang());

//        System.out.println("Chạy vào giỏ hàng xong ... cần redirect lại giỏ hàng ");
        return ResponseEntity.ok(jsonResult);
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id,
            final Model model,
            final HttpServletRequest request,
            final HttpServletResponse response
    ) {
        // lấy ra cart
        HttpSession session = request.getSession();  // tạo mới 1 session
        GioHang cart = null; // khởi tạo 1 Object cart = null
        cart = (GioHang) session.getAttribute("cart");

//        List<SanPhamTrongGioHang> dsSanPhamTrongGio = cart.getDs_SanPhamTrongGioHang();
//        List<SanPhamTrongGioHang> dsSanPhamTrongGioSauKhiXoa = dsSanPhamTrongGio.stream()
//                                                                                .filter(product -> !product.getIdSanPhamCT().equals(id))
//                                                                                .collect(Collectors.toList());

//        List<SanPhamTrongGioHang> dsSanPhamTrongGioTruoc = new ArrayList<>();
////        dsSanPhamTrongGio.remove()
//        dsSanPhamTrongGioTruoc = cart.getDs_SanPhamTrongGioHang();
//        System.out.println("Ds san pham trong gio truoc khi xoa: "+ dsSanPhamTrongGioTruoc.size());
        // xóa sản phẩm khỏi cart

        List<SanPhamTrongGioHang> dsSanPhamTrongGio = cart.getDs_SanPhamTrongGioHang();

//        System.out.println("Danh sách sản phẩm trong giỏ hàng " + dsSanPhamTrongGio.size());

        // xóa sản phẩm khỏi giỏ
        for(int i=0;i<dsSanPhamTrongGio.size();i++){
//            System.out.println("San pham tại vị trí i : " + dsSanPhamTrongGio.get(i).getIdSanPhamCT());
//            System.out.println("San phẩm tìm để xóa : " + id);
            if(dsSanPhamTrongGio.get(i).getIdSanPhamCT().equals(id)) {
                dsSanPhamTrongGio.remove(i);
                break;
            }
        }

        cart = new GioHang();
        for(SanPhamTrongGioHang sanPhamTrongGioHang : dsSanPhamTrongGio){
            cart.getDs_SanPhamTrongGioHang().add(sanPhamTrongGioHang);
        }
//        List<SanPhamTrongGioHang> dsSanPhamTrongGio = new ArrayList<>();
//        dsSanPhamTrongGio.remove()
        System.out.println("Ds san pham trong gio sau khi xoa: "+ dsSanPhamTrongGio.size());
        // lưu cart vào giỏ
//        session.setAttribute("cart", cart);
        session.setAttribute("cart",cart);
        session.setAttribute("totalCartProducts", cart.totalSanPhamTrongGioHangs());
        session.setAttribute("totalPriceResult", cart.tongTienTrongGioHang());

        // lấy ra tổng tiền được chọn thanh toán
        Double tongTienThanhToan = (Double) session.getAttribute("totalPriceCartThanhToan");

        model.addAttribute("totalPriceCartThanhToan",tongTienThanhToan==null?0:tongTienThanhToan);

        System.out.println("Xóa khỏi giỏ");
        return "redirect:/gio-hang/view-gio";
    }

    @PostMapping("/add-to-cartThanhToan")
    public ResponseEntity<Map<String, Object>> addToCartThanhToan(
            final Model model
            , final HttpServletRequest request
            , final HttpServletResponse response
            , @RequestBody SanPhamTrongGioHang sanPhamTrongGioHang
    ) throws IOException {
//        System.out.println("Number check : " + sanPhamTrongGioHang.getNumberCheck());
        HttpSession session = request.getSession();
        GioHang cartThanhToan = null; // khởi tạo 1 Object cart = null

        // nếu giỏ hàng không null, thì lấy session có tên cart gán vào giỏ hàng
        if(session.getAttribute("cartThanhToan")!=null) {
//            System.out.println("có sản phẩm trong giỏ hàng");
            cartThanhToan = (GioHang) session.getAttribute("cartThanhToan"); // nếu cart đang tồn tại giá trị thì gán giá trị đang tồn tại của cart này vào
        }else {  // chưa có j thì khởi tạo cart mới
            cartThanhToan = new GioHang();
            session.setAttribute("cartThanhToan", cartThanhToan);
//            System.out.println("giỏ hàng chưa có gì cả ");
        }

        Double tongTien = 0.0;

        List<SanPhamTrongGioHang> dsSanPhamTrongGioThanhToan = new ArrayList<>();
        if(sanPhamTrongGioHang.getNumberCheck()==1){
            if(cartThanhToan.getDs_SanPhamTrongGioHang().size()>0){
//                System.out.println("Gio hang thanh toan da co san pham truoc do : " + cartThanhToan.getDs_SanPhamTrongGioHang().size());
                dsSanPhamTrongGioThanhToan = cartThanhToan.getDs_SanPhamTrongGioHang();
            }
//            System.out.println("Danh sách giỏ hàng trước khi thêm " + dsSanPhamTrongGioThanhToan.size());
            SanPhamTrongGioHang sanPhamMoiThem = new SanPhamTrongGioHang();
            ChiTietSanPham chiTietSanPham = chiTietSPService.chiTietTheoId(sanPhamTrongGioHang.getIdSanPhamCT());
            sanPhamMoiThem.setIdSanPhamCT(sanPhamTrongGioHang.getIdSanPhamCT());
            sanPhamMoiThem.setSanPham(chiTietSanPham.getSanPham());
            sanPhamMoiThem.setMauSac(chiTietSanPham.getMauSac());
            sanPhamMoiThem.setKichCo(chiTietSanPham.getKichCo());
            sanPhamMoiThem.setGia(chiTietSanPham.getGiaTriSanPham());
            sanPhamMoiThem.setNumberCheck(1);
            sanPhamMoiThem.setSoLuong(sanPhamTrongGioHang.getSoLuong());
            sanPhamMoiThem.setHinhAnh(chiTietSanPham.getHinhAnh());  // chưa xử lý được hình ảnh

//            if(sanPhamMoiThem==null){
//                System.out.println("Sản phẩm mới chọn vào giỏ hàng null");
//            }

            // thêm sản phẩm vào giỏ trong list
            dsSanPhamTrongGioThanhToan.add(sanPhamMoiThem);
//            System.out.println("Danh sách sản phẩm sau khi thêm " + dsSanPhamTrongGioThanhToan.size());
//                        cartThanhToan = new GioHang();

            // thêm sản phẩm vào session cart thanh toán
//            cartThanhToan.getDs_SanPhamTrongGioHang().add(sanPhamMoiThem);

            cartThanhToan = new GioHang();
            for(SanPhamTrongGioHang sanPhamGio : dsSanPhamTrongGioThanhToan){
                cartThanhToan.getDs_SanPhamTrongGioHang().add(sanPhamGio);
            }
//            System.out.println("Danh sách sản phẩm trong session giỏ hàng thanh toán : " + cartThanhToan.getDs_SanPhamTrongGioHang().size());


            // tính tổng tiền giỏ hàng thanh toán
            tongTien = dsSanPhamTrongGioThanhToan.stream()
                    .mapToDouble(sanPham -> sanPham.getSoLuong() * sanPham.getGia()) // Ánh xạ sản phẩm thành giá trị tiền
                    .sum();

            // thêm danh sách sản phẩm vào session

             session.setAttribute("cartThanhToan",cartThanhToan);
            model.addAttribute("totalPriceCartThanhToan",tongTien);

        }else {
            if(sanPhamTrongGioHang.getNumberCheck()==1){
                cartThanhToan = (GioHang) session.getAttribute("cartThanhToan");
                dsSanPhamTrongGioThanhToan = cartThanhToan.getDs_SanPhamTrongGioHang();
//                System.out.println("Danh sách sản phẩm trong giỏ hàng thanh toán : " + dsSanPhamTrongGioThanhToan.size());

                // kiểm tra id sản phẩm có trong giỏ hàng thanh toán chưa ? (có )

                List<SanPhamTrongGioHang> ds_addProductNewToCart = new ArrayList<>();
                for(SanPhamTrongGioHang spCartThanhToan : dsSanPhamTrongGioThanhToan){
                    if(spCartThanhToan.getIdSanPhamCT().equals(sanPhamTrongGioHang.getIdSanPhamCT())){
                        spCartThanhToan.setSoLuong(sanPhamTrongGioHang.getSoLuong());
//                        System.out.println(" sản phẩm có trong cart thanh toán + numbercheck = 1 => cập nhật số lượng trong giỏ hàng thanh toán ");
                    }else{
                        SanPhamTrongGioHang sanPhamMoiThem = new SanPhamTrongGioHang();
                        ChiTietSanPham chiTietSanPham = chiTietSPService.chiTietTheoId(sanPhamTrongGioHang.getIdSanPhamCT());

                        sanPhamMoiThem.setIdSanPhamCT(sanPhamTrongGioHang.getIdSanPhamCT());
                        sanPhamMoiThem.setSanPham(chiTietSanPham.getSanPham());
                        sanPhamMoiThem.setMauSac(chiTietSanPham.getMauSac());
                        sanPhamMoiThem.setKichCo(chiTietSanPham.getKichCo());
                        sanPhamMoiThem.setGia(chiTietSanPham.getGiaTriSanPham());
                        sanPhamMoiThem.setNumberCheck(1);
                        sanPhamMoiThem.setSoLuong(sanPhamTrongGioHang.getSoLuong());
                        sanPhamMoiThem.setHinhAnh(chiTietSanPham.getHinhAnh());  // chưa xử lý được hình ảnh

                        // thêm sản phẩm vào giỏ trong list
                        ds_addProductNewToCart.add(sanPhamMoiThem);
//                        System.out.println("size danh sách giỏ hàng sau khi thêm " + dsSanPhamTrongGioThanhToan.size());
//                        System.out.println(" sản phẩm chưa có trong cart thanh toán + numbercheck = 1 => thêm sản phẩm vào giỏ hàng thanh toán ");
                    }
                }
                dsSanPhamTrongGioThanhToan.addAll(ds_addProductNewToCart);
                tongTien = dsSanPhamTrongGioThanhToan.stream()
                        .mapToDouble(sanPham -> sanPham.getSoLuong() * sanPham.getGia()) // Ánh xạ sản phẩm thành giá trị tiền
                        .sum();

                // thêm các sản phẩm lại vào cartThanhToan
                cartThanhToan = new GioHang(); // khởi tạo lại , thêm lại các sản phẩm vào giỏ hàng thanh toán
                for(SanPhamTrongGioHang sanPham : dsSanPhamTrongGioThanhToan){
                    cartThanhToan.getDs_SanPhamTrongGioHang().add(sanPham);
                }

                // thêm danh sách sản phẩm vào session
                session.setAttribute("cartThanhToan",cartThanhToan);
                model.addAttribute("totalPriceCartThanhToan",tongTien);

            }else{
//                System.out.println("Sản phẩm được bỏ chọn khỏi giỏ hàng" + sanPhamTrongGioHang.getNumberCheck());
                // kiểm tra id sản phẩm có trong giỏ hàng thanh toán chưa ? (có )
                // => xóa sản phẩm khỏi cart
                int checkXoa = 0;
                SanPhamTrongGioHang xoaSanPhamGio = new SanPhamTrongGioHang();
                cartThanhToan = (GioHang) session.getAttribute("cartThanhToan");
                dsSanPhamTrongGioThanhToan = cartThanhToan.getDs_SanPhamTrongGioHang();
//                System.out.println("Danh sách sản phẩm trong giỏ - sau khi vào hàm check bỏ chọn" + dsSanPhamTrongGioThanhToan.size());
                for(int i=0; i<dsSanPhamTrongGioThanhToan.size();i++){
                    if(dsSanPhamTrongGioThanhToan.get(i).getIdSanPhamCT().equals(sanPhamTrongGioHang.getIdSanPhamCT())){
                        xoaSanPhamGio = dsSanPhamTrongGioThanhToan.get(i);
                        break;
                    }
                }
//                System.out.println("Danh sách sản phẩm trong giỏ hàng thanh toán trước khi xóa = " + dsSanPhamTrongGioThanhToan.size() );
                dsSanPhamTrongGioThanhToan.remove(xoaSanPhamGio);
//                System.out.println("Danh sách sản phẩm trong giỏ hàng thanh toán sau khi xóa = " + dsSanPhamTrongGioThanhToan.size() );

                tongTien = dsSanPhamTrongGioThanhToan.stream()
                        .mapToDouble(sanPham -> sanPham.getSoLuong() * sanPham.getGia()) // Ánh xạ sản phẩm thành giá trị tiền
                        .sum();

                // thêm các sản phẩm lại vào cartThanhToan
                cartThanhToan = new GioHang(); // khởi tạo lại , thêm lại các sản phẩm vào giỏ hàng thanh toán
                for(SanPhamTrongGioHang sanPham : dsSanPhamTrongGioThanhToan){
                    cartThanhToan.getDs_SanPhamTrongGioHang().add(sanPham);
                }

                // thêm danh sách sản phẩm vào session
                session.setAttribute("cartThanhToan",cartThanhToan);
                model.addAttribute("totalPriceCartThanhToan",tongTien);
            }
        }

        // lưu dữ liệu vào json
        Map<String, Object> jsonResult = new HashMap<String, Object>();
        jsonResult.put("code", 200);
        jsonResult.put("status", "Success");
        jsonResult.put("totalPriceCartThanhToan", tongTien);


        // kiểm tra trong cartToThanhToan == null và numbercheckSP = 1
        // => thêm sản phẩm vào giỏ hàng thanh toán , tính tổng tiền => hiển thị

        // kiểm tra nếu cartToThanhToan !=null
            // kiểm tra tiếp numbercheckSP = 1
                // kiểm tra id sản phẩm có trong giỏ hàng thanh toán chưa ? (có )
                // => cập nhật số lượng sản phẩm trong cart
                // kiểm tra id sản phẩm có trong giỏ hàng thanh toán chưa ? (chưa )
                // => thêm sản phẩm vào cart
        // gọi ra hàm tính tổng tiền, tính lại tổng tiền toàn bộ cartThanhToan & lưu thông tin vào session

        // kiểm tra nếu cartToThanhToan !=null
            // kiểm tra tiếp numbercheckSP = 0
                // kiểm tra id sản phẩm có trong giỏ hàng thanh toán chưa ? (có )
                // => xóa sản phẩm khỏi cart

                // kiểm tra id sản phẩm có trong giỏ hàng thanh toán chưa ? (chưa ) -- ko cần check
                // => xóa sản phẩm khỏi cart
        // gọi ra hàm tính tổng tiền, tính lại tổng tiền toàn bộ cartThanhToan & lưu thông tin vào session

//        System.out.println("Hết 1 lượt chạy");

        return ResponseEntity.ok(jsonResult);
    }

}
