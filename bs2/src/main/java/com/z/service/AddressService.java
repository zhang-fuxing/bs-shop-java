package com.z.service;

import com.z.model.Address;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author z
 * @since 2022-04-23
 */
public interface AddressService extends IService<Address> {

    String getUserAddress(int id);
    String updateAddress(Address address);
}
