package com.example.duantn.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "GioHangCT")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GioHangCT extends BaseModel {
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSanPhamCT", referencedColumnName = "Id")
    private SanPhamCT sanPhamCT;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdGioHang", referencedColumnName = "Id")
    private GioHang gioHang;
    @Column(name = "DonGia")
    private Float donGia;
    @Column(name = "SoLuong")
    private Integer soLuong;


}
