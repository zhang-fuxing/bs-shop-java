package com.zfx.bsshop.service.impl;

import com.zfx.bsshop.model.User;
import com.zfx.bsshop.mapper.UserMapper;
import com.zfx.bsshop.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
