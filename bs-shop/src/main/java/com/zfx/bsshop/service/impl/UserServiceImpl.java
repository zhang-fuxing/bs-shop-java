package com.zfx.bsshop.service.impl;

import com.zfx.bsshop.common.util.ImageValidateCodeUtil;
import com.zfx.bsshop.common.util.ResultModel;
import com.zfx.bsshop.dao.UserDAO;
import com.zfx.bsshop.dto.SignIn;
import com.zfx.bsshop.model.User;
import com.zfx.bsshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public ResultModel<User> login(SignIn sign) {
        return null;
    }

    @Override
    public void getVerifyImage(HttpServletRequest request, HttpServletResponse response) {
        new ImageValidateCodeUtil().getAuthCode(request,response);
    }
}
