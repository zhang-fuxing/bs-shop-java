package com.z.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.z.dto.LoginDTO;
import com.z.model.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
public interface UserService extends IService<User> {
    String userLogin(LoginDTO loginDTO);
    String userRegister(User user);

    String getUserList();
    String getFreezeList();
}
