package com.z.common.util;

import cn.hutool.core.util.StrUtil;
import com.z.dto.LoginDTO;
import com.z.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zfx
 * @date 2022-03-12 20:27
 */
public class CheckArgs {
    private static final String phonePattern = "0?(13|14|15|18)[0-9]{9}";
    private static final String emailPattern = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    public static CheckModel login(LoginDTO loginDTO, String verifyCode) {
        if (StrUtil.isBlank(loginDTO.getPhone()) && StrUtil.isBlank(loginDTO.getEmail())) {
            return new CheckModel(-1,"登录账号不能为空");
        }
        if (StringUtils.isBlank(loginDTO.getEmail()) && !StrUtil.isBlank(loginDTO.getPhone())){
            Pattern pattern = Pattern.compile(phonePattern);
            Matcher matcher = pattern.matcher(loginDTO.getPhone());
            boolean matches = matcher.matches();
            if (!matches) {
                return new CheckModel(-2,"手机格式不正确");
            }
        }

        if (!StrUtil.isBlank(loginDTO.getEmail()) && StrUtil.isBlank(loginDTO.getPhone())) {
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(loginDTO.getEmail());
            boolean matches = matcher.matches();
            System.out.println(matches);
            if (!matches) {
                return new CheckModel(-2,"邮箱格式不正确");
            }
        }

        if (StrUtil.isBlank(loginDTO.getPassword())) {
            return new CheckModel(-1,"密码不能为空");
        }
        if (StrUtil.isBlank(loginDTO.getVerifyCode())){
            return new CheckModel(-1,"请输入验证码");
        }
        if (!verifyCode.equals(loginDTO.getVerifyCode())) {
            return new CheckModel(-2,"验证码不正确");
        }
        return new CheckModel();
    }

    public static CheckModel register(User user) {
        if (user == null) {
            return new CheckModel(-1,"表单不能为空");
        }

        if (StrUtil.isBlank(user.getUname())) {
            return new CheckModel(-1,"用户名不能为空");
        }
        if (StrUtil.isBlank(user.getUname())){
            return new CheckModel(-1,"电话号码不能为空");
        } else if (!Pattern.compile(phonePattern).matcher(user.getPhone()).matches()) {
            return new CheckModel(-2,"手机号格式不正确");
        }
        if (StrUtil.isBlank(user.getPassword())) {
            return new CheckModel(-1,"密码不能为空");
        } else if (user.getPassword().length() < 6) {
            return new CheckModel(-2,"密码最少6位");
        }
        if (StrUtil.isBlank(user.getNickname())) {
            return new CheckModel(-1,"昵称不能为空");
        }
        return new CheckModel();
    }

}
