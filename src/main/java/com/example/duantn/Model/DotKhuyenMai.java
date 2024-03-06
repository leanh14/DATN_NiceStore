package com.example.duantn.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "DotKhuyenMai")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DotKhuyenMai extends BaseModel{

    @Column(name = "Ma")
    private String ma;

    @Column(name = "tenDotKhuyenMai")
    private String tenDotKhuyenMai;

    @Column(name = "GiaTriGiam")
    private Double giaTriGiam;

    @Column(name = "NgayBatDau")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;

}
