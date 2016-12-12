package com.yggdrasil.Controller;

import com.yggdrasil.Entity.User;
import com.yggdrasil.Repository.UserRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登陆
 */
@RestController
public class LoginControl {
    @Resource
    UserRepository userRepository;
    @RequestMapping("/login.action")
    public String login(User user, HttpServletRequest httpServletRequest) {
        if (userRepository.findByIdAndPassword(user.getId(), user.getPassword()) != null) {
            httpServletRequest.getSession().setAttribute("isLog",true);
            return "success";
        }
        httpServletRequest.getSession().setAttribute("isLog",false);
        return "error";
    }
}
