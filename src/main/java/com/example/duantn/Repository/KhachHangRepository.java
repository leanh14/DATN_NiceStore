package com.example.duantn.Repository;

import com.example.duantn.Model.ChucVu;
import com.example.duantn.Model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID>{
    @Query(value = "select * from KhachHang order by ngaySua desc", nativeQuery = true)
    public List<KhachHang> getAll();

    // getAll
    @Query(value = "select * from KhachHang order by ngaySua desc",
            countQuery = "select count(*) from KhachHang", nativeQuery = true)
    public Page<KhachHang> getAll(Pageable pageable);

    @Query(value = "select * from KhachHang where concat(ten, ma) like %:textSearch%  order by ten desc",
            countQuery = "select count(*) from KhachHang where concat(ten, ma) like %:textSearch% ",
            nativeQuery = true)
    public Page<KhachHang> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select HoTen from KhachHang where HoTen =:textSearch  order by ten desc",
            countQuery = "select count(HoTen) from KhachHang where HoTen =:textSearch ", nativeQuery = true)
    public List<KhachHang> getAllTheoTen(@Param("textSearch") String textSearch);

}
