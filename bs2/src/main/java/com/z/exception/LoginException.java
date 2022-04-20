package com.z.exception;

import lombok.Data;


/**
 * @author zfx
 */
@Data
public class LoginException extends RuntimeException{
    private int code;
    private String message;

    public LoginException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}