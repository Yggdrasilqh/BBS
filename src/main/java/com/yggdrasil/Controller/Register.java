package com.yggdrasil.Controller;

import com.yggdrasil.Entity.User;
import com.yggdrasil.Repository.UserRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Yggdrasil on 16/12/8.
 */
@Controller
public class Register {

    @Resource
    UserRepository userRepository;
    @RequestMapping("/register.action")
    @ResponseBody
    public String executeRegister(User user, HttpServletRequest httpServletRequest){
        if(userRepository.exists(user.getId())){
            return "error";
        }
        httpServletRequest.getSession().setAttribute("isLog", true);
        userRepository.save(user);
        return "success";
    }
}
