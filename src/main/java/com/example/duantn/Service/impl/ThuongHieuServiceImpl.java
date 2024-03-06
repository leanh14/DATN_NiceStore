package com.example.duantn.Service.impl;

import com.example.duantn.Model.ThuongHieu;
import com.example.duantn.Repository.ThuongHieuRepository;
import com.example.duantn.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ThuongHieuServiceImpl implements BaseService<ThuongHieu> {
    @Autowired
    ThuongHieuRepository repo_thuongHieu;


    @Override
    public List<ThuongHieu> layDanhSach() {
        return repo_thuongHieu.getAll();
    }

    @Override
    public Page<ThuongHieu> layDanhSach(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ThuongHieu> layDanhSach(String textSearch, Pageable pageable) {
        return null;
    }

    @Override
    public void xoa(UUID id) {

    }

    @Override
    public void themMoi(ThuongHieu entity) {

    }

    @Override
    public ThuongHieu capNhat(ThuongHieu entity) {
        return null;
    }

    @Override
    public ThuongHieu chiTietTheoId(UUID id) {
        return null;
    }

    @Override
    public List<ThuongHieu> layDanhSachTheoTen(String ten) {
        return null;
    }
}
