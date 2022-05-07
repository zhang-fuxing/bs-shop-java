package com.z.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.common.util.ResultModel;
import com.z.mapper.CartItemMapper;
import com.z.model.CartItem;
import com.z.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author z
 * @since 2022-04-26
 */
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements CartItemService {

    @Autowired
    CartItemMapper cartItemMapper;

    @Override
    public String getCartByUid(int id) {

        QueryWrapper<CartItem> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",id);
        List<CartItem> cartItems = cartItemMapper.selectList(wrapper);

        return ResultModel.success(cartItems);
    }
}
