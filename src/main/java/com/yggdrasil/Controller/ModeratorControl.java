package com.yggdrasil.Controller;

import com.yggdrasil.Entity.Moderator;
import com.yggdrasil.Repository.ModeratorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by chenq on 2016/12/19,019.
 */
@RestController
@RequestMapping("/login/moderator")
public class ModeratorControl {
    @Resource
    ModeratorRepository moderatorRepository;

    @RequestMapping("/add")
    public String addModerator(String user,String layout){
        String user_id[] = user.split("/");
        String layout_id[] = layout.split("/");
        Moderator moderator = new Moderator();
        moderator.setLayout_id(Integer.parseInt(layout_id[0]));
        moderator.setUser_id(user_id[0]);
        moderatorRepository.save(moderator);
        return "success";
    }
}
