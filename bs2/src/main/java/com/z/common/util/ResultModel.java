package com.z.common.util;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class ResultModel<T> {
    private int code;
    private String message="";
    private T content;
    public ResultModel(){
    }
    public ResultModel(int code,String message){
        this.code = code;
        this.message = message;
    }
    public ResultModel(int code,String message,T content){
        this.code = code;
        this.message = message;
        this.content = content;
    }
    public static <T> String success(String message,T content){
        return JSON.toJSONString(new ResultModel<T>(0,message,content));
    }
    public static <T> String success(T content){
        return JSON.toJSONString(new ResultModel<T>(0,"success",content));
    }

    public static <T> String error(int code,String message){
        return JSON.toJSONString(new ResultModel<T>(code,message));
    }
    public static <T>String error(String message){
        return JSON.toJSONString(new ResultModel<T>(-1,message));
    }
    public static <T> String error(){
        return JSON.toJSONString( new ResultModel<T>(-1,"error"));
    }
}
