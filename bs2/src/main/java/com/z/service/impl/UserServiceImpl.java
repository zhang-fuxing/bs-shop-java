package com.z.service.impl;

import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.common.util.EncryptUtils;
import com.z.common.util.Keys;
import com.z.common.util.ResultModel;
import com.z.dto.LoginDTO;
import com.z.mapper.UserMapper;
import com.z.model.User;
import com.z.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

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

    @Autowired
    private UserMapper userMapper;

    @Override
    public String userLogin(LoginDTO loginDTO) {
        User user = new User();
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        if (loginDTO.getPhone() != null) {
            wrapper.eq("phone",loginDTO.getPhone());
            if (userMapper.selectOne(wrapper) == null) {
                return ResultModel.error("该手机号未注册");
            }
            wrapper.eq("password", EncryptUtils.SHA1(loginDTO.getPassword(), Keys.key1))
                    .eq("user_status",1)
                    .eq("is_delete",0);;
            user = userMapper.selectOne(wrapper);
            if (user == null) {
                return ResultModel.error("密码错误");
            }
        } else if (loginDTO.getEmail() != null) {
            wrapper.eq("email",loginDTO.getEmail());
            if (userMapper.selectOne(wrapper) == null) {
                return ResultModel.error("该邮箱未注册或邮箱地址有误");
            }
            wrapper.eq("password", EncryptUtils.SHA1(loginDTO.getPassword(), Keys.key1))
                    .eq("user_status",1)
                    .eq("is_delete",0);
            user = userMapper.selectOne(wrapper);
            if (user == null) {
                return ResultModel.error("密码错误");
            }
        }

        LocalDateTime now = LocalDateTime.now();
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",user.getId());
        map.put("uname",user.getUname());
        map.put("nickname",user.getNickname());
        map.put("uid",user.getUid());
        map.put("phone",user.getPhone());
        map.put("email",user.getEmail());
        map.put(JWTPayload.ISSUED_AT, now);
        map.put(JWTPayload.NOT_BEFORE, now);
        map.put(JWTPayload.EXPIRES_AT, now.plusDays(3));
        String token = JWTUtil.createToken(map, "zhang".getBytes());
        return ResultModel.success(token);
    }

    @Override
    public String userRegister(User user) {
        return null;
    }
    

    @Override
    public String getUserList() {
        List<User> users = userMapper.selectList(new QueryWrapper<User>().eq("is_delete",0));
        if (CollectionUtils.isEmpty(users)) {
            return ResultModel.error("用户列表为空");
        }
        return ResultModel.success(users);
    }

    @Override
    public String getFreezeList() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_status",-1).eq("is_delete",0);
        return ResultModel.success(userMapper.selectList(wrapper));
    }
}
