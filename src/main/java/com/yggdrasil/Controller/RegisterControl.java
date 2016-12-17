package com.yggdrasil.Controller;

import com.yggdrasil.Entity.User;
import com.yggdrasil.Repository.UserRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册
 */
@Controller
public class RegisterControl {

    @Resource
    UserRepository userRepository;

    @RequestMapping("/register.action")
    @ResponseBody
    public String executeRegister(@RequestBody User user, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        user.setGroup_id(1);
        user.setAuthority_id(1);
        if (userRepository.exists(user.getId())) {
            return "error";
        }
        httpServletRequest.getSession().setAttribute("isLog", true);
        userRepository.save(user);
        return "success";
    }
}
