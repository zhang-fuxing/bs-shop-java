package com.z.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.z.common.util.ResultModel;
import com.z.model.Category;
import com.z.model.CtgDetail;
import com.z.service.CategoryService;
import com.z.service.CtgDetailService;
import com.z.vo.CategoryVO;
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
 * @author z
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CtgDetailService ctgDetailService;

    @RequestMapping("/getAllLeve1")
    public String getAllLevel1() {
        List<Category> list = categoryService.list();
        String result;
        if (CollectionUtils.isEmpty(list)) {
            result = ResultModel.error(-1,"未查询到数据");
        } else {
            result = ResultModel.success(list);
        }
        return result;
    }

    @RequestMapping("/getAllLeve2")
    public String getAllLevel2() {
        List<CategoryVO> list = categoryService.getLv2List();
        String result;
        if (CollectionUtils.isEmpty(list)) {
            result = ResultModel.error(-1,"未查询到数据");
        } else {
            result = ResultModel.success(list);
        }
        return result;
    }

    @RequestMapping("/lv2ByLv1/{id}")
    public String getLevelById(@PathVariable("id") int id) {
        QueryWrapper<CtgDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("cid",id);
        CtgDetail list = ctgDetailService.getOne(wrapper);
        if (list == null)
            return ResultModel.error(301,"列表为空");
        return ResultModel.success(list);
    }

}
