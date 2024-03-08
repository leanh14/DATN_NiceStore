package com.example.duantn.Service.impl;

import com.example.duantn.Model.GioHang;
import com.example.duantn.Repository.GioHangRepository;
import com.example.duantn.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class GioHangServiceImpl implements BaseService<GioHang> {
    @Autowired
    GioHangRepository gioHangRepository;
    @Override
    public List<GioHang> layDanhSach() {
        return gioHangRepository.getAll();
    }

    @Override
    public Page<GioHang> layDanhSach(Pageable pageable) {
        return gioHangRepository.getAll(pageable);
    }

    @Override
    public Page<GioHang> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return gioHangRepository.getAll(textSearch, pageable);
        }
        return gioHangRepository.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        GioHang gioHangXoa = gioHangRepository.findById(id).get();
        gioHangRepository.delete(gioHangXoa);
    }

    @Override
    public void themMoi(GioHang entity) {
        if(entity!=null){
            gioHangRepository.save(entity);
        }
    }

    @Override
    public GioHang capNhat(GioHang entity) {
        if(entity!=null){
            return gioHangRepository.save(entity);
        }
        return null;
    }

    @Override
    public GioHang chiTietTheoId(UUID id) {
        Optional<GioHang> gioHang = gioHangRepository.findById(id);
        GioHang gioHang1 = gioHang.get();
        return gioHang1;
    }

    @Override
    public List<GioHang> layDanhSachTheoTen(String ten) {
        return  gioHangRepository.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu){
        List<GioHang> dsGioHang = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(GioHang gioHang : dsGioHang){
            if(gioHang.getTen().equalsIgnoreCase(tenMoi.trim())){
                isCheck = true;
                break;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if(tenMoi.trim().equalsIgnoreCase(tenCu)){
            isCheck2 = false;
        }

        return isCheck&&isCheck2 ;
    }

    public Boolean kiemTraTrungTenKhong(String tenCheck){
        List<GioHang> dsGioHang = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(GioHang gioHang : dsGioHang){
            if(gioHang.getTen().equalsIgnoreCase(tenCheck.trim())){
                isCheck = true;
                break;
            }
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck){
        List<GioHang> dsGioHang = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(GioHang gioHang : dsGioHang){
            if(gioHang.getMa().equalsIgnoreCase(maCkeck.trim())){
                isCheck = true;
            }
        }
        return isCheck ;
    }
    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu){
        List<GioHang> dsGioHang = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(GioHang gioHang : dsGioHang){
            if(gioHang.getMa().equalsIgnoreCase(maMoi.trim())){
                isCheck = true;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if(maMoi.trim().equalsIgnoreCase(maCu)){
            isCheck2 = false;
        }

        return isCheck&&isCheck2 ;
    }
}
