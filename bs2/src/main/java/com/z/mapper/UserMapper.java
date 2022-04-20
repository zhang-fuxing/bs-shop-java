package com.z.mapper;

import com.z.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
