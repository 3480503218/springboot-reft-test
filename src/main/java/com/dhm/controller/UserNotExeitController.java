package com.dhm.controller;

import com.dhm.exception.UserNotExeitException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotExeitController {
    //浏览器和客户端都反回json，无法自适应
//    @ResponseBody
//    @ExceptionHandler(UserNotExeitException.class)
//    public Map<String,Object> handleException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }



    @ExceptionHandler(UserNotExeitException.class)
    public String handleException(Exception e,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入自己的状态码,传入我们自己的错误状态码 4xx 5xx，否则就不会进入定制错误页面的解析流程
/**
 6 * Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
 */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);

        return "forward:/error";
    }
}
