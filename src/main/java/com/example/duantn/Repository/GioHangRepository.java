package com.example.duantn.Repository;

import com.example.duantn.Model.GioHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
    @Query(value = "select * from GioHang order by ngaySua desc", nativeQuery = true)
    public List<GioHang> getAll();

    // getAll
    @Query(value = "select * from GioHang order by ngaySua desc",
            countQuery = "select count(*) from GioHang", nativeQuery = true)
    public Page<GioHang> getAll(Pageable pageable);

    @Query(value = "select * from GioHang where concat(Ma, Ten) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from GioHang where concat(Ma, Ten) like %:textSearch% ",
            nativeQuery = true)
    public Page<GioHang> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from GioHang where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from GioHang where Ma =:textSearch ", nativeQuery = true)
    public List<GioHang> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from GioHang where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from GioHang where Ten =:textSearch ", nativeQuery = true)
    public List<GioHang> getAllTheoTen(@Param("textSearch") String textSearch);
}
