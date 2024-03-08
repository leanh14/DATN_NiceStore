package com.example.duantn.controller;

import com.example.duantn.Model.GioHang;
import com.example.duantn.Model.KhachHang;
import com.example.duantn.Service.impl.GioHangCTServiceImpl;
import com.example.duantn.Service.impl.GioHangServiceImpl;
import com.example.duantn.Service.impl.SanPhamCTServiceImpl;
import com.example.duantn.dto.Constant;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/gio-hang-ct")
public class GioHangCTController {
    @Autowired
    GioHangServiceImpl gioHangService;
    @Autowired
    GioHangCTServiceImpl gioHangCTService;
    @Autowired
    SanPhamCTServiceImpl sanPhamCTService;
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

}
