package com.example.duantn.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonRequest {
    private UUID id;

    @NotBlank(message = "{hoaDon.datHang.hoVaTen.notblank}")
    private String hoVaTen;

    @NotBlank(message = "{hoaDon.datHang.soDT.notblank}")
    private String soDT;

    @NotBlank(message = "{hoaDon.datHang.email.notblank}")
    private String email;

    @NotBlank(message = "{hoaDon.datHang.diaChi.notblank}")
    private String diaChi;

    private String ghiChu;


}
