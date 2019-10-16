package com.dhm.exception;

public class UserNotExeitException extends   RuntimeException {
    public UserNotExeitException(){
        super("用户不存在");
    }
}
