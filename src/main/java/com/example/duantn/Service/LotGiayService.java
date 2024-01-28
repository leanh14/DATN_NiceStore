package com.example.duantn.Service;

import com.example.duantn.Model.LotGiay;

import java.util.List;
import java.util.UUID;

public interface LotGiayService {
    List<LotGiay> getAll();
    void delete(UUID id);
    void add(LotGiay lotGiay);
    LotGiay detail(UUID id);
    LotGiay update(UUID id,LotGiay lotGiay);
}
