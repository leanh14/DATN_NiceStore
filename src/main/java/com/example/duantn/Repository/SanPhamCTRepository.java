package com.example.duantn.Repository;

import com.example.duantn.Model.SanPhamCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamCTRepository extends JpaRepository<SanPhamCT, UUID> {
    @Query(value = "select * from SanPhamCT ",nativeQuery = true)
    List<SanPhamCT> getAll();
}
