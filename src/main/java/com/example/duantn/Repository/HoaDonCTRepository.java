package com.example.duantn.Repository;

import com.example.duantn.Model.HoaDonCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonCTRepository extends JpaRepository<HoaDonCT, UUID> {
    @Query(value = "select * from HoaDonCT ",nativeQuery = true)
    List<HoaDonCT> getAll();
}
