package com.yggdrasil.Controller;

import com.yggdrasil.Entity.Layout;
import com.yggdrasil.Entity.Moderator;
import com.yggdrasil.Entity.UserGroup;
import com.yggdrasil.Repository.LayoutRepository;
import com.yggdrasil.Repository.ModeratorRepository;
import com.yggdrasil.Repository.UserGroupRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 版面
 */
@RestController
@RequestMapping("/login/layout")
public class LayoutControl {

    private LayoutRepository layoutRepository;
    @Resource
    private UserGroupRepository userGroupRepository;

    @Resource
    private ModeratorRepository moderatorRepository;

    @Autowired
    public LayoutControl(LayoutRepository layoutRepository) {
        this.layoutRepository = layoutRepository;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Layout> showLayout() {
        return layoutRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String layoutInsert(@RequestBody Layout layout, HttpServletRequest httpServletRequest) {
        layoutRepository.save(layout);
        List<Layout> layoutList = layoutRepository.findAll();
        Map<Integer, Integer> layoutMap = new HashMap<>();
        layoutList.forEach(layout1 -> layoutMap.put(layout1.getId(), layout1.getGroup_id()));
        httpServletRequest.getSession().setAttribute("layoutMap",layoutMap);
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

    @RequestMapping("/getName")
    public String getName(int layout_id){
        return layoutRepository.getOne(layout_id).getName();
    }

}
