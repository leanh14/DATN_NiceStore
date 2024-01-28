package com.example.duantn.Service;

import com.example.duantn.Model.SanPhamCT;

import java.util.List;
import java.util.UUID;

public interface SanPhamCTService {
    List<SanPhamCT> getAll();
    void delete(UUID id);
    void add(SanPhamCT sanPhamCT);
    SanPhamCT detail(UUID id);
    SanPhamCT update(UUID id,SanPhamCT sanPhamCT);
}
