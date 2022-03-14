package com.zfx.bsshop;

import com.zfx.bsshop.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BsShopApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(BsShopApplicationTests.class);

    @Autowired
    private CategoryService categoryService;

    @Test
    void contextLoads() {

    }


}
