package com.example.duantn.Service.impl;

import com.example.duantn.Model.ChiTietSanPham;
import com.example.duantn.Model.KichCo;
import com.example.duantn.Repository.ChiTietSanPhamRepository;
import com.example.duantn.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSPServiceImpl implements BaseService<ChiTietSanPham> {
    @Autowired
    ChiTietSanPhamRepository repo_chiTietSanPham;

    @Override
    public List<ChiTietSanPham> layDanhSach() {
        return repo_chiTietSanPham.getAll();
    }

    @Override
    public Page<ChiTietSanPham> layDanhSach(Pageable pageable) {
        return repo_chiTietSanPham.getAll(pageable);
    }

    @Override
    public Page<ChiTietSanPham> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return repo_chiTietSanPham.getAll(textSearch, pageable);
        }

        return repo_chiTietSanPham.getAll(pageable);
    }

    @Override
    public void xoa(UUID id) {

    }

    @Override
    public void themMoi(ChiTietSanPham entity) {

    }

    @Override
    public ChiTietSanPham capNhat(ChiTietSanPham entity) {
        return null;
    }

    @Override
    public ChiTietSanPham chiTietTheoId(UUID id) {
        Optional<ChiTietSanPham> chiTietSanPham = repo_chiTietSanPham.findById(id);
        ChiTietSanPham chiTietSanPham1 = chiTietSanPham.get();
        return chiTietSanPham1;
    }

    @Override
    public List<ChiTietSanPham> layDanhSachTheoTen(String ten) {
        return null;
    }

    public void capNhatSoLuongSauKhiDatHang(Integer soLuongMua, UUID idChiTietSP) {
        repo_chiTietSanPham.updateSoLuong(soLuongMua, idChiTietSP);
    }
}
