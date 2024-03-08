package com.example.duantn.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Table(name = "MuiGiay")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MuiGiay extends BaseModel{

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "MoTa")
    private String moTa;

}
