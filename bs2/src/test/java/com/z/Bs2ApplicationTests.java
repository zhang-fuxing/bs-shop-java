package com.z;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.z.mapper.PimageMapper;
import com.z.mapper.ProductMapper;
import com.z.mapper.UserMapper;
import com.z.model.Address;
import com.z.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.HashMap;
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
    @Autowired
    PrdAttrService prdAttrService;


    @Test
    void context() {
        // MailUtil.send("zhangfuxing1010@163.com", "邮件测试","123456",false);

        File file = new File("D:\\localfile\\iso\\1.bin");
        file.delete();
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
