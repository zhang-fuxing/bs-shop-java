package com.z.controller;


import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.z.common.util.ResultModel;
import com.z.model.Orders;
import com.z.service.CartItemService;
import com.z.service.OrdersService;
import com.z.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author z
 * @since 2022-05-05
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartService;

    @PostMapping("/addOrder")
    public String addOrder(@RequestBody Orders order, HttpServletRequest request) {
        String token = request.getHeader("token");
        return ordersService.createOrder(order, token);
    }

    @PostMapping("/addBatch")
    public String addOrderBatch(@RequestBody Orders[] orders, HttpServletRequest request) {
        if (orders.length == 0) {
            return ResultModel.error("提交的订单为空");
        }
        String token = request.getHeader("token");
        String orderByCart = ordersService.createOrderByCart(orders, token);
        return ResultModel.success(orderByCart);
    }

    @PostMapping("/listForUser")
    public String getList(HttpServletRequest request) {
        int uid = (int) JWTUtil.parseToken(request.getHeader("token")).getPayload("id");
        List<Orders> list = ordersService.list(new QueryWrapper<Orders>()
                .eq("uid", uid)
                .eq("is_delete", 0)
                .eq("status", 0)
        );
        return ResultModel.success(list);
    }

    @PostMapping("/list")
    public String getLists(HttpServletRequest request) {
        int uid = (int) JWTUtil.parseToken(request.getHeader("token")).getPayload("id");
        List<Orders> list = ordersService.list(new QueryWrapper<Orders>()
                .eq("uid", uid)
                .eq("is_delete", 0)
        );
        return ResultModel.success(list);
    }

    @PostMapping("/receive")
    public String getOrderList(HttpServletRequest request) {
        int uid = (int) JWTUtil.parseToken(request.getHeader("token")).getPayload("id");
        List<Orders> list = ordersService.list(new QueryWrapper<Orders>()
                .eq("uid", uid)
                .eq("is_delete", 0)
                .eq("status", 1)
        );
        return ResultModel.success(list);
    }

    @PostMapping("/sendGoods/{oid}")
    public String sendGoods(@PathVariable("oid") int oid, HttpServletRequest request) {
        UpdateWrapper<Orders> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", oid).set("status",1);
        boolean update = ordersService.update(wrapper);
        return ResultModel.success(update);
    }


}


















