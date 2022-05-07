package com.z.service.impl;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.z.common.util.ResultModel;
import com.z.mapper.OrdersMapper;
import com.z.model.Orders;
import com.z.model.Product;
import com.z.service.CartItemService;
import com.z.service.OrdersService;
import com.z.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author z
 * @since 2022-05-05
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartService;

    private final Logger logger = LoggerFactory.getLogger(OrdersServiceImpl.class);

    @Override
    public String createOrder(Orders order, String token) {
        JWT jwt = JWTUtil.parseToken(token);
        int uid = (int) jwt.getPayload("id");
        String uname = String.valueOf(jwt.getPayload("uname"));

        Product product = productService.getById(order.getPid());
        BigDecimal price = product.getUnitPrice();
        BigDecimal buyNum = new BigDecimal(order.getBuyNum());

        order.setUid(uid);
        order.setCreateUser(uname);
        order.setPriceCount(price.multiply(buyNum));
        order.setStatus(0);
        order.setIsDelete(0);
        order.setCreateTime(LocalDateTime.now());
        logger.info("创建订单服务，订单对象：" + order);
        int insert = ordersMapper.insert(order);
        String message = "";
        if (insert > 0) {
            message = "订单创建成功";
        } else {
            message = "订单插入失败";
        }
        return ResultModel.success(message);
    }

    @Override
    public String createOrderByCart(Orders[] orders, String token) {
        String str = "执行成功";
        for (Orders order : orders) {
            String order1 = createOrder(order, token);
            boolean b = cartService.removeById(order.getId());
            if (!b) {
                str = order1;
                break;
            }
        }
        return ResultModel.success(str);
    }
}
