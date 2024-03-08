package com.example.duantn.Service.impl;

import com.example.duantn.Model.ChatLieu;
import com.example.duantn.Model.KichCo;
import com.example.duantn.Repository.ChatLieuRepository;
import com.example.duantn.Service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatLieuServiceImpl implements BaseService<ChatLieu> {
    @Autowired
    ChatLieuRepository repo_chatLieu;


    @Override
    public List<ChatLieu> layDanhSach() {
        return repo_chatLieu.getAll();
    }

    @Override
    public Page<ChatLieu> layDanhSach(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ChatLieu> layDanhSach(String textSearch, Pageable pageable) {
        return null;
    }

    @Override
    public void xoa(UUID id) {

    }

    @Override
    public void themMoi(ChatLieu entity) {

    }

    @Override
    public ChatLieu capNhat(ChatLieu entity) {
        return null;
    }

    @Override
    public ChatLieu chiTietTheoId(UUID id) {
        return null;
    }

    @Override
    public List<ChatLieu> layDanhSachTheoTen(String ten) {
        return repo_chatLieu.getAllTheoTen(ten);
    }

    public Boolean kiemTraTrungTenKhong(String tenMoi, String tenCu) {
        List<ChatLieu> dsChatLieu = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (ChatLieu chatLieu : dsChatLieu) {
            if (chatLieu.getTen().equalsIgnoreCase(tenMoi.trim())) {
                isCheck = true;
            }
        }

        // kiem tra xem ten moi co bang ten cu khong
        if (tenMoi.trim().equalsIgnoreCase(tenCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }

    public Boolean kiemTraTrungTenKhong(String tenCheck) {
        List<ChatLieu> dsChatLieu = this.layDanhSach();
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        for (ChatLieu chatLieu : dsChatLieu) {
            if (chatLieu.getTen().equalsIgnoreCase(tenCheck.trim())) {
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maCkeck) {
        List<ChatLieu> dsChatLieu = repo_chatLieu.getAllTheoMa(maCkeck);
        Boolean isCheck = false;

        // kiem tra xem ten moi co trung voi cac ten khac khong
        if (dsChatLieu.size() > 0) {
            isCheck = true;
        }
        return isCheck;
    }

    public Boolean kiemTraTrungMaKhong(String maMoi, String maCu) {
        List<ChatLieu> dsChatLieu = this.layDanhSach();
        Boolean isCheck = false;
        Boolean isCheck2 = true;

        // kiem tra xem ma moi co trung voi cac ma khac khong
        for (ChatLieu chatLieu : dsChatLieu) {
            if (chatLieu.getMa().equalsIgnoreCase(maMoi.trim())) {
                isCheck = true;
                break;
            }
        }

        // kiem tra xem ma moi co bang ma cu khong
        if (maMoi.trim().equalsIgnoreCase(maCu)) {
            isCheck2 = false;
        }

        return isCheck && isCheck2;
    }

}
