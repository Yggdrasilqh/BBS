package com.yggdrasil.Controller;

import com.yggdrasil.Entity.Layout;
import com.yggdrasil.Repository.LayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 版面
 */
@RestController
@RequestMapping("/login/layout")
public class LayoutControl {

    private LayoutRepository layoutRepository;

    @Autowired
    public LayoutControl(LayoutRepository layoutRepository) {
        this.layoutRepository = layoutRepository;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Layout> showLayout() {
        return layoutRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String layoutInsert(Layout layout) {
        layoutRepository.save(layout);
        return "success";
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public String layoutDelete(int id) {
        layoutRepository.delete(id);
        return "success";
    }

}
