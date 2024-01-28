package com.example.duantn.Service.impl;

import com.example.duantn.Model.PhieuGiamGia;
import com.example.duantn.Repository.PhieuGiamGiaRepository;
import com.example.duantn.Service.PhieuGiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhieuGiamGiaServiceImpl implements PhieuGiamGiaService {
    @Autowired
    PhieuGiamGiaRepository phieuGiamGiaRepository;

    @Override
    public List<PhieuGiamGia> getAll() {
        return phieuGiamGiaRepository.getAll();
    }

    @Override
    public void delete(UUID id) {
        phieuGiamGiaRepository.deleteById(id);

    }

    @Override
    public void add(PhieuGiamGia phieuGiamGia) {
        phieuGiamGiaRepository.save(phieuGiamGia);

    }

    @Override
    public PhieuGiamGia detail(UUID id) {
        PhieuGiamGia phieuGiamGia = phieuGiamGiaRepository.findById(id).get();
        return phieuGiamGia;
    }

    @Override
    public PhieuGiamGia update(UUID id, PhieuGiamGia phieuGiamGia) {
        PhieuGiamGia phieuGiamGia1 = phieuGiamGiaRepository.save(phieuGiamGia);
        return phieuGiamGia1;
    }
}
