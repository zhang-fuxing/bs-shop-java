package com.zfx.bsshop.controller;


import com.alibaba.fastjson.JSON;
import com.zfx.bsshop.common.util.ResultModel;
import com.zfx.bsshop.model.Category;
import com.zfx.bsshop.model.CtgDetail;
import com.zfx.bsshop.service.CategoryService;
import com.zfx.bsshop.service.CtgDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CtgDetailService ctgDetailService;

    @RequestMapping("/getAllLeve1")
    public String getAllLevel1() {
        List<Category> list = categoryService.list();
        String result = "";
        if (CollectionUtils.isEmpty(list)) {
            result = JSON.toJSONString(ResultModel.error(-1,"未查询到数据"));
        } else {
            result = JSON.toJSONString(ResultModel.success(list));
        }
        return result;
    }

    @RequestMapping("/getAllLeve2")
    public String getAllLevel2() {
        List<CtgDetail> list = ctgDetailService.list();
        String result = "";
        if (CollectionUtils.isEmpty(list)) {
            result = JSON.toJSONString(ResultModel.error(-1,"未查询到数据"));
        } else {
            result = JSON.toJSONString(ResultModel.success(list));
        }
        return result;
    }
}
