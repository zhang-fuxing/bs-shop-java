package com.z.service;

import com.z.model.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author z
 * @since 2022-05-05
 */
public interface OrdersService extends IService<Orders> {
    String createOrder(Orders order, String token);
    String createOrderByCart(Orders[] orders, String token);
}
