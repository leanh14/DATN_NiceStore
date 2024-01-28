package com.example.duantn.Repository;

import com.example.duantn.Model.LotGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LotGiayRepository extends JpaRepository<LotGiay, UUID> {
    @Query(value = "select * from LotGiay ",nativeQuery = true)
    List<LotGiay> getAll();
}
