package com.example.duantn.Service.impl;

import com.example.duantn.Model.DanhMuc;
import com.example.duantn.Repository.DanhMucRepository;
import com.example.duantn.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DanhMucServiceImpl implements BaseService<DanhMuc> {
    @Autowired
    DanhMucRepository repo_danhMuc;

    @Override
    public List<DanhMuc> layDanhSach() {
        return repo_danhMuc.getAll();
    }

    @Override
    public Page<DanhMuc> layDanhSach(Pageable pageable) {
        return null;
    }

    @Override
    public Page<DanhMuc> layDanhSach(String textSearch, Pageable pageable) {
        return null;
    }

    @Override
    public void xoa(UUID id) {

    }

    @Override
    public void themMoi(DanhMuc entity) {

    }

    @Override
    public DanhMuc capNhat(DanhMuc entity) {
        return null;
    }

    @Override
    public DanhMuc chiTietTheoId(UUID id) {
        return null;
    }

    @Override
    public List<DanhMuc> layDanhSachTheoTen(String ten) {
        return null;
    }
}
