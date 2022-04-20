package com.z.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.common.util.ImageValidateCodeUtil;
import com.z.common.util.ResultModel;
import com.z.dto.SignIn;
import com.z.mapper.UserMapper;
import com.z.model.User;
import com.z.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public ResultModel<User> login(SignIn sign) {
        return null;
    }



    @Override
    public void getVerifyImage(HttpServletRequest request, HttpServletResponse response) {
        new ImageValidateCodeUtil().getAuthCode(request,response);
    }
}
