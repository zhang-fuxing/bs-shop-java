package com.z;

import com.z.mapper.ProductMapper;
import com.z.service.CategoryService;
import com.z.service.ProductService;
import com.z.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


    @Test
    void context() {
        System.out.println(productService.count());

    }

}
