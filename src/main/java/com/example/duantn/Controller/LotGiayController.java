package com.example.duantn.Controller;

import com.example.duantn.Model.LotGiay;
import com.example.duantn.Repository.LotGiayRepository;
import com.example.duantn.Service.LotGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/lot-giay")
public class LotGiayController {
    @Autowired
    LotGiayRepository lotGiayRepository;
    @Autowired
    LotGiayService lotGiayService;

    //hienthi
    @GetMapping("/hien-thi")
    public String getAll(Model model,
                         @RequestParam(value = "page",defaultValue = "0")int page){
        Integer size = 5;
        Pageable pageable = PageRequest.of(page,size);
        model.addAttribute("lotGiay",new LotGiay());
        model.addAttribute("listLG",lotGiayRepository.findAll(pageable).getContent());
        model.addAttribute("totalPage",lotGiayRepository.findAll(pageable).getTotalElements());
        return "/LotGiayForm/trangChu";
    }
    //detail
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id,Model model){
        LotGiay lotGiay = lotGiayService.detail(UUID.fromString(id));
        model.addAttribute("lotGiay",lotGiay);
        return "/LotGiayForm/update";
    }
    //delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        lotGiayService.delete(UUID.fromString(id));
        return "redirect:/lot-giay/hien-thi";
    }
    //add
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("lotGiay")LotGiay lotGiay){
        lotGiayService.add(lotGiay);
        return "redirect:/lot-giay/hien-thi";
    }
    //update
    @PostMapping("/update/{id}")
    public String update(@PathVariable String id,@ModelAttribute("lotGiay")LotGiay lotGiay){
        lotGiayService.update(UUID.fromString(id),lotGiay);
        return "redirect:/lot-giay/hien-thi";
    }
}
