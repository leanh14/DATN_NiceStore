package com.example.duantn.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "GioHang")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GioHang extends BaseModel{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhachHang", referencedColumnName = "Id")
    private KhachHang khachHang;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
}
