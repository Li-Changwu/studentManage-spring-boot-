package com.licw.springbootstudentmanage.config;

import com.licw.springbootstudentmanage.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("add");
    }

        //注册拦截器
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor( new LoginHandlerInterceptor()).addPathPatterns("/**")
                    .excludePathPatterns("/login.html","/index.html","/login","/");
        }
}
