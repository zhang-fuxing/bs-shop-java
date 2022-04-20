package com.z.dto;

/**
 * @author zfx
 * @date 2022-03-04 15:55
 */

public class SignIn {

    private String phone;
    private String email;
    private String password;
    private String validateCode;

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

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    @Override
    public String toString() {
        return "SignIn{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", validateCode='" + validateCode + '\'' +
                '}';
    }
}
