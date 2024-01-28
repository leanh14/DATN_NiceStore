package com.example.duantn.Service.impl;

import com.example.duantn.Model.HoaDon;
import com.example.duantn.Model.HoaDonCT;
import com.example.duantn.Repository.HoaDonCTRepository;
import com.example.duantn.Service.HoaDonCtService;
import com.example.duantn.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonCTServiceImpl  implements HoaDonCtService {
    @Autowired
    HoaDonCTRepository hoaDonCTRepository;

    @Override
    public List<HoaDonCT> getAll() {
        return hoaDonCTRepository.getAll();
    }

    @Override
    public void delete(UUID id) {

        hoaDonCTRepository.deleteById(id);
    }

    @Override
    public void add(HoaDonCT hoaDonCT) {
        hoaDonCTRepository.save(hoaDonCT);

    }

    @Override
    public HoaDonCT detail(UUID id) {
        HoaDonCT hoaDonCT = hoaDonCTRepository.findById(id).get();
        return hoaDonCT;
    }

    @Override
    public HoaDonCT update(UUID id, HoaDonCT hoaDonCT) {
        HoaDonCT hoaDonCT1 = hoaDonCTRepository.save(hoaDonCT);
        return hoaDonCT1;
    }
}
