package com.licw.springbootstudentmanage.interceptor;

import com.licw.springbootstudentmanage.aop.WebLogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user =request.getSession().getAttribute("loginUser");
        if(user == null){
            //not login
            request.setAttribute("msg","请先登录");
            logger.info("==========未登录非法请求===========");
            logger.info("请求IP:{}",request.getRemoteAddr());
            logger.info("请求URL:{}",request.getRequestURL().toString());
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        else{
            //logined
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
