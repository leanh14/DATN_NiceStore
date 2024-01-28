package com.example.duantn.Controller;

import com.example.duantn.Model.SanPhamCT;
import com.example.duantn.Repository.SanPhamCTRepository;
import com.example.duantn.Service.KieuDangService;
import com.example.duantn.Service.LotGiayService;
import com.example.duantn.Service.SanPhamCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/san-phamct")
public class SanPhamCTController {
    @Autowired
    SanPhamCTRepository sanPhamCTRepository;
    @Autowired
    SanPhamCTService sanPhamCTService;
    @Autowired
    LotGiayService lotGiayService;
    @Autowired
    KieuDangService kieuDangService;

    //hienthi
    @GetMapping("/hien-thi")
    public String getAll(Model model,
                         @RequestParam(value = "page",defaultValue = "0")int page){
        Integer size = 5;
        Pageable pageable = PageRequest.of(page,size);
        model.addAttribute("sanPhamCT",new SanPhamCT());
        model.addAttribute("listSPCT",sanPhamCTRepository.findAll(pageable).getContent());
        model.addAttribute("totalPage",sanPhamCTRepository.findAll(pageable).getTotalElements());
        model.addAttribute("listKD",kieuDangService.getAll());
        model.addAttribute("listLG",lotGiayService.getAll());
        return "SanPhamCTForm/trangChu";
    }
    //detail
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id,Model model){
        SanPhamCT sanPhamCT = sanPhamCTService.detail(UUID.fromString(id));
        model.addAttribute("sanPhamCT",sanPhamCT);
        model.addAttribute("listKD",kieuDangService.getAll());
        model.addAttribute("listLG",lotGiayService.getAll());
        return "SanPhamCTForm/update";
    }
    //delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        sanPhamCTService.delete(UUID.fromString(id));
        return "redirect:/san-phamct/hien-thi";
    }
    //add
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("sanPhamCT")SanPhamCT sanPhamCT){
        sanPhamCTService.add(sanPhamCT);
        return "redirect:/san-phamct/hien-thi";
    }
    //update
    @PostMapping("/update/{id}")
    public String update(@PathVariable String id,@ModelAttribute("sanPhamCT")SanPhamCT sanPhamCT){
        sanPhamCTService.update(UUID.fromString(id),sanPhamCT);
        return "redirect:/san-phamct/hien-thi";

    }
}
