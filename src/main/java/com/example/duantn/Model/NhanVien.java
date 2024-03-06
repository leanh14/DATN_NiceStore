package com.example.duantn.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.UUID;

@Table(name = "NhanVien")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NhanVien extends BaseModel {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChucVu",referencedColumnName = "Id")
    private ChucVu chucVu;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "HoTen")
    private String hoVaTen;

    @Column(name = "TaiKhoan")
    private String taiKhoan;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "Email")
    private String email;

    @Column(name = "diaChi")
    private String diaChi;


}
