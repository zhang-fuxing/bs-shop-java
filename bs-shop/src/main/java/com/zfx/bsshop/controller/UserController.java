package com.zfx.bsshop.controller;


import com.alibaba.fastjson.JSON;
import com.zfx.bsshop.common.util.CheckArgs;
import com.zfx.bsshop.common.util.JwtUtils;
import com.zfx.bsshop.common.util.ResultModel;
import com.zfx.bsshop.dto.SignIn;
import com.zfx.bsshop.model.User;
import com.zfx.bsshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody SignIn sign) {
        ResultModel resultModel = CheckArgs.loginCheck(sign);
        if (resultModel.getCode() < 0) {
            return JSON.toJSONString(ResultModel.error(resultModel.getCode(), resultModel.getMessage()));
        }
        ResultModel<User> login = userService.login(sign);
        if (login.getCode() < 0) {
            return JSON.toJSONString(ResultModel.error(login.getCode(), login.getMessage()));
        }
        String token = JwtUtils.createToken(login.getContent().getId(), login.getContent().getUname());

        return JSON.toJSONString(ResultModel.success(token));
    }

    @GetMapping("/verify")
    public void getVerifyImg(HttpServletRequest request, HttpServletResponse response) {
        userService.getVerifyImage(request, response);
    }

}
