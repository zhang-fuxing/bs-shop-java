package com.zfx.bsshop.controller;

import com.zfx.bsshop.common.util.ImageValidateCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zfx
 * @date 2022-03-04 14:11
 *
 * 路由控制器
 */
@Controller
@RequestMapping("/app")
@CrossOrigin
public class ApplicationController {


    @RequestMapping("/index")
    public String toIndex() {
        return "/index";
    }

    @RequestMapping("/toReg")
    public String toReg() {
        return "/reg";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/user/login";
    }

    @RequestMapping("/verify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        ImageValidateCodeUtil i = new ImageValidateCodeUtil();
        i.getAuthCode(request, response);
    }


}
