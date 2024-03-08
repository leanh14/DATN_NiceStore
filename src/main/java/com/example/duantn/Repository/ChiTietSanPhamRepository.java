package com.example.duantn.Repository;

import com.example.duantn.Model.ChatLieu;
import com.example.duantn.Model.ChiTietSanPham;
import com.example.duantn.Model.KichCo;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, UUID> {
    @Query(value = "select * from ChiTietSanPham ", nativeQuery = true)
    public List<ChiTietSanPham> getAll();

    @Query(value = "select  * from SanPhamCT ",
            countQuery = "select  count(*) from SanPhamCT", nativeQuery = true)
    public Page<ChiTietSanPham> getAll( Pageable pageable);


    @Query(value = "select  * from SanPhamCT \n" +
            "inner join SanPham on SanPhamCT.IdSanPham = SanPham.Id\n" +
            "inner join DanhMuc on SanPhamCT.IdDanhMuc = DanhMuc.Id\n" +
            "inner join ThuongHieu on SanPhamCT.IdThuongHieu = ThuongHieu.Id\n" +
            "where Concat(SanPham.ten, DanhMuc.Ten, ThuongHieu.Ten) like %:textSearch%\n",
            countQuery = "select  count(*) from SanPhamCT \n" +
                    "inner join SanPham on SanPhamCT.IdSanPham = SanPham.Id\n" +
                    "inner join DanhMuc on SanPhamCT.IdDanhMuc = DanhMuc.Id\n" +
                    "inner join ThuongHieu on SanPhamCT.IdThuongHieu = ThuongHieu.Id\n" +
                    "where Concat(SanPham.ten, DanhMuc.Ten, ThuongHieu.Ten) like %:textSearch%\n",
            nativeQuery = true)
    public Page<ChiTietSanPham> getAll(@Param("textSearch") String textSearch, Pageable pageable);


    // @Modifying : cho spring biet day la truy van cap nhat/delete , bắt buộc có @Transctional
    @Transactional
    @Modifying
    @Query(value = "UPDATE SanPhamCT " +
            "SET SoLuong = SoLuong - :soLuongMua " +
            "WHERE ID = :idSanPhamCT", nativeQuery = true)
    public void updateSoLuong(@Param("soLuongMua") Integer soLuongMua, @Param("idSanPhamCT") UUID idSanPhamCT);

}
