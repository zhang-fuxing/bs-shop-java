package com.zfx.bsshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zfx.bsshop.common.util.ResultModel;
import com.zfx.bsshop.dto.SignIn;
import com.zfx.bsshop.mapper.UserMapper;
import com.zfx.bsshop.model.User;
import com.zfx.bsshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public ResultModel<User> login(SignIn sign) {
        User user = new User();
        user.setPhone(sign.getPhone());
        user.setEmail(sign.getEmail());
        List<User> userList = userMapper.selectByAccount(user);
        if (CollectionUtils.isEmpty(userList)) {
            return ResultModel.error(-1,"账号不存在");
        }
        List<User> list = userMapper.selectOne(sign);
        if (CollectionUtils.isEmpty(list)) {
            return ResultModel.error(-2, "密码不正确，请检查大小写是否正确");
        }
        return ResultModel.success("登录成功", list.get(0));
    }
}
