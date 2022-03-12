package com.zfx.bsshop.service;

import com.zfx.bsshop.dto.SignIn;
import com.zfx.bsshop.model.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zfx
 * @since 2022-03-06
 */
public interface CustomerService extends IService<Customer> {

    /**
     *
     * @param sign
     * @return
     */
    Customer login(SignIn sign);

}
