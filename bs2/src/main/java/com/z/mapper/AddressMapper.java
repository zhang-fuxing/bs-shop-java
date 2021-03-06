package com.z.mapper;

import com.z.model.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author z
 * @since 2022-04-23
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

    int updateAddress(Address address);
}
