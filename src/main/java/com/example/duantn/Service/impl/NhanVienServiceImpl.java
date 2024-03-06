package com.example.duantn.Service.impl;

import com.example.duantn.Model.NhanVien;
import com.example.duantn.Model.NhanVien;
import com.example.duantn.Repository.NhanVienRepository;
import com.example.duantn.Repository.NhanVienRepository;
import com.example.duantn.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements BaseService<NhanVien> {
    @Autowired
    NhanVienRepository repo_nhanVien;

    @Override
    public List<NhanVien> layDanhSach() {
        return repo_nhanVien.getAll();
    }

    @Override
    public Page<NhanVien> layDanhSach(Pageable pageable) {
        return  repo_nhanVien.getAll(pageable);
    }

    @Override
    public Page<NhanVien> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return repo_nhanVien.getAll(textSearch, pageable);
        }
        return repo_nhanVien.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        NhanVien NhanVienXoa = repo_nhanVien.findById(id).get();
        repo_nhanVien.delete(NhanVienXoa);
    }

    @Override
    public void themMoi(NhanVien entity) {
        if(entity!=null){
            repo_nhanVien.save(entity);
        }
    }

    @Override
    public NhanVien capNhat(NhanVien entity) {
        if(entity!=null){
            return repo_nhanVien.save(entity);
        }
        return null;
    }

    @Override
    public NhanVien chiTietTheoId(UUID id) {
        Optional<NhanVien> NhanVien = repo_nhanVien.findById(id);
        NhanVien NhanVien1 = NhanVien.get();
        return NhanVien1;
    }

    @Override
    public List<NhanVien> layDanhSachTheoTen(String ten) {
        return  repo_nhanVien.getAllTheoTen(ten);
    }


    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu){
        List<NhanVien> dsNhanVien = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(NhanVien nhanVien : dsNhanVien){
            if(nhanVien.getHoVaTen().equalsIgnoreCase(tenMoi.trim())){
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
        List<NhanVien> dsNhanVien = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(NhanVien nhanVien : dsNhanVien){
            if(nhanVien.getHoVaTen().equalsIgnoreCase(tenCheck.trim())){
                isCheck = true;
                break;
            }
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck){
        List<NhanVien> dsnhanVien = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(NhanVien nhanVien : dsnhanVien){
            if(nhanVien.getMa().equalsIgnoreCase(maCkeck.trim())){
                isCheck = true;
            }
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu){
        List<NhanVien> dsnhanVien = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(NhanVien nhanVien : dsnhanVien){
            if(nhanVien.getMa().equalsIgnoreCase(maMoi.trim())){
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
