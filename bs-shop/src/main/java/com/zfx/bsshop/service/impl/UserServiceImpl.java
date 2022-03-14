package com.zfx.bsshop.service.impl;

import com.zfx.bsshop.common.util.ResultModel;
import com.zfx.bsshop.dto.SignIn;
import com.zfx.bsshop.model.User;
import com.zfx.bsshop.service.UserService;
import org.springframework.stereotype.Service;

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


    @Override
    public ResultModel<User> login(SignIn sign) {
        return null;
    }
}
