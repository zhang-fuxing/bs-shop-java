package com.z.mapper;

import com.z.model.CartItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 购物车表 Mapper 接口
 * </p>
 *
 * @author z
 * @since 2022-04-26
 */
@Mapper
public interface CartItemMapper extends BaseMapper<CartItem> {

}
