package com.example.duantn.Repository;

import com.example.duantn.Model.MauSac;
import com.example.duantn.Model.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, UUID> {
    @Query(value = "select * from ThuongHieu ", nativeQuery = true)
    public List<ThuongHieu> getAll();
}
