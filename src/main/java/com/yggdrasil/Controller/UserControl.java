package com.yggdrasil.Controller;


import com.yggdrasil.Repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yggdrasil.Entity.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

 /**
 * 用户
 */
@RestController
@RequestMapping("/login/user/")
public class UserControl {
    @Resource
    UserRepository userRepository;

    @RequestMapping("/getCurrAuthority")
    public int getCurrAuthority(HttpServletRequest httpServletRequest){
        User user = (User)httpServletRequest.getSession().getAttribute("user");
        return user.getAuthority_id();
    }
     @RequestMapping(value = "/getName",method = RequestMethod.GET)
     public String getPostUser(String id) {
         return userRepository.findById(id).getName();
     }
}
