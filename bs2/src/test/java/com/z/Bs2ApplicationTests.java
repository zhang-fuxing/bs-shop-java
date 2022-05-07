package com.z;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.z.mapper.PimageMapper;
import com.z.mapper.ProductMapper;
import com.z.mapper.UserMapper;
import com.z.model.Address;
import com.z.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class Bs2ApplicationTests {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CartItemService cartItemService;
    @Autowired
    PimageMapper pimageMapper;
    @Autowired
    PimageService pimageService;
    @Autowired
    RecommendService recommendService;
    @Autowired
    Snowflake snowflake;

    @Autowired
    AddressService addressService;


    @Test
    void context() {
        // MailUtil.send("zhangfuxing1010@163.com", "邮件测试","123456",false);
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIxNTIxMDQ2MTUxMDIxMDcyMzg0IiwibmJmIjoxNjUxNjQwODc3LCJ1bmFtZSI6IuW8oOemj-WFtCIsInBob25lIjoiMTM2NDg1ODY2NTMiLCJuaWNrbmFtZSI6IuWNleaOqOS6uiIsImlkIjoxLCJleHAiOjE2NTE5MDAwNzcsImlhdCI6MTY1MTY0MDg3NywiZW1haWwiOiJ6aGFuZ2Z1eGluZzEwMTBAMTYzLmNvbSJ9.C1pDLfBRPgc9DZAnbAF0KTRBZYHT5fHc24VcT-NcUEQ";
        JWT jwt = JWTUtil.parseToken(token);
        JWTHeader header = jwt.getHeader();
        Object id = jwt.getPayload("id");
        System.out.println("id = " + id);

        boolean verify = JWTUtil.verify(token, "123".getBytes());
        System.out.println("verify = " + verify);
    }

    @Test
    void pimageListTest() {
        String emailPattern = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(emailPattern);
        boolean matches = matcher.matches();
        System.out.println(matches);
    }

    @Test
    void orderTest() {
        UpdateWrapper<Address> wrapper = new UpdateWrapper<>();
        wrapper.set("receive_status",1).eq("id",1).eq("uid",1);
        boolean update = addressService.update(wrapper);
        UpdateWrapper<Address> wrapper1 = new UpdateWrapper<>();
        wrapper1.eq("receive_status",1).eq("uid",1).set("receive_status",0);
        addressService.update(wrapper1);
    }

}
