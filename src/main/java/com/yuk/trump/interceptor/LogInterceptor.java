package com.yuk.trump.interceptor;

import com.yuk.trump.entity.Admin;
import com.yuk.trump.entity.Log;
import com.yuk.trump.service.LogService;
import com.yuk.trump.util.Const;
import com.yuk.trump.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ：TrumpK
 * @date ：Created in 2019/9/13 12:56
 * @description：LogInterceptor
 * @modified By：
 */
public class LogInterceptor implements HandlerInterceptor {
    @Autowired
    private Log log;
    @Autowired
    private LogService logService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String stringDate = DateUtil.getStringDate("yyyy-MM-dd HH:mm:ss");
        String username = null;
        HttpSession session=request.getSession(false);
        if(session==null){
            return;
        }
        if(request.getSession().getAttribute(Const.ADMIN) != null){
            Admin admin = (Admin)request.getSession().getAttribute(Const.ADMIN);
            username = admin.getUsername();
        }
        String uri = request.getRequestURI();
        if(uri.equals("/manager/logList")){
            return;
        }

        log.setLogTime(stringDate);
        log.setUsername(username);
        log.setUri(uri);

        logService.insertByLog(log);
    }
}
