package com.lena.controller;

import com.lena.entity.Appraisalitem;
import com.lena.service.ItemService;
import com.lena.vo.AppraisalVo;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.StyledEditorKit;
import java.util.List;

/**
 * @ClassName AppraisalController
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/9/11 7:59
 * @Version 1.0
 */
@Controller
public class AppraisalController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String getPage(Model model){
        AppraisalVo appraisalVo=new AppraisalVo();
        appraisalVo.setApps(itemService.findAll());
        model.addAttribute("appraisalVo",appraisalVo);

        return "index";
    }

    @PostMapping("/input")
    public String input(AppraisalVo vo){


        vo.getApps().forEach(a-> System.out.println(a.getKaohejieguo()));
        //model.addAttribute("apps",itemService.findAll());
        System.out.println("------------");
        return "success";
    }



}
