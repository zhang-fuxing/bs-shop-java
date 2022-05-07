package com.z.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.common.util.ResultModel;
import com.z.mapper.AddressMapper;
import com.z.model.Address;
import com.z.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author z
 * @since 2022-04-23
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public String getUserAddress(int id) {
        List<Address> address = addressMapper.selectList(new QueryWrapper<Address>().eq("uid", id));
        if (CollectionUtils.isEmpty(address)) {
            return ResultModel.error("地址为空");
        }
        return ResultModel.success(address);
    }

    @Override
    public String updateAddress(Address address) {
        int i = addressMapper.updateAddress(address);
        if (i == 0) {
            return ResultModel.error("修改失败");
        }
        return ResultModel.success("修改成功");
    }
}
