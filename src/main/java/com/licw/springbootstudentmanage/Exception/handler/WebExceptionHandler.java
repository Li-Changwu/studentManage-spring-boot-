package com.licw.springbootstudentmanage.Exception.handler;

import com.licw.springbootstudentmanage.Exception.IncorrectNameException;
import com.licw.springbootstudentmanage.Exception.IncorrectPasswordException;
import com.licw.springbootstudentmanage.Exception.KeyConflictException;
import com.licw.springbootstudentmanage.util.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class WebExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(WebExceptionHandler.class);

    @ExceptionHandler
    public ResultBean incorrectNameException(IncorrectNameException e) {
        log.error("账号不存在", e);
        return ResultBean.error(-1, "账号不存在");
    }

    @ExceptionHandler
    public ResultBean incorrectPasswordException(IncorrectPasswordException e){
        log.error("密码错误", e);
        return ResultBean.error(-2,"密码错误");
    }

    @ExceptionHandler
    public ResultBean keyConflictException(KeyConflictException e){
        log.error("添加主键冲突",e);
        return ResultBean.error(-3,"该学号已存在");
    }
    @ExceptionHandler
    public ResultBean unknownMethodException(HttpRequestMethodNotSupportedException e) {
        log.error("HTTP 方法错误（POST or GET）", e);
        return ResultBean.error(-4, "HTTP 方法错误（POST or GET）");
    }
    @ExceptionHandler
    public ResultBean unknownException(Exception e) {
        log.error("发生了未知异常", e);
        return ResultBean.error(-99, "系统发生未知异常");
    }

}
