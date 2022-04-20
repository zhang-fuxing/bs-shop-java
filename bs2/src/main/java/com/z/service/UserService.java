package com.z.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.z.common.util.ResultModel;
import com.z.dto.SignIn;
import com.z.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
public interface UserService extends IService<User> {
    ResultModel<User> login(SignIn sign);
    void getVerifyImage(HttpServletRequest request, HttpServletResponse response);
}
