package com.zfx.bsshop.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zfx
 * @date 2022-03-04 15:55
 */
@Data
@Accessors(chain = true)
public class SignIn {
    private String phone;
    private String password;
    private String validateCode;
}
