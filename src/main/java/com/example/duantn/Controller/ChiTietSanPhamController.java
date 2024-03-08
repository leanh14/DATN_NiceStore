package com.example.duantn.controller;

import com.example.duantn.Repository.ChiTietSanPhamRepository;
import com.example.duantn.Service.impl.ChiTietSPServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Controller;

@Controller
public class ChiTietSanPhamController {
    @Autowired
    ChiTietSPServiceImpl service_chiTietSP;



}
