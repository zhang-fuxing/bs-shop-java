package com.z.service;

import com.z.model.CartItem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 购物车表 服务类
 * </p>
 *
 * @author z
 * @since 2022-04-26
 */
public interface CartItemService extends IService<CartItem> {
    String getCartByUid(int id) ;
}
