package com.example.duantn.Service.impl;

import com.example.duantn.Model.ChucVu;
import com.example.duantn.Model.MuiGiay;
import com.example.duantn.Repository.ChucVuRepository;
import com.example.duantn.Repository.KichCoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuServiceImpl {
    @Autowired
    ChucVuRepository repo_chucVu;

    public List<ChucVu> layDanhSach() {
        return repo_chucVu.getAll();
    }
}
