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
        return null;
    }
}
