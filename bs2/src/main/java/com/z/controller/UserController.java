package com.z.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.z.common.util.CheckArgs;
import com.z.common.util.CheckModel;
import com.z.common.util.ResultModel;
import com.z.dto.LoginDTO;
import com.z.model.User;
import com.z.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;
    GifCaptcha captcha = CaptchaUtil.createGifCaptcha(120, 32, 6);

    @RequestMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        String code = captcha.getCode();
        CheckModel rs = CheckArgs.login(loginDTO, code);
        if (rs.getFlag() != 0) {
            return ResultModel.error(rs.getFlag(), rs.getMessage());
        }

        String user = userService.userLogin(loginDTO);

        logger.info("user login......" + user);
        return user;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        CheckModel register = CheckArgs.register(user);
        if (register.getFlag() != 0) {
            return ResultModel.error(register.getFlag(),register.getMessage());
        }

        return userService.userRegister(user);
    }

    @GetMapping("/verify")
    public void getVerifyImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        captcha.createCode();
        captcha.write(response.getOutputStream());
        System.out.println(captcha.getCode());

    }

    @PostMapping("/admin/list")
    public String getUserList() {
        return userService.getUserList();
    }

    @PostMapping("/admin/freezeList")
    public String getFreezeList() {
        return userService.getFreezeList();
    }


    @GetMapping("/checkEmail/{email}")
    public String checkEmail(@PathVariable("email") String email){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        User rs = userService.getOne(wrapper);
        if (rs != null) {
            return ResultModel.error("邮箱已注册");
        }
        return ResultModel.success("邮箱可用");
    }
    @GetMapping("/checkUname/{uname}")
    public String checkUname(@PathVariable("uname") String uname){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("uname", uname);
        User rs = userService.getOne(wrapper);
        if (rs != null) {
            return ResultModel.error("用户名已注册");
        }
        return ResultModel.success("用户名可用");
    }
    @GetMapping("/checkPhone/{phone}")
    public String checkPhone(@PathVariable("phone") String phone){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", phone);
        User rs = userService.getOne(wrapper);
        if (rs != null) {
            return ResultModel.error("手机已注册");
        }
        return ResultModel.success("手机可用");
    }

    @PostMapping("/info")
    public String getUserInfo(HttpServletRequest request) {
        Integer uid = (Integer) JWTUtil.parseToken(request.getHeader("token")).getPayload("id");
        User user = userService.getById(uid);
        if (user == null) {
            return ResultModel.error("登录信息可能已失效，请重新登录");
        }

        return ResultModel.success(user);
    }
}
