package com.yggdrasil.Controller;


import com.yggdrasil.Repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
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
