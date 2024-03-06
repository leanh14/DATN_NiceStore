package com.example.duantn.Service.impl;

import com.example.duantn.Model.DayGiay;
import com.example.duantn.Repository.DayGiayRepository;
import com.example.duantn.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DayGiayServiceImpl implements BaseService<DayGiay> {
    @Autowired
    DayGiayRepository repo_dayGiay;
    @Override
    public List<DayGiay> layDanhSach() {
        return repo_dayGiay.getAll();
    }

    @Override
    public Page<DayGiay> layDanhSach(Pageable pageable) {
        return null;
    }

    @Override
    public Page<DayGiay> layDanhSach(String textSearch, Pageable pageable) {
        return null;
    }

    @Override
    public void xoa(UUID id) {

    }

    @Override
    public void themMoi(DayGiay entity) {

    }

    @Override
    public DayGiay capNhat(DayGiay entity) {
        return null;
    }

    @Override
    public DayGiay chiTietTheoId(UUID id) {
        return null;
    }

    @Override
    public List<DayGiay> layDanhSachTheoTen(String ten) {
        return null;
    }
}
