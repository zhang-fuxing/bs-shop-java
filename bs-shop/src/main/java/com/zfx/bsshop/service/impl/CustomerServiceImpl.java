package com.zfx.bsshop.service.impl;

import com.zfx.bsshop.dto.SignIn;
import com.zfx.bsshop.model.Customer;
import com.zfx.bsshop.mapper.CustomerMapper;
import com.zfx.bsshop.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zfx
 * @since 2022-03-06
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public Customer login(SignIn sign) {
        return null;
    }
}
