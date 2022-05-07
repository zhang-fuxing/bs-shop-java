package com.z.dto;

/**
 * @author zfx
 * @date 2022-04-21 10:28
 */

public class LoginDTO {
    private String phone;
    private String email;
    private String password;
    private String verifyCode;

    public LoginDTO() {
    }

    public LoginDTO(String phone, String email, String password, String verifyCode) {
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
