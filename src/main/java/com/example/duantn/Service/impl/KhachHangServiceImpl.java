package com.example.duantn.Service.impl;

import com.example.duantn.Model.KhachHang;
import com.example.duantn.Repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl {
    @Autowired
    KhachHangRepository khachHangRepository;

    public List<KhachHang> layDanhSach() {
        return khachHangRepository.getAll();
    }
}
