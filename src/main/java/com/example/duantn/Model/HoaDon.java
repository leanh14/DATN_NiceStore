package com.example.duantn.Model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Table(name="HoaDon")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdPhieuGiamGia")
    private PhieuGiamGia phieuGiamGia;

    private String ma;
    private Date ngayMua;
    private Date ngayNhan;
    private Date ngayGiao;
    private Date ngayThanhToan;
    private Float tongTienThanhToan;
    private Float tienVanChuyen;
    private Float tongTienGiamGia;
    private String tenKH;
    private String diaChi;
    private String soDT;
    private String ghiChu;
    private  String hinhThucTT;
    private Integer trangThai;
}
