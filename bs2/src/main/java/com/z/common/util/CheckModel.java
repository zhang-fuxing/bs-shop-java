package com.z.common.util;

/**
 * @author zfx
 * @date 2022-04-22 10:33
 */
public class CheckModel {
    private Integer flag;
    private String message;


    public CheckModel() {
        this.flag = 0;
        this.message = "success";
    }

    public CheckModel(String message) {
        this.flag = 0;
        this.message = message;
    }

    public CheckModel(Integer flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CheckModel{" +
                "flag=" + flag +
                ", message='" + message + '\'' +
                '}';
    }
}
