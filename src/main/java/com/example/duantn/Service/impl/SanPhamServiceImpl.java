package com.example.duantn.Service.impl;

import com.example.duantn.Model.SanPham;
import com.example.duantn.Model.SanPham;
import com.example.duantn.Repository.SanPhamRepository;
import com.example.duantn.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements BaseService<SanPham> {
    @Autowired
    SanPhamRepository sanPham_repo;

    @Override
    public List<SanPham> layDanhSach() {
        return sanPham_repo.getAll();
    }

    public Page<SanPham> layDanhSachVoiTrangThai_1(Pageable pageable) {
        return sanPham_repo.getAllWithStatus_1(pageable);
    }

    @Override
    public Page<SanPham> layDanhSach(Pageable pageable) {
        return  sanPham_repo.getAll(pageable);
    }

    @Override
    public Page<SanPham> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return sanPham_repo.getAll(textSearch, pageable);
        }
        return sanPham_repo.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        SanPham SanPhamXoa = sanPham_repo.findById(id).get();
        sanPham_repo.delete(SanPhamXoa);
    }

    @Override
    public void themMoi(SanPham entity) {
        sanPham_repo.save(entity);
    }

    @Override
    public SanPham capNhat(SanPham entity) {
        return sanPham_repo.save(entity);
    }

    @Override
    public SanPham chiTietTheoId(UUID id) {
        Optional<SanPham> SanPham = sanPham_repo.findById(id);
        SanPham SanPham1 = SanPham.get();
        return SanPham1;
    }

    @Override
    public List<SanPham> layDanhSachTheoTen(String ten) {
        return  sanPham_repo.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu){
        List<SanPham> dsSanPham = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(SanPham sanPham : dsSanPham){
            if(sanPham.getTen().equalsIgnoreCase(tenMoi.trim())){
                isCheck = true;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if(tenMoi.trim().equalsIgnoreCase(tenCu)){
            isCheck2 = false;
        }

        return isCheck&&isCheck2 ;
    }

    public Boolean kiemTraTrungTenKhong(String tenCheck){
        List<SanPham> dsSanPham = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(SanPham sanPham : dsSanPham){
            if(sanPham.getTen().equalsIgnoreCase(tenCheck.trim())){
                isCheck = true;
            }
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck){
        List<SanPham> dsSanPham = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(SanPham sanPham : dsSanPham){
            if(sanPham.getMa().equalsIgnoreCase(maCkeck.trim())){
                isCheck = true;
            }
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu){
        List<SanPham> dsSanPham = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(SanPham sanPham : dsSanPham){
            if(sanPham.getMa().equalsIgnoreCase(maMoi.trim())){
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
