package com.yuk.trump.filter;

import com.alibaba.fastjson.JSON;
import com.yuk.trump.result.CodeMsg;
import com.yuk.trump.result.Result;
import com.yuk.trump.constant.UserConstant;
import com.yuk.trump.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/14 19:27
 * @description：AccessInterceptor
 * @modified By：
 */
@Service
public class AccessInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    AdminService authTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            Secured secured = hm.getMethodAnnotation(Secured.class);
            if (secured != null) {
                String authToken = request.getHeader(UserConstant.USER_TOKEN);
                // 如果登入之前没有认证过，那么直接返回放行
                if (StringUtils.isEmpty(authToken)) {
                    return true;
                }
                String userId = authTokenService.checkToken(authToken);
                if (StringUtils.isEmpty(userId)) {
                    render(response, CodeMsg.LOGIN_FAILURE);
                    return false;
                }
            }
            return true;
        }
        return true;
    }


    private void render(HttpServletResponse response, CodeMsg cm) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String str = JSON.toJSONString(Result.error(cm));
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }
}