package com.example.duantn.Service;

import com.example.duantn.Model.KieuDang;

import java.util.List;
import java.util.UUID;

public interface KieuDangService {
    List<KieuDang> getAll();
    void delete(UUID id);
    void add(KieuDang kieuDang);
    KieuDang update(UUID id,KieuDang kieuDang);
    KieuDang detail(UUID id);
}
