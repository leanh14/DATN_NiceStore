package com.example.duantn.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "KhachHang")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KhachHang extends BaseModel{
    @Column(name = "Ma")
    private String ma;
    @Column(name = "HoTen")
    private String ten;
}
