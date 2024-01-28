package com.example.duantn.Service;

import com.example.duantn.Model.HoaDon;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    List<HoaDon> getAll();
    void delete(UUID id);
    void add(HoaDon hoaDon);
    HoaDon detail(UUID id);
    HoaDon update(UUID id,HoaDon hoaDon);
}
