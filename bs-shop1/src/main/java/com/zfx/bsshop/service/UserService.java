package com.zfx.bsshop.service;

import com.zfx.bsshop.common.util.ResultModel;
import com.zfx.bsshop.dto.SignIn;
import com.zfx.bsshop.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
public interface UserService {

    ResultModel<User> login(SignIn sign);
    void getVerifyImage(HttpServletRequest request, HttpServletResponse response);
}
