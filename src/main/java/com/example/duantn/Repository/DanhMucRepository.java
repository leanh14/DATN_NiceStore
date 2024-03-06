package com.example.duantn.Repository;

import com.example.duantn.Model.ChatLieu;
import com.example.duantn.Model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, UUID> {
    @Query(value = "select * from DanhMuc", nativeQuery = true)
    public List<DanhMuc> getAll();
}
