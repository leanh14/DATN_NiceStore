package com.example.duantn.Request;

import com.example.duantn.Model.KichCo;
import com.example.duantn.Model.MauSac;
import com.example.duantn.Model.SanPham;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamTrongGioHang {
    private UUID idSanPhamCT;
    private SanPham sanPham;
    private KichCo kichCo;
    private MauSac mauSac;
    private String hinhAnh;
    private Integer soLuong;
    private Double gia;
    private Integer numberCheck;

    // hàm tính thành tiền của sản phẩm
    public Double tongTien() {
        if(this.gia==null || this.soLuong==null) {
            return 0.0;
        }
        return this.soLuong*this.gia;
    }
}
