package com.zfx.bsshop.controller;


import com.alibaba.fastjson.JSON;
import com.zfx.bsshop.common.util.JwtUtils;
import com.zfx.bsshop.common.util.ResultModel;
import com.zfx.bsshop.dto.SignIn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zfx
 * @since 2022-03-06
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody SignIn sign, HttpSession session ) {
//        String code = String.valueOf(session.getAttribute("RANDOM_VALIDATE_CODE_KEY"));
//        if (!StringUtils.hasLength(sign.getPhone())) {
//            return JSON.toJSONString(ResultModel.error("电话不能为空"));
//        }
//        if (!code.equalsIgnoreCase(sign.getValidateCode())) {
//            return JSON.toJSONString(ResultModel.error("验证码错误"));
//        }
        String token = JwtUtils.createToken(1, sign.getPhone());
        System.out.println("token = " + token);
        return JSON.toJSONString(ResultModel.success(token));
    }
}
