package com.zfx.bsshop.controller;


import com.alibaba.fastjson.JSON;
import com.zfx.bsshop.common.util.ResultModel;
import com.zfx.bsshop.model.Category;
import com.zfx.bsshop.service.CategoryService;
import com.zfx.bsshop.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/getAllLeve1")
    public String getAllLevel1() {
        List<Category> list = categoryService.getAllLevel1();
        String result;
        if (CollectionUtils.isEmpty(list)) {
            result = JSON.toJSONString(ResultModel.error(-1,"未查询到数据"));
        } else {
            result = JSON.toJSONString(ResultModel.success(list));
        }
        return result;
    }

    @RequestMapping("/getAllLeve2")
    public String getAllLevel2() {
        List<CategoryVO> list = categoryService.getAllLevel2();
        String result;
        if (CollectionUtils.isEmpty(list)) {
            result = JSON.toJSONString(ResultModel.error(-1,"未查询到数据"));
        } else {
            result = JSON.toJSONString(ResultModel.success(list));
        }
        return result;
    }

    @RequestMapping("/getLevelById/{id}")
    public String getLevelById(@PathVariable("id") int id) {
        List<CategoryVO> list = categoryService.getLevelById(id);
        if (CollectionUtils.isEmpty(list))
            return JSON.toJSONString(ResultModel.error(301,"列表为空"));
        return JSON.toJSONString(ResultModel.success(list));
    }
}
