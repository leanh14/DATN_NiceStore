package com.example.duantn.Service.impl;

import com.example.duantn.Model.LotGiay;
import com.example.duantn.Repository.LotGiayRepository;
import com.example.duantn.Service.LotGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LotGiayServiceImpl implements LotGiayService {
    @Autowired
    LotGiayRepository lotGiayRepository;

    @Override
    public List<LotGiay> getAll() {
        return lotGiayRepository.getAll();
    }

    @Override
    public void delete(UUID id) {

        lotGiayRepository.deleteById(id);
    }

    @Override
    public void add(LotGiay lotGiay) {

        lotGiayRepository.save(lotGiay);
    }

    @Override
    public LotGiay detail(UUID id) {
        LotGiay lotGiay = lotGiayRepository.findById(id).get();
        return lotGiay;
    }

    @Override
    public LotGiay update(UUID id, LotGiay lotGiay) {
        LotGiay lotGiay1 = lotGiayRepository.save(lotGiay);
        return lotGiay1;
    }
}
