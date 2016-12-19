package com.yggdrasil.Controller;


import com.yggdrasil.Entity.User;
import com.yggdrasil.Repository.ModeratorRepository;
import com.yggdrasil.Repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import javax.annotation.Resource;

/**
 * 用户
 */
@RestController
@RequestMapping("/login/user/")
public class UserControl {

    @Resource
    UserRepository userRepository;


    @Resource
    ModeratorRepository moderatorRepository;


    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getPostUserName(String id) {
        return userRepository.findById(id).getName();
    }


    @RequestMapping(value = "/getDeleteAuthority", method = RequestMethod.GET)
    public String getDeleteAuthority(HttpServletRequest httpServletRequest, int layout_id) {
        String result = "";
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user.getAuthority_id() == 2 || moderatorRepository.findByUser_idAndLayout_id(user.getId(), layout_id) != null)
            result = "true";
        else
            result = "false";

        return result;
    }


    @RequestMapping("/getCurrAuthority")
    public int getCurrAuthority(HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        return user.getAuthority_id();
    }

     @RequestMapping("/getCurr")
     public User getUser(HttpServletRequest httpServletRequest){
         return (User)httpServletRequest.getSession().getAttribute("user");
     }

     @RequestMapping(value = "/modifyUserInfo", method = RequestMethod.POST)
     public String modifyUserInfo(@RequestBody User user_info, HttpServletRequest httpServletRequest) {
         User user = (User)httpServletRequest.getSession().getAttribute("user");
         user_info.setId(user.getId());
         user_info.setGroup_id(user.getGroup_id());
         user_info.setAuthority_id(user.getAuthority_id());
         user_info.setSex(user.getSex());
         user_info.setAcc_point(user.getAcc_point());
         userRepository.save(user_info);
         httpServletRequest.getSession().setAttribute("user",user_info);
         return "success";
     }

}
