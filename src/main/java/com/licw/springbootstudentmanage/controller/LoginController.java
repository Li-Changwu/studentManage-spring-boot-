package com.licw.springbootstudentmanage.controller;

import com.licw.springbootstudentmanage.Exception.IncorrectNameException;
import com.licw.springbootstudentmanage.Exception.IncorrectPasswordException;
import com.licw.springbootstudentmanage.beans.User;
import com.licw.springbootstudentmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("uuid") String uuid,
                        @RequestParam("passwd") String passwd,
                        HttpSession session)
            throws IncorrectNameException, IncorrectPasswordException {

//        System.out.println(uuid +","+passwd);
        User loginUser = userService.getById(uuid);

        //判断用户是否存在
        if(loginUser == null){
            throw new IncorrectNameException();
            //return ResultBean.error(-1,"用户名错误");
        }else{
            if(passwd.equals(loginUser.getPassWd())){
                session.setAttribute("loginUser",loginUser);
                return "redirect:main.html";
            }
            else{
                throw new IncorrectPasswordException();
                //return ResultBean.error(-2,"密码错误");
            }

        }
    }
    
    @PostMapping("/to_login")

    public String toLogin(){
        return "add";
    }
}
