package com.example.duantn.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @GetMapping("/hien-thi")
    public String getAll(Model model){
        return "customer/sanPhamForm/trangChu";
    }
}
