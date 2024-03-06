package com.example.duantn.controller;

import com.example.duantn.Model.ChiTietSanPham;
import com.example.duantn.Repository.ChiTietSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class TestController {
    @Autowired
    ChiTietSanPhamRepository repo_chiTietSP;

    @RequestMapping("/test")
    public String test(){
        System.out.println("Chạy vào trang test");
        return "customer/test";
    }

    @RequestMapping("/test1")
    public String test1(){
        UUID idSanPham = UUID.fromString("9EC3D96C-1E8D-449A-9766-1E2154A30527");
        repo_chiTietSP.updateSoLuong(2,idSanPham);
        System.out.println(" Chay xong ham cap nhat so luong");
        return "customer/test";
    }

}
