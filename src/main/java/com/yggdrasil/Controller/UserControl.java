package com.yggdrasil.Controller;

import com.yggdrasil.Repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by chenq on 2016/12/13,013.
 */
@RestController
@RequestMapping("/login/user")
public class UserControl {

    @Resource
    UserRepository userRepository;

    @RequestMapping(value = "/getName",method = RequestMethod.GET)
    public String getPostUser(String id){
        return userRepository.findById(id).getName();
    }
}
