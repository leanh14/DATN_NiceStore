package com.example.duantn.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Table(name = "KichThuoc")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KichCo extends BaseModel{

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "MoTa")
    private String moTa;

}
