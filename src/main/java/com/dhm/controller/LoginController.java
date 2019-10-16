package com.dhm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(String username, String password, Map map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else {
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }
}
