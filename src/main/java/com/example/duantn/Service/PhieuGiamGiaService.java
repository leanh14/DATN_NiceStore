package com.example.duantn.Service;

import com.example.duantn.Model.PhieuGiamGia;

import java.util.List;
import java.util.UUID;

public interface PhieuGiamGiaService {
    List<PhieuGiamGia> getAll();
    void delete(UUID id);
    void add(PhieuGiamGia phieuGiamGia);
    PhieuGiamGia detail(UUID id);
    PhieuGiamGia update(UUID id,PhieuGiamGia phieuGiamGia);
}
