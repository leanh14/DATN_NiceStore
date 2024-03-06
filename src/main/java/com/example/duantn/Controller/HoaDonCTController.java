package com.example.duantn.Controller;

import com.example.duantn.Model.HoaDonCT;
import com.example.duantn.Repository.HoaDonCTRepository;
import com.example.duantn.Service.HoaDonCtService;
import com.example.duantn.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/hoa-donct")
public class HoaDonCTController {
    @Autowired
    HoaDonCTRepository hoaDonCTRepository;
    @Autowired
    HoaDonCtService hoaDonCtService;
    @Autowired
    HoaDonService hoaDonService;

    //hienthi
    @GetMapping("/hien-thi")
    public String getAll(Model model,
                         @RequestParam(value = "page",defaultValue = "0")int page){
        Integer size = 5;
        Pageable pageable = PageRequest.of(page,size);
        model.addAttribute("hoaDonCT",new HoaDonCT());
        model.addAttribute("listHDCT",hoaDonCTRepository.findAll(pageable).getContent());
        model.addAttribute("totalPage",hoaDonCTRepository.findAll(pageable).getTotalElements());
        model.addAttribute("listHD",hoaDonService.getAll());
        return "admin/HoaDonCTForm/trangChu";
    }
    //detail
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id,Model model){
        HoaDonCT hoaDonCT = hoaDonCtService.detail(UUID.fromString(id));
        model.addAttribute("hoaDonCT",hoaDonCT);
        model.addAttribute("listHD",hoaDonService.getAll());
        return "admin/HoaDonCTForm/update";
    }
    //delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        hoaDonCtService.delete(UUID.fromString(id));
        return "redirect:/hoa-donct/hien-thi";
    }
    //add
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("hoaDonCT")HoaDonCT hoaDonCT){
        hoaDonCtService.add(hoaDonCT);
        return "redirect:/hoa-donct/hien-thi";
    }
    //update
    @PostMapping("/update/{id}")
    public String update(@PathVariable String id,@ModelAttribute("hoaDonCT")HoaDonCT hoaDonCT){
        hoaDonCtService.update(UUID.fromString(id),hoaDonCT);
        return "redirect:/hoa-donct/hien-thi";
    }
}
