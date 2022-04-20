package com.z.controller;


import com.alibaba.fastjson.JSON;
import com.z.common.util.JwtUtils;
import com.z.common.util.ResultModel;
import com.z.dto.SignIn;
import com.z.model.User;
import com.z.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody SignIn sign) {

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
