package com.example.duantn.Repository;

import com.example.duantn.Model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query(value = "select * from HoaDon ",nativeQuery = true)
    List<HoaDon>getAll();
}
