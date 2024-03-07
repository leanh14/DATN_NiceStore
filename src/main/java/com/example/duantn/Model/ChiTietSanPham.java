package com.example.duantn.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "SanPhamCT")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChiTietSanPham extends BaseModel{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDotKhuyenMai",referencedColumnName = "Id")
    private DotKhuyenMai dotKhuyenMai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSanPham",referencedColumnName = "Id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDanhMuc",referencedColumnName = "Id")
    private DanhMuc danhMuc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKieuDang",referencedColumnName = "Id")
    private KieuDang kieuDang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdThuongHieu",referencedColumnName = "Id")
    private ThuongHieu thuongHieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMuiGiay",referencedColumnName = "Id")
    private MuiGiay muiGiay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDeGiay",referencedColumnName = "Id")
    private DeGiay deGiay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdLotGiay",referencedColumnName = "Id")
    private LotGiay lotGiay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDayGiay",referencedColumnName = "Id")
    private DayGiay dayGiay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKichThuoc",referencedColumnName = "Id")
    private KichCo kichCo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChatLieu",referencedColumnName = "Id")
    private ChatLieu chatLieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac",referencedColumnName = "Id")
    private MauSac mauSac;

    @Column(name = "GiaTriSanPham")
    private Double giaTriSanPham;

    @Column(name = "GiaTriGiam")
    private Double giaTriGiam;


    @Column(name = "KhoiLuong")
    private Double khoiLuong;


    @Column(name = "NgayHetGiamGia")
    private Date ngayHetGiamGia;


    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "HinhAnh")
    private String HinhAnh;

}
