package com.z.controller;


import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.z.common.util.ResultModel;
import com.z.model.CartItem;
import com.z.model.Product;
import com.z.service.CartItemService;
import com.z.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <p>
 * 购物车表 前端控制器
 * </p>
 *
 * @author z
 * @since 2022-04-26
 */
@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ProductService productService;

    @PostMapping("/list")
    public String getUserCart(HttpServletRequest request){
        String token = request.getHeader("token");
        System.out.println(token);
        JWT jwt = JWTUtil.parseToken(token);
        Integer userId = (Integer) jwt.getPayload("id");
        return cartItemService.getCartByUid(userId);
    }

    @PostMapping("/add")
    public String addCart(@RequestBody CartItem cart,HttpServletRequest request) {
        CartItem cartItem = cartItemService.getOne(new QueryWrapper<CartItem>().eq("product_id", cart.getProductId()));
        if (cartItem != null) {
            return ResultModel.error(1,"该商品已存在购物车中");
        }
        String token = request.getHeader("token");
        JWT jwt = JWTUtil.parseToken(token);
        int uid = (int) jwt.getPayload("id");
        String nickname = String.valueOf(jwt.getPayload("nickname"));
        Product product = productService.getById(cart.getProductId());

        cart.setUid(uid);
        cart.setDeleteStatus(0);
        cart.setNickname(nickname);
        cart.setPrice(product.getUnitPrice());
        cart.setCreateTime(LocalDateTime.now());
        boolean save = cartItemService.save(cart);
        if (!save) {
            return ResultModel.error(-1,"插入失败");
        }
        return ResultModel.success("添加成功");
    }

    @PostMapping("/remove/{cid}")
    public String removeCartItems(@PathVariable("cid") Integer cid) {
        boolean b = cartItemService.removeById(cid);
        return ResultModel.success(b);
    }

}











