package com.example.duantn.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "LotGiay")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LotGiay extends BaseModel {

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "MoTa")
    private String moTa;

}
