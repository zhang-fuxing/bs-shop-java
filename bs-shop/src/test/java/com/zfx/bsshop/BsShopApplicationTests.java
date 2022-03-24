package com.zfx.bsshop;

import com.zfx.bsshop.dao.space.CategoryDetailSpaceDAO;
import com.zfx.bsshop.service.CategoryService;
import com.zfx.bsshop.vo.CategoryVO;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class BsShopApplicationTests {

    @Autowired
    private  Logger logger;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    CategoryDetailSpaceDAO categoryDetailSpaceDAO;


    @Test
    void context() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("lv1id",6);
        List<CategoryVO> list = categoryDetailSpaceDAO.selectCategoryDetail(map);
        list.forEach(System.out::println);
    }

}
