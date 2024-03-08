package com.example.duantn.controller;

import com.example.duantn.Model.GioHang;
import com.example.duantn.Model.KhachHang;
import com.example.duantn.Request.GioHangRequest;
import com.example.duantn.Service.impl.GioHangServiceImpl;
import com.example.duantn.Service.impl.KhachHangServiceImpl;
import com.example.duantn.dto.Constant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/gio-hang")
public class GioHangController {
    @Autowired
    GioHangServiceImpl gioHangService;

    @Autowired
    KhachHangServiceImpl khachHangService;

    @GetMapping("/hien-thi")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int currentPage,
            HttpServletRequest request
    ) {

        model.addAttribute("gioHang", new GioHang());
        String textSearch = request.getParameter("textsearch");
        System.out.println("Text search : " + textSearch);

        // phan trang
        Pageable pageable = PageRequest.of(currentPage, Constant.pageNumber);
        Page<GioHang> pageGioHang = gioHangService.layDanhSach(textSearch, pageable);
        List<GioHang> gioHangx = pageGioHang.getContent();
        List<KhachHang> dsKhachHang = khachHangService.layDanhSach();

        // muon hien thi so trang
        model.addAttribute("tongSL", pageGioHang.getNumberOfElements());
        model.addAttribute("totalPage", pageGioHang.getTotalPages());
        model.addAttribute("dsGioHang", gioHangx);
        model.addAttribute("dsKhachHang", dsKhachHang);
        model.addAttribute("pageChoosedNumber", currentPage);
        return "admin/gioHang/create";
    }

    @GetMapping("/view-sua/{id}")
    public String view_sua(
            @PathVariable("id") UUID id,
            @ModelAttribute("gioHang") GioHangRequest gioHang,
            Model model
    ) {
        GioHang gioHangx = gioHangService.chiTietTheoId(id);
        model.addAttribute("gioHang", gioHangx);
        model.addAttribute("dsKhachHang", khachHangService.layDanhSach());
        return "admin/gioHang/update";
    }

    @PostMapping("/sua/{id}")
    public String sua(
            @PathVariable("id") UUID id,
            @Valid @ModelAttribute("gioHang") GioHangRequest request,
            BindingResult result,
            Model model
    ) throws ParseException {

        if (result.hasErrors()) {
            model.addAttribute("dsKhachHang", khachHangService.layDanhSach());
            System.out.println("Có lỗi nhưng không hiện lỗi");
            System.out.println("Ngày sinh của nhân viên : " + request.getTen());
            System.out.println("Lỗi tại : " + result.toString());
            return "admin/gioHang/update";
        }

        GioHang gioHangCu = gioHangService.chiTietTheoId(id);

//        if(nhanVienService.kiemTraTrungMaKhong(request.getMa(), nhanVienCu.getMa())){
//            model.addAttribute("trungMa",true);
//            return "admin/sanPham/update";
//        }
//
//        if(nhanVienService.kiemTraTrungTenKhong(request.getHoVaTen(), nhanVienCu.getHoVaTen())){
//            model.addAttribute("trungTen",true);
//            return "admin/sanPham/update";
//        }

        GioHang gioHangUpdate = new GioHang();
        KhachHang tenKhachHang = new KhachHang();

        tenKhachHang.setId(request.getKhachHang().getId());
        gioHangUpdate.setKhachHang(tenKhachHang);

        gioHangUpdate.setId(gioHangCu.getId());
        gioHangUpdate.setMa(request.getMa());
        gioHangUpdate.setTen(request.getTen());
        gioHangUpdate.setTrangThai(Integer.valueOf(request.getTrangThai()));
        gioHangUpdate.setNguoiTao(1);
        gioHangUpdate.setNguoiSua(1);
        gioHangUpdate.setNgayTao(Constant.getDateNow());
        gioHangUpdate.setNgaySua(Constant.getDateNow());

        gioHangService.capNhat(gioHangUpdate);
        System.out.println("Sửa dữ liệu thành công");
        model.addAttribute("gioHang", gioHangUpdate);
        model.addAttribute("messageSuccess", true);

        return "redirect:/gio-hang/hien-thi";
    }

    @PostMapping("/them")
    public String themMoi(
            Model model,
            @ModelAttribute("gioHang") GioHangRequest request
    ) throws ParseException {
        GioHang gioHangThemMoi = new GioHang();
        KhachHang tenKhachHang = new KhachHang();
        tenKhachHang.setId(request.getKhachHang().getId());
        gioHangThemMoi.setKhachHang(tenKhachHang);

        gioHangThemMoi.setId(null);
        gioHangThemMoi.setMa(request.getMa());
        gioHangThemMoi.setTen(request.getTen());
        gioHangThemMoi.setTrangThai(Integer.valueOf(request.getTrangThai()));
        gioHangThemMoi.setNguoiTao(1);
        gioHangThemMoi.setNguoiSua(1);
        gioHangThemMoi.setNgayTao(Constant.getDateNow());
        gioHangThemMoi.setNgaySua(Constant.getDateNow());

        gioHangService.themMoi(gioHangThemMoi);
        System.out.println("Thêm mới nhân viên thành công");

        return "redirect:/gio-hang/hien-thi";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(
            @PathVariable("id") UUID id
    ) {
        gioHangService.xoa(id);
        return "redirect:/dia-chi/hien-thi";
    }
}
