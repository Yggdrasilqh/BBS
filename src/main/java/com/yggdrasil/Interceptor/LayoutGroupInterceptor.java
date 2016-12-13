package com.yggdrasil.Interceptor;

import com.yggdrasil.Entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 进入版面拦截
 */
public class LayoutGroupInterceptor implements HandlerInterceptor {

    private int layout_group_id = -1;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        int layout_id = Integer.parseInt(httpServletRequest.getParameter("layout_id"));
        Map<Integer,Integer> layoutMap = (Map) httpServletRequest.getSession().getAttribute("layoutMap");
        layoutMap.forEach((id,group_id) -> {
            if(id == layout_id)
                layout_group_id = group_id;
        });
        if(httpServletRequest.getSession().getAttribute("user") != null) {
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if (user.getGroup_id() >= layout_group_id && layout_group_id >= 0) {
                return true;
            } else {
                httpServletResponse.sendRedirect("/layout.html");
                return false;
            }
        }
        httpServletResponse.sendRedirect("/login.html");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
