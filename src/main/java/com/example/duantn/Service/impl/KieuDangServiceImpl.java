package com.example.duantn.Service.impl;

import com.example.duantn.Model.KieuDang;
import com.example.duantn.Repository.KieuDangRepository;
import com.example.duantn.Service.KieuDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KieuDangServiceImpl  implements KieuDangService {
    @Autowired
    private KieuDangRepository kieuDangRepository;
    @Override
    public List<KieuDang> getAll() {
        return  kieuDangRepository.getAll();
    }

    @Override
    public void delete(UUID id) {
        kieuDangRepository.deleteById(id);
    }

    @Override
    public void add(KieuDang kieuDang) {

        kieuDangRepository.save(kieuDang);
    }

    @Override
    public KieuDang update(UUID id, KieuDang kieuDang) {
        KieuDang kieuDang1 = kieuDangRepository.save(kieuDang);
        return kieuDang1;
    }

    @Override
    public KieuDang detail(UUID id) {
        KieuDang kieuDang = kieuDangRepository.findById(id).get();
        return kieuDang;
    }
}
