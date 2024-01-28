package com.example.duantn.Model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Table(name="PhieuGiamGia")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class PhieuGiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String ma;
    private String tenPhieu;
    private Float giaTriGiam;
    private String hinhThucGiam;
    private String dieuKienGiam;
    private Float  giaTienXetDieuKien;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Date ngayTao;
    private Date ngaySua;
    private String nguoiTao;
    private String nguoiSua;
    private Integer trangThai;
}
