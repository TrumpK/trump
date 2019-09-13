package com.yuk.trump.interceptor;

import com.yuk.trump.util.Const;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 12:52
 * @description：LoginInterceptor
 * @modified By：
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getRequestURI();
        if(!StringUtils.isEmpty(request.getSession().getAttribute(Const.ADMIN))){
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/manager/login");
        return false;
    }
}
