package com.yggdrasil.Controller;

import com.yggdrasil.Entity.User;
import com.yggdrasil.Repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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



    @RequestMapping(value = "getUserId",method = RequestMethod.GET)
    public String getUserId(HttpServletRequest httpServletRequest){
        User user = (User)httpServletRequest.getSession().getAttribute("user");
        return user.getId();
    }


}
