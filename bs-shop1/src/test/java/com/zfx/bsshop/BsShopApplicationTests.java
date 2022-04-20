package com.zfx.bsshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class BsShopApplicationTests {

    @Test
    void context() throws IOException {
        File file = new File("D:/localfile/photos/1");
        for (String s : file.list()) {
            System.out.println(s);
        }


    }

}
