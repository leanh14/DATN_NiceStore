//package com.example.duantn.controller;
//
//import com.example.duantn.Model.ChiTietSanPham;
//import com.example.duantn.Model.DotKhuyenMai;
//import com.example.duantn.Model.KichCo;
//import com.example.duantn.Model.SanPham;
//import com.example.duantn.Request.DotKhuyenMaiRequest;
//import com.example.duantn.Request.KichCoRequest;
//import com.example.duantn.Service.impl.ChiTietSPServiceImpl;
//import com.example.duantn.Service.impl.DotKhuyenMaiServiceImpl;
//import com.example.duantn.Service.impl.SanPhamServiceImpl;
//import com.example.duantn.dto.Constant;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.text.ParseException;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//@Controller
//@RequestMapping("/dot-khuyen-mai")
//public class DotKhuyenMaiController {
//    @Autowired
//    DotKhuyenMaiServiceImpl dotKhuyenMaiService;
//
//    @Autowired
//    SanPhamServiceImpl sanPhamService;
//
//    @Autowired
//    ChiTietSPServiceImpl chiTietSPService;
//
//    @GetMapping("/hien-thi")
//    public String index(
//            Model model,
//            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
//            HttpServletRequest request
//    ) {
////        model.addAttribute("dotKhuyenMai", new KichCo());
//        String textSearch = request.getParameter("textsearch");
//
//        // phan trang
//        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
//        Page<DotKhuyenMai> pageDotKhuyenMai =  dotKhuyenMaiService.layDanhSach(textSearch, pageable);
//        List<DotKhuyenMai> dotKhuyenMais = pageDotKhuyenMai.getContent();
//
//        // muon hien thi so trang
//        model.addAttribute("tongSL",pageDotKhuyenMai.getNumberOfElements());
//        model.addAttribute("totalPage",pageDotKhuyenMai.getTotalPages());
//        model.addAttribute("dsDotKhuyenMai", dotKhuyenMais);
//        model.addAttribute("pageChoosedNumber",currentPage);
//
//        return "admin/dotKhuyenMai/show";
//    }
//
//    @GetMapping("/view-sua/{id}")
//    public String view_sua(
//            @PathVariable("id") UUID id ,
//            @ModelAttribute("dotKhuyenMai") DotKhuyenMaiRequest dotKhuyenMaiRequest,
//            Model model
//    ) {
//        DotKhuyenMai dotKhuyenMaiX = dotKhuyenMaiService.chiTietTheoId(id);
//        model.addAttribute("dotKhuyenMai",dotKhuyenMaiX);
//        return "admin/dotKhuyenMai/update";
//    }
//
//    @PostMapping("/sua/{id}")
//    public String sua(
//            @PathVariable("id") UUID id ,
//            @Valid @ModelAttribute("dotKhuyenMai") DotKhuyenMaiRequest request,
//            BindingResult result ,
//            Model model
//    ) throws ParseException {
//        if(result.hasErrors()){
////            System.out.println("Error basic : " + result.toString());
//            return "admin/dotKhuyenMai/update";
//        }
//
//        DotKhuyenMai dotKhuyenMaiCu = dotKhuyenMaiService.chiTietTheoId(id);
//
//        if(dotKhuyenMaiService.kiemTraTrungMaKhong(request.getMa(), dotKhuyenMaiCu.getMa())==true){
////            System.out.println("Trùng mã rồi...");
//            model.addAttribute("trungMa",true);
//            return "admin/dotKhuyenMai/update";
//        }
//
//        if(dotKhuyenMaiService.kiemTraTrungTenKhong(request.getTenDotKhuyenMai(), dotKhuyenMaiCu.getTenDotKhuyenMai())){
//            model.addAttribute("trungTen",true);
//            return "admin/dotKhuyenMai/update";
//        }
//
//        DotKhuyenMai dotKhuyenMaiUpdate = new DotKhuyenMai();
//        dotKhuyenMaiUpdate.setId(dotKhuyenMaiCu.getId());
//        dotKhuyenMaiUpdate.setMa(request.getMa());
//        dotKhuyenMaiUpdate.setTenDotKhuyenMai(request.getTenDotKhuyenMai());
//        dotKhuyenMaiUpdate.setGiaTriGiam(request.getGiaTriGiam());
//
//        Date ngayBatDau = request.getNgayBatDau();
//        dotKhuyenMaiUpdate.setNgayBatDau(new java.sql.Date(ngayBatDau.getTime()));
//
//        Date ngayKetThuc = request.getNgayKetThuc();
//        dotKhuyenMaiUpdate.setNgayKetThuc(new java.sql.Date(ngayKetThuc.getTime()));
//
//        Integer trangThai = request.getTrangThai();
//        dotKhuyenMaiUpdate.setTrangThai(trangThai);
//        dotKhuyenMaiUpdate.setNgaySua(Constant.getDateNow());
//
//        dotKhuyenMaiUpdate.setNgayTao(dotKhuyenMaiCu.getNgayTao());
//        dotKhuyenMaiUpdate.setNguoiSua(1);
//        dotKhuyenMaiUpdate.setNguoiTao(1);
//
//        dotKhuyenMaiService.capNhat(dotKhuyenMaiUpdate);
////        System.out.println("Sửa dữ liệu thành công");
//
//        model.addAttribute("dotKhuyenMai", request);
//        model.addAttribute("messageSuccess",true);
//
//        return "admin/dotKhuyenMai/update";
//    }
//
//    @GetMapping("/view-them")
//    public String view_sua(
//            @ModelAttribute("kichThuoc") DotKhuyenMaiRequest request,
//            Model model ,
//            @RequestParam(name = "page",defaultValue = "0") int currentPage,
//            HttpServletRequest httpServletRequest
//    ) {
//        String textSearch = httpServletRequest.getParameter("textsearch");
//
//        // phan trang
//        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
//        Page<ChiTietSanPham> pageSanPham = chiTietSPService.layDanhSach(textSearch, pageable);
//        List<ChiTietSanPham> chiTietSanPhams = pageSanPham.getContent();
//
////        System.out.println("size of chitiet san pham : " + chiTietSanPhams.size());
//
//        model.addAttribute("dotKhuyenMai",new DotKhuyenMaiRequest());
//        model.addAttribute("dsSanPham", chiTietSanPhams);
//
//        // muon hien thi so trang
//        model.addAttribute("tongSL",pageSanPham.getNumberOfElements());
//        model.addAttribute("totalPage",pageSanPham.getTotalPages());
//        model.addAttribute("pageChoosedNumber",currentPage);
//        return "admin/dotKhuyenMai/create";
//    }
//
//    @PostMapping("/them")
//    public String themMoi(
//            Model model,
//            @ModelAttribute("dotKhuyenMai") DotKhuyenMaiRequest request,
//            BindingResult result ,
//            @RequestParam(name = "page",defaultValue = "0") int currentPage ,
//            HttpServletRequest httpServletRequest
//    ) throws ParseException
//    {
//        String[] luaChon = httpServletRequest.getParameterValues("luaChonDotKhuyenMai") ;
//        System.out.println("Lựa chọn: " + luaChon.toString());
//
//        if(luaChon!=null){
//            System.out.println("Lua chon = " + luaChon);
//        }
//
//        if(result.hasErrors()){
//            return "admin/dotKhuyenMai/create";
//        }
//        if(dotKhuyenMaiService.kiemTraTrungMaKhong(request.getMa())){
//            model.addAttribute("trungMa",true);
//
//            return "admin/dotKhuyenMai/create";
//        }
//
//        if(dotKhuyenMaiService.kiemTraTrungTenKhong(String.valueOf(request.getTenDotKhuyenMai()))){
//            model.addAttribute("trungTen",true);
//
//            return "admin/dotKhuyenMai/create";
//        }
//
//        DotKhuyenMai dotKhuyenMaiMoi = new DotKhuyenMai();
//        dotKhuyenMaiMoi.setMa(request.getMa());
//        dotKhuyenMaiMoi.setTenDotKhuyenMai(request.getTenDotKhuyenMai());
//        dotKhuyenMaiMoi.setGiaTriGiam(request.getGiaTriGiam());
//
//        Date ngayBatDau = request.getNgayBatDau();
//        dotKhuyenMaiMoi.setNgayBatDau(new java.sql.Date(ngayBatDau.getTime()));
//
//        Date ngayKetThuc = request.getNgayKetThuc();
//        dotKhuyenMaiMoi.setNgayKetThuc(new java.sql.Date(ngayKetThuc.getTime()));
//
//        Integer trangThai = request.getTrangThai();
//        dotKhuyenMaiMoi.setTrangThai(trangThai);
//        dotKhuyenMaiMoi.setNgaySua(Constant.getDateNow());
//        dotKhuyenMaiMoi.setNgayTao(Constant.getDateNow());
//        dotKhuyenMaiMoi.setNguoiSua(1);
//        dotKhuyenMaiMoi.setNguoiTao(1);
//
//        dotKhuyenMaiService.themMoi(dotKhuyenMaiMoi);
//
//        model.addAttribute("dotKhuyenMai",new DotKhuyenMaiRequest());
//        model.addAttribute("messageSuccess",true);
//
//        return "admin/dotKhuyenMai/create";
//    }
//
//    @GetMapping("/xoa/{id}")
//    public String xoa(
//            @PathVariable("id") UUID id
//    ) {
//        DotKhuyenMai dotKhuyenMaiX = dotKhuyenMaiService.chiTietTheoId(id);
//        dotKhuyenMaiService.xoa(id);
//        return "redirect:/dot-khuyen-mai/hien-thi";
//    }
//
//}
