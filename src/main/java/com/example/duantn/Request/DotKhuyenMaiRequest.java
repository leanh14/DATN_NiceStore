package com.example.duantn.Request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DotKhuyenMaiRequest {
    private UUID id;

    @NotBlank(message = "{dotKhuyenMai.ma.notblank}")
    private String ma;

    @NotBlank(message = "{dotKhuyenMai.tenDotKhuyenMai.notblank}")
    private String tenDotKhuyenMai;

    @NotNull(message = "{dotKhuyenMai.giaTriGiam.notnull}")
    private Double giaTriGiam;

    @NotNull(message = "{dotKhuyenMai.ngayBatDau.notnull}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDau;

    @NotNull(message = "{dotKhuyenMai.ngayKetThuc.notnull}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKetThuc;

    @NotNull(message = "{dotKhuyenMai.trangThai.notnull}")
    private Integer trangThai;
}
