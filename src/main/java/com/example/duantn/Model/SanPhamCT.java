package com.example.duantn.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "SanPhamCT")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SanPhamCT extends BaseModel {
    @Column(name = "Ma")
    private String ma;
}
