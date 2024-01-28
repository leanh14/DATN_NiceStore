package com.example.duantn.Service.impl;

import com.example.duantn.Model.SanPhamCT;
import com.example.duantn.Repository.SanPhamCTRepository;
import com.example.duantn.Service.SanPhamCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamCTServiceImpl implements SanPhamCTService {
    @Autowired
    SanPhamCTRepository sanPhamCTRepository;

    @Override
    public List<SanPhamCT> getAll() {
        return sanPhamCTRepository.getAll();
    }

    @Override
    public void delete(UUID id) {
        sanPhamCTRepository.deleteById(id);

    }

    @Override
    public void add(SanPhamCT sanPhamCT) {
        sanPhamCTRepository.save(sanPhamCT);

    }

    @Override
    public SanPhamCT detail(UUID id) {
        SanPhamCT sanPhamCT = sanPhamCTRepository.findById(id).get();
        return sanPhamCT;
    }

    @Override
    public SanPhamCT update(UUID id, SanPhamCT sanPhamCT) {
        SanPhamCT sanPhamCT1 = sanPhamCTRepository.save(sanPhamCT);
        return sanPhamCT1;
    }
}
