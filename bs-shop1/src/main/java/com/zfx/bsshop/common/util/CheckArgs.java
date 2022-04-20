package com.zfx.bsshop.common.util;

import com.zfx.bsshop.dto.SignIn;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zfx
 * @date 2022-03-12 20:27
 */
public class CheckArgs {
    public static ResultModel loginCheck(SignIn sign) {
        if (sign == null) {
            return ResultModel.error(-10, "未提交信息");
        } else if (StringUtils.isBlank(sign.getPhone()) && StringUtils.isBlank(sign.getEmail())) {
            return ResultModel.error(-20, "账号不能为空");
        } else if (StringUtils.isBlank(sign.getPassword())) {
            return ResultModel.error(-30,"密码不能为空");
        } else if (StringUtils.isBlank(sign.getValidateCode())) {
            return ResultModel.error(-40, "请输入验证码");
        } else {
            return ResultModel.success(true);
        }
    }
}
