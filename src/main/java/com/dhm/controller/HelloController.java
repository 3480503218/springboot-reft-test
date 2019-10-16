package com.dhm.controller;

import com.dhm.exception.UserNotExeitException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name){
if("oo".equals(name)){
    throw new UserNotExeitException();
}
        return "hello me";
    }

    @RequestMapping("/hellos")
    public String hellos(Map map){
        map.put("name","zhangsan");
        return "success";
    }


//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
}
