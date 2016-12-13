package com.yggdrasil.Controller;

import com.sun.deploy.net.HttpResponse;
import com.yggdrasil.Entity.Layout;
import com.yggdrasil.Entity.User;
import com.yggdrasil.Repository.LayoutRepository;
import com.yggdrasil.Repository.UserRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登陆
 */
@Controller
public class LoginControl {
    @Resource
    UserRepository userRepository;
    @Resource
    LayoutRepository layoutRepository;

    @RequestMapping(value = "/login.action")
    public String login(User user, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {


        List<Layout> layoutList = layoutRepository.findAll();
        Map<Integer, Integer> layoutMap = new HashMap<>();
        layoutList.forEach(layout -> {
            layoutMap.put(layout.getId(),layout.getGroup_id());
        });

        User existUser = userRepository.findByIdAndPassword(user.getId(), user.getPassword());
        if (existUser != null) {
            httpServletRequest.getSession().setAttribute("user", existUser);
            httpServletRequest.getSession().setAttribute("layoutMap",layoutMap);
            //httpServletResponse.sendRedirect("/layout.html");
            return "layout.html";
        }
        return "error";
    }
}
