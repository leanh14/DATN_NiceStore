package com.example.duantn.Model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Table(name = "SanPhamCT")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class SanPhamCT {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdKieuDang")
    private KieuDang kieuDang;
    @ManyToOne
    @JoinColumn(name = "IdLotGiay")
    private LotGiay lotGiay;

    private String giaTriSanPham;
    private String giaTriGiam;
    private Float khoiLuong;
    private Date ngayHetGiamGia;
    private String moTa;
    private Integer soLuong;
    private String hinhAnh;
    private Date ngayTao;
    private Date ngaySua;
    private String nguoiTao;
    private String nguoiSua;
    private Integer trangThai;
}
