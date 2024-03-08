package com.example.duantn.Repository;

import com.example.duantn.Model.GioHang;
import com.example.duantn.Model.GioHangCT;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangCTRepository extends JpaRepository<GioHangCT, UUID> {
    @Query(value = "select * from GioHangCT order by ngaySua desc", nativeQuery = true)
    public List<GioHangCT> getAll();

    // getAll
    @Query(value = "select * from GioHangCT order by ngaySua desc",
            countQuery = "select count(*) from GioHangCT", nativeQuery = true)
    public Page<GioHangCT> getAll(Pageable pageable);

    @Query(value = "select * from GioHangCT where concat(Ma, Ten) like %:textSearch%  order by ngaySua desc",
            countQuery = "select count(*) from GioHangCT where concat(Ma, Ten) like %:textSearch% ",
            nativeQuery = true)
    public Page<GioHangCT> getAll(@Param("textSearch") String textSearch, Pageable pageable);

    @Query(value = "select * from GioHangCT where Ma =:textSearch  order by ten desc",
            countQuery = "select count(*) from GioHangCT where Ma =:textSearch ", nativeQuery = true)
    public List<GioHangCT> getAllTheoMa(@Param("textSearch") String textSearch);

    @Query(value = "select * from GioHangCT where Ten =:textSearch  order by ten desc",
            countQuery = "select count(*) from GioHangCT where Ten =:textSearch ", nativeQuery = true)
    public List<GioHangCT> getAllTheoTen(@Param("textSearch") String textSearch);
}
