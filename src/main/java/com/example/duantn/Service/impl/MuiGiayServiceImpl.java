package com.example.duantn.Service.impl;

import com.example.duantn.Model.KichCo;
import com.example.duantn.Model.MuiGiay;
import com.example.duantn.Repository.MuiGiayRepository;
import com.example.duantn.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MuiGiayServiceImpl implements BaseService<MuiGiay> {

    @Autowired
    MuiGiayRepository muiGiay_repo;

    @Override
    public List<MuiGiay> layDanhSach() {
        return muiGiay_repo.getAll();
    }

    @Override
    public Page<MuiGiay> layDanhSach(Pageable pageable) {
        return  muiGiay_repo.getAll(pageable);
    }

    @Override
    public Page<MuiGiay> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            System.out.println("Chạy vào đây");
            return muiGiay_repo.getAll(textSearch, pageable);
        }

        return muiGiay_repo.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        MuiGiay muiGiayXoa = muiGiay_repo.findById(id).get();
        muiGiay_repo.delete(muiGiayXoa);
    }

    @Override
    public void themMoi(MuiGiay entity) {
        muiGiay_repo.save(entity);
    }

    @Override
    public MuiGiay capNhat(MuiGiay entity) {
        return muiGiay_repo.save(entity);
    }

    @Override
    public MuiGiay chiTietTheoId(UUID id) {
        Optional<MuiGiay> muiGiay = muiGiay_repo.findById(id);
        MuiGiay muiGiay1 = muiGiay.get();
        return muiGiay1;
    }

    @Override
    public List<MuiGiay> layDanhSachTheoTen(String ten) {
        return  muiGiay_repo.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu){
        List<MuiGiay> dsMuiGiay = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(MuiGiay muiGiay : dsMuiGiay){
            if(muiGiay.getTen().equalsIgnoreCase(tenMoi.trim())){
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
        List<MuiGiay> dsMuiGiay = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(MuiGiay muiGiay : dsMuiGiay){
            if(muiGiay.getTen().equalsIgnoreCase(tenCheck.trim())){
                isCheck = true;
                break;
            }
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck){
        List<MuiGiay> dsMuiGiay = muiGiay_repo.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if(dsMuiGiay.size()>0){
            isCheck = true;
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu){
        List<MuiGiay> dsMuiGiay = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        for(MuiGiay muiGiay : dsMuiGiay){
            if(muiGiay.getMa().equalsIgnoreCase(maMoi.trim())){
                isCheck = true;
                break;
            }
        }

        // kiem tra xem ma moi co bang ma cu khong
        if(maMoi.trim().equalsIgnoreCase(maCu)){
            isCheck2 = false;
        }

        return isCheck&&isCheck2 ;
    }



}
