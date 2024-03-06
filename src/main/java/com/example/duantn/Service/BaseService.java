package com.example.duantn.Service;

import com.example.duantn.Model.BaseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface BaseService <E extends BaseModel>{
    List<E> layDanhSach() ;
    
    Page<E> layDanhSach(Pageable pageable) ;

    Page<E> layDanhSach(String textSearch, Pageable pageable) ;

    void xoa(UUID id) ;

    void themMoi(E entity);

    E capNhat( E entity) ;

    E chiTietTheoId(UUID id) ;

    List<E> layDanhSachTheoTen(String ten);
}
