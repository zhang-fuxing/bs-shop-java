package com.zfx.bsshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zfx.bsshop.dto.SignIn;
import com.zfx.bsshop.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> selectOne(SignIn sign);
    List<User> selectByAccount(User user);
}
