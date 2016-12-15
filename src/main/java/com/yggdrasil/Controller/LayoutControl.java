package com.yggdrasil.Controller;

import com.yggdrasil.Entity.Layout;
import com.yggdrasil.Entity.UserGroup;
import com.yggdrasil.Repository.LayoutRepository;
import com.yggdrasil.Repository.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 版面
 */
@RestController
@RequestMapping("/login/layout")
public class LayoutControl {

    private LayoutRepository layoutRepository;
    @Resource
    private UserGroupRepository userGroupRepository;

    @Autowired
    public LayoutControl(LayoutRepository layoutRepository) {
        this.layoutRepository = layoutRepository;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Layout> showLayout() {
        return layoutRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String layoutInsert(@RequestBody Layout layout) {
        layoutRepository.save(layout);
        return "success";
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public Layout getById(int id){
        return layoutRepository.findOne(id);
    }


    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public String layoutDelete(int id) {
        layoutRepository.delete(id);
        return "success";
    }

    @RequestMapping("/getUserGroup")
    public List<UserGroup> getUserGroup(){
        return userGroupRepository.findAll();
    }

}
