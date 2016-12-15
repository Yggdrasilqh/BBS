package com.yggdrasil.Controller;

import com.yggdrasil.Entity.Layout;
import com.yggdrasil.Repository.LayoutRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * 增删改版面
 */
@RestController
@RequestMapping("/login/modifyLayout/")
public class ModifyLayout {
    @Resource
    LayoutRepository layoutRepository;

    @RequestMapping("/add")
    private String addlayout(Layout layout) {
        if(layout != null) {
            layoutRepository.save(layout);
            return "success";
        }
        else
            return "false";
    }

    @RequestMapping("/delete")
    private String deleteLayout(int id) {
        layoutRepository.delete(id);
        return "success";
    }

    @RequestMapping("/modify")
    private String modifyLayout(Layout layout){
        if(layoutRepository.exists(layout.getId())) {
            layoutRepository.save(layout);
            return "success";
        }
        else
            return "false";
    }
}
