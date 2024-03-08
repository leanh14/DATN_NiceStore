package com.example.duantn.Repository;

import com.example.duantn.Model.DotKhuyenMai;
import com.example.duantn.Model.DotKhuyenMai;
import com.example.duantn.Model.KichCo;
import com.example.duantn.Model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DotKhuyenMaiRepository extends JpaRepository<DotKhuyenMai, UUID> {
    @Query(value = "select * from DotKhuyenMai order by ngaySua desc", nativeQuery = true)
    public List<DotKhuyenMai> getAll();

    @Query(value = "select * from DotKhuyenMai where trangThai = 1", nativeQuery = true)
    public List<DotKhuyenMai> getAllWithStatus_1();



    // getAll
    @Query(value = "select * from DotKhuyenMai order by ngaySua desc",
            countQuery = "select count(*) from DotKhuyenMai", nativeQuery = true)
    public Page<DotKhuyenMai> getAll(Pageable pageable);

    @Query(value = "select * from DotKhuyenMai where concat(tenDotKhuyenMai, ma) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from DotKhuyenMai where concat(tenDotKhuyenMai, ma) like %:textSearch% ",
            nativeQuery = true)
    public Page<DotKhuyenMai> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select tenDotKhuyenMai from DotKhuyenMai where tenDotKhuyenMai =:textSearch  order by ngaySua desc",
            countQuery = "select count(tenDotKhuyenMai) from DotKhuyenMai where tenDotKhuyenMai =:textSearch ", nativeQuery = true)
    public List<DotKhuyenMai> getAllTheoTen(@Param("textSearch") String textSearch);

    @Query(value = "select * from DotKhuyenMai where Ma =:textSearch ",
            countQuery = "select count(*) from DotKhuyenMai where Ma =:textSearch ", nativeQuery = true)
    public List<DotKhuyenMai> getAllTheoMa(@Param("textSearch") String textSearch);
}
