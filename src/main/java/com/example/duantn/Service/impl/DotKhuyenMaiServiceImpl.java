package com.example.duantn.Service.impl;

import com.example.duantn.Model.DotKhuyenMai;
import com.example.duantn.Repository.DotKhuyenMaiRepository;
import com.example.duantn.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DotKhuyenMaiServiceImpl implements BaseService<DotKhuyenMai> {
    @Autowired
    DotKhuyenMaiRepository dotKhuyenMai_repo;

    @Override
    public List<DotKhuyenMai> layDanhSach() {
        return dotKhuyenMai_repo.getAll();
    }

    public List<DotKhuyenMai> layDanhSachVoiTrangThai_1() {
        return dotKhuyenMai_repo.getAll();
    }


    @Override
    public Page<DotKhuyenMai> layDanhSach(Pageable pageable) {
        return dotKhuyenMai_repo.getAll(pageable);
    }

    @Override
    public Page<DotKhuyenMai> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
//            System.out.println("Chạy vào đây");
            return dotKhuyenMai_repo.getAll(textSearch, pageable);
        }
        return dotKhuyenMai_repo.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {
        DotKhuyenMai dotKhuyenMai = dotKhuyenMai_repo.getReferenceById(id);
        dotKhuyenMai_repo.delete(dotKhuyenMai);
    }

    @Override
    public void themMoi(DotKhuyenMai entity) {
        if(entity!=null){
            dotKhuyenMai_repo.save(entity);
        }
    }

    @Override
    public DotKhuyenMai capNhat(DotKhuyenMai entity) {
        if(entity!=null){
            return dotKhuyenMai_repo.save(entity);
        }
        return null;
    }

    @Override
    public DotKhuyenMai chiTietTheoId(UUID id) {
        Optional<DotKhuyenMai> dotKhuyenMai = dotKhuyenMai_repo.findById(id);
        return dotKhuyenMai.get();
    }

    @Override
    public List<DotKhuyenMai> layDanhSachTheoTen(String ten) {
        return dotKhuyenMai_repo.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu){
        List<DotKhuyenMai> dsDotKhuyenMai = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(DotKhuyenMai kichThuoc : dsDotKhuyenMai){
            if(kichThuoc.getTenDotKhuyenMai().equalsIgnoreCase(tenMoi.trim())){
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
        List<DotKhuyenMai> dsDotKhuyenMai = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for(DotKhuyenMai kichThuoc : dsDotKhuyenMai){
            if(kichThuoc.getTenDotKhuyenMai().equalsIgnoreCase(tenCheck.trim())){
                isCheck = true;
            }
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck){
        List<DotKhuyenMai> dsdotKhuyenMai = dotKhuyenMai_repo.getAllTheoMa(maCkeck);
//        System.out.println("dsKich co co size : " + dsdotKhuyenMai.size());
//        System.out.println("Mã check trùng : " + maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if(dsdotKhuyenMai.size()>0){
            isCheck = true;
        }
        return isCheck ;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu){
//        System.out.println("Chạy vào function kiemTraTrungMa ");
        List<DotKhuyenMai> dsDotKhuyenMai = this.layDanhSach();
//        System.out.println("size of ds DotKhuyenMai = " + dsDotKhuyenMai.size());
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ten khac khong
        for(DotKhuyenMai dotKhuyenMai : dsDotKhuyenMai){
//            System.out.println("dot khuyen mai database : " + dotKhuyenMai.getMa());
//            System.out.println("dot khuyen mai check : " + maMoi);
            if(dotKhuyenMai.getMa().equalsIgnoreCase(maMoi.trim())){
                isCheck = true;
                break;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if(maMoi.trim().equalsIgnoreCase(maCu)){
            isCheck2 = false;
        }
//        System.out.println("is check : " + isCheck);
//        System.out.println("is check 2 : " + isCheck);

        return isCheck&&isCheck2 ;
    }

}
