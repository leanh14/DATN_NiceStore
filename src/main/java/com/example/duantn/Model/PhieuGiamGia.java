package com.example.duantn.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "PhieuGiamGia")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PhieuGiamGia extends BaseModel{

    @Column(name = "Ma")
    private String ma;

    @Column(name = "TenPhieu")
    private String ten;

    @Column(name = "GiaTriGiam")
    private Double giaTriGiam;

    @Column(name = "HinhThucGiam")
    private String HinhThucGiam;

    @Column(name = "DieuKienGiam")
    private String DieuKienGiam;

    @Column(name = "GiaTienXetDieuKien")
    private Double giaTienXetDieuKien;

}
