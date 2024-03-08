package com.example.duantn.Repository;

import com.example.duantn.Model.KichCo;
import com.example.duantn.Model.SanPham;
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
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    @Query(value = "select * from SanPham order by ngaySua desc", nativeQuery = true)
    public List<SanPham> getAll();

    @Query(value = "select * from SanPham WHERE trangThai=1",
            countQuery = "select count(*) from SanPham WHERE trangThai=1", nativeQuery = true)
    public Page<SanPham> getAllWithStatus_1(Pageable pageable);

    // getAll
    @Query(value = "select * from SanPham order by ngaySua desc",
            countQuery = "select count(*) from SanPham", nativeQuery = true)
    public Page<SanPham> getAll(Pageable pageable);

    @Query(value = "select * from SanPham where concat(Ten, MoTa) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from SanPham where concat(Ten, MoTa) like %:textSearch% ",
            nativeQuery = true)
    public Page<SanPham> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select Ten from SanPham where Ten =:textSearch  order by ngaySua desc",
            countQuery = "select count(Ten) from SanPham where Ten =:textSearch ", nativeQuery = true)
    public List<SanPham> getAllTheoTen(@Param("textSearch") String textSearch);

    @Query(value = "select * from SanPham where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from SanPham where Ma =:textSearch ", nativeQuery = true)
    public List<SanPham> getAllTheoMa(@Param("textSearch") String textSearch);

}
