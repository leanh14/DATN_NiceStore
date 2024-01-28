package com.example.duantn.Repository;

import com.example.duantn.Model.PhieuGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhieuGiamGiaRepository extends JpaRepository<PhieuGiamGia, UUID> {
    @Query(value = "select * from PhieuGiamGia ",nativeQuery = true)
    List<PhieuGiamGia>getAll();
}
