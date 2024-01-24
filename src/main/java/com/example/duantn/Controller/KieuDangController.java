package com.example.duantn.Controller;

import com.example.duantn.Model.KieuDang;
import com.example.duantn.Repository.KieuDangRepository;
import com.example.duantn.Service.KieuDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/kieu-dang")
public class KieuDangController {
    @Autowired
    KieuDangRepository kieuDangRepository;
    @Autowired
    KieuDangService kieuDangService;

    //hienthi
    @GetMapping("/hien-thi")
    public String getAll(Model model,
                         @RequestParam(value = "page",defaultValue = "0")int page){
        Integer size = 5;
        Pageable pageable = PageRequest.of(page,size);
        model.addAttribute("kieuDang",new KieuDang());
        model.addAttribute("listKD",kieuDangRepository.findAll(pageable).getContent());
        model.addAttribute("totalPage",kieuDangRepository.findAll(pageable).getTotalElements());
        return"/KieuDangForm/trangChu";
    }
    //detail
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id,Model model){
        KieuDang kieuDang = kieuDangService.detail(UUID.fromString(id));
        model.addAttribute("kieuDang",kieuDang);
        return "/KieuDangForm/update";
    }
    //delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        kieuDangService.delete(UUID.fromString(id));
        return "redirect:/kieu-dang/hien-thi";
    }
    //add
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("kieuDang")KieuDang kieuDang){
        kieuDangService.add(kieuDang);
        return "redirect:/kieu-dang/hien-thi";
    }
    //update
    @PostMapping("/update/{id}")
    public String update(@PathVariable String id,@ModelAttribute("kieuDang")KieuDang kieuDang){
        kieuDangService.update(UUID.fromString(id),kieuDang);
        return "redirect:/kieu-dang/hien-thi";
    }
}
