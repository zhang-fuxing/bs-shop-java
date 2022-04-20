package com.zfx.bsshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zfx.bsshop.dao")
public class BsShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BsShopApplication.class, args);
    }

}
