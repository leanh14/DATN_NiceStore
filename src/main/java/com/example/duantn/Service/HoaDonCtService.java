package com.example.duantn.Service;

import com.example.duantn.Model.HoaDonCT;

import java.util.List;
import java.util.UUID;

public interface HoaDonCtService {
    List<HoaDonCT> getAll();
    void delete(UUID id);
    void add(HoaDonCT hoaDonCT);
    HoaDonCT detail(UUID id);
    HoaDonCT update(UUID id,HoaDonCT hoaDonCT);

}
