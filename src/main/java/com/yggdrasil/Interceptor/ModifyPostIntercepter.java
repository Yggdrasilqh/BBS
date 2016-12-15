package com.yggdrasil.Interceptor;

import com.yggdrasil.Entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Yggdrasil on 16/12/14.
 */
public class ModifyPostIntercepter implements HandlerInterceptor {

    private boolean flag = false;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        int layout_id = Integer.parseInt(httpServletRequest.getParameter("layout_id"));
        flag = false;
        Map<String, Integer> layoutMap = (Map) httpServletRequest.getSession().getAttribute("moderatorMap");
        layoutMap.forEach((user_id, moderator_layout_id) -> {
            if (user.getId().equals(user_id) && moderator_layout_id == layout_id)
                flag = true;
        });
        return user.getAuthority_id() == 2 || flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
