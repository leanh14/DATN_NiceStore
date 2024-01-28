package com.example.duantn.Service.impl;

import com.example.duantn.Model.HoaDon;
import com.example.duantn.Repository.HoaDonRepository;
import com.example.duantn.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    HoaDonRepository hoaDonRepository;
    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepository.getAll();
    }

    @Override
    public void delete(UUID id) {
        hoaDonRepository.deleteById(id);

    }

    @Override
    public void add(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);

    }

    @Override
    public HoaDon detail(UUID id) {
        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        return hoaDon;
    }

    @Override
    public HoaDon update(UUID id, HoaDon hoaDon) {
        HoaDon hoaDon1 = hoaDonRepository.save(hoaDon);
        return hoaDon1;
    }
}
